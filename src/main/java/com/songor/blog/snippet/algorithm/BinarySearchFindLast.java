package com.songor.blog.snippet.algorithm;

/**
 * 二分查找：查找最后一个值等于给定值的元素
 *
 * @author chensongyu
 */
public class BinarySearchFindLast implements Search {
  @Override
  public int search(int[] arr, int n, int value) {
    int low = 0, high = n - 1;
    while (low <= high) {
      int middle = low + ((high - low) >> 1);
      if (arr[middle] > value) {
        high = middle - 1;
      } else if (arr[middle] < value) {
        low = middle + 1;
      } else {
        if (middle == high || arr[middle + 1] != value) {
          return middle;
        } else {
          low = middle + 1;
        }
      }
    }
    return -1;
  }
}
