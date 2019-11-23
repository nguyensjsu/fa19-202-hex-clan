import java.util.ArrayList;
import java.util.List;

public class Level2Strategy implements ILevelStrategy {

    private int targetScore = 0;

    public int getTargetScore() {
        return targetScore;
    }

    public List<IComponent> getTroops() {
        ArrayList<IComponent> troop1 = new ArrayList<>();
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 10; x++) {
                troop1.add(new EnemyShip2(1, 250 + ((x + 1) * 50), 250 + ((y + 1) * 50)));
                targetScore += 10;
            }
        }
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 10; x++) {
                troop1.add(new EnemyShip1(-1, 250 + ((x + 1) * 50), 150 + ((y + 1) * 50)));
                targetScore += 10;
            }
        }
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 10; x++) {
                troop1.add(new EnemyShip2(1, 250 + ((x + 1) * 50), 50 + ((y + 1) * 50)));
                targetScore += 10;
            }
        }
        return troop1;
    }
}
