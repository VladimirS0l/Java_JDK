package ru.java.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 250;
    private static final int WINDOW_HEIGHT = 350;
    public static int sizeX;
    public static int sizeY;

    JButton btnStart = new JButton("Start new game");
    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(true);
            }
        });

        add(btnStart);
    }
}
