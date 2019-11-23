/**
 * Write a description of class IScoreSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IPlayerEventSubject {
    // instance variables - replace the example below with your own

    void addHandler(IPlayerEventHandler handler);

    void removeHandler(IPlayerEventHandler handler);

    void notifyHandlers(Event event);
}
