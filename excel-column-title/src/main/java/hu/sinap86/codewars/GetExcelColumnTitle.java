package hu.sinap86.codewars;

/**
 * Get the Excel column title! CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/get-the-excel-column-title/">
 *     https://www.codewars.com/kata/get-the-excel-column-title/</a>
 */
public class GetExcelColumnTitle {

    public static String getColumnTitle(int num) {
        if (num < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 26;
            if (rem == 0) {
                sb.append('Z');
                num = (num / 26) - 1;
            } else {
                char aChar = (char) ((rem - 1) + 'A');
                System.out.println("Added: " + aChar);
                sb.append(aChar);
                num = num / 26;
            }
        }

        return sb.reverse().toString();
    }
}
