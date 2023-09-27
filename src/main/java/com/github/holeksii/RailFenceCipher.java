package com.github.holeksii;

public class RailFenceCipher {

  public static String encode(String text, int rails) {
    if (rails < 2) {
      throw new IllegalArgumentException("Rails must be greater than 1");
    }

    char[][] matrix = new char[rails][text.length()];
    boolean down = false;
    int row = 0;

    for (int i = 0; i < text.length(); i++) {
      if (row == 0 || row == rails - 1) {
        down = !down;
      }

      matrix[row][i] = text.charAt(i);

      row += down ? 1 : -1;
    }

    StringBuilder encoded = new StringBuilder();
    for (int i = 0; i < rails; i++) {
      for (int j = 0; j < text.length(); j++) {
        if (matrix[i][j] != 0) {
          encoded.append(matrix[i][j]);
        }
      }
    }

    return encoded.toString();
  }

  public static String decode(String encoded, int rails) {
    if (rails < 2) {
      throw new IllegalArgumentException("Rails must be greater than 1");
    }

    char[][] matrix = new char[rails][encoded.length()];
    boolean down = false;
    int row = 0;

    for (int i = 0; i < encoded.length(); i++) {
      if (row == 0 || row == rails - 1) {
        down = !down;
      }

      matrix[row][i] = '*';
      row += down ? 1 : -1;
    }

    int index = 0;
    for (int i = 0; i < rails; i++) {
      for (int j = 0; j < encoded.length(); j++) {
        if (matrix[i][j] == '*' && index < encoded.length()) {
          matrix[i][j] = encoded.charAt(index++);
        }
      }
    }

    StringBuilder decoded = new StringBuilder();
    row = 0;
    down = false;
    for (int i = 0; i < encoded.length(); i++) {
      if (row == 0 || row == rails - 1) {
        down = !down;
      }

      decoded.append(matrix[row][i]);
      row += down ? 1 : -1;
    }

    return decoded.toString();
  }
}
