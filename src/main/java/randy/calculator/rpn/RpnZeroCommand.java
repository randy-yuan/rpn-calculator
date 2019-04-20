package randy.calculator.rpn;

import java.util.NoSuchElementException;

public abstract class RpnZeroCommand extends RpnCommand {
    public RpnZeroCommand(RpnContext context) {
        super(context);
    }

    @Override
    public int operandCount() {
        return 0;
    }

    @Override
    public void undo() {
        try {
            getContext().pop();
        } catch (NoSuchElementException e) {
            throw new RpnStackError(this);
        }
    }
}
