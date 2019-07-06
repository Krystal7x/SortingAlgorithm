package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution36K_ConvertSearchTree {
    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    //全局变量
    private TreeNode lastNodeInList;

    public TreeNode Convert(TreeNode pRootOfTree) {
        //特判
        if(pRootOfTree == null)
        { return null;}

        lastNodeInList = new TreeNode(0);
        ConvertCore(pRootOfTree);



        //找到最左边是造出来的空值
        TreeNode cur = lastNodeInList;
        while(cur.left != null) {
            cur = cur.left;
        }
        //所以，再往右边一个
        cur = cur.right;
        //释放空间
        cur.left = null;
        return cur;
    }

    /**
     * 我们用一个节点指针 lastNodeInList 来指向已排序的链表的最后一个节点。
     在中序遍历的时候，每遍历到一个节点，就将该节点与 lastNodeInList 双向连接，并将 lastNodeInList 置为新遍历到的这个节点。
     * @param root
     */
    private void ConvertCore(TreeNode root) {
        //中序遍历
        if(root.left != null)
        { ConvertCore(root.left);}

        lastNodeInList.right = root;
        root.left = lastNodeInList;
        lastNodeInList = root;

        if(root.right != null)
        { ConvertCore(root.right);}
    }
    private static void printTree(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Solution36K_ConvertSearchTree cbst = new Solution36K_ConvertSearchTree();
        TreeNode root = cbst.Convert(node1);
        printTree(root);
        System.out.println();
    }
}
