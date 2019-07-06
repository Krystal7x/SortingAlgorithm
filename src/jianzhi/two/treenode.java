package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 */
public class treenode {
    treenode father = null;
    treenode leftnext = null;
    treenode rigttnext = null;
    int value;

    public treenode getFather() {
        return father;
    }

    public void setFather(treenode father) {
        this.father = father;
    }

    public treenode getLeftnext() {
        return leftnext;
    }

    public void setLeftnext(treenode leftnext) {
        this.leftnext = leftnext;
    }

    public treenode getRigttnext() {
        return rigttnext;
    }

    public void setRigttnext(treenode rigttnext) {
        this.rigttnext = rigttnext;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // 中序遍历输出查看
    public void printList() {
        if(leftnext != null)
        { leftnext.printList();}
        System.out.print(value);
        if(rigttnext != null)
        {rigttnext.printList();}
    }
}
