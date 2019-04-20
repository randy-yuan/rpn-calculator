package randy.calculator.rpn;

public class RpnStackOverflowException extends RpnException {
    public RpnStackOverflowException(RpnContext context) {
        super(context, String.format("operator %s (position: %d): stack overflow",
                context.getOp(), context.getPos()));
    }
}
