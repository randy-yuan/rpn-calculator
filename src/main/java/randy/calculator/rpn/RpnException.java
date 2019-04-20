package randy.calculator.rpn;

/**
 * Created by randy on 18/11/3.
 */
public class RpnException extends RuntimeException {
    private String op;
    private int pos;

    public RpnException(RpnContext context, String message) {
        super(message);
        this.op = context.getOp();
        this.pos = context.getPos();
    }

    public RpnException(RpnCommand command, String message) {
        this(command.getContext(), message);
    }

    public String getOp() {
        return op;
    }

    public int getPos() {
        return pos;
    }
}
