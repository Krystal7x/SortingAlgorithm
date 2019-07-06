package jianzhi.three;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tt on 2018/10/9.
 *
 题目：求树中两个结点的最低公共祖先

 分析：其实这是一组题目，考官没有说清楚树的结构，那么做法就不尽相同。

 比如，如果是二叉搜索树的话，我们只需从根结点判断，如果二结点与根的左右子树比较一大一小，那么跟结点就是二者最低公共祖先；如果二结点都比左子结点小，向左子树递归进行比较；如果二结点都比右子树结点大，向右子树递归进行比较；

 如果不是二叉搜索树，但带有指向父节点的指针，那么此题转换成在两个有相交的链表上求第一个相交点。

 如果不带指向父节点的指针，那么我们可以记录从根结点到这两个结点的路径即可求出。
 */
public class Solution68_CommonParent {
// 节点类
private static class TreeNode {
    int val;
    List<TreeNode> children = new ArrayList<>();
    public TreeNode(int val) {this.val = val;}
    @Override
    public String toString() {return val + "";}
}
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode p1, TreeNode p2) {
        //path1和path2分别存储根节点到p1和p2的路径（不包括p1和p2）
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        List<TreeNode> tmpList = new ArrayList<TreeNode>();
        getNodePath(root, p1, tmpList, path1);
        getNodePath(root, p2, tmpList, path2);
        //如果路径不存在，返回空
        if (path1.size() == 0 || path2.size() == 0) {return null; 	}
        return getLastCommonParent(path1, path2);
    }
    // 获取根节点到目标节点的路径
    public static void getNodePath(TreeNode root, TreeNode target, List<TreeNode> tmpList, List<TreeNode> path) {
        //鲁棒性
        if (root == null || root == target) {return;}
        tmpList.add(root);
        List<TreeNode> children = root.children;
        for (TreeNode node : children) {
            if (node == target) {path.addAll(tmpList);break;}
            getNodePath(node, target, tmpList, path);
        }
        tmpList.remove(tmpList.size() - 1);
    }
    //将问题转化为求链表最后一个共同节点
    private static TreeNode getLastCommonParent(List<TreeNode> p1, List<TreeNode> p2) {
        TreeNode tmpNode = null;
        for (int i = 0; i < p1.size(); i++) {
            if (p1.get(i) != p2.get(i)) {break;	}
            tmpNode = p1.get(i);
        }
        return tmpNode;

    }
}