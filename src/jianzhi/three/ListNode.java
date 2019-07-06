package jianzhi.three;

/**
 * Created by tt on 2018/9/17.
 */
public class ListNode {
    public int value;
    public ListNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    public void printOut(){
        ListNode n=this;
        while(n!=null){
            System.out.print(n.value+"->");
            n=n.next;
        }
        System.out.println();
    }
}
