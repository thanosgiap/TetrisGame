package com.game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.util.Random;

public class Shape {

    protected enum Tetrominoe{
        Noshape, Zshape, SShape, LineShape, TShape, SquareShape, LShape, MirroredShape
    }

    private Tetrominoe pieceShape;
    private int[][] coords;

    public Shape(){
        coords = new int[4][2];
        setShape(Tetrominoe.Noshape);
    }

    void setShape(Tetrominoe shape){
        int[][][] coordsTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };
        for (int i = 0; i<4; i++){
            System.arraycopy(coordsTable[shape.ordinal()], 0, coords, 0, 4);
        }
        pieceShape = shape;
    }
    private void setX(int index, int x){
        coords[index][0] = x;
    }
    private void setY(int index, int y){
        coords[index][1] = y;
    }
    int x(int index) {
        return coords[index][0];
    }
    int y(int index) {
        return coords[index][1];
    }
    Tetrominoe getShape(){
        return pieceShape;
    }
    void setRandomShape(){
        var r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;

        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[x]);
    }

    


}
