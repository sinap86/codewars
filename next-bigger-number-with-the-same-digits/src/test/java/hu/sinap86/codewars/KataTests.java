package hu.sinap86.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Sinka László
 */
public class KataTests {

    @Test
    public void basicTests() {
        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));
    }

    @Test
    public void harderTests() {
        assertEquals(123456785123446789L, Kata.nextBiggerNumber(123456784987654321L));
        assertEquals(1834525096, Kata.nextBiggerNumber(1834525069  ));
        assertEquals(123456798, Kata.nextBiggerNumber(123456789 ));

    }

}
