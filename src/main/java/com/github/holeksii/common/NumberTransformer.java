package com.github.holeksii.common;

public class NumberTransformer {

  public int transform(int num) {
    if (num == 0) {
      return 1;
    }

    int result = 0;
    int multiplier = 1;
    while (num > 0) {
      int digit = num % 10;
      num /= 10;

      // If digit is 9, add 10 to the result
      if (digit == 9) {
        result += (10 * multiplier);
        multiplier *= 100; // 10 for the 0 and another 10 for the 1 in the next iteration
      } else {
        result += ((digit + 1) * multiplier);
        multiplier *= 10;
      }
    }
    return result;
  }

  public void printlnTransformed(int num) {
    System.out.println(transform(num));
  }
}
