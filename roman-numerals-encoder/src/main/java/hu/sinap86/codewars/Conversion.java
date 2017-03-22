package hu.sinap86.codewars;

/**
 * Roman Numerals Encoder CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/roman-numerals-encoder"> https://www.codewars.com/kata/roman-numerals-encoder</a>
 */
public class Conversion {

    private int[] values = { 1000, 900, 800, 500, 400, 100, 90, 80, 50, 40, 10, 9, 8, 5, 4, 1 };
    private String[] symbols = { "M", "CM", "DCCC", "D", "CD", "C", "XC", "LXXX", "L", "XL", "X", "IX", "VIII", "V", "IV", "I" };

    public String solution(int n) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            final int value = values[i];
            while (n >= value) {
                n -= value;
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

}
