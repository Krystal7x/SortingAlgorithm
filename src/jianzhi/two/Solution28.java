package jianzhi.two;

import jianzhi.three.treeNode;

/**
 * Created by tt on 2018/9/18.
 */
public class Solution28 {
    public static boolean isSymmetrical(treeNode n1, treeNode n2) {
        if(n1==null&&n2==null){return true;}
        if(n1==null||n2==null){return false;}
        if(n1.value!=n2.value){return false;}
        return isSymmetrical(n1.left,n2.right)&&isSymmetrical(n1.right,n2.left);
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
        c.value = 6;
        d.value = 5;
        e.value = 7;
        f.value = 7;
        g.value = 5;
        System.out.println(isSymmetrical(a, a));
    }
}
