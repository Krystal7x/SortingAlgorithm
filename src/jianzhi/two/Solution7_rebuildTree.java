package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 重建二叉树
 */
public class Solution7_rebuildTree {

    //递归实现
    public static treenode rebultTree(int[] pre,int pstart,int pend,int[] in,int istart,int iend){
        if(pstart> pend || istart > iend){ return null;}
        treenode root =new treenode();
        int r = pre[pstart];
        root.value = r;
        int i=istart;
        for(i=istart;i<iend;i++){
            if(in[i] == r){break;}
        }
        root.leftnext= rebultTree(pre,pstart+1, pstart+i-istart,in, istart, i-1);
        root.rigttnext= rebultTree(pre,pstart+i-istart+1, pend,in, i+1, iend);
        return root;
    }
    // 测试
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        treenode root = rebultTree(preorder,0,7 ,inorder,0,7);
        System.out.println(root.leftnext.leftnext.rigttnext.value);
        root.printList();
    }
}
