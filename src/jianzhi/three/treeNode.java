package jianzhi.three;

/**
 * Created by tt on 2018/9/18.
 */
public class treeNode {
    public treeNode left =null;
    public treeNode right =null;
    public int  value ;

    public treeNode getLeft() {
        return left;
    }

    public void setLeft(treeNode left) {
        this.left = left;
    }

    public treeNode getRight() {
        return right;
    }

    public void setRight(treeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void printList() {
        treeNode n = this;
        if(n.left!=null){n.left.printList();}
        System.out.print(n.value+"->");
        if(n.right!=null){n.right.printList();}
    }

}
