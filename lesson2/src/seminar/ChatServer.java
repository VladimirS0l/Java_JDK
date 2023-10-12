package seminar;

import seminar.service.ServerListener;
import seminar.service.ServerTrheadSocket;
import seminar.service.ThreadSocket;

public class ChatServer {
    private boolean serverStatus;
    private ServerListener serverListener;
    private final ServerTrheadSocket serverTrheadSocket;

    public ChatServer(ServerListener serverListener, ServerTrheadSocket serverTrheadSocket) {
        this.serverTrheadSocket = serverTrheadSocket;
        serverStatus = false;
        this.serverListener = serverListener;
    }

    public void start() {
        if (serverStatus) {
            serverListener.onMessageRecived("Server already start!");
        }
        else {
            serverListener.onMessageRecived("Server start!");
            serverTrheadSocket.onStart();
        }
    }

    public void stop() {
        if (!serverStatus) {
            serverListener.onMessageRecived("Server stop!");
            serverTrheadSocket.onStop();
        }
        else serverListener.onMessageRecived("Server stop!");
    }
}
