package jianzhi.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution59 {
    static class tmp{
        public Integer pos;    public Integer num;
        public tmp() { }
        public tmp(Integer num,Integer pos) {this.pos = pos;this.num = num;}
        public Integer getNum() { return num; }
        public void setNum(Integer num) {  this.num = num; }
        public Integer getPos() {return pos; }
        public void setPos(Integer pos) { this.pos = pos; }
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (num==null){return arr; }
        if (num.length<size||size<=0){return arr;}
        PriorityQueue<tmp> q = new PriorityQueue<>(100, new Comparator<tmp>() {  @Override    public int compare(tmp o1, tmp o2) { return o2.num-o1.num;}  });
        for (int i = 0; i<size-1; i++)  {q.offer(new tmp(num[i],i));}
        for (int i = size-1; i<num.length; i++){
            q.offer(new tmp(num[i],i));
            tmp p = q.peek();
            while (p.getPos()<i-(size-1)){
                q.poll();
                p = q.peek();
            }
            arr.add(p.getNum());
        }
        return arr;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//方法二
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<num.length; i++){
            if(q.isEmpty()){q.add(i);	  }//存入的是下标
            if(i-q.peekFirst()>=size){q.pollFirst();}	//超过滑动窗口大小了，从队头取出元素
            while(!q.isEmpty()&&num[q.peekLast()]<=num[i]){q.pollLast();}//如果加入的元素大于队列中已有的元素，已有元素就出队列
            q.add(i);		//每次遍历数组，都要加入一个元素
            // System.out.println(q);
            if(i>=size-1){	//从第三个数字开始
                 list.add(num[q.peekFirst()]);//从尾巴开始取出
                }
        }
        return list;
    }

}
