package randy.calculator.rpn;

/**
 * Created by randy on 18/10/30.
 */
public enum Operator {
    ADD("+"),

    SUB("-"),

    MUL("*"),

    DIV("/"),

    SQRT("sqrt"),

    NUM("num"),

    CLEAR("clear"),

    UNDO("undo"),

    EXIT("exit");

    private String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static Operator of(String sign) {
        for (Operator op : Operator.values()) {
            if (op.getSign().equalsIgnoreCase(sign)) {
                return op;
            }
        }
        return Operator.NUM;
    }

    @Override
    public String toString() {
        return getSign();
    }
}
