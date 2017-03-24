package hu.sinap86.codewars;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Next bigger number with the same digits CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/next-bigger-number-with-the-same-digits"> https://www.codewars.com/kata/next-bigger-number-with-the-same-digits</a>
 */
public class Kata {

    public static long nextBiggerNumber(long n) {
        if (n < 10) {
            return -1;
        }

        final StringBuilder sb = new StringBuilder();

        final String str = String.valueOf(n);
        for (int i = str.length() - 1; i > 0; i--) {
            // find the first place from the right where the left-digit is less than the right one
            final int digit = Character.getNumericValue(str.charAt(i - 1));
            if (digit < Character.getNumericValue(str.charAt(i))) {

                // find the smallest digit that is larger than left-digit
                int smallestLargerDigit = 9;
                int indexOfSmallestLargerDigit = 0;
                for (int j = i; j < str.length(); j++) {
                    final int actualDigit = Character.getNumericValue(str.charAt(j));
                    if (actualDigit > digit && actualDigit <= smallestLargerDigit) {
                        smallestLargerDigit = actualDigit;
                        indexOfSmallestLargerDigit = j;
                    }
                }

                // collect the righter digits except the smallest larger one
                final ArrayList<Integer> digits = new ArrayList<>();
                for (int j = i - 1; j < str.length(); j++) {
                    if (j != indexOfSmallestLargerDigit) {
                        digits.add(Character.getNumericValue(str.charAt(j)));
                    }
                }

                sb.append(str.substring(0, i - 1));
                sb.append(smallestLargerDigit);

                // sort the digits
                Collections.sort(digits);
                for (int actualDigit : digits) {
                    sb.append(actualDigit);
                }
                return Long.parseLong(sb.toString());
            }
        }
        return -1;
    }
}
