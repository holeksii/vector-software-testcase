package com.github.holeksii.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTransformerTest {
  
  static final  NumberTransformer TRANSFORMER = new NumberTransformer();

  @Test
  public void testSingleDigitTransformation() {
    assertEquals(1, TRANSFORMER.transform(0));
    assertEquals(2, TRANSFORMER.transform(1));
    assertEquals(3, TRANSFORMER.transform(2));
    assertEquals(10, TRANSFORMER.transform(9));
  }

  @Test
  public void testMultipleDigitTransformation() {
    assertEquals(10109, TRANSFORMER.transform(998));
    assertEquals(456, TRANSFORMER.transform(345));
    assertEquals(21010, TRANSFORMER.transform(199));
  }

  @Test
  public void testAllNinesTransformation() {
    assertEquals(10, TRANSFORMER.transform(9));
    assertEquals(1010, TRANSFORMER.transform(99));
    assertEquals(101010, TRANSFORMER.transform(999));
  }

  @Test
  public void testZeroTransformation() {
    assertEquals(1, TRANSFORMER.transform(0));
  }

  @Test
  public void testRandomTransformation() {
    assertEquals(89, TRANSFORMER.transform(78));
    assertEquals(54321, TRANSFORMER.transform(43210));
    assertEquals(2211, TRANSFORMER.transform(1100));
  }
}
