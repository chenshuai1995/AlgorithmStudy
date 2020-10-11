package linkedlist.linked_list_cycle.jim;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author Jim Chen
 * @date 2020-10-11
 */
public class App141 {

    public static void main(String[] args) {
        // head = [3,2,0,-4]
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minusFour = new ListNode(-4);

        head.next = two;
        two.next = zero;
        zero.next = minusFour;
        minusFour.next = two;

        // 链表有环，输出会栈溢出
//        System.out.println(head);

        // hash
        System.out.println(hasCycleWithHash(head));

        // 快慢指针
        System.out.println(hasCycleWithFastAndSlowIndex(head));
    }

    /**
     * 使用快慢指针
     *
     * while循环的话，可以用head和head.next分别表示slow和fast指针
     * for循环的话，可以在i++的时候，分别+1和+2来表示slow和fast指针
     *
     * @param head
     * @return
     */
    private static boolean hasCycleWithFastAndSlowIndex(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next; // 走1步
            fast = fast.next.next; // 走2步
        }
        return true;
    }

    /**
     * 使用hash表来存储链表中访问过的节点
     * @param head
     * @return
     */
    public static boolean hasCycleWithHash(ListNode head) {
        Set<ListNode> hasAccessed = new HashSet<>();

        while (head != null) {
            if (!hasAccessed.add(head)) {
                return true; // 有访问过的节点，有环
            }
            head = head.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        @Override
        public String toString() {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }

    }

}
