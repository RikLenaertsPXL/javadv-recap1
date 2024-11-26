package be.pxl.dice.domain;

import be.pxl.dice.exceptions.InvalidDieValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DieTests {

    private Die sut;

    @BeforeEach
    public void setUp() {
        sut = new Die(7);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSidesDieLessThenFour() {
        assertThrows(IllegalArgumentException.class, () -> new Die(2));
    }

    @Test
    public void shouldReturnValueBetweenOneAndValueWhenGetValue() {
        sut.setValue(5);
        assertEquals(5, sut.getValue());
    }

    @Test
    public void shouldThrowInvalidDieExceptionWhenValueBiggerThanSidesOrLessThanOne() {
        assertThrows(InvalidDieValueException.class, () -> sut.setValue(10));
        assertThrows(InvalidDieValueException.class, () -> sut.setValue(-4));
    }

    @Test
    public void shouldSetValueBetweenOneAndNumberOfSidesWhenRoll() {
        sut.roll();
        int value = sut.getValue();
        assertTrue(value >= 1 && value <= sut.getSides());
    }

    @Test
    public void testToString() {
        sut.setValue(5);
        assertEquals("[5]", sut.toString());
    }
}
