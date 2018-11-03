package calculator.rpn;

/**
 * Created by randy on 18/10/30.
 */
public class InsufficientParameterException extends CalculatorException {
  public InsufficientParameterException(Operator op, int pos) {
    super(op, pos, String.format("operator %s (position: %d): insufficient parameters", op, pos));
  }
}
