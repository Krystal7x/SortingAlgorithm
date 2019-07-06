package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution35K_fenli_fuza_list {

    public static class RandomListNode {
        public int label;
        public RandomListNode next = null;
        public RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null)
        { return null;}
        copyList(pHead);
        handleRandom(pHead);
        return split(pHead);
    }

    /**
     * 第一步：根据原始链表的每个节点N创建对应的N'。把N'链接在N的后面。
     */
    private void copyList(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while(cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
    }

    /**
     * 第二步：设置复制出来的节点的random
     */
    private void handleRandom(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
    }

    /**
     * 第三步：把这个长链表拆分成两个链表
     * 两个 拆分
     */
    private RandomListNode split(RandomListNode pHead) {
        RandomListNode newHead = pHead.next;
        //二指针法
        RandomListNode cur = pHead;
        RandomListNode newCur = newHead;
        while(true) {
            cur.next = newCur.next;
            cur = cur.next;
            if(cur == null){ break;}//重点
            newCur.next = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
