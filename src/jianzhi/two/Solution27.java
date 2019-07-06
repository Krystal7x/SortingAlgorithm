package jianzhi.two;

import jianzhi.three.treeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tt on 2018/9/18.
 * 描述：输入一个二叉树，作镜像变换👈👉。
 思路：即递归交换左右子树。
 考点：树的遍历算法的熟练掌握，这里用到的是前序遍历。
 */
public class Solution27 {
    public static treeNode mirrorTree(treeNode root) {
        treeNode result =root;
        if(root==null){  return null;}
        Queue<treeNode> q = new LinkedBlockingQueue<treeNode>();
        q.add(root);
        while(!q.isEmpty()){
            treeNode n =q.poll();
            treeNode l = n.left;
            treeNode r = n.right;
            if(l!=null){q.add(l);}
            if(r!=null){q.add(r);}
            treeNode temp =n.left;
            n.left=n.right;
            n.right=temp;
        }

        return result;
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
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        a.value = 8;
        b.value = 6;
        c.value = 10;
        d.value = 5;
        e.value = 7;
        f.value = 9;
        g.value = 11;
        a.printList();
        a=mirrorTree(a);
        System.out.println("=========="); // 中序输出也是对称的
        a.printList();
    }
}
