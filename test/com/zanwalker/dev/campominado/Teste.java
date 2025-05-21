package com.zanwalker.dev.campominado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Teste {

   @Test
    void testarSeIgualADois() {
       int a = 1+1;

       assertEquals(2, a);

    }

    @Test
    void testarSeIgualATres(){
        int x = 2 + 10 -7;

        assertEquals(3, x);
    }

}