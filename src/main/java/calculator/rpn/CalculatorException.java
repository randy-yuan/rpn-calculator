package calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class CalculatorException extends RuntimeException {
  private String op;
  private int pos;

  public CalculatorException(String op, int pos, String message) {
    super(message);
    this.op = op;
    this.pos = pos;
  }

  public CalculatorException(Operator op, int pos, String message) {
    this(op.getSign(), pos, message);
  }

  public String getOp() {
    return op;
  }

  public int getPos() {
    return pos;
  }
}
