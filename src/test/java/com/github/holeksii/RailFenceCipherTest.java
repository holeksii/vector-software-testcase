package com.github.holeksii;

import org.junit.jupiter.api.Test;
import com.github.holeksii.common.RailFenceCipher;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RailFenceCipherTest {

  static String TEXT = "WEAREDISCOVEREDFLEEATONCE";
  static String ENCODED_WITH_3_RAILS = "WECRLTEERDSOEEFEAOCAIVDEN";
  static String HELLO = "HELLO";

  @Test
  public void testBasicEncoding() {
    assertEquals(ENCODED_WITH_3_RAILS, RailFenceCipher.encode(TEXT, 3));
  }

  @Test
  public void testBasicDecoding() {
    assertEquals(TEXT, RailFenceCipher.decode(ENCODED_WITH_3_RAILS, 3));
  }

  // Negative Tests
  @Test
  public void testEncodeWithOneRail() {
    assertThrows(IllegalArgumentException.class, () -> RailFenceCipher.encode(TEXT, 1));
  }

  @Test
  public void testDecodeWithOneRail() {
    assertThrows(IllegalArgumentException.class, () -> RailFenceCipher.decode(TEXT, 1));
  }

  // Equivalence Partitioning
  @Test
  public void testEmptyStringEncode() {
    assertEquals("", RailFenceCipher.encode("", 3));
  }

  @Test
  public void testEmptyStringDecode() {
    assertEquals("", RailFenceCipher.decode("", 3));
  }

  // Boundary Tests
  @Test
  public void testSingleCharacterEncode() {
    assertEquals("A", RailFenceCipher.encode("A", 2));
  }

  @Test
  public void testSingleCharacterDecode() {
    assertEquals("A", RailFenceCipher.decode("A", 2));
  }

  // Test more rails than characters
  @Test
  public void testMoreRailsThanTextLengthEncode() {
    assertEquals(HELLO, RailFenceCipher.encode(HELLO, 10));
  }

  @Test
  public void testMoreRailsThanTextLengthDecode() {
    assertEquals(HELLO, RailFenceCipher.decode(HELLO, 10));
  }

  @Test
  public void testEncodeDecodeSymmetry() {
    String original = "A longer string with spaces and stuff!";
    assertEquals(original, RailFenceCipher.decode(RailFenceCipher.encode(original, 5), 5));
  }
}
