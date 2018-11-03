package calculator.rpn;

import org.junit.Assert;
import org.junit.Before;

/**
 * Created by randy on 18/11/3.
 */
public class BaseTest {
  protected CalculatorContext context;
  protected RpnCalculator calculator;

  @Before
  public void init() {
    context = new CalculatorContext();
    calculator = new RpnCalculator(context);
  }

  protected void test(String input, String result) {
    calculator.parseAndCalc(input);
    Assert.assertEquals(result, context.stackContent());
  }
}
