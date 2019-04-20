package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnLog2Command extends RpnUnitaryCommand {
    private static final double LOG2 = Math.log(2);

    public RpnLog2Command(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.LOG2;
    }

    @Override
    public void execute() {
        checkOperand();

        try {
            BigDecimal op = getContext().popToHistory();
            getContext().push(BigDecimal.valueOf(Math.log(op.doubleValue()) / LOG2));
        } catch (ArithmeticException|NumberFormatException e) {
            throw new RpnArithmeticException(this);
        }
    }
}
