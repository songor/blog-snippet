package com.songor.blog.snippet.algorithm;

/**
 * 计数排序
 *
 * @author chensongyu
 */
public class CountingSort implements Sort {
  @Override
  public void sort(int[] arr, int n) {
    if (n <= 1) {
      return;
    }

    // 查找数据范围
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    // 计算每个元素的个数
    int[] bucket = new int[max + 1];
    for (int i = 0; i <= max; i++) {
      bucket[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      bucket[arr[i]]++;
    }

    // 依次累加
    for (int i = 1; i <= max; i++) {
      bucket[i] = bucket[i - 1] + bucket[i];
    }

    // 关键步骤
    int[] sort = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int value = arr[i];
      int index = bucket[value] - 1;
      sort[index] = value;
      bucket[value]--;
    }

    // 拷贝
    System.arraycopy(sort, 0, arr, 0, n);
  }
}
