package hu.sinap86.codewars;

import java.util.Stack;

/**
 * Reverse polish notation calculator CodeWars Kata for Java language.
 *
 * @author Sinka László
 * @see <a href="https://www.codewars.com/kata/reverse-polish-notation-calculator/"> https://www.codewars.com/kata/reverse-polish-notation-calculator/</a>
 */
public class Calc {

    public double evaluate(String expr) {
        if (expr.isEmpty()) {
            return 0;
        }

        final Stack<Double> stack = new Stack<>();
        for (String token : expr.split(" ")) {
            if (token.matches("[\\+\\-\\*/]")) {
                final Double operandB = stack.pop();
                final Double operandA = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operandA + operandB);
                        break;
                    case "-":
                        stack.push(operandA - operandB);
                        break;
                    case "*":
                        stack.push(operandA * operandB);
                        break;
                    case "/":
                        stack.push(operandA / operandB);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
}
