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
  public List<String> traverse(Node<String> node) {
    List<String> result = new ArrayList<>();
    inOrder(node, result);
    return result;
  }

  private void inOrder(Node<String> node, List<String> result) {
    if (node == null) {
      return;
    }
    inOrder(node.getLeft(), result);
    result.add(node.getData());
    inOrder(node.getRight(), result);
  }
}
