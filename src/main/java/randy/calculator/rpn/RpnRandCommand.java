package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnRandCommand extends RpnZeroCommand {
    public RpnRandCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.RAND;
    }

    @Override
    public void execute() {
        try {
            getContext().push(BigDecimal.valueOf(Math.random()));
        } catch (NumberFormatException e) {
            throw new InvalidOperatorException(this);
        }
    }
}
