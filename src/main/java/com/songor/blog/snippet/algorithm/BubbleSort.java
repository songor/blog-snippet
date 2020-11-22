package com.songor.blog.snippet.algorithm;

/**
 * 冒泡排序
 *
 * @author chensongyu
 */
public class BubbleSort implements Sort {
  @Override
  public void sort(int[] arr, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 0; i < n; i++) {
      // 是否已经达到完全有序
      boolean flag = true;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
          flag = false;
        }
      }
      if (flag) {
        return;
      }
    }
  }
}
