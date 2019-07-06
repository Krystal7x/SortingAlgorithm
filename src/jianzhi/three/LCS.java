package jianzhi.three;

/**
 * Created by tt on 2018/9/18.
 */
public class LCS {

    public static int[][]  longestCommonSubsequence(String str1,String str2) {
        int[][] result =new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    result[i][j]=result[i-1][j-1]+1;
                }else{
                    result[i][j]= Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return  result;
    }


    public static void printMatix( int[][] matix) {
        for(int i=0;i<matix.length;i++){
            for(int j=0;j<matix[0].length;j++){
                System.out.print(matix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String printlcs( int[][] matix ,String str1) {
        StringBuffer  result=new StringBuffer ();
       int i=matix.length-1;
        int j=matix[0].length-1;
        System.out.println(matix[i][j]);
        while(i>0 && j>0){
            if(matix[i][j]==(matix[i-1][j-1]+1)){
                result.append(str1.charAt(i-1));
                i--;j--;
                continue;
            }
            if(matix[i][j]==matix[i-1][j]){
                i--;  continue;
            }
            if(matix[i][j]==matix[i][j-1]){
                j--;  continue;
            }
        }
        return  result.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "fjssharpsword";
        String str2 = "helloworld";
        int[][] matix =   longestCommonSubsequence(str1, str2);
        printMatix(matix);
        System.out.println();
        System.out.println(printlcs(matix,str1));

    }
}
