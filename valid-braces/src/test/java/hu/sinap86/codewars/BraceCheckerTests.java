package hu.sinap86.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Sinka László
 */
public class BraceCheckerTests {

    private BraceChecker checker = new BraceChecker();

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("[(])"));
    }
}
