import greenfoot.Actor;
import greenfoot.World;

public class SpawnEntity {

    private Actor actor;
    private int x;
    private int y;

    public SpawnEntity(Actor actor, int x, int y) {
        this.actor = actor;
        this.x = x;
        this.y = y;
    }

    public void spawn(World world) {
        world.addObject(actor, x, y);
    }
}
