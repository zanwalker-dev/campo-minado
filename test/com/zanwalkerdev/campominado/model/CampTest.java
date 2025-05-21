package com.zanwalkerdev.campominado.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CampTest {

    private Camp camp;

    @BeforeEach
    void startCamp() {
        camp = new Camp(3,3);
    }

    @Test
    void testAdjacentRange1Left(){
        Camp adjacent = new Camp(3,2);
        boolean result = camp.addAdjacent(adjacent);
        assertTrue(result);
    }

    @Test
    void testAdjacentRange1Right(){
        Camp adjacent = new Camp(3,4);
        boolean result = camp.addAdjacent(adjacent);
        assertTrue(result);
    }

    @Test
    void testAdjacentRange1Top(){
        Camp adjacent = new Camp(2,3);
        boolean result = camp.addAdjacent(adjacent);
        assertTrue(result);
    }

    @Test
    void testAdjacentRange1Down(){
        Camp adjacent = new Camp(4,3);
        boolean result = camp.addAdjacent(adjacent);
        assertTrue(result);
    }

    @Test
    void testAdjacentRange2(){
        Camp adjacent = new Camp(2,2);
        boolean result = camp.addAdjacent(adjacent);
        assertTrue(result);
    }

    @Test
    void testNotAdjacent(){
        Camp adjacent = new Camp(1,4);
        boolean result = camp.addAdjacent(adjacent);
        assertFalse(result);
    }


}
