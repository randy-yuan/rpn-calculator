package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnPow2Command extends RpnUnitaryCommand {
    public RpnPow2Command(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.POW2;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.pow(2, op.doubleValue())));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
