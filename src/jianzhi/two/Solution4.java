package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 描述：二维数组中，数字按从左到右、从上到下的顺序递增。给定一个整数，判断该数组中是否含有该整数。
 思路：从数组的右上角或左下角开始进行查找数据，缩小可能包含该数的范围。
 考点：画图分析问题，寻求问题的突破口。并能正确编写程序，避免死循环等问题。
 */
public class Solution4 {
    public static boolean findNum(int[][] arr,int a){
        int length=arr.length-1;
        int deep= arr[0].length-1;
        int row=0;
        while(length>=0 && row<=deep){
            int temp= arr[length][row];
            if(temp==a){ return true;}
            else if( a<temp){length--;}
            else if(a >temp){row++;}
        }
        return false;
    }
    // 测试
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findNum(arr, 9));
    }
}
