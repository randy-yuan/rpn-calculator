package randy.calculator.rpn;

import java.math.BigDecimal;

public class RpnPiCommand extends RpnZeroCommand {
    private static final BigDecimal PI = BigDecimal.valueOf(Math.PI);

    public RpnPiCommand(RpnContext context) {
        super(context);
    }

    @Override
    public Operator getOperator() {
        return Operator.PI;
    }

    @Override
    public void execute() {
        getContext().push(PI);
    }
}
