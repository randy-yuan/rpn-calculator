package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnLnCommand extends RpnUnitaryCommand {
    public RpnLnCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.LN;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.log(op.doubleValue())));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
