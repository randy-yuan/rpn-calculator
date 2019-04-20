package randy.calculator.rpn;

public class RpnStackError extends RpnException {
    public RpnStackError(RpnCommand command) {
        super(command, "Rpn stack error");
    }
}
