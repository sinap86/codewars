package hu.sinap86.codewars;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * Best travel CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/best-travel"> https://www.codewars.com/kata/best-travel</a>
 */
public class SumOfK {

    private static int[] data;
    private static TreeSet<Integer> sums;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        data = new int[k];
        sums = new TreeSet<>();
        calculateSums(ls, k, 0, 0);

        final Iterator<Integer> it = sums.descendingIterator();
        while (it.hasNext()) {
            final Integer next = it.next();
            if (next <= t) {
                return next;
            }
        }
        return null;
    }

    private static void calculateSums(final List<Integer> ls, final int k, final int start, final int index) {
        if (index == k) {
            /*
            for (int i : data) {
                System.out.print(i + " ");
            }
            */
            final int sum = IntStream.of(data).sum();
            sums.add(sum);
            // System.out.println("sum: " + sum);
            return;
        }
        for (int i = start; i < ls.size(); i++) {
            data[index] = ls.get(i);
            calculateSums(ls, k, i + 1, index + 1);
        }
    }
}
