package com.zanwalkerdev.campominado;

import com.zanwalkerdev.campominado.model.Board;

public class App {

    public static void main(String[] args) {
        Board board = new Board(6, 6, 6);

        System.out.println(board);
    }
}
