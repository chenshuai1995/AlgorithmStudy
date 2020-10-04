package linkedlist.reverse_linked_list.jim;

/**
 * 206. 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author Jim Chen
 * @date 2020-10-04
 */
public class App206 {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		
		one.next = two;
		two.next = three;
		
		System.out.println(one);
		ListNode reversed = reverseList(one);
		System.out.println(reversed);
	}
	
	private static ListNode reverseList(ListNode head) {
		ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
            // 记录一下当前节点的下一个节点
            ListNode tmp = cur.next;
            // 将当前节点的下一个节点反向指向pre
            cur.next = pre;
            // pre和cur指针，向前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
}
