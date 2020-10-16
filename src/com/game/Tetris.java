package com.game;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {

    private JLabel statusbar;

    public Tetris(){
        initUI();
    }

    private void initUI(){
        statusbar = new JLabel("0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris Game");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar(){
        return statusbar;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            var game = new Tetris();
            game.setVisible(true);
        });
    }

}
