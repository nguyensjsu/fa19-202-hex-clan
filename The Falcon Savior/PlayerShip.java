import greenfoot.World;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PlayerShip extends Leaf {

    private ScoreBoard scoreBoard;

    PlayerShip(int x, int y, LeafType leafType, ScoreBoard scoreBoard) {
        super(x, y, leafType);
        this.scoreBoard = scoreBoard;
    }

    void moveLeft() {
        if (getX() - 10 > 0) {
            this.setLocation(getX() - 2, getY());
        }
    }

    void moveRight() {
        if (getX() + 10 < this.getWorld().getWidth()) {
            this.setLocation(getX() + 2, getY());
        }
    }

    public void act() {
        control();
    }

    public void display(World world) {
        super.display(world);
        scoreBoard.display(world);
    }

    public int getScore() {
        return scoreBoard.score;
    }

    void shoot() {
        Rocket rocket = new Rocket(getX(), getY() - 10);
        rocket.addObserver(scoreBoard);
        IComponent wrappedRocket = new DualSoundDecorator(rocket);
        wrappedRocket.display(getWorld());
    }

    abstract public void control();
}
