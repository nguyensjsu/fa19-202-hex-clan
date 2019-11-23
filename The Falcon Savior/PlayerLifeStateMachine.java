/**
 * Write a description of class PlayerLifeStateMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerLifeStateMachine implements ILifeStateMachine, ILifeStateSubject {
    // instance variables - replace the example below with your own
    private OneLifeState oneLifeState;
    private TwoLifeState twoLifeState;
    private ThreeLifeState threeLifeState;
    private ILifeState currentLifeState;

    private ILifeStateObserver observer;

    PlayerLifeStateMachine() {
        oneLifeState = new OneLifeState(this);
        twoLifeState = new TwoLifeState(this);
        threeLifeState = new ThreeLifeState(this);

        this.currentLifeState = threeLifeState;
    }

    @Override
    public void onPlayerHit() {
        currentLifeState.onPlayerHit();
    }

    @Override
    public void gameOver() {
        notifyObserver();
    }

    @Override
    public void setStateOneLifeState() {
        currentLifeState = oneLifeState;
    }

    @Override
    public void setStateTwoLifeState() {
        currentLifeState = twoLifeState;
    }

    @Override
    public void setStateThreeLifeState() {
        currentLifeState = threeLifeState;
    }

    public void addObserver(ILifeStateObserver observer) {
        this.observer = observer;
    }

    public void removeObserver(ILifeStateObserver observer) {

    }

    public void notifyObserver() {
        if (null != this.observer) {
            observer.gameOver();
        }
    }
}
