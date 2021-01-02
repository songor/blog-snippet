package com.songor.blog.snippet.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 *
 * @author chensongyu
 */
public class PostOrderBinaryTreeTraverse implements BinaryTreeTraverse {
  @Override
  public <T> List<T> traverse(Node<T> node) {
    List<T> result = new ArrayList<>();
    postOrder(node, result);
    return result;
  }

  private <T> void postOrder(Node<T> node, List<T> result) {
    if (node == null) {
      return;
    }
    postOrder(node.getLeft(), result);
    postOrder(node.getRight(), result);
    result.add(node.getData());
  }
}
