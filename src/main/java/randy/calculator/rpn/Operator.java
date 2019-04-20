package randy.calculator.rpn;

/**
 * Created by randy on 18/10/30.
 */
public enum Operator {
    ADD("+"),

    SUB("-"),

    MUL("*"),

    DIV("/"),

    POW("pow"),

    SQRT("sqrt"),

    SQUARE("**"),

    EXP("exp"),

    TEN("ten"),

    POW2("pow2"),

    LN("ln"),

    LOG("log"),

    LOG2("log2"),

    NUM("num"),

    E("e"),

    PI("pi"),

    RAND("rand"),

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
