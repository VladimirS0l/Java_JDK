package seminar.service;

public class ServerListenerImpl implements ServerListener{
    @Override
    public void onMessageRecived(String message) {
        System.out.println("Message: " + message);
    }
}
