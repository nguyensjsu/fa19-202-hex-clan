import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Display the  menu page with multiple options of New game , Scores , Credits
 *
 * @author Shalabh Neema
 * @version (a version number or a date)
 */
public class MenuWorld extends World {

    private Button singlePlayerButton;
    private Button twoPlayerButton;
    private Button helpButton;
    private Button creditsButton;

    /**
     * Constructor for objects of class MenuWorld.
     */
    public MenuWorld() {
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        Greenfoot.setWorld(this);

        singlePlayerButton = new Button(Button.Type.SINGLE_PLAYER);
        twoPlayerButton = new Button(Button.Type.MULTI_PLAYER);
        helpButton = new Button(Button.Type.HELP);
        creditsButton = new Button(Button.Type.CREDITS);

        instantiate();
        Greenfoot.start();
    }

    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
    }

    private void instantiate() {
        setupMenuCommand();

        addObject(singlePlayerButton, getWidth() / 4, 120);
        addObject(twoPlayerButton, getWidth() / 4, 160);
        addObject(helpButton, getWidth() / 4, 200);
        addObject(creditsButton, getWidth() / 4, 240);
    }

    private void setupMenuCommand() {
        IMenuCommand singlePlayerCommand = new MenuCommand();
        IMenuCommand twoPlayerCommand = new MenuCommand();
        IMenuCommand helpCommand = new MenuCommand();
        IMenuCommand creditsCommand = new MenuCommand();

        singlePlayerCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                SoundController.getInstance().stopMenuBackgroundMusic();
                Greenfoot.setWorld(new GameWorld(false));
            }
        });

        twoPlayerCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                SoundController.getInstance().stopMenuBackgroundMusic();
                Greenfoot.setWorld(new GameWorld(true));
            }
        });

        helpCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                SoundController.getInstance().stopMenuBackgroundMusic();
                Greenfoot.setWorld(new HelpWorld());

            }
        });

        creditsCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                Greenfoot.setWorld(new ChartWorld());
            }
        });

        singlePlayerButton.setMenuCommand(singlePlayerCommand);
        twoPlayerButton.setMenuCommand(twoPlayerCommand);
        helpButton.setMenuCommand(helpCommand);
        creditsButton.setMenuCommand(creditsCommand);
    }

    @Override
    public void stopped() {
        SoundController.getInstance().stopMenuBackgroundMusic();
    }

    @Override
    public void started() {
        SoundController.getInstance().playMenuBackgroundMusic();
    }
}
