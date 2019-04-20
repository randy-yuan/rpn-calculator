package randy.calculator.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RpnDivCommand extends RpnBinaryCommand {
    public RpnDivCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.DIV;
    }

    @Override
    public void execute() {
        checkOperand();
        if (getContext().peek().compareTo(BigDecimal.ZERO) == 0) {
            throw new DivisionByZeroException(this);
        }

        BigDecimal op1 = getContext().popToHistory();
        BigDecimal op2 = getContext().popToHistory();
        BigDecimal result = op2.divide(op1, MAX_SCALE, RoundingMode.HALF_UP).stripTrailingZeros();
        getContext().push(result);
    }
}
