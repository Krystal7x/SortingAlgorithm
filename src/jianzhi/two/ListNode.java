package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 */
class ListNode{
    ListNode next = null;
    int value;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void printOut() {
        System.out.println(value);
        ListNode tmp = next;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }
}
