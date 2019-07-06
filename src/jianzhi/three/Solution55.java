package jianzhi.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tt on 2018/9/19.
 * 平衡二叉树
 */
public class Solution55 {


    public static int treeDepth(treeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
        }
    }

    public static int treeWidth(treeNode root) {
        if (root == null) {return 0;}
        Queue<treeNode> q=new LinkedList<>();
        q.offer(root);
        int width=1;
        int max=0;
        while(true) {
            int w=0;
            while (width > 0) {
                treeNode n = q.poll();
                width--;
                if (n.left != null) {q.offer(n.left);w++; }
                if (n.right != null) {q.offer(n.right); w++;}
            }
            if(w==0){break;}
            width=w;
            if(w>max){max=w;}
        }
        return max;
    }



    //平衡二叉树判断
    public static int isBalanceTree( treeNode root){
        if(root==null){return 0;}
        int leftDepth=isBalanceTree(root.left);
        if(leftDepth==-1){return -1;}
        int rightDepth=isBalanceTree(root.right);
        if(rightDepth==-1){return -1;}
        if(leftDepth-rightDepth>1||leftDepth-rightDepth<-1){
            return -1;
        }
      return Math.max(leftDepth,rightDepth)+1;
    }

    // 测试
    public static void main(String[] args) {
        treeNode a = new treeNode();
        treeNode b = new treeNode();
        treeNode c = new treeNode();
        treeNode d = new treeNode();
        treeNode e = new treeNode();
        treeNode f = new treeNode();
        treeNode g = new treeNode();
        treeNode h = new treeNode();
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        //c.right = g;
        f.left=h;
        System.out.println(treeDepth(a));
        System.out.println(treeWidth(a));
    }
}
