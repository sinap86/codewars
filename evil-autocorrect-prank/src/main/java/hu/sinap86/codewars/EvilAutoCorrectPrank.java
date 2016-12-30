package hu.sinap86.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evil AutoCorrect Prank CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/evil-autocorrect-prank/train/java">
 * https://www.codewars.com/kata/evil-autocorrect-prank/train/java</a>
 */
public class EvilAutoCorrectPrank {
    public static String autoCorrect(final String input) {
        final Pattern patternYou = Pattern.compile("([yY][oO])([uU])+(\\W)*");
        final Pattern patternU = Pattern.compile("\\s*[uU]\\s*");
        final String[] words = input.split("\\s");
        for (int i = 0; i < words.length; i++) {
            final Matcher matcherYou = patternYou.matcher(words[i]);
            final Matcher matcherU = patternU.matcher(words[i]);
            if (matcherYou.matches()) {
                words[i] = matcherYou.replaceAll("your sister$3");
            } else if (matcherU.matches()) {
                words[i] = matcherU.replaceAll("your sister");
            }
        }
        return String.join(" ", words);
    }
}
