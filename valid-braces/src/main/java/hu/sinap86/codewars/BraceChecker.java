package hu.sinap86.codewars;

/**
 * Valid Braces CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/5277c8a221e209d3f6000b56"> https://www.codewars.com/kata/5277c8a221e209d3f6000b56</a>
 */
public class BraceChecker {

    public boolean isValid(String braces) {
        boolean replaced;
        do {
            final int length = braces.length();
            braces = braces.replaceAll("\\{\\}", "").replaceAll("\\(\\)", "").replaceAll("\\[\\]", "");
            replaced = braces.length() < length;
        } while (replaced);

        return braces.isEmpty();
    }
}
