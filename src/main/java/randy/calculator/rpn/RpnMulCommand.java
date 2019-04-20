package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnMulCommand extends RpnBinaryCommand {
    @Override
    public Operator getOperator() {
        return Operator.MUL;
    }

    @Override
    public void execute() {
        checkOperand();
        BigDecimal op1 = getContext().popToHistory();
        BigDecimal op2 = getContext().popToHistory();
        getContext().push(op2.multiply(op1));
    }
}
