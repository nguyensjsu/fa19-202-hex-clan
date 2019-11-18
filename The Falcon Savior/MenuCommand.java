public class MenuCommand implements IMenuCommand {

    private IMenuReceiver menuReceiver;

    @Override
    public void executeCommand() {
        menuReceiver.performAction();
    }

    @Override
    public void setReceiver(IMenuReceiver menuReceiver) {
        this.menuReceiver = menuReceiver;
    }
}
