package jianzhi.three;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution63_dpMaxProfit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int max = 0;
        int[] f = new int[prices.length];
        int minPrice = prices[0];
        f[0] = 0;
        for(int i=1;i<f.length;i++){
            f[i] = max(f[i-1],prices[i]-minPrice);
            minPrice = min(minPrice,prices[i]);
            if(f[i]>max)
            {max = f[i];}
        }
        return max;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }

    public int min(int a,int b){
        return a<b?a:b;
    }
}
