package com.songor.blog.snippet.leetcode;

/**
 * 二叉树的最大深度
 *
 * @author chensongyu
 */
public class LeetCode_104 {
  /**
   * Solution
   *
   * @param root 根节点 root
   * @return 最大深度
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
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
