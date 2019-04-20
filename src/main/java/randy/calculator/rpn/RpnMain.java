package randy.calculator.rpn;

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
 *   pow   - performs the pow on the top two items from the stack
 *   sqrt  - performs a square root on the top item from the stack
 *   '**'  - performs a square on the top item from the stack
 *   exp   - E raised to the power of the top item from the stack
 *   ten   - 10 raised to the power of the top item from the stack
 *   pow2  - 2 raised to the power of the top item from the stack
 *   ln    - performs the natural logarithm (base E) on the top item from the stack
 *   log   - performs the base 10 logarithm on the top item from the stack
 *   log2  - performs the base 2 logarithm on the top item from the stack
 *   e     - push the E value to the stack
 *   pi    - push the PI value to the stack
 *   rand  - push a random number between 0 and 1.0 to the stack
 *   undo  - undoes the previous operation, “undo undo” will undo the previous two operations
 *   clear - removes all items from the stack
 *   exit  - exit the calculator
 */
public class RpnMain {
  public static void initCommands(RpnCalculator calculator, RpnContext context) {
    calculator.setCommand(Operator.ADD, new RpnAddCommand(context));
    calculator.setCommand(Operator.SUB, new RpnSubCommand(context));
    calculator.setCommand(Operator.MUL, new RpnMulCommand(context));
    calculator.setCommand(Operator.DIV, new RpnDivCommand(context));
    calculator.setCommand(Operator.POW, new RpnPowCommand(context));
    calculator.setCommand(Operator.SQRT, new RpnSqrtCommand(context));
    calculator.setCommand(Operator.SQUARE, new RpnSquareCommand(context));
    calculator.setCommand(Operator.EXP, new RpnExpCommand(context));
    calculator.setCommand(Operator.TEN, new RpnTenCommand(context));
    calculator.setCommand(Operator.POW2, new RpnPow2Command(context));
    calculator.setCommand(Operator.LN, new RpnLnCommand(context));
    calculator.setCommand(Operator.LOG, new RpnLogCommand(context));
    calculator.setCommand(Operator.LOG2, new RpnLog2Command(context));
    calculator.setCommand(Operator.CLEAR, new RpnClearCommand(context));
    calculator.setCommand(Operator.NUM, new RpnNumberCommand(context));
    calculator.setCommand(Operator.E, new RpnECommand(context));
    calculator.setCommand(Operator.PI, new RpnPiCommand(context));
    calculator.setCommand(Operator.RAND, new RpnRandCommand(context));
  }

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    RpnContext context = new RpnContext();
    RpnCalculator calculator = new RpnCalculator(context);
    initCommands(calculator, context);

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
