package calculator.rpn;

import org.junit.Test;
import org.junit.Assert;


/**
 * Created by randy on 18/11/3.
 */
public class RpnCalculatorTest extends BaseTest {

  @Test
  public void testInvalidOperator() {
    try {
      calculator.parseAndCalc("1 2 a");
    } catch (InvalidOperatorException e) {
      Assert.assertEquals("1 2", context.stackContent());
      Assert.assertEquals("a", e.getOp());
      Assert.assertEquals(5, e.getPos());
    }
  }

  @Test
  public void testAddition() {
    test("1 2 +", "3");
    test("-1 +2 +", "3 1");
  }

  @Test
  public void testSubtraction() {
    test("1 2 -", "-1");
    test("0 -", "-1");
    test("-2 -", "1");
  }

  @Test
  public void testMultiplication() {
    test("2 3 *", "6");
    test("-0.5 *", "-3");
    test("-0.4 *", "1.2");
    test("1.20 *", "1.44");
  }

  @Test
  public void testDivision() {
    test("3 2 /", "1.5");
    test("-0.5 /", "-3");
    test("-3 /", "1");
    test("3 /", "0.3333333333");
    test("0.2 /", "1.6666666666");
  }

  @Test
  public void testSqrt() {
    test("0 sqrt", "0");
    test("clear 3 sqrt", "1.7320508075");
    try {
      test("clear -1 sqrt", "");
    } catch (CalculatorException e) {
      Assert.assertEquals("-1", context.stackContent());
      Assert.assertEquals("sqrt", e.getOp());
      Assert.assertEquals(10, e.getPos());
    }
  }

  @Test
  public void testUndo() {
    test("1 2 undo", "1");
    test("2 + undo undo", "1");
    test("sqrt undo", "1");
    test("undo", "");
    test("undo undo", "");
  }

  @Test
  public void testClear() {
    test("clear", "");
    test("1 2 clear", "");
    test("undo", "1 2");
    test("+ clear", "");
    test("undo", "3");
  }
}
