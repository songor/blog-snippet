package com.songor.blog.snippet.algorithm;

/**
 * 二分查找
 *
 * @author chensongyu
 */
public class BinarySearch implements Search {
  @Override
  public int search(int[] arr, int n, int value) {
    int start = 0;
    int end = n - 1;
    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (arr[middle] == value) {
        return middle;
      } else if (arr[middle] < value) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    return -1;
  }
}
