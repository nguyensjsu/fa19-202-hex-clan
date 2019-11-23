/**
 * Write a description of class ILifeStateSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ILifeStateSubject {
    void addObserver(ILifeStateObserver observer);

    void removeObserver(ILifeStateObserver observer);

    void notifyObserver();
}
