package randy.calculator.rpn;

/**
 * Created by randy on 18/10/30.
 */
public class InsufficientParameterException extends RpnException {
  public InsufficientParameterException(RpnCommand command) {
    super(command, String.format("operator %s (position: %d): insufficient parameters",
            command.getContext().getOp(), command.getContext().getPos()));
  }
}
