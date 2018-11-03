package calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class DivisionByZeroException extends CalculatorException {
  public DivisionByZeroException(Operator op, int pos) {
    super(op, pos, String.format("operator %s (position: %d): division by zero", op, pos));
  }
}
