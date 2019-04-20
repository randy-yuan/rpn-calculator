package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnPowCommand extends RpnBinaryCommand {
    public RpnPowCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.POW;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            double op1 = getContext().popToHistory().doubleValue();
            double op2 = getContext().popToHistory().doubleValue();
            getContext().push(BigDecimal.valueOf(Math.pow(op2, op1)));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
