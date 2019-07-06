package jianzhi.three;

/**
 * Created by tt on 2018/9/21.
 */
public class Solution54_K_Tree {

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    //标示
    private int kth = 0;

    //中序遍历
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){return null;}
        //先左边
        TreeNode result = KthNode(pRoot.left, k);


        if(kth == k){return result;}
        if(++kth == k){ return pRoot;}



        //再右边
        result = KthNode(pRoot.right, k);
        return result;
    }
}
