package com.github.holeksii;

import org.junit.jupiter.api.Test;
import com.github.holeksii.common.NumberTransformer;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTransformerTest {

  @Test
  public void testSingleDigitTransformation() {
    NumberTransformer transformer = new NumberTransformer();

    assertEquals(1, transformer.transform(0));
    assertEquals(2, transformer.transform(1));
    assertEquals(3, transformer.transform(2));
    assertEquals(10, transformer.transform(9));
  }

  @Test
  public void testMultipleDigitTransformation() {
    NumberTransformer transformer = new NumberTransformer();

    assertEquals(10109, transformer.transform(998));
    assertEquals(456, transformer.transform(345));
    assertEquals(21010, transformer.transform(199));
  }

  @Test
  public void testAllNinesTransformation() {
    NumberTransformer transformer = new NumberTransformer();

    assertEquals(10, transformer.transform(9));
    assertEquals(1010, transformer.transform(99));
    assertEquals(101010, transformer.transform(999));
  }

  @Test
  public void testZeroTransformation() {
    NumberTransformer transformer = new NumberTransformer();

    assertEquals(1, transformer.transform(0));
  }

  @Test
  public void testRandomTransformation() {
    NumberTransformer transformer = new NumberTransformer();

    assertEquals(89, transformer.transform(78));
    assertEquals(54321, transformer.transform(43210));
    assertEquals(2211, transformer.transform(1100));
  }
}
