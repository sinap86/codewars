package hu.sinap86.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleAssembler2 {

    private static final Pattern PATTERN = Pattern.compile("(mov|inc|dec|jnz){1}\\s{1}(\\w){1}\\s?(-?\\w+)?");

    public static Map<String, Integer> interpret(String[] program) {
        // TODO remove
        System.out.println("program: " + Arrays.deepToString(program));
        final Map<String, Integer> registers = new HashMap<>();
        processNextInstruction(Arrays.asList(program).listIterator(), registers);
        return registers;
    }

    private static void processNextInstruction(final ListIterator<String> iterator, final Map<String, Integer> registers) {
        if (!iterator.hasNext()) {
            return;
        }

        final String instruction = iterator.next();
        // TODO remove
        System.out.println("instruction: " + instruction);
        final Matcher matcher = PATTERN.matcher(instruction);
        if (matcher.matches()) {
            final String command = matcher.group(1);
            final String register = matcher.group(2);
            final String value = matcher.group(3);
            switch (command) {
                case "mov":
                    if (value.matches("[a-zA-Z]+")) {
                        registers.put(register, registers.get(value));
                    } else {
                        registers.put(register, Integer.parseInt(value));
                    }
                    break;
                case "inc":
                    registers.put(register, registers.get(register) + 1);
                    break;
                case "dec":
                    registers.put(register, registers.get(register) - 1);
                    break;
                case "jnz":
                    System.out.println("\t\tjnz");
                    if ((register.matches("-?[0-9]+") && Integer.parseInt(register) != 0) || registers.get(register) != 0) {
                        System.out.println("\t\tjnz - move");
                        move(iterator, Integer.parseInt(value));
                    }
                    break;
            }
            System.out.println("\tregisters: " + registers);
            processNextInstruction(iterator, registers);
        }
    }

    private static void move(final ListIterator<String> iterator, final int step) {
        if (step < 0) {
            for (int i = step; i <= 0; i++) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            }
        } else {
            for (int i = step; i > 1; i--) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            }
        }
    }
}
