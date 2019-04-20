package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnLogCommand extends RpnUnitaryCommand {
    public RpnLogCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.LOG;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.log10(op.doubleValue())));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
