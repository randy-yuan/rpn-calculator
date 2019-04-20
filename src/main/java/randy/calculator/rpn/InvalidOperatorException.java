package randy.calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class InvalidOperatorException extends RpnException {
  public InvalidOperatorException(RpnCommand command) {
    super(command, String.format("operator %s (position: %d): invalid",
            command.getContext().getOp(), command.getContext().getPos()));
  }
}
