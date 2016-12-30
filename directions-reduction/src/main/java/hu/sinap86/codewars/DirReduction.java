package hu.sinap86.codewars;

import java.util.Arrays;

/**
 * Directions Reduction CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/550f22f4d758534c1100025a">
 *     https://www.codewars.com/kata/550f22f4d758534c1100025a</a>
 */
public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (("NORTH".equals(arr[i]) && "SOUTH".equals(arr[i + 1])) ||
                ("SOUTH".equals(arr[i]) && "NORTH".equals(arr[i + 1])) ||
                ("EAST".equals(arr[i]) && "WEST".equals(arr[i + 1])) ||
                ("WEST".equals(arr[i]) && "EAST".equals(arr[i + 1]))) {
                arr[i] = null;
                arr[i + 1] = null;
            }
        }
        final String[] newArr = Arrays.stream(arr)
                .filter(s -> s != null)
                .toArray(String[]::new);

        if (newArr.length == arr.length) {
            return arr;
        } else {
            return dirReduc(newArr);
        }
    }
}
