package hu.sinap86.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Sinka László
 */
public class GetExcelColumnTitleTest {

    public static int getRandInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static int getColumnNumber(String col) {
        String abc = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            result += abc.indexOf(col.charAt(i)) * (int) Math.pow(26, col.length() - i - 1);
        }
        return result;
    }

    @Test
    public void examplesInDescriptionTest() {
        assertEquals("A", GetExcelColumnTitle.getColumnTitle(1));
        assertEquals("Z", GetExcelColumnTitle.getColumnTitle(26));
        assertEquals("AA", GetExcelColumnTitle.getColumnTitle(27));
        assertEquals("AZ", GetExcelColumnTitle.getColumnTitle(52));
        assertEquals("BA", GetExcelColumnTitle.getColumnTitle(53));
        assertEquals("ZZ", GetExcelColumnTitle.getColumnTitle(702));
        assertEquals("AAA", GetExcelColumnTitle.getColumnTitle(703));
        assertEquals("AYK", GetExcelColumnTitle.getColumnTitle(1337));
        assertEquals("XPEH", GetExcelColumnTitle.getColumnTitle(432778));

        int num1 = GetExcelColumnTitleTest.getRandInt(1, 100);
        String title1 = GetExcelColumnTitle.getColumnTitle(num1);
        int expected1 = GetExcelColumnTitleTest.getColumnNumber(title1);
        assertEquals(expected1, num1);

        int num2 = GetExcelColumnTitleTest.getRandInt(10000, 100000);
        String title2 = GetExcelColumnTitle.getColumnTitle(num2);
        int expected2 = GetExcelColumnTitleTest.getColumnNumber(title2);
        assertEquals(expected2, num2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroInputShouldThrowIllegalArgumentException() {
        GetExcelColumnTitle.getColumnTitle(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSmallInputShouldThrowIllegalArgumentException() {
        GetExcelColumnTitle.getColumnTitle(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeBigInputShouldThrowIllegalArgumentException() {
        GetExcelColumnTitle.getColumnTitle(-27);
    }

    @Test
    public void bigNumberShouldNotCrash() {
        assertEquals("ZZZ", GetExcelColumnTitle.getColumnTitle(18278));
        assertEquals("AAAA", GetExcelColumnTitle.getColumnTitle(18279));
        assertEquals("FXSHRXW", GetExcelColumnTitle.getColumnTitle(2147483647));
    }
}
