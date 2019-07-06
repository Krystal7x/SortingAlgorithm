package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution37K_Serialize {
    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String Serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }
    public void Serialize(TreeNode root,StringBuilder sb) {
        if(root==null){
            sb.append("$");
        }else{
            //先序遍历
            sb.append(root.val);
            Serialize( root.left, sb.append(","));
            Serialize( root.right, sb.append(","));
        }
    }

    public TreeNode Deserialize(String str) {
        String[] strarr=str.split(",");
        Deserialize(strarr);
        return Deserialize(strarr);
    }
    int index=0;
    public TreeNode Deserialize(String[] strarr) {
        if(strarr[index].equals("$")){
            index++;
            return  null;
        }
        TreeNode root =new TreeNode(Integer.valueOf(strarr[index]));
        index++;
        root.left=Deserialize(strarr);
        root.right=Deserialize(strarr);
        return root;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        Solution37K_Serialize sbt = new Solution37K_Serialize();
        String s = sbt.Serialize(node1);
        // 1,2,4,$,$,$,3,5,$,$,6,$,$
        System.out.println(s);

        TreeNode newRoot = sbt.Deserialize(s);
        String s2 = sbt.Serialize(newRoot);
        // 1,2,4,$,$,$,3,5,$,$,6,$,$
        System.out.println(s);
    }
}
