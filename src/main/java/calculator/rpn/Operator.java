package calculator.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by randy on 18/10/30.
 */
public enum Operator {
  ADD("+") {
    @Override
    public void calc(CalculatorContext context, OpCommand command) {
      if (context.stackSize() < 2) {
        throw new InsufficientParameterException(this, command.getPos());
      }

      BigDecimal param1 = context.pop();
      BigDecimal param2 = context.pop();
      BigDecimal result = param2.add(param1);
      context.push(result);
      command.addParam(param1).addParam(param2).addResult(result);
    }
  },

  SUB("-") {
    @Override
    public void calc(CalculatorContext context, OpCommand command) {
      if (context.stackSize() < 2) {
        throw new InsufficientParameterException(this, command.getPos());
      }

      BigDecimal param1 = context.pop();
      BigDecimal param2 = context.pop();
      BigDecimal result = param2.subtract(param1);
      context.push(result);
      command.addParam(param1).addParam(param2).addResult(result);
    }
  },

  MUL("*") {
    @Override
    public void calc(CalculatorContext context, OpCommand command) {
      if (context.stackSize() < 2) {
        throw new InsufficientParameterException(this, command.getPos());
      }

      BigDecimal param1 = context.pop();
      BigDecimal param2 = context.pop();
      BigDecimal result = param2.multiply(param1);
      context.push(result);
      command.addParam(param1).addParam(param2).addResult(result);
    }
  },

  DIV("/") {
    @Override
    public void calc(CalculatorContext context, OpCommand command) {
      if (context.stackSize() < 2) {
        throw new InsufficientParameterException(this, command.getPos());
      }
      if (BigDecimal.ZERO.compareTo(context.peek()) == 0) {
        throw new DivisionByZeroException(this, command.getPos());
      }

      BigDecimal param1 = context.pop();
      BigDecimal param2 = context.pop();
      BigDecimal result = param2.divide(param1, MAX_SCALE, RoundingMode.HALF_UP).stripTrailingZeros();
      context.push(result);
      command.addParam(param1).addParam(param2).addResult(result);
    }
  },

  SQRT("sqrt") {
    @Override
    public void calc(CalculatorContext context, OpCommand command) {
      if (context.stackSize() < 1) {
        throw new InsufficientParameterException(this, command.getPos());
      }
      if (context.peek().compareTo(BigDecimal.ZERO) < 0) {
        throw new InvalidOperatorException(this, command.getPos());
      }

      BigDecimal param = context.pop();
      BigDecimal result = new BigDecimal(Math.sqrt(param.doubleValue()));
      context.push(result);
      command.addParam(param).addResult(result);
    }
  },

  NUM("num") {
    @Override
    public void calc(CalculatorContext context, OpCommand command)
        throws InsufficientParameterException {
      command.getInputs().forEach(number -> {
        context.push(number);
        command.addResult(number);
      });
    }
  },

  CLEAR("clear") {
    @Override
    public void calc(CalculatorContext context, OpCommand command)
        throws InsufficientParameterException {
      while (!context.isEmpty()) {
        command.addParam(context.pop());
      }
    }
  },

  UNDO("undo"),
  EXIT("exit");

  private static final int MAX_SCALE = 15;

  private String sign;

  Operator(String sign) {
    this.sign = sign;
  }

  public String getSign() {
    return sign;
  }

  public void calc(CalculatorContext context, OpCommand command) {
  }

  public void undo(CalculatorContext context, OpCommand command) {
    int numberOfResults = command.getResults().size();
    for (int i = 0; i < numberOfResults; i++) {
      context.pop();
    }
    for (int j = command.getParams().size() - 1; j >= 0; j--) {
      context.push(command.getParams().get(j));
    }
    command.reset();
  }

  public static Operator of(String sign) {
    for (Operator op: Operator.values()) {
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
