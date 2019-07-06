package jianzhi.three;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tt on 2018/9/18.
 * 面试题40 最小的k个数

 描述：输入n个整数，找出其中最小的k个数。
 思路：1基于快排的特点，容易实现数组元素大小的查找。同理也很容易找到第k大的数，别忘了容易犯的差1错误。
 2.用堆
 考点：对同类问题的联想能力。
 */
public class Solution40_quick_henlihai {



    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length == 0 || k <= 0 || k > input.length)
        {return new ArrayList<>();}
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int end = input.length - 1;


        int p = partition(input, start, end);
        //这个快速排序的方法很多地方都可以用，很吊
        while(p != k - 1) {
            if(p > k - 1)
            {end = p - 1;}
            if(p < k - 1)
            { start = p + 1;}
            p = partition(input, start, end);
        }
        for(int i = 0; i < k; ++i)
        {  result.add(input[i]);}
        return result;
    }

    private int partition(int[] array, int low, int high) {
        if(low >= high) {return low;}
        int val = array[0];
        int i = low;
        int j = high + 1;
        while(true) {
            while(array[++i] < val) {if(i == high){ break;}}
            while(array[--j] > val) {if(j == low) {break;}}
            if(i >= j){ break;}
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }

    private void swap(int[] array, int indexA, int indexB) {
        int t = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = t;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    public static  void heap_k(int[] arr,int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }});
        for(int i=0;i<arr.length;i++){
            if(q.size()<k){
                q.offer(arr[i]);
                continue;
            }
            if(q.size()==k){
                if(q.peek()>arr[i]){
                    q.poll();
                    q.offer(arr[i]);
                }
            }
        }
        for(Integer i:q){
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,34,4,5,78,6,5,12};
       heap_k(arr,3);
    }

}
