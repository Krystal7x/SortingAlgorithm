package jianzhi.three;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution52_repeatNode {
    public static class ListNode {
        public int val;
        public ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){  return null;}
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        // 求链表1、链表2长度
        for(ListNode cur = pHead1; cur != null; cur = cur.next){ ++len1;}

        for(ListNode cur = pHead2; cur != null; cur = cur.next){   ++len2;}

        if(len1 > len2) {
            for(int i = 0; i < len1 - len2; ++i){ cur1 = cur1.next;}
        }
        else {
            for(int i = 0; i < len2 - len1; ++i){cur2 = cur2.next;}
        }
        while(cur1 != null) {
            if(cur1 == cur2){ return cur1;}
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
