package calculator.rpn;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by randy on 18/10/31.
 */
public class RpnCalculator {
  private CalculatorContext context;

  public RpnCalculator(CalculatorContext context) {
    this.context = context;
  }

  /**
   * Parses and calculates the input RPN string.
   *
   * @param input the input string containing whitespace separated lists of numbers and operators
   * @return true, or false if 'exit' is received
   * @throws CalculatorException if invalid operator, insufficient parameters, division by zero
   */
  public boolean parseAndCalc(String input) {
    int inputLen = input.length();
    boolean opFlag = false;
    int pos = 0;
    int start = 0;
    for (; pos < inputLen; pos++) {
      if (opFlag && Character.isWhitespace(input.charAt(pos))) {
        opFlag = false;
        if (!calc(input.substring(start, pos), start + 1)) {
          return false;
        }
      } else if (!opFlag && !Character.isWhitespace(input.charAt(pos))) {
        opFlag = true;
        start = pos;
      }
    }
    return !opFlag || calc(input.substring(start).trim(), start + 1);
  }

  private boolean calc(String opStr, int pos) {
    OpCommand command = toCommand(opStr, pos);
    if (command == null) {
      throw new InvalidOperatorException(opStr, pos);
    }
    if (command.getOp() == Operator.EXIT) {
      return false;
    }
    if (command.getOp() == Operator.UNDO) {
      Optional<OpCommand> lastCommand = context.getCommandHistory().pop();
      if (lastCommand.isPresent()) {
        lastCommand.get().undo(context);
      }
    } else {
      command.execute(context);
      context.getCommandHistory().push(command);
    }
    return true;
  }

  private OpCommand toCommand(String opStr, int pos) {
    OpCommand command = new OpCommand(Operator.of(opStr), pos);
    if (command.getOp() == Operator.NUM) {
      try {
        command.addInput(new BigDecimal(opStr));
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return command;
  }
}
