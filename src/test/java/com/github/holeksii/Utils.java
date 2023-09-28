package com.github.holeksii;

public class Utils {
  
  public static boolean nearlyEqual(double a, double b) {
    double epsilon = Math.ulp(a) + Math.ulp(b);
    return Math.abs(a - b) <= epsilon;
  }
}
