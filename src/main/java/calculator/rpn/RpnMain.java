package calculator.rpn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by randy on 18/10/30.
 *
 * A command-line based RPN (reverse polish notation) calculator.
 * The following operators are supported:
 *   '+'   - performs the addition on the top two items from the stack
 *   '-'   - performs the subtraction on the top two items from the stack
 *   '*'   - performs the multiplication on the top two items from the stack
 *   '/'   - performs the division on the top two items from the stack
 *   sqrt  - performs a square root on the top item from the stack
 *   undo  - undoes the previous operation, “undo undo” will undo the previous two operations
 *   clear - removes all items from the stack
 *   exit  - exit the calculator
 */
public class RpnMain {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    CalculatorContext context = new CalculatorContext();
    RpnCalculator calculator = new RpnCalculator(context);
    try {
      boolean success = true;
      while (success) {
        success = calculator.parseAndCalc(reader.readLine());
        pw.append("stack: ").println(context.stackContent());
        pw.flush();
      }
    } catch (Exception e) {
      pw.println(e.getMessage());
      pw.append("stack: ").println(context.stackContent());
      pw.flush();
    }
  }

}
