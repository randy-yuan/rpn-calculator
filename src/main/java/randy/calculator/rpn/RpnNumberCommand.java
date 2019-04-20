package randy.calculator.rpn;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class RpnNumberCommand extends RpnCommand {
    public RpnNumberCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.NUM;
    }

    @Override
    public int operandCount() {
        return 0;
    }

    @Override
    public void execute() {
        try {
            getContext().push(new BigDecimal(getContext().getOp()));
        } catch (NumberFormatException e) {
            throw new InvalidOperatorException(this);
        }
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
