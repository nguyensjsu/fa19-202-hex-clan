abstract class EnemyShip extends Leaf implements IProjectileOwner {

    Script script = Script.NORMAL;
    private int direction;
    private boolean end = false;
    private boolean isDirectionChanged = false;

    EnemyShip(int direction, int x, int y, LeafType type) {
        super(x, y, type);
        this.direction = direction;
    }

    void move() {
        setLocation(getX() + direction, getY());
        isDirectionChanged = false;
    }

    /**
     * Checks if we should go down
     */
    void checkMove() {
        if (script == Script.NORMAL) {
            if (!isDirectionChanged) {
                if (getX() >= 870 || getX() <= 160) {
                    script = Script.DOWN;
                    toggleDirection();
                }
            }

            if (getY() >= 750) {
                end = true;
            }
        }
    }

    private void toggleDirection() {
        direction = direction * -1;
        isDirectionChanged = true;
    }

    void moveDown() {
        setLocation(getX(), getY() + 90);

        script = Script.NORMAL;
    }

    @Override
    public void notifyOwner(Event event) {

    }

    public enum Script {
        DOWN,
        NORMAL
    }
}
