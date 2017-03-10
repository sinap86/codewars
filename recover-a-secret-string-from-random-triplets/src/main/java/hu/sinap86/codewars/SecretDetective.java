package hu.sinap86.codewars;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Recover a secret string from random triplets Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets"> https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets</a>
 */
public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        final HashSet<Character> allDependentChars = new HashSet<>();
        final HashMap<Character, HashSet<Character>> charDependency = new HashMap<>();
        for (char[] triplet : triplets) {
            for (int i = 0; i < triplet.length - 1; i++) {
                final char actualChar = triplet[i];
                final char nextChar = triplet[i + 1];
                HashSet<Character> dependentChars = charDependency.get(actualChar);
                if (dependentChars == null) {
                    dependentChars = new HashSet<>();
                    charDependency.put(actualChar, dependentChars);
                }
                dependentChars.add(nextChar);
                allDependentChars.add(nextChar);
            }
        }

        final Character firstLetter = charDependency.entrySet().stream().filter(e -> !allDependentChars.contains(e.getKey())).findFirst().get().getKey();
        final TreeSet<String> paths = new TreeSet<>(Comparator.comparing(String::length));
        buildTree(charDependency, firstLetter, "", paths);
        return paths.last();
    }

    private void buildTree(final HashMap<Character, HashSet<Character>> routesDefinition, final Character from, String pathVisited, final TreeSet<String> paths) {
        final HashSet<Character> destinations = routesDefinition.get(from);
        pathVisited += from;
        if (destinations == null) {
            paths.add(pathVisited);
        } else {
            for (Character destination : destinations) {
                buildTree(routesDefinition, destination, pathVisited, paths);
            }
        }
    }

}
