package jianzhi.three;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by tt on 2018/9/21.
 */
public class Solution41 {
    //存储小的值 ，要有大顶堆
    Queue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    //存储大的值
    Queue<Integer> min = new PriorityQueue<Integer>();

    public void insert(Integer num) {
        // TODO
        if((max.size()-min.size())==1){
            max.add(num);
            min.add(max.poll());
        }else{
            min.add(num);
            max.add(min.poll());
        }
    }
    public Double getMedian() {
        if((max.size()-min.size())==1){
            return (double)(max.peek());
        }else{
            int maxint=max.peek();
            int minint=min.peek();
            double result=(double)(maxint+minint)/2;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution41 s=new Solution41();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        System.out.println(s.getMedian());
        s.insert(4);
        System.out.println(s.getMedian());
    }

}
