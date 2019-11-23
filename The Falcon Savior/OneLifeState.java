/**
 * Write a description of class OneLifeState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OneLifeState implements ILifeState {

    private ILifeStateMachine machine;

    OneLifeState(ILifeStateMachine m) {
        machine = m;
    }

    @Override
    public void onPlayerHit() {
        machine.gameOver();
    }

    @Override
    public void onLifeUp() {
        machine.setStateTwoLifeState();
    }
}