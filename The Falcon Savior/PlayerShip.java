/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PlayerShip extends Leaf implements IPlayerEventSubject, IProjectileOwner {

    int speed;
    int lifeCount = 3;
    private IPlayerEventHandler chain;

    PlayerShip(int x, int y, LeafType leafType) {
        super(x, y, leafType);
    }

    void moveLeft() {
        if (getX() + speed >= 870)
            setLocation(870, getY());
        else
            move(speed);
    }

    void moveRight() {
        if (getX() - speed <= 160)
            setLocation(160, getY());
        else
            move(-speed);
    }

    public void act() {
        control();
    }

    void shoot() {
        IProjectile rocket = new PlayerRocket(getX(), getY() - 10);
        rocket.addProjectileOwner(this);
        IComponent wrappedRocket = new DualSoundDecorator((IComponent) rocket);
        wrappedRocket.display(getWorld());
    }

    abstract public void control();

    @Override
    public void addHandler(IPlayerEventHandler handler) {
        if (null == chain) {
            chain = handler;
        } else {
            IPlayerEventHandler prev = chain;
            while (prev.hasNext()) {
                prev = handler.getNext();
            }
            prev.setNext(handler);
        }
    }

    @Override
    public void removeHandler(IPlayerEventHandler handler) {

    }

    @Override
    public void notifyHandlers(Event event) {
        if (event == Event.LIFE) {
            if (lifeCount > 1) {
                lifeCount--;
            } else {
                getWorld().removeObject(this);
            }
        }
        chain.handleEvent(event);
    }

    @Override
    public void notifyOwner(Event event) {
        notifyHandlers(event);
    }
}
