package be.pxl.dice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DiceSetTests {

    private DiceSet sut;

    @BeforeEach
    public void setUp() {
        sut = new DiceSet(5, 3);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNumberOfDiceLessThenTwo() {
        assertThrows(IllegalArgumentException.class, () -> new DiceSet(4, 1));
    }

    @Test
    public void testGetDescription() {
        assertEquals("3d5", sut.getDescripton());
    }

    @Test
    public void testGetIndividual(){
        assertEquals(1, sut.getIndividual(1));
    }

    @Test
    public void testSetIndividual(){
        sut.setIndividual(0, 4);
        assertEquals(4, sut.getIndividual(0));
    }

    @Test
    public void testSum() {
        assertEquals(3, sut.sum());
    }

    @Test
    public void testToString(){
        assertEquals("[1][1][1]", sut.toString());
    }

    @Test
    public void testRollDice(){
        boolean testSucces = true;
        sut.roll();
        for (int i = 0; i < 3; i++) {
            int value = sut.getIndividual(i);
            if (value < 1 || value > 5) {
                testSucces = false;
            }
        }
        assertTrue(testSucces);
    }

    @Test
    public void testValues(){
        List<Integer> actualValues = sut.values();
        List<Integer> expectedValues = Arrays.asList(1,1,1);

        assertEquals(actualValues, expectedValues);
    }
}
