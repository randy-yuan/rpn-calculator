package randy.calculator.rpn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RpnSqrtCommand extends RpnUnitaryCommand {
    private static final int PRECISION = 100;

    @Override
    public Operator getOperator() {
        return Operator.SQRT;
    }

    @Override
    public void execute() {
        checkOperand();
        if (getContext().peek().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidOperatorException(this);
        }

        BigDecimal op = getContext().popToHistory();
        getContext().push(sqrt(op));
    }

    private BigDecimal sqrt(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal two = BigDecimal.valueOf(2);
        MathContext mc = new MathContext(PRECISION, RoundingMode.HALF_UP);

        BigDecimal r = num;
        int cnt = 0;
        while (cnt < PRECISION) {
            r = (r.add(num.divide(r, mc))).divide(two, mc);
            cnt++;
        }

        return r.setScale(MAX_SCALE, RoundingMode.HALF_UP);
    }
}
