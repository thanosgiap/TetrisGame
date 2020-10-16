package com.game;

import java.awt.*;
import java.awt.dnd.DropTargetAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.tools.Tool;

public class Board extends JPanel{
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 22;
    private final int PERIOD_INTERVAL = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusbar;
    private Shape curPiece;
    private Shape.Tetrominoe[] board;

    public Board(Tetris parent){
        initBoard(parent);
    }

    private void initBoard(Tetris parent){
        setFocusable(true);
        statusbar = parent.getStatusBar();
        addKeyListener(new TAdapter());
    }

    private int squareWidth(){
        return (int)getSize().getHeight()/BOARD_HEIGHT;
    }

    //Not sure about this function
    private Shape.Tetrominoe shapeAt(int x, int y){
        return board[(y*BOARD_WIDTH) + x];
    }

    void start(){
        curPiece = new Shape();
        board = new Shape.Tetrominoe[BOARD_WIDTH*BOARD_HEIGHT];

        clearBoard();
        newPiece();

        timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        timer.start();
    }
}
