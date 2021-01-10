package com.songor.blog.snippet.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * （递归）打印 n 个数据的所有排列
 */
public class Permutation {
  /**
   * 假设数组中存储的是 1，2，3 ... n
   * f(1, 2, ... n) = {最后一位是 1, f(n-1)} + {最后一位是 2, f(n-1)} + ... + {最后一位是 n, f(n-1)}
   *
   * @param data 数组
   * @param n 数组个数
   * @param k 要处理的子数组个数
   */
  public void print(int[] data, int n, int k, List<String> result) {
    if (k == 1) {
      result.add(
          Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    for (int i = 0; i < k; i++) {
      int tmp = data[i];
      data[i] = data[k - 1];
      data[k - 1] = tmp;

      print(data, n, k - 1, result);

      tmp = data[i];
      data[i] = data[k - 1];
      data[k - 1] = tmp;
    }
  }
}
