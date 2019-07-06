package jianzhi.two;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution13_path {
    public static int m=0;
    public static boolean isOK(int low,int col,int limit){
        int count=0;
        while(low>0){count=count+low%10; low /= 10;}
        while(col>0){count=count+col%10; col /= 10;}
        if(count<=limit)return true;
        return false;
    }


    public static int hasPath(int lows,int cols,int limit){
        if(lows<0 || limit<0 || cols<0){return 0 ;}
        int[][] visited= new  int[lows][cols];
        int result = huishu(limit,0,lows, 0, cols, visited);
        return result;
    }

    public static int huishu(int limit,int low,int lows,int col,int cols,int[][] visited){
        int result =0;
        if(0<=low && 0<=col && low<lows&& col<cols && !isOK(low,col,limit)){visited[low][col]=2;return 0;}
        if( 0<=low && 0<=col && low<lows&& col<cols && isOK(low,col,limit)&& visited[low][col]<=0 ){
            visited[low][col]=1;
            result=huishu(limit,low+1,lows, col, cols, visited)+
            huishu(limit,low-1,lows, col, cols, visited)+
            huishu(limit,low,lows, col+1, cols, visited)+
            huishu(limit,low,lows, col-1, cols, visited)+1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(hasPath(3,4,3));
    }
}
