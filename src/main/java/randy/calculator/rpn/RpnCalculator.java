package randy.calculator.rpn;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by randy on 18/10/31.
 */
public class RpnCalculator {
  private RpnContext context;
  private RpnCommandHistory history;
  private Map<Operator, RpnCommand> commandMap;

  public RpnCalculator(RpnContext context) {
    this.context = context;
    this.history = new RpnCommandHistory();
    this.commandMap = new EnumMap<>(Operator.class);
  }

  public void setCommand(Operator op, RpnCommand command) {
    commandMap.put(op, command);
  }

  public RpnCommand getCommand(Operator op) {
    return commandMap.get(op);
  }

  /**
   * Parses and calculates the input RPN string.
   *
   * @param input the input string containing whitespace separated lists of numbers and operators
   * @return true, or false if 'exit' is received
   * @throws RpnException if invalid operator, insufficient parameters, division by zero
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
    Operator op = Operator.of(opStr);
    if (op == Operator.EXIT) {
      return false;
    }
    if (op == Operator.UNDO) {
      Optional<RpnCommand> lastCommand = history.pop();
      lastCommand.ifPresent(RpnCommand::undo);
      return true;
    } else {
      context.setOp(opStr);
      context.setPos(pos);
      RpnCommand command = getCommand(op);
      if (command != null) {
        command.execute();
        history.push(command);
        return true;
      } else {
        return false;
      }
    }
  }
}
