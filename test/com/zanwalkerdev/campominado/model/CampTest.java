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
    void testAdjascentRange1Left(){
        Camp adjascent = new Camp(3,2);
        boolean result = camp.addAdjacent(adjascent);
        assertTrue(result);
    }

    @Test
    void testAdjascentRange1Right(){
        Camp adjascent = new Camp(3,4);
        boolean result = camp.addAdjacent(adjascent);
        assertTrue(result);
    }

    @Test
    void testAdjascentRange1Top(){
        Camp adjascent = new Camp(2,3);
        boolean result = camp.addAdjacent(adjascent);
        assertTrue(result);
    }

    @Test
    void testAdjascentRange1Down(){
        Camp adjascent = new Camp(4,3);
        boolean result = camp.addAdjacent(adjascent);
        assertTrue(result);
    }

    @Test
    void testAdjascentRange2(){
        Camp adjascent = new Camp(2,2);
        boolean result = camp.addAdjacent(adjascent);
        assertTrue(result);
    }

    @Test
    void testNotAdjascent(){
        Camp adjascent = new Camp(1,4);
        boolean result = camp.addAdjacent(adjascent);
        assertFalse(result);
    }


}
