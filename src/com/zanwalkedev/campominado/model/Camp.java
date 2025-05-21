package com.zanwalkedev.campominado.model;

import java.util.ArrayList;
import java.util.List;

public class Camp {

    private final int line;
    private final int column;

    private boolean mined; //false por padrão
    private boolean opened; //false por padrão
    private boolean marked;

    private List<Camp> adjacent = new ArrayList<>();

    Camp(int line, int column){
        this.line = line;
        this.column = column;
    }
}
