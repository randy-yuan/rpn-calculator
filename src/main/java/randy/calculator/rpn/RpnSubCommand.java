package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnSubCommand extends RpnBinaryCommand {
    @Override
    public Operator getOperator() {
        return Operator.SUB;
    }

    @Override
    public void execute() {
        checkOperand();
        BigDecimal op1 = getContext().popToHistory();
        BigDecimal op2 = getContext().popToHistory();
        getContext().push(op2.subtract(op1));
    }
}
