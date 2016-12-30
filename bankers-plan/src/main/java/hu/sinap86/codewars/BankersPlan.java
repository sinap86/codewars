package hu.sinap86.codewars;

/**
 * Banker's Plan CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/56445c4755d0e45b8c00010a">
 *     https://www.codewars.com/kata/56445c4755d0e45b8c00010a</a>
 */
public class BankersPlan {

    // f0 - deposit, p - interest rate, c0 - withdrawed amount, n - years, i - inflation
    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        int[][] data = new int[n][2];
        data[0] = new int[]{ f0, c0 };
        for (int j = 1; j < n; j++) {
            int f = (int) (data[j - 1][0] * (1 + p / 100) - data[j - 1][1]);
            int c = (int) (data[j - 1][1] * (1 + i / 100));
            data[j] = new int[]{ f, c };
            if (f < 0) {
                return false;
            }
        }
        return true;
    }
}
