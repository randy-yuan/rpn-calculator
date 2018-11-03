package calculator.rpn;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by randy on 18/11/3.
 */
public class TestExamples extends BaseTest {

  @Test
  public void test1() {
    test("5 2", "5 2");
  }

  @Test
  public void test2() {
    test("2 sqrt", "1.4142135623");
    test("clear 9 sqrt", "3");
  }

  @Test
  public void test3() {
    test("5 2 -", "3");
    test("3 -", "0");
    test("clear", "");
  }

  @Test
  public void test4() {
    test("5 4 3 2", "5 4 3 2");
    test("undo undo *", "20");
    test("5 *", "100");
    test("undo", "20 5");
  }

  @Test
  public void test5() {
    test("7 12 2 /", "7 6");
    test("*", "42");
    test("4 /", "10.5");
  }

  @Test
  public void test6() {
    test("1 2 3 4 5", "1 2 3 4 5");
    test("*", "1 2 3 20");
    test("clear 3 4 -", "-1");
  }

  @Test
  public void test7() {
    test("1 2 3 4 5", "1 2 3 4 5");
    test("* * * *", "120");
  }

  @Test
  public void test8() {
    try {
      test("1 2 3 * 5 + * * 6 5", "11");
    } catch (InsufficientParameterException e) {
      Assert.assertEquals(context.stackContent(), "11");
      Assert.assertEquals(e.getOp(), "*");
      Assert.assertEquals(e.getPos(), 15);
    }
  }
}
