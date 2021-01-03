package com.songor.blog.snippet.algorithm;

import java.util.Objects;

/**
 * 二叉查找树
 *
 * @author chensongyu
 */
public class BinarySearchTree {
  protected Node<Integer> tree;

  /**
   * 查找
   *
   * @param data 要查找节点的值
   * @return 要查找的节点
   */
  public Node<Integer> find(int data) {
    return findBaseNode(tree, data);
  }

  protected Node<Integer> findBaseNode(Node<Integer> node, int data) {
    Node<Integer> current = node;
    while (current != null) {
      if (data < current.getData()) {
        current = current.getLeft();
      } else if (data > current.getData()) {
        current = current.getRight();
      } else {
        return current;
      }
    }
    return null;
  }

  /**
   * 插入
   *
   * @param data 要插入的值
   */
  public void insert(int data) {
    insertBaseNode(tree, data);
  }

  protected void insertBaseNode(Node<Integer> node, int data) {
    if (node == null) {
      node = new Node<>();
      node.setData(data);
      tree = node;
      return;
    }

    Node<Integer> current = node;
    while (current != null) {
      if (data < current.getData()) {
        if (current.getLeft() == null) {
          Node<Integer> aNode = new Node<>();
          aNode.setData(data);
          current.setLeft(aNode);
        } else {
          current = current.getLeft();
        }
      } else if (data > current.getData()) {
        if (current.getRight() == null) {
          Node<Integer> aNode = new Node<>();
          aNode.setData(data);
          current.setRight(aNode);
        } else {
          current = current.getRight();
        }
      } else {
        return;
      }
    }
  }

  /**
   * 删除
   *
   * @param data 要删除节点的值
   */
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
    要删除的节点没有子节点
    */
    if (current.getLeft() == null && current.getRight() == null) {
      if (parentOfCurrent == null) {
        tree = null;
      } else {
        if (current == parentOfCurrent.getLeft()) {
          parentOfCurrent.setLeft(null);
        } else {
          parentOfCurrent.setRight(null);
        }
      }
      return;
    }

    /*
    要删除的节点只有一个子节点
     */
    boolean oneNode =
        (current.getLeft() != null && current.getRight() == null) || (current.getRight() != null
            && current.getLeft() == null);
    if (oneNode) {
      if (parentOfCurrent == null) {
        if (current.getLeft() != null) {
          tree = current.getLeft();
        } else {
          tree = current.getRight();
        }
      } else {
        if (parentOfCurrent.getLeft() == current) {
          if (current.getLeft() != null) {
            parentOfCurrent.setLeft(current.getLeft());
          } else {
            parentOfCurrent.setLeft(current.getRight());
          }
        } else {
          if (current.getLeft() != null) {
            parentOfCurrent.setRight(current.getLeft());
          } else {
            parentOfCurrent.setRight(current.getRight());
          }
        }
      }
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
      if (parentOfMinimum == current) {
        parentOfMinimum.setRight(minimum.getRight());
      } else {
        // FIXME 此处需要判断要删除节点的子节点
        parentOfMinimum.setLeft(null);
      }
      return;
    }
  }

  /**
   * 快速查找最大节点
   *
   * @return 最大节点
   */
  public Node<Integer> findMax() {
    Node<Integer> max = tree;
    if (max == null) {
      return null;
    }
    while (max.getRight() != null) {
      max = max.getRight();
    }
    return max;
  }

  /**
   * 快速查找最小节点
   *
   * @return 最小节点
   */
  public Node<Integer> findMin() {
    Node<Integer> min = tree;
    if (min == null) {
      return null;
    }
    while (min.getLeft() != null) {
      min = min.getLeft();
    }
    return min;
  }

  /**
   * 快速查找前驱节点
   *
   * @param data 当前节点的值
   * @return 当前节点的前驱节点
   */
  public Node<Integer> findPredecessor(int data) {
    Node<Integer> node = find(data);
    if (node == null) {
      return null;
    }
    Node<Integer> predecessor = node.getLeft();
    if (predecessor == null) {
      return null;
    }
    while (predecessor.getRight() != null) {
      predecessor = predecessor.getRight();
    }
    return predecessor;
  }

  /**
   * 快速查找后继节点
   *
   * @param data 当前节点的值
   * @return 当前节点的后继节点
   */
  public Node<Integer> findSuccessor(int data) {
    Node<Integer> node = find(data);
    if (node == null) {
      return null;
    }
    Node<Integer> successor = node.getRight();
    if (successor == null) {
      return null;
    }
    while (successor.getLeft() != null) {
      successor = successor.getLeft();
    }
    return successor;
  }

  public Node<Integer> getTree() {
    return tree;
  }
}
