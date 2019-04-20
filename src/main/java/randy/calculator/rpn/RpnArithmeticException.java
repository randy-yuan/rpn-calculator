package randy.calculator.rpn;

public class RpnArithmeticException extends RpnException {
    public RpnArithmeticException(RpnCommand command) {
        super(command, String.format("operator %s (position: %d): arithmetic error",
                command.getContext().getOp(), command.getContext().getPos()));
    }
}
