package ru.java.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    Map() {
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight/3;
        cellWidth = panelWidth/3;

        g.setColor(Color.BLACK);
        for (int i = 0; i <3; i++) {
            int y = i*cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int l = 0; l < 3; l++) {
            int x = l*cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) continue;

                if (field[i][j] == HUMAN_DOT) {

                }else if (field[i][j] == AI_DOT){

                } else {
                    throw new RuntimeException("Unexpected value: " + field[i][j] + " in cell: x=" + i + " y=" + j);
                }
            }
        }
    }

    private void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
//        System.out.printf("x=%d, y=%d", cellX, cellX);
        repaint();
    }

    private void initMap() {
        field = new char[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x>=0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[x][y] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean checkWin(char c) {
        boolean rowGeneral = false;
        boolean columnGeneral = false;
        boolean mainDiagonal = true;
        boolean diagonal = true;
        for (int i = 0; i < fieldSizeX; i++) {
            boolean row = true;
            for (int j = 0; j <fieldSizeY; j++) {
                if (field[i][j] == c) return row;
                else row = false;
            }
            //Проверка ряда
            if (row) rowGeneral = true;
        }

        int count = 0;
        while (count < 3) {
            boolean column = true;
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    if (field[i][count] == c) return column;
                    else column = false;
                }
            }
            if (column) columnGeneral = true;
            count++;
        }

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = fieldSizeY-1; j >=0 ; j--) {
                if (field[i][j] == c) return diagonal;
                else diagonal = false;
            }
        }

        for (int i = fieldSizeX-1; i >= 0; i--) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == c) return mainDiagonal;
                else mainDiagonal = false;
            }
        }
        if (rowGeneral && columnGeneral && diagonal && mainDiagonal) return true;
        else return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j <fieldSizeY; j++) {
                if (field[i][j] ==EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
