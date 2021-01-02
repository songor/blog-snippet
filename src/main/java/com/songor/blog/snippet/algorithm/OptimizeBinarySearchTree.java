package com.songor.blog.snippet.algorithm;

import java.util.Objects;

/**
 * 二叉查找树，优化删除算法
 *
 * @author chensongyu
 */
public class OptimizeBinarySearchTree extends BinarySearchTree {
  @Override
  public void delete(int data) {
    Node<Integer> current = tree;
    Node<Integer> parentOfCurrent = null;

    while (current != null && !Objects.equals(data, current.getData())) {
      parentOfCurrent = current;
      if (data < current.getData()) {
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
    }
    if (current == null) {
      return;
    }

    /*
    要删除的节点有两个子节点
     */
    if (current.getLeft() != null && current.getRight() != null) {
      Node<Integer> minimum = current.getRight();
      Node<Integer> parentOfMinimum = current;
      while (minimum.getLeft() != null) {
        parentOfMinimum = minimum;
        minimum = minimum.getLeft();
      }
      current.setData(minimum.getData());
      /*
      右子树中最小节点为要删除的节点
       */
      current = minimum;
      parentOfCurrent = parentOfMinimum;
    }

    /*
    要删除的节点没有子节点 或 要删除的节点只有一个子节点
     */
    Node<Integer> childOfCurrent;
    if (current.getLeft() != null) {
      childOfCurrent = current.getLeft();
    } else if (current.getRight() != null) {
      childOfCurrent = current.getRight();
    } else {
      childOfCurrent = null;
    }

    if (parentOfCurrent == null) {
      /*
      根节点为要删除的节点
       */
      tree = childOfCurrent;
    } else if (parentOfCurrent.getLeft() == current) {
      parentOfCurrent.setLeft(childOfCurrent);
    } else {
      parentOfCurrent.setRight(childOfCurrent);
    }
  }
}
