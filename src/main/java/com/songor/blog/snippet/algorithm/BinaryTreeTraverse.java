package com.songor.blog.snippet.algorithm;

import java.util.List;

/**
 * 二叉树遍历
 *
 * @author chensongyu
 */
public interface BinaryTreeTraverse {
  /**
   * 遍历
   *
   * @param node 二叉树
   * @return 遍历结果
   */
  <T> List<T> traverse(Node<T> node);
}
