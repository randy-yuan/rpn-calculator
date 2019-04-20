package randy.calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class DivisionByZeroException extends RpnException {
  public DivisionByZeroException(RpnCommand command) {
    super(command, String.format("operator %s (position: %d): division by zero",
            command.getContext().getOp(), command.getContext().getPos()));
  }
}
