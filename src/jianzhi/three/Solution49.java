package jianzhi.three;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution49 {

    public static int getUglyNum_s1(int n){
        int count= 1;
        int index=1;
        while(true){
            if(count==n){break;}
            index++;
            if(isUgly(index)){count++;}
        }
        return index;
    }
    public static boolean isUgly(int num){
        while(num%2==0){num=num/2;}
        while(num%3==0){num=num/3;}
        while(num%5==0){num=num/5;}
        return num==1;
    }




    public static int getUglyNum_s2(int n){

        int[] result = new int[n];
        result[0]=1;
        for(int i=1;i<result.length;i++){
            int temp =result[i-1];
            for(int j=i-1;j>=0;j--){
                if(result[i]==0){result[i]=result[j]*2;continue;}
                else if(result[j]*2 > temp &&result[j]*2<result[i]){
                    result[i]=result[j]*2;
                    continue;
                }
                else if(result[j]*3 > temp && result[j]*3<result[i]){
                    result[i]=result[j]*3;
                    continue;
                }
                else if(result[j]*5> temp &&result[j]*5 < result[i]){
                    result[i]=result[j]*5;
                    continue;
                }

            }
        }
        return result[n-1];

    }





    // 测试
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        System.out.println("方法1计算的第1500个丑数：" + getUglyNum_s1(1500));
       long t1 = System.currentTimeMillis();
        System.out.println("方法1耗时：" + (t1 - t0) + "ms");
        System.out.println("方法2计算的第1500个丑数：" + getUglyNum_s2(1500));
        long t2 = System.currentTimeMillis();
       System.out.println("方法2耗时：" +(t2 - t1) + "ms");
    }

}
