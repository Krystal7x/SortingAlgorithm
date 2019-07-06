package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 题目一：找出数组中重复的数字

 描述：在长度为n的数组里所有数字都在0~n-1范围内。数组中某些数字是重复的，请找出任意一个重复的数字。如数组｛2, 3, 1, 0, 2, 5, 3｝，输出的重复的数字为2或3。
 思路：利用数组的索引在0~n-1这个范围的性质，将数字i移至索引i的位置。
 考点：对数组的理解以及对问题的分析能力。

 　题目二：不修改数组找出重复的数字

 描述：在长度为n+1的数组里所有数字都在1~n范围内。找出重复的数字，但不修改数组。
 思路：当然可完全利用题目一的方法，只是需要辅助空间。不需要辅助空间是最好的了。这里使用二分法，对数组进行计数，逐渐缩小重复的数字所处的范围。
 考点：对二分查找的灵活应用，毕竟写出正确无误的二分法时有些难度的。同时要重视与面试官的沟通，明确需求，如是否能更改数组，是否可以使用辅助空间等。

 */

public class Solution3 {

    // 输出数组中重复的数字，空间复杂度O(n)，时间复杂度O(n)
    public static void duplicate(int[] arr){
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
          if(temp[arr[i]]==0){temp[arr[i]]++;}
            else{System.out.println(arr[i]);}
        }
    }


    // 输出数组中重复的数字，空间复杂度O(1)，时间复杂度O(n)
    public static void duplicate1(int[] arr){
        for(int i=0;i<arr.length;i++){
            while(arr[i]!=i){
                if(arr[i]==arr[arr[i]]){
                    System.out.println(arr[i]);
                    break;
                }else{
                    int temp= arr[i];
                    arr [i]=arr[temp];
                     arr[temp]=temp;
                }
            }
        }
    }
    // 输出数组中重复的数字，空间复杂度O(1)，时间复杂度O(nlog(n))
    public static void duplicate2(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(end>=start){
            int middle =(start+end)/2;
            int count =getcount(arr,start,middle);
            if(start==end){
                if(count>1){System.out.println(start);break;}
                else{System.out.println("0");break;}
            }
            if(count>(middle-start+1)){end=middle;}
            else {start=middle;}
        }
    }

    public static int  getcount (int[] arr,int start,int end){
        int count=0;
        for(int i=0 ;i<arr.length;i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return  count;
    }
    // 测试
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        duplicate(arr);
        duplicate1(arr);
        int[] arr2 = {2, 3, 5, 4, 3, 6, 7};
        duplicate2(arr2);
    }
}
