package hu.sinap86.codewars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Who won the election? CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/554910d77a3582bbe300009c">
 *     https://www.codewars.com/kata/554910d77a3582bbe300009c</a>
 */
public class BallotsCounter {

    public static String getWinner(final List<String> listOfBallots) {
        final Map<String, Long> counts = listOfBallots.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        final long maxCount = counts.values().stream().max(Long::compare).get();
        final List<String>
                winners =
                counts.entrySet().stream().filter(e -> e.getValue() > listOfBallots.size() / 2 && e.getValue() == maxCount).map(e -> e.getKey()).collect(Collectors.toList());

        return winners.size() == 1 ? winners.get(0) : null;
    }

}
