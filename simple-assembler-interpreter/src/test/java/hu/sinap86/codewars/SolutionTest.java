package hu.sinap86.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for SimpleAssembler.
 */
public class SolutionTest {

    @Test
    public void simple_1() {
        String[] program = new String[]{ "mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a" };
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 1);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void simple_2() {
        String[] program = new String[]{ "mov a -10", "mov b a", "inc a", "dec b", "jnz a -2" };
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 0);
        out.put("b", -20);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void complex_1() {
        String[]
                program =
                new String[]{ "mov a 1", "mov b 1", "mov c 0", "mov d 26", "jnz c 2", "jnz 1 5", "mov c 7", "inc d", "dec c", "jnz c -2", "mov c a", "inc a", "dec b", "jnz b -2", "mov b c", "dec d",
                              "jnz d -6", "mov c 18", "mov d 11", "inc a", "dec d", "jnz d -2", "dec c", "jnz c -5" };
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 318009);
        out.put("b", 196418);
        out.put("c", 0);
        out.put("d", 0);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void complex_2() {
        String[]  program = new String[]{ "mov d 100", "dec d", "mov b d", "jnz b -2", "inc d", "mov a d", "jnz 5 10", "mov c a" };
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 1);
        out.put("b", 0);
        out.put("d", 1);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void complex_3() {
        String[] program = new String[]{ "mov c 12", "mov b 0", "mov a 200", "dec a", "inc b", "jnz a -2", "dec c", "mov a b", "jnz c -5", "jnz 0 1", "mov c a" };
        Map<String, Integer> out = new HashMap<String, Integer>();
        out.put("a", 409600);
        out.put("b", 409600);
        out.put("c", 409600);
        assertEquals(out, SimpleAssembler.interpret(program));
    }
}
