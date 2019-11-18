
public interface IMenuCommand {

    void executeCommand();

    void setReceiver(IMenuReceiver menuReceiver);
}
