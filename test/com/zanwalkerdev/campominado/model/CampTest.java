package com.zanwalkerdev.campominado.model;

import com.zanwalkerdev.campominado.exceptions.ExplosionException;
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

    @Test
    void testStandardValueMarked(){
        assertFalse(camp.isMarked());
    }

    @Test
    void testToggleMarked(){
        camp.toggleMark();
        assertTrue(camp.isMarked());
    }

    @Test
    void testToggleMarked2Times(){
        camp.toggleMark();
        camp.toggleMark();
        assertFalse(camp.isMarked());
    }

    @Test
    void openCampWithoutMineNoMarked(){
        assertTrue(camp.open());
    }

    @Test
    void openCampWithoutMineButMarked(){
        camp.toggleMark();
        assertFalse(camp.open());
    }

    @Test
    void openCampMinedAndMarked(){
        camp.toggleMark();
        camp.toMine();
        assertFalse(camp.open());
    }

    @Test
    void openCampMinedNoMarked(){ // BOOOOM!
        camp.toMine();

        assertThrows(ExplosionException.class, () -> camp.open());
    }

    @Test
    void openWithAdjacentSafe1(){
        Camp camp11 = new Camp(1,1);
        Camp camp22 = new Camp(2,2);

        camp22.addAdjacent(camp11);
        camp.addAdjacent(camp22);

        camp.open();

        assertTrue(camp22.isOpened() && camp11.isOpened());
    }

    @Test
    void openWithAdjacentSafe2(){
        Camp camp11 = new Camp(1,1);
        Camp camp12 = new Camp(1,2);
        camp12.toMine();
        Camp camp22 = new Camp(2,2);

        camp22.addAdjacent(camp11);
        camp22.addAdjacent(camp12);
        camp.addAdjacent(camp22);

        camp.open();

        assertTrue(camp22.isOpened() && !camp11.isOpened());
    }




}
