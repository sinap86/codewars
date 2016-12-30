package hu.sinap86.codewars;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * @author Sinka László
 */
public class BankersPlanTest {

    @Test
    public void testFortune() {
        assertTrue(BankersPlan.fortune(100000, 1, 2000, 15, 1));
        assertTrue(BankersPlan.fortune(100000, 1, 10000, 10, 1));
        assertFalse(BankersPlan.fortune(100000, 1, 9185, 12, 1));
    }
}
