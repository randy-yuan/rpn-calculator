package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnExpCommand extends RpnUnitaryCommand {
    public RpnExpCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.EXP;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.pow(Math.E, op.doubleValue())));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
