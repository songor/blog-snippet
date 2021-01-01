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
  public List<String> traverse(Node<String> node) {
    List<String> result = new ArrayList<>();
    postOrder(node, result);
    return result;
  }

  private void postOrder(Node<String> node, List<String> result) {
    if (node == null) {
      return;
    }
    postOrder(node.getLeft(), result);
    postOrder(node.getRight(), result);
    result.add(node.getData());
  }
}
