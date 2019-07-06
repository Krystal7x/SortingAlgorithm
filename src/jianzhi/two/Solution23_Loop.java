package jianzhi.two;

/**
 * Created by tt on 2018/9/21.
 */
public class Solution23_Loop {
    public static class ListNode {
        public int val;
        public ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null){return null;}
        // 判断是否存在环
        ListNode node1 = pHead;
        ListNode node2 = pHead;//两步走也要一步一步走
        while(node2 != null) {
            node2 = node2.next;
            if(node2 == null){ return null;}
            node2 = node2.next;
            node1 = node1.next;
            if(node1 == node2){break;}
        }
        if(node2 == null){ return null;}


        // 统计环的节点个数
        int count = 1;
        ListNode cur = node2.next;
        while(cur != node2) {
            ++count;
            cur = cur.next;
        }


        // 找到环的入口结点
        node1 = pHead;
        node2 = pHead;
        while(count-- != 0) {
            node2 = node2.next;
        }
        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

}
