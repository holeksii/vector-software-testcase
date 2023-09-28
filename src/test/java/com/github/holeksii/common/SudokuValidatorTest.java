package com.github.holeksii.common;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuValidatorTest {

  static final SudokuValidator VALIDATOR = new SudokuValidator();

  @Test
  public void testValidSudoku() {
    List<List<Integer>> sudoku = Arrays.asList(
        Arrays.asList(5, 3, null, null, 7, null, null, null, null),
        Arrays.asList(6, null, null, 1, 9, 5, null, null, null),
        Arrays.asList(null, 9, 8, null, null, null, null, 6, null),
        Arrays.asList(8, null, null, null, 6, null, null, null, 3),
        Arrays.asList(4, null, null, 8, null, 3, null, null, 1),
        Arrays.asList(7, null, null, null, 2, null, null, null, 6),
        Arrays.asList(null, 6, null, null, null, null, 2, 8, null),
        Arrays.asList(null, null, null, 4, 1, 9, null, null, 5),
        Arrays.asList(null, null, null, null, 8, null, null, 7, 9));

    assertTrue(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void testInvalidSudoku() {

    List<List<Integer>> sudoku = Arrays.asList(
        Arrays.asList(5, 3, null, null, 7, null, null, null, null),
        Arrays.asList(6, null, null, 1, 9, 5, null, null, null),
        Arrays.asList(null, 9, 8, null, null, null, null, 6, null),
        Arrays.asList(8, null, null, null, 6, null, null, null, 3),
        Arrays.asList(4, null, null, 8, null, 3, null, null, 1),
        Arrays.asList(7, null, null, null, 2, null, null, null, 6),
        Arrays.asList(null, 6, null, null, null, null, 2, 8, null),
        Arrays.asList(null, null, null, 4, 1, 9, null, null, 5),
        Arrays.asList(null, null, null, null, 8, null, null, 7, 8) // 8 is repeated in the last row
    );

    assertFalse(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void test4x4ValidSudoku() {
    List<List<Integer>> sudoku =  Arrays.asList(
      Arrays.asList(1, 2, 3, 4),
      Arrays.asList(3, 4, 1, 2),
      Arrays.asList(2, 1, 4, 3),
      Arrays.asList(4, 3, 2, 1));
    assertTrue(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void testIncompleteSudoku() {
    List<List<Integer>> sudoku = Arrays.asList(
        Arrays.asList(5, 3, null, null, 7, null, null, null, null),
        Arrays.asList(null, null, null, 1, 9, 5, null, null, null),
        Arrays.asList(null, 9, 8, null, null, null, null, 6, null)
    // ... keep the other rows (can be filled or incomplete)

    );
    assertFalse(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void testInvalidNumbersInSudoku() {
    List<List<Integer>> sudoku = Arrays.asList(
        Arrays.asList(10, 3, 4, null), // 10 is invalid for a 4x4 board
        Arrays.asList(3, 4, 1, 2),
        Arrays.asList(2, 1, 4, 3),
        Arrays.asList(4, 3, 2, 1));
    assertFalse(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void testInvalidBoardDimensions() {
    List<List<Integer>> sudoku = Arrays.asList(
      Arrays.asList(1, 2, 3, 4, 5),
      Arrays.asList(1, 2, 3, 4, 5),
      Arrays.asList(1, 2, 3, 4, 5),
      Arrays.asList(1, 2, 3, 4, 5),
      Arrays.asList(1, 2, 3, 4, 5)
    // ... (5 rows in total, but this is invalid since 5x5 isn't allowed)
    );
    assertFalse(VALIDATOR.isValidSudoku(sudoku));
  }

  @Test
  public void testNullBoard() {
    assertFalse(VALIDATOR.isValidSudoku(null));
  }

  @Test
  public void testEmptyBoard() {
    assertFalse(VALIDATOR.isValidSudoku(Collections.emptyList()));
  }
}
