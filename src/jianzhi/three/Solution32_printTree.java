package jianzhi.three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tt on 2018/9/18.
 */
public class Solution32_printTree {
    //分层打印树
    public static void printTree(treeNode root){
        Queue<treeNode> q =new LinkedList<>();
        q.offer(root);
        int n=1;
        while(true){
            int count=0;
            while(n>0){
                treeNode node= q.poll();n--;
                System.out.print(node.value+" ");
                if(node.left!=null){q.offer(node.left);count++;}
                if(node.right!=null){q.offer(node.right);count++;}
            }
            if(count==0){break;}
            n=count;
            System.out.println();
        }
    }

    //之字形分层打印树
    public static void zhiprintTree(treeNode root){
        if(root==null){return;}
        Stack<treeNode> lefes =new Stack<>();
        Stack<treeNode> rights =new Stack<>();
        int leftn=1;
        int rightn=0;
        lefes.push(root);
        boolean index=false;

        while(true) {
            if (!index) {
                int count = 0;
                while (leftn > 0) {
                    treeNode node = lefes.pop();leftn--;
                    System.out.print(node.value + " ");
                    if (node.left != null) {rights.push(node.left);count++;}
                    if (node.right != null) {rights.push(node.right);count++;}
                }
                if (count == 0) { break;}
                index = true;rightn = count;System.out.println();
            } else {
                int count = 0;
                while (rightn > 0) {
                    treeNode node = rights.pop(); rightn--;
                    System.out.print(node.value + " ");
                    if (node.right != null) {lefes.push(node.right);count++;}
                    if (node.left != null) {lefes.push(node.left);count++; }
                }
                if (count == 0) { break;}
                index = false;leftn = count; System.out.println();
            }
        }


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
        d.value = 5;
        e.value = 7;
        f.value = 4;
        g.value = 3;
        printTree(a);
        System.out.println();
        zhiprintTree(a);
    }

}
