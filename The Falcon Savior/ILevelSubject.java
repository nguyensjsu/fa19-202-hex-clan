/**
 * Write a description of class ILevelSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ILevelSubject {
    void addObserver(ILevelObserver observer);

    void removeObserver(ILevelObserver observer);

    void notifyObserver();
}
