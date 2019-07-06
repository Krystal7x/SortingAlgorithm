package jianzhi.two;

import jianzhi.three.treeNode;

import java.util.LinkedList;
import java.util.Queue;

/**树的子结构
 * Created by tt on 2018/9/18.
 * 描述：输入一个二叉树，作镜像变换👈👉。
 找到树A中与树B根节点值相同的节点，设树A中该节点为subRoot
 在遍历树B的同时，遍历subRoot，如果遍历完树B发现subRoot中没有与B不一致的地方，则B是A的子结构
 遍历树B时，发现subRoot中有与树B结构不一致的地方，则退出遍历
 重复步骤1，找到树A中与树B根节点下一个值相同的节点
 */
public class Solution26 {

    public static boolean isChildTree(treeNode n1, treeNode n2){
        if(n1==null&&n2!=null){return false;}
        if(n1!=null&&n2==null){return true;}
        if(n1==null&& n2==null){return true;}
        if(n1!=null&& n2!=null && n1.value==n2.value){
            return isChildTree(n1.left,n2.left)&&isChildTree(n1.right,n2.right);
        }
        return false;
    }

    public static boolean ChildTree(treeNode n1,treeNode n2){
        Queue<treeNode> q= new LinkedList<>();
        q.offer(n1);
        while(!q.isEmpty()){
            treeNode n= q.poll();
            boolean r = isChildTree(n,n2);
            if(r){return true;}
            if(n.left!=null){q.offer(n.left);}
            if(n.right!=null){q.offer(n.right);}
        }
        return false;

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

        treeNode b1 = new treeNode();
        treeNode d1 = new treeNode();
        treeNode e1= new treeNode();
        b1.value = 6;
        d1.value = 5;
        e1.value = 7;
        b1.left = d1;
        b1.right = e1;


        System.out.println(ChildTree(a,b1));

    }
}
