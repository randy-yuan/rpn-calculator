package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnTenCommand extends RpnUnitaryCommand {
    public RpnTenCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.TEN;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.pow(10, op.doubleValue())));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
