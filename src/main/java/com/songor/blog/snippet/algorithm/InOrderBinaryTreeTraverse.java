package com.songor.blog.snippet.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author chensongyu
 */
public class InOrderBinaryTreeTraverse implements BinaryTreeTraverse {
  @Override
  public <T> List<T> traverse(Node<T> node) {
    List<T> result = new ArrayList<>();
    inOrder(node, result);
    return result;
  }

  private <T> void inOrder(Node<T> node, List<T> result) {
    if (node == null) {
      return;
    }
    inOrder(node.getLeft(), result);
    result.add(node.getData());
    inOrder(node.getRight(), result);
  }
}
