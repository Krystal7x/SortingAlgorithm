package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 面试题8  二叉树的下一个节点
 描述：给定一棵二叉树和其中的一个节点，找出中序遍历序列的下一个节点。树中应定义指向左节点、右节点、父节点的三个变量。
 思路：该节点若存在右节点，右子树的最左节点则为下一节点；若不存在右节点，则向上遍历，直至找到是父节点的左节点的那个节点，该节点的父节点则为下一节点。
 考点：对中序遍历的理解。
 */
public class Solution8 {
    public static treenode find(treenode n){
        if(n.rigttnext!=null){
            treenode r=n.rigttnext;
            while(r.leftnext!=null){
                r=r.leftnext;
            }
            return r;
        }
        while(n.father!=null){
            treenode f=n.father;
            if(n==f.leftnext){return f;}
            n=f;
        }
        return new treenode();
    }

    public static void main(String[] args) {
        // 建立一个二叉树节点的数组，并tree[i].value赋值
        treenode[] tree = new treenode[9];
        char[] chars = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new treenode();
            tree[i].value = chars[i];
        }
        // 左右节点关系
        tree[0].leftnext = tree[1];
        tree[0].rigttnext = tree[2];
        tree[1].leftnext = tree[3];
        tree[1].rigttnext = tree[4];
        tree[2].leftnext = tree[5];
        tree[2].rigttnext = tree[6];
        tree[4].leftnext = tree[7];
        tree[4].rigttnext = tree[8];
        // 父节点关系
        tree[1].father = tree[0];
        tree[2].father = tree[0];
        tree[3].father = tree[1];
        tree[4].father = tree[1];
        tree[5].father = tree[2];
        tree[6].father = tree[2];
        tree[7].father = tree[4];
        tree[8].father = tree[4];
  /*
         *        a
         *      /   \
         *     b     c
         *    / \   / \
         *   d   e  f  g
         *      / \
         *     h   i
         */
        System.out.println(tree[1].value);
        System.out.println("-------------");
        tree[0].printList();
        System.out.println("-------------");
        System.out.println(find(tree[1]).value);
    }
}
