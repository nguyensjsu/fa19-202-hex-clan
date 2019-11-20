import greenfoot.World;

public class Wave {

    private SpawnEntity[] contents;

    public Wave(SpawnEntity[] contents) {
        this.contents = contents;
    }

    public void spawnWave(World world) {
        for (SpawnEntity entity : contents) {
            entity.spawn(world);
        }
    }
}
