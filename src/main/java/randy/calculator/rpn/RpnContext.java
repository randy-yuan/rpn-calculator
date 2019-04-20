package randy.calculator.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by randy on 18/10/30.
 */
public class RpnContext {
  private Deque<BigDecimal> stack;
  private Deque<BigDecimal> history;
  private String op;
  private int pos;

  public RpnContext() {
    stack = new LinkedList<>();
    history = new LinkedList<>();
  }

  public BigDecimal peek() {
    return stack.peekLast();
  }

  public BigDecimal pop() {
    return stack.removeLast();
  }

  public BigDecimal popToHistory() {
    BigDecimal num = pop();
    pushHistory(num);
    return num;
  }

  public RpnContext push(BigDecimal number) {
    stack.addLast(number);
    return this;
  }

  public BigDecimal popHistory() {
    return history.removeLast();
  }

  public RpnContext pushHistory(BigDecimal number) {
    history.addLast(number);
    return this;
  }

  public RpnContext recover(int n) {
    for (int i = 0; i < n; i++) {
      push(popHistory());
    }
    return this;
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public boolean isNotEmpty() {
    return !isEmpty();
  }

  public int stackSize() {
    return stack.size();
  }

  public String getOp() {
    return op;
  }

  public RpnContext setOp(String op) {
    this.op = op;
    return this;
  }

  public int getPos() {
    return pos;
  }

  public RpnContext setPos(int pos) {
    this.pos = pos;
    return this;
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
   * Resets the stack.
   */
  public void reset() {
    stack.clear();
    history.clear();
  }
}
