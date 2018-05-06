package hu.sinap86.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleAssembler {

    private static final Pattern PATTERN = Pattern.compile("(mov|inc|dec|jnz){1}\\s{1}(\\w){1}\\s?(-?\\w+)?");

    public static Map<String, Integer> interpret(String[] program) {
        final Map<String, Integer> registers = new HashMap<>();
        int index = 0;
        while (true) {
            if (index >= program.length) {
                return registers;
            }
            final Matcher matcher = PATTERN.matcher(program[index]);
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
                        index++;
                        break;
                    case "inc":
                        registers.put(register, registers.get(register) + 1);
                        index++;
                        break;
                    case "dec":
                        registers.put(register, registers.get(register) - 1);
                        index++;
                        break;
                    case "jnz":
                        if (!registers.containsKey(register) || registers.get(register) != 0) {
                            index = index + Integer.parseInt(value);
                        } else {
                            index++;
                        }
                        break;
                }
            }
        }
    }

}
