/**
 * Write a description of class ILifeStateMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ILifeStateMachine {
    // instance variables - replace the example below with your own
    void onPlayerHit();

    void gameOver();

    void setStateOneLifeState();

    void setStateTwoLifeState();

    void setStateThreeLifeState();
}