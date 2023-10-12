package seminar;

import seminar.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindows extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 700;
    private static final int WINDOW_POSY = 200;

    private static final String BTN_START = "Start";
    private static final String BTN_STOP = "Stop";

    ServerWindows() {

        ServerListener serverListener = new ServerListenerImpl();
        ServerTrheadSocket serverTrheadSocket = new ServerTrheadSocketImpl();
        ThreadSocket threadSocket = new ThreadSocketImpl();
        ChatServer chatServer = new ChatServer(serverListener, serverTrheadSocket);

        JButton btnStart = new JButton(BTN_START);
        JButton btnStop = new JButton(BTN_STOP);
        JTextArea field = new JTextArea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        JPanel panBotton = new JPanel(new GridLayout(1, 1));

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatServer.start();
                threadSocket.onButton(BTN_START);
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatServer.stop();
                threadSocket.onButton(BTN_STOP);
            }
        });

        panBotton.add(btnStart);
        panBotton.add(btnStop);
        add(panBotton, BorderLayout.CENTER);
        setVisible(true);


    }
}
