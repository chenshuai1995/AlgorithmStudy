package linkedlist.reverse_linked_list.mayf;

import org.w3c.dom.NodeList;

/**
 * 206.反转链表
 * https://leetcode.com/problems/reverse-linked-list/
 * @Author mayufeng
 * @CreateTime 2020/10/15 6:45 下午
 **/
public class App206 {

    public static void main(String[] args) {

        App206 app = new App206();

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(8);
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node.next = node2;

        showNodeList(node);

        ListNode newNode = app.reverseList(node);

        showNodeList(newNode);

    }

    /**
     * 使用递归方法反转链表（单参数）
     * 使用链表数据特征与变量引用特性
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null){

            return head;

        }

        ListNode newNode = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return newNode;

    }

    /**
     * 使用递归方法反转链表（双参数）
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head,ListNode newNextNode) {

        boolean nextFlag = (head.next != null);

        boolean isFirst = (newNextNode == null);

        if(isFirst){
            if(nextFlag){
                newNextNode = new ListNode(head.val);
            }else{
                return head;
            }
        }

        ListNode newNode = null;

        if(nextFlag){

            if(isFirst){

                newNode = this.reverseList1(head.next,newNextNode);

            }else{

                ListNode tempNode = new ListNode(head.val);

                tempNode.next = newNextNode;

                newNode = this.reverseList1(head.next,tempNode);

            }

        }else{

            newNode = head;

            newNode.next = newNextNode;

        }

        return newNode;

    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void showNodeList(ListNode node){

        ListNode tempNode = node;

        while(true){

            if(tempNode.next!=null){

                System.out.print(tempNode.val+"->");

                tempNode = tempNode.next;

            }else{

                System.out.println(tempNode.val+"->NULL");

                break;

            }

        }

    }
}
