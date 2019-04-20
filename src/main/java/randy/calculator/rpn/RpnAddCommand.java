package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnAddCommand extends RpnBinaryCommand {
    public RpnAddCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.ADD;
    }

    @Override
    public void execute() {
        checkOperand();
        BigDecimal op1 = getContext().popToHistory();
        BigDecimal op2 = getContext().popToHistory();
        getContext().push(op1.add(op2));
    }
}
