/**
 * Write a description of class TwoLifeState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TwoLifeState implements ILifeState {
    ILifeStateMachine machine;

    public TwoLifeState(ILifeStateMachine m) {
        machine = m;
    }

    @Override
    public void onPlayerHit() {
        machine.setStateOneLifeState();
    }

    @Override
    public void onLifeUp() {
        machine.setStateThreeLifeState();
    }

}
