package randy.calculator.rpn;

public abstract class RpnCommand {
    public static final int MAX_SCALE = 15;

    private RpnContext context;

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
