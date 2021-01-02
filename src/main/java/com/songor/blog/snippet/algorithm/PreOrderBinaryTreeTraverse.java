package com.songor.blog.snippet.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历
 *
 * @author chensongyu
 */
public class PreOrderBinaryTreeTraverse implements BinaryTreeTraverse {
  @Override
  public <T> List<T> traverse(Node<T> node) {
    List<T> result = new ArrayList<>();
    preOrder(node, result);
    return result;
  }

  private <T> void preOrder(Node<T> node, List<T> result) {
    if (node == null) {
      return;
    }
    result.add(node.getData());
    preOrder(node.getLeft(), result);
    preOrder(node.getRight(), result);
  }
}
