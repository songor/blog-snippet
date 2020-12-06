package com.songor.blog.snippet.algorithm;

/**
 * 求一个数的平方根，要求精确到小数点后 x 位（二分法）
 *
 * @author chensongyu
 */
class Sqrt {
  /**
   * @param value 待求平方根的数
   * @param threshold 误差的阈值
   * @return 此数的平方根
   */
  double sqrt(int value, double threshold) {
    double low = 1.0;
    double high = value;
    while (low <= high) {
      double middle = low + (high - low) / 2;
      double square = middle * middle;
      double delta = Math.abs(square - value);
      if (delta < threshold) {
        return middle;
      } else if (square < value) {
        low = middle;
      } else {
        high = middle;
      }
    }
    return -1.0;
  }
}
