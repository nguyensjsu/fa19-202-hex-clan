/**
 * Write a description of class LifeGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LifeGroup extends Component implements IPlayerEventHandler {
    private IPlayerEventHandler nextHandler;

    private ILifeStateMachine lifeStateMachine;

    LifeGroup(ILifeStateMachine machine) {
        this.lifeStateMachine = machine;
    }

    public boolean hasNext() {
        return null != this.nextHandler;
    }

    public IPlayerEventHandler getNext() {
        return this.nextHandler;
    }

    public void setNext(IPlayerEventHandler handler) {
        this.nextHandler = handler;
    }

    public void handleEvent(Event event) {
        if (event == Event.LIFE) {
            IComponent removedComponent = removeLastComponent();
            if (null != removedComponent) {
                if (removedComponent instanceof Life) {
                    ((Life) removedComponent).removeLife();
                    this.lifeStateMachine.onPlayerHit();
                }
            }
        } else if (null != nextHandler) {
            this.nextHandler.handleEvent(event);
        }
    }

    IComponent removeLastComponent() {
        IComponent component = null;
        if (getComponents().size() > 0) {
            component = getComponents().get(getComponents().size() - 1);
            getComponents().remove(component);
        }
        return component;
    }
}
