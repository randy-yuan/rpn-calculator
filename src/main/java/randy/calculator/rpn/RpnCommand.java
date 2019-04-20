package randy.calculator.rpn;

import java.math.MathContext;
import java.math.RoundingMode;

public abstract class RpnCommand {
    public static final int MAX_SCALE = 15;
    public static final int PRECISION = 100;

    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    public static final MathContext MC = new MathContext(PRECISION, ROUNDING_MODE);

    private RpnContext context;

    public RpnCommand(RpnContext context) {
        this.context = context;
    }

    public RpnContext getContext() {
        return context;
    }

    public RpnCommand setContext(RpnContext context) {
        this.context = context;
        return this;
    }

    public abstract Operator getOperator();

    public abstract int operandCount();

    public abstract void execute();

    public abstract void undo();

    protected void checkOperand() {
        if (getContext().stackSize() < operandCount()) {
            throw new InsufficientParameterException(this);
        }
    }
}
