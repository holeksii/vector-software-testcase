package com.github.holeksii;

import java.util.HashSet;
import java.util.List;

public class SudokuValidator {

  public boolean isValidSudoku(List<List<Integer>> board) {
    return board != null && isBoardSizeValid(board) && areRowsValid(board) && areColumnsValid(board)
        && areSubgridsValid(board);
  }

  private boolean isBoardSizeValid(List<List<Integer>> board) {
    int N = board.size();
    int rootN = (int) Math.sqrt(N);
    if (rootN * rootN != N || N <= 1) {
      return false;
    }

    for (List<Integer> row : board) {
      if (row.size() != N) {
        return false;
      }
    }

    return true;
  }

  private boolean areRowsValid(List<List<Integer>> board) {
    int N = board.size();
    for (int i = 0; i < N; i++) {
      HashSet<Integer> rowSet = new HashSet<>();
      for (int j = 0; j < N; j++) {
        if (board.get(i).get(j) != null && !rowSet.add(board.get(i).get(j))) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean areColumnsValid(List<List<Integer>> board) {
    int N = board.size();
    for (int i = 0; i < N; i++) {
      HashSet<Integer> colSet = new HashSet<>();
      for (int j = 0; j < N; j++) {
        if (board.get(j).get(i) != null && !colSet.add(board.get(j).get(i))) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean areSubgridsValid(List<List<Integer>> board) {
    int N = board.size();
    int rootN = (int) Math.sqrt(N);

    for (int i = 0; i < N; i += rootN) {
      for (int j = 0; j < N; j += rootN) {
        HashSet<Integer> blockSet = new HashSet<>();

        for (int k = 0; k < rootN; k++) {
          for (int l = 0; l < rootN; l++) {
            if (board.get(i + k).get(j + l) != null && !blockSet.add(board.get(i + k).get(j + l))) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
