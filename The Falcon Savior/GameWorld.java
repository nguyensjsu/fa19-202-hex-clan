import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.List;

/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class GameWorld extends World implements ILevelObserver, ILifeStateObserver {

    private Level level;
    private int gameOverCounter = 1;
    private boolean isMultiPlayer;

    private ScoreBoard scoreBoardSecondPlayer;

    private ScoreBoard scoreBoardFirstPlayer;

    /**
     * Constructor for objects of class GameWorld.
     */
    GameWorld(boolean multiPlayer) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        this.isMultiPlayer = multiPlayer;

        IComponent gameScreen = new Component();
        IComponent enemyGroup = new Component();

        level = new Level(500, 50);
        level.addObserver(this);
        enemyGroup.addChildren(level.getEnemyTroops());

        gameScreen.addChild(level);
        gameScreen.addChild(enemyGroup);

        PlayerShip firstPlayer = new PlayerShip1(500, 700);

        if (multiPlayer) {
            gameOverCounter = 2;
            firstPlayer = new PlayerShip1(450, 700);
            PlayerShip secondPlayer = new PlayerShip2(550, 700);
            scoreBoardSecondPlayer = new ScoreBoard(950, 50, level);
            PlayerLifeStateMachine secondPlayerStateMachine = new PlayerLifeStateMachine();
            secondPlayerStateMachine.addObserver(this);
            LifeGroup secondPlayerLifeGroup = new LifeGroup(secondPlayerStateMachine);
            secondPlayerLifeGroup.addChild(new Life(950, 750));
            secondPlayerLifeGroup.addChild(new Life(950, 720));
            secondPlayerLifeGroup.addChild(new Life(950, 690));
            secondPlayer.addHandler(scoreBoardSecondPlayer);
            secondPlayer.addHandler(secondPlayerLifeGroup);
            gameScreen.addChild(secondPlayer);
            gameScreen.addChild(scoreBoardSecondPlayer);
            gameScreen.addChild(secondPlayerLifeGroup);
        }

        scoreBoardFirstPlayer = new ScoreBoard(50, 50, level);
        PlayerLifeStateMachine firstPlayerStateMachine = new PlayerLifeStateMachine();
        firstPlayerStateMachine.addObserver(this);
        LifeGroup firstPlayerLifeGroup = new LifeGroup(firstPlayerStateMachine);
        firstPlayerLifeGroup.addChild(new Life(50, 750));
        firstPlayerLifeGroup.addChild(new Life(50, 720));
        firstPlayerLifeGroup.addChild(new Life(50, 690));
        firstPlayer.addHandler(scoreBoardFirstPlayer);
        firstPlayer.addHandler(firstPlayerLifeGroup);

        gameScreen.addChild(firstPlayer);
        gameScreen.addChild(scoreBoardFirstPlayer);
        gameScreen.addChild(firstPlayerLifeGroup);

        gameScreen.display(this);
    }

    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
    }

    public void onLevelIncreased() {
        IComponent enemyGroup = new Component();
        List<IComponent> troops = level.getEnemyTroops();
        if (!troops.isEmpty()) {
            enemyGroup.addChildren(troops);
            enemyGroup.display(this);
        } else {
            if (isMultiPlayer) {
                gameOver();
            }
            gameOver();
        }
    }

    public void gameOver() {
        if (gameOverCounter == 1) {
            Greenfoot.delay(20);
            if (isMultiPlayer) {
                Greenfoot.setWorld(new GameOver(scoreBoardFirstPlayer.getScore(), scoreBoardSecondPlayer.getScore()));
            } else {
                Greenfoot.setWorld(new GameOver(scoreBoardFirstPlayer.getScore()));
            }
        } else {
            gameOverCounter--;
        }
    }
}
