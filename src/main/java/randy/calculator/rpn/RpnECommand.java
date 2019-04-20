package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnECommand extends RpnZeroCommand {
    private static final BigDecimal E = BigDecimal.valueOf(Math.E);

    public RpnECommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.E;
    }

    @Override
    public void execute() {
        getContext().push(E);
    }
}
