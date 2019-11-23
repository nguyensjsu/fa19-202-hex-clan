import greenfoot.GreenfootSound;

class SoundController {

    private static SoundController sInstance;

    private GreenfootSound menuBackgroundMusic;

    /**
     * Don't let anyone instantiate this class.
     */
    private SoundController() {
        try {
            menuBackgroundMusic = new GreenfootSound("GameStartMusic.wav");
        } catch (Exception ex) {
            // Ignore
        }
    }

    public synchronized static SoundController getInstance() {
        if (null == sInstance) {
            sInstance = new SoundController();
        }
        return sInstance;
    }

    public void playMenuBackgroundMusic() {
        try {
            menuBackgroundMusic.playLoop();
        } catch (Exception ex) {
            // Ignore
        }
    }

    public void stopMenuBackgroundMusic() {
        menuBackgroundMusic.stop();
    }
}
