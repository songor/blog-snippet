package com.songor.blog.snippet.algorithm;

/**
 * 在数组 arr 中查找 key，返回 key 所在的位置
 *
 * @author chensongyu
 */
public class FindKeyInArray {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int n = 5;
    int key = 4;
    System.out.println(find(arr, n, key));
    System.out.println(findWithSentinel(arr, n, key));
  }

  private static int find(int[] arr, int n, int key) {
    if (arr == null || n <= 0) {
      return -1;
    }

    int i = 0;
    while (i < n) {
      if (arr[i] == key) {
        return i;
      }
      ++i;
    }

    return -1;
  }

  private static int findWithSentinel(int[] arr, int n, int key) {
    if (arr == null || n <= 0) {
      return -1;
    }

    if (arr[n - 1] == key) {
      return n - 1;
    }
    // 将 arr[n-1] 的值替换成 key
    int tmp = arr[n - 1];
    arr[n - 1] = key;

    int i = 0;
    // 通过一个哨兵 arr[n-1] = key 成功省掉了一个比较语句 i < n
    while (arr[i] != key) {
      ++i;
    }

    // 恢复 arr[n-1] 原来的值
    arr[n - 1] = tmp;

    if (i == n - 1) {
      return -1;
    } else {
      return i;
    }
  }
}
