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
  public List<String> traverse(Node<String> node) {
    List<String> result = new ArrayList<>();
    preOrder(node, result);
    return result;
  }

  private void preOrder(Node<String> node, List<String> result) {
    if (node == null) {
      return;
    }
    result.add(node.getData());
    preOrder(node.getLeft(), result);
    preOrder(node.getRight(), result);
  }
}
