package com.songor.blog.snippet.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 支持重复数据的二叉查找树
 *
 * @author chensongyu
 */
public class DuplicateBinarySearchTree extends OptimizeBinarySearchTree {
  /**
   * 查找
   *
   * @param data 要查找节点的值
   * @return 要查找的节点集合
   */
  public List<Node<Integer>> duplicateFind(int data) {
    List<Node<Integer>> result = new ArrayList<>();
    Node<Integer> node = super.findBaseNode(tree, data);
    while (node != null) {
      result.add(node);
      node = super.findBaseNode(node.getRight(), data);
    }
    return result;
  }

  /**
   * 插入
   *
   * @param data 要插入的值
   */
  public void duplicateInsert(int data) {
    List<Node<Integer>> sameNode = duplicateFind(data);
    if (sameNode.size() > 0) {
      Node<Integer> node = sameNode.get(sameNode.size() - 1);
      insertBaseNode(node.getRight(), data);
    } else {
      super.insert(data);
    }
  }

  /**
   * 删除
   *
   * @param data 要删除节点的值
   */
  public void duplicateDelete(int data) {
    List<Node<Integer>> sameNode = duplicateFind(data);
    IntStream.range(0, sameNode.size()).forEach(i -> super.delete(data));
  }
}
