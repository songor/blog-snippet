package com.songor.blog.snippet.algorithm;

/**
 * 查找算法
 */
public interface Search {
  /**
   * 查找
   *
   * @param arr 待查找的数组
   * @param n 数组的大小
   * @param value 待查找的值
   * @return 如果待查找的值存在于待查找的数组中，返回此值的下标，否则返回 -1
   */
  int search(int[] arr, int n, int value);
}
