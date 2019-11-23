/**
 * Write a description of class IScoreObserver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IPlayerEventHandler {
    boolean hasNext();

    IPlayerEventHandler getNext();

    // instance variables - replace the example below with your own
    void setNext(IPlayerEventHandler handler);

    void handleEvent(Event event);
}
