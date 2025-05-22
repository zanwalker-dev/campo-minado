package com.zanwalkerdev.campominado.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


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
        long armedMines = 0;
        Predicate<Camp> mined = c -> c.isMined();

        do{
            armedMines = camps.stream().filter(mined).count();
            int random = (int) (Math.random() * camps.size());
            camps.get(random).toMine();
        } while (armedMines < this.mines);
    }

    public boolean objectiveAchieved(){
        return camps.stream().allMatch(c -> c.objectiveAchieved());
    }

    public void resetGame(){
        camps.stream().forEach(c -> c.reset());
        drawMines();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(int line = 0; line < this.lines; line++){
            for(int column = 0; column < this.columns; column++){
                sb.append(" ");
                sb.append(camps.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
