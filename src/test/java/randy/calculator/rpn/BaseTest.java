package randy.calculator.rpn;

import org.junit.Assert;
import org.junit.Before;

/**
 * Created by randy on 18/11/3.
 */
public class BaseTest {
  protected RpnContext context;
  protected RpnCalculator calculator;

  @Before
  public void init() {
    context = new RpnContext();
    calculator = new RpnCalculator(context);
    RpnMain.initCommands(calculator, context);
  }

  protected void test(String input, String result) {
    calculator.parseAndCalc(input);
    Assert.assertEquals(result, context.stackContent());
  }
}
