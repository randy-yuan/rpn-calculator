package calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class InvalidOperatorException extends CalculatorException {
  public InvalidOperatorException(String op, int pos) {
    super(op, pos, String.format("operator %s (position: %d): invalid", op, pos));
  }

  public InvalidOperatorException(Operator op, int pos) {
    super(op, pos, String.format("operator %s (position: %d): invalid", op, pos));
  }
}
