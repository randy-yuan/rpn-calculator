package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnSquareCommand extends RpnUnitaryCommand {
    public RpnSquareCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.SQUARE;
    }

    @Override
    public void execute() {
        checkOperand();

        BigDecimal op = getContext().popToHistory();
        getContext().push(op.multiply(op));
    }
}
