package com.songor.blog.snippet.leetcode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author chensongyu
 */
public class LeetCode_450 {
  /**
   * Solution
   *
   * @param root 根节点 root
   * @param key 值 key
   * @return 根节点的引用
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode current = root;
    TreeNode parentOfCurrent = null;
    while (current != null && current.val != key) {
      parentOfCurrent = current;
      if (key < current.val) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    if (current == null) {
      return root;
    }

    if (current.left != null && current.right != null) {
      TreeNode minimum = current.right;
      TreeNode parentOfMinimum = current;
      while (minimum.left != null) {
        parentOfMinimum = minimum;
        minimum = minimum.left;
      }
      current.val = minimum.val;
      current = minimum;
      parentOfCurrent = parentOfMinimum;
    }

    TreeNode childOfCurrent;
    if (current.left != null) {
      childOfCurrent = current.left;
    } else if (current.right != null) {
      childOfCurrent = current.right;
    } else {
      childOfCurrent = null;
    }

    if (parentOfCurrent == null) {
      root = childOfCurrent;
    } else {
      if (parentOfCurrent.left == current) {
        parentOfCurrent.left = childOfCurrent;
      } else {
        parentOfCurrent.right = childOfCurrent;
      }
    }
    return root;
  }

  /**
   * 二叉树节点
   */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}

