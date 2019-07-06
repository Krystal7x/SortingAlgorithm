package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 */
public class Solution12K_huishu_path {

    public static boolean hasPath(char[][] matrix,String str){
        boolean result= false;
        if(matrix==null || str.length()<=0){return result;}
        int lows= matrix.length;
        int cols=matrix[0].length;
        boolean[][] visited= new  boolean[lows][cols];
        int pathlength=0;
        for(int low=0;low<lows;low++){
            for(int col=0;col<cols;col++){
                if(matrix[low][col]==str.charAt(0)){
                    result=huishu(str,matrix,low,lows, col, cols, pathlength, visited);
                }
            }
        }
        return result;
    }

    public static boolean huishu(String str,char[][] matrix,int low,int lows,int col,int cols,int pathlength,boolean[][] visited){
        boolean result=false;
        if(pathlength>str.length()-1){return true;}
        if( 0<=low && 0<=col && low<lows&& col<cols && str.charAt(pathlength)==matrix[low][col] && !visited[low][col] ){
            visited[low][col]=true;
            pathlength++;
            result=huishu(str,matrix,low+1,lows, col, cols, pathlength, visited)||
                    huishu(str,matrix,low-1,lows, col, cols, pathlength, visited)||
                    huishu(str,matrix,low,lows, col+1, cols, pathlength, visited)||
                    huishu(str,matrix,low,lows, col-1, cols, pathlength, visited);
            if(!result) {
                visited[low][col]=false;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        char[][] matrix = { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
        String str = "bfc";
        System.out.println(hasPath(matrix, str));
    }
}
