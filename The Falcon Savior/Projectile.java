public class Projectile extends Leaf implements IProjectile {

    private IProjectileOwner projectileOwner;

    Projectile(int x, int y, LeafType type) {
        super(x, y, type);
    }

    @Override
    public void addProjectileOwner(IProjectileOwner owner) {
        this.projectileOwner = owner;
    }

    void notifyProjectileOwner(Event event) {
        if (null != projectileOwner) {
            this.projectileOwner.notifyOwner(event);
        }
    }
}
