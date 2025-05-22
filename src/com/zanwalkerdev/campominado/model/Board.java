package com.zanwalkerdev.campominado.model;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private int lines;
    private int columns;
    private int mines;

    private final List<Camp> camps = new ArrayList<>();

    public Board(int lines, int columns, int mines) {
        this.lines = lines;
        this.columns = columns;
        this.mines = mines;

        generateCamps();
        associateAdjacents();
        drawMines();
    }

    private void generateCamps() {
        for (int line = 0; line < this.lines; line++) {
            for (int column = 0; column < this.columns; column++) {
                camps.add(new Camp(line, column));
            }
        }
    }

    private void associateAdjacents() {
        for(Camp c1: camps) {
            for(Camp c2: camps) {
                c1.addAdjacent(c2);
            }
        }
    }

    private void drawMines() {
    }

}
