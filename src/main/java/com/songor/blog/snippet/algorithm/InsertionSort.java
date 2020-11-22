package com.songor.blog.snippet.algorithm;

/**
 * 插入排序
 * @author chensongyu
 */
public class InsertionSort implements Sort {
  @Override
  public void sort(int[] arr, int n) {
    if (n <= 1) {
      return;
    }

    for (int i = 1; i < n; i++) {
      int value = arr[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (arr[j] > value) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = value;
    }
  }
}
