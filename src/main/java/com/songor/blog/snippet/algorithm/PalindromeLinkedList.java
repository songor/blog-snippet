package com.songor.blog.snippet.algorithm;

import lombok.AllArgsConstructor;

/**
 * 如果字符串是通过单链表来存储的，那该如何来判断是一个回文串呢？
 *
 * @author chensongyu
 */
public class PalindromeLinkedList {
  public static void main(String[] args) {
    Node three = new Node('s', null);
    Node two = new Node('o', three);
    Node head = new Node('s', two);
    System.out.println(isPalindrome(head));

    Node four = new Node('p', null);
    three = new Node('o', four);
    two = new Node('o', three);
    head = new Node('p', two);
    System.out.println(isPalindrome(head));
  }

  private static boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
      return true;
    }

    /*
    使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步
     */
    Node fast = head;
    Node slow = head;
    Node reverse = null;
    while (fast != null && fast.next != null) {
      /*
      在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序
       */
      fast = fast.next.next;
      Node next = slow.next;
      slow.next = reverse;
      reverse = slow;
      slow = next;
    }
    if (fast != null) {
      slow = slow.next;
    }

    /*
    最后比较中点两侧的链表是否相等
     */
    while (slow != null && reverse != null) {
      if (slow.data != reverse.data) {
        return false;
      }
      slow = slow.next;
      reverse = reverse.next;
    }
    return true;
  }

  @AllArgsConstructor
  private static class Node {
    public char data;
    public Node next;
  }
}
