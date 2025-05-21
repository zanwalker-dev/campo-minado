package com.zanwalkerdev.campominado.model;

import java.util.ArrayList;
import java.util.List;

public class Camp {

    private final int line;
    private final int column;

    private boolean mined; //false por padrão
    private boolean opened; //false por padrão
    private boolean marked;

    private List<Camp> adjacentList = new ArrayList<>();

    public Camp(int line, int column){
        this.line = line;
        this.column = column;
    }

    /* Logica para adicionar vizinhos, para vizinhos na horizontal e vertical o valor
    absoluto deve ser 1 para vizinhos na diagonal o valor absoluto deverá ser 0 */
    boolean addAdjacent(Camp adjacent){

        boolean lineDiff = line != adjacent.line;
        boolean columnDiff = column != adjacent.column;
        boolean diagonal = lineDiff && columnDiff;

        int detlaLine = Math.abs(line - adjacent.line);
        int detlaColumn = Math.abs(column - adjacent.column);
        int deltaGeral = detlaLine + detlaColumn;

        if(deltaGeral == 1 && !diagonal){
            adjacentList.add(adjacent);
            return true;
        } else if(deltaGeral == 2 && diagonal){
            adjacentList.add(adjacent);
            return true;
        } else {
            return false;
        }
    }

    /* Logica para alternar campo aberto/maracado: */
    void toggleMark(){
        if(!opened){
            marked = !marked;
        }
    }

    boolean open(){
        if(!opened && !marked){
            opened = true;

            if(mined){

            }
        }
        return false;
    }
}
