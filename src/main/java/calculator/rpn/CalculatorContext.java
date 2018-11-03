package calculator.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by randy on 18/10/30.
 */
public class CalculatorContext {
  private Deque<BigDecimal> stack;
  private OpCommandHistory commandHistory;

  public CalculatorContext() {
    stack = new LinkedList<>();
    commandHistory = new OpCommandHistory();
  }

  public BigDecimal pop() {
    return stack.removeLast();
  }

  public BigDecimal peek() {
    return stack.peekLast();
  }

  public void push(BigDecimal number) {
    stack.addLast(number);
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public int stackSize() {
    return stack.size();
  }

  public OpCommandHistory getCommandHistory() {
    return commandHistory;
  }

  /**
   * Formats the current contents of the stack to a space-separated string
   * and appends the result to the given string buffer.
   *
   * @param sb the result string buffer to be appended
   */
  public void printStack(StringBuffer sb) {
    if (sb != null) {
      DecimalFormat df = new DecimalFormat("0.##########");
      df.setRoundingMode(RoundingMode.DOWN);
      for (BigDecimal number : stack) {
        df.format(number, sb, new FieldPosition(0)).append(' ');
      }
      if (sb.length() > 0) {
        sb.setLength(sb.length() - 1);
      }
    }
  }

  /**
   * Formats and returns the current contents of the stack as a space-separated string.
   *
   * @return the formatted string
   */
  public String stackContent() {
    StringBuffer sb = new StringBuffer();
    printStack(sb);
    return sb.toString();
  }

  /**
   * Resets the context, clears the stack and the command histories.
   */
  public void reset() {
    stack.clear();
    commandHistory.clear();
  }
}
