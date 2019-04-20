package randy.calculator.rpn;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class RpnClearCommand extends RpnCommand {
    @Override
    public Operator getOperator() {
        return Operator.CLEAR;
    }

    @Override
    public int operandCount() {
        return -1;
    }

    @Override
    public void execute() {
        int count = 0;
        while (getContext().isNotEmpty()) {
            getContext().popToHistory();
            count++;
        }
        getContext().pushHistory(BigDecimal.valueOf(count));
    }

    @Override
    public void undo() {
        try {
            int count = getContext().popHistory().intValue();
            getContext().recover(count);
        } catch (NoSuchElementException e) {
            throw new RpnStackError(this);
        }
    }
}
