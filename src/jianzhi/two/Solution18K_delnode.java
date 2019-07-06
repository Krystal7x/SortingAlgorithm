package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 */
public class Solution18K_delnode {

    //12345变成1235 ，O(1)时间内
    public static void deleteOneNode(jianzhi.three.ListNode root, jianzhi.three.ListNode n){
        //复制next值法
        if(root==n){
            root=root.next;
        }
        jianzhi.three.ListNode temp=root;
        jianzhi.three.ListNode next=n.next;
        if(next!=null){
            n.value=next.value;
            n.next=next.next;
        }else{
            while(temp.next.value!=n.value){temp=temp.next;}
            temp.next=null;
        }

    }
    //123345变成12345
    public static void deleteReapeatNode(jianzhi.three.ListNode root){

        //两个指针
        if(root ==null || root.next == null){return;}
        jianzhi.three.ListNode cur=root;
        jianzhi.three.ListNode next=null;
        while(cur!=null){
            next=root.next;
            if(next==null) {
              break;
            }
            while(next!=null && cur.value==next.value){
                next=next.next;
            }
                cur.next=next;
                cur=next;
        }
    }



    //122334变成14  重点
    public static void deleteReapeatNode2(jianzhi.three.ListNode root){
        if(root ==null || root.next == null){return;}
        //三个节点法
        jianzhi.three.ListNode pre=null;
        jianzhi.three.ListNode cur = root;
        jianzhi.three.ListNode next=null;
        while(cur!=null){
            next=cur.next;
            boolean del=false;
            if(next!=null&&cur.value==next.value){
                del=true;
            }
            if(!del){
                pre=cur;
                cur=next;
            }else{
                int value=cur.value;
                jianzhi.three.ListNode delnode=cur;
                while(delnode!=null&&delnode.value==value){
                    next = delnode.next;
                    delnode=next;
                }
                if(pre==null){
                    //头结点重复的情况,所以改变root
                    root=next;
                }else{
                    pre.next=next;
                }
                cur=next;
            }

        }

    }
    public static void main(String[] args) {
        jianzhi.three.ListNode[] ln = new jianzhi.three.ListNode[6]; // 0->1 -> 2 -> 3 -> 4 -> 5
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new jianzhi.three.ListNode();
            ln[i].value = i;
            if(i > 0){ ln[i - 1].next = ln[i];}
        }
        jianzhi.three.ListNode n= new jianzhi.three.ListNode();
        n.value=2;
        n.next=ln[2].next;
        ln[2].next=n;
        ln[0].printOut();


        //12345变成1235
        /* deleteReapeatNode(ln[0]);
        System.out.println("==== after delete ====");
        ln[0].printOut();*/


        //123345变成12345
        /*deleteOneNode(ln[0], ln[2]);
        System.out.println("==== after delete ====");
        ln[0].printOut();*/


        //122334变成14
       /* deleteReapeatNode2(ln[0]);
        System.out.println("==== after delete ====");
        ln[0].printOut();*/
    }
}
