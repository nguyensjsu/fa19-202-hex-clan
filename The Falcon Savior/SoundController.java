import greenfoot.GreenfootSound;

public class SoundController {

    private static SoundController sInstance;

    private GreenfootSound menuBackgroundMusic;

    /**
     * Don't let anyone instantiate this class.
     */
    private SoundController() {
        menuBackgroundMusic = new GreenfootSound("main_menu_music.mp3");
    }

    public synchronized static SoundController getInstance() {
        if (null == sInstance) {
            sInstance = new SoundController();
        }
        return sInstance;
    }

    public void playMenuBackgroundMusic() {
        menuBackgroundMusic.playLoop();
    }

    public void stopMenuBackgroundMusic() {
        if (menuBackgroundMusic.isPlaying()) {
            menuBackgroundMusic.stop();
        }
    }
}