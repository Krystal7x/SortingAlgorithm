package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 描述：把数组开头的一部分移动到数组的末尾得到的数组称为旋转数组。输入一个递增排序的数组的旋转数组，输出数组的最小值。
 思路：考虑旋转数组的特点，使用二分查找方法逐渐缩小目标值的范围。需要考虑的特殊情况有：数组仅有一个元素的情形；数组未旋转的情形；形如｛1，0，1，1，1｝的数组需要顺序查找，因为二分查找会跳过最小值。
 考点：对于新概念的理解；对二分查找的熟练掌握；对不同输入的分析和全面考虑。
 */
public class Solution11 {
    public static int min(int[] arr){
        int i=0;
        int j=arr.length-1;
        int middle=(i+j)/2;
        if(arr[i]<arr[j]){return arr[i];}
        while(i<j){
            if(arr[middle]==arr[i] && arr[middle]==arr[j]){ return min2(arr,i,j);}
            if(arr[middle]<=arr[i]){j=middle;}
            if(arr[middle]>=arr[j]){i=middle;}
            if(i+1>=j){break;}
        }
        return arr[j];
    }


    public static int min2(int[] arr,int start,int end){
        int result=99999;
        for(int i=start;i<=end;i++){
            if(arr[i]<result){result=arr[i];}
        }
        return result;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 3 };
        int[] arr2 = { 1, 0 , 1, 1, 1 };
        System.out.println(min(arr));
        System.out.println(min(arr2));
    }
}
