package jianzhi.three;


import java.util.LinkedList;

/**
 * Created by tt on 2018/9/20.
 *
 * * 题目：
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 思路：
 * 使用前序遍历，然后用栈保存路径，并统计当前路径的sum。
 * 当某个节点已经不在路径内，这个节点要出栈，并从sum中减去对应的值。
 * ps:因为打印路径的时候需要遍历这个栈，所以这个栈结构最好能遍历。
 */
public class Solution34K_zhi_lujin {
    public static  LinkedList<treeNode> list =new  LinkedList<treeNode> ();
    public static void zhi(treeNode root,int sum) {
        if(root==null){return;}
        list.addFirst(root);
        if(root.left!=null){zhi(root.left,sum-root.value);}
        if(root.right!=null){zhi(root.right,sum-root.value);}
        if(root.left==null&& root.right==null && sum-root.value==0){
            print(list);
        }
        list.removeFirst();

    }
    public static void print(LinkedList<treeNode> stack){
        for (treeNode i:stack){
            System.out.print(i.value+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        treeNode a = new treeNode();
        treeNode b = new treeNode();
        treeNode c = new treeNode();
        treeNode d = new treeNode();
        treeNode e = new treeNode();
        treeNode f = new treeNode();
        treeNode g = new treeNode();
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        a.value = 8;
        b.value = 6;
        c.value = 2;
        d.value = 0;
        e.value = 7;
        f.value = 4;
        g.value = 3;
        System.out.println();
        zhi(a,14);
    }
}
