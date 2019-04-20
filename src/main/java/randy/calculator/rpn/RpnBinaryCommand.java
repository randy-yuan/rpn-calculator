package randy.calculator.rpn;

import java.util.NoSuchElementException;

public abstract class RpnBinaryCommand extends RpnCommand {
    @Override
    public int operandCount() {
        return 2;
    }

    @Override
    public void undo() {
        try {
            getContext().pop();
            getContext().recover(operandCount());
        } catch (NoSuchElementException e) {
            throw new RpnStackError(this);
        }
    }
}
