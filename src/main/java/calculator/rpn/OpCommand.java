package calculator.rpn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by randy on 18/10/30.
 */
public class OpCommand {
  private Operator op;
  private int pos;
  private List<BigDecimal> inputs;
  private List<BigDecimal> params;
  private List<BigDecimal> results;

  public OpCommand(Operator op, int pos) {
    this.op = op;
    this.pos = pos;
    this.inputs = new ArrayList<>();
    this.params = new ArrayList<>();
    this.results = new ArrayList<>();
  }

  public OpCommand addInput(BigDecimal number) {
    this.inputs.add(number);
    return this;
  }

  public OpCommand addParam(BigDecimal number) {
    this.params.add(number);
    return this;
  }

  public OpCommand addResult(BigDecimal number) {
    this.results.add(number);
    return this;
  }

  public Operator getOp() {
    return op;
  }

  public int getPos() {
    return pos;
  }

  public List<BigDecimal> getInputs() {
    return inputs;
  }

  public List<BigDecimal> getParams() {
    return params;
  }

  public List<BigDecimal> getResults() {
    return results;
  }

  public void execute(CalculatorContext context) throws InsufficientParameterException {
    op.calc(context, this);
  }

  public void undo(CalculatorContext context) {
    op.undo(context, this);
  }

  public void reset() {
    params.clear();
    results.clear();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("OpCommand{ op=")
      .append(op.getSign())
      .append(", pos=")
      .append(pos)
      .append(", inputs=[");

    if (!inputs.isEmpty()) {
      sb.append(inputs.get(0));
      for (int i = 1; i < inputs.size(); i++) {
        sb.append(", ").append(inputs.get(i));
      }
    }

    sb.append("], params=[");
    if (!params.isEmpty()) {
      sb.append(params.get(0));
      for (int i = 1; i < params.size(); i++) {
        sb.append(", ").append(params.get(i));
      }
    }

    sb.append("], results=[");
    if (!results.isEmpty()) {
      sb.append(results.get(0));
      for (int i = 1; i < results.size(); i++) {
        sb.append(", ").append(results.get(i));
      }
    }

    return sb.append("] }").toString();
  }
}
