package appOnSwing.chat;

import appOnSwing.model.Map;
import appOnSwing.model.SettingsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ChatWindow extends JFrame{

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 300;

    JButton newGame = new JButton("New Game");
    JButton exit = new JButton("Exit");

    JButton connect = new JButton("Connect");
    JButton send = new JButton("Send");

    {
        System.out.println(readChat());
    }
    public ChatWindow()  {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatApp");
        setResizable(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

//        setLayout(new GridLayout(10, 1));

        JPanel panSet = new JPanel(new GridLayout(4, 1));
        JTextField login = new JTextField("Login");
        JTextField password = new JTextField("Password");
        JTextField ip = new JTextField("IP");
        JTextField port = new JTextField("Port");
        panSet.add(login);
        panSet.add(password);
        panSet.add(ip);
        panSet.add(port);
        panSet.add(connect);
        add(panSet, BorderLayout.NORTH);

        JPanel panMid = new JPanel(new GridLayout(1, 2));
        JTextArea chat = new JTextArea();
        chat.append(readChat());
        chat.setEditable(false);
        JList<String> listUsers = new JList<>();
        String[] users = {"Vladimir", "Viki", "Ted", "John", "Alice"};
        listUsers.setListData(users);
        panMid.add(chat);
        panMid.add(listUsers);
        add(panMid);

        JPanel panChat = new JPanel(new GridLayout(3, 1));
        JTextField msg = new JTextField("");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = users[1] + ": " + msg.getText();
                chat.append(message + String.format("%n"));
                System.out.println(message);
                writeChat(message);
            }
        });
        panChat.add(msg);
        panChat.add(send);
        panChat.add(exit);
        add(panChat, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Метод записывает историю сообщений
     * @param s принимает на вход строку
     */
    private void writeChat(String s) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("chatDb", true))){
            bf.write(s+"\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод читает историю из файла
     * @return возвращает строку с историей чата
     */
    private String readChat() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("chatDb"))) {
            String temp = br.readLine();
            while (temp != null) {
                sb.append(temp).append("\n");
                temp = br.readLine();
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

}
