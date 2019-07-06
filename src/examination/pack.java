package examination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Created by tt on 2018/4/5.
 */
public class pack {
    public static void main(String[] arg0){
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        ArrayList<Integer> w_arrayList = new ArrayList<Integer>();
        ArrayList<Integer> v_arrayList = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(i == 0){
                m = Integer.parseInt(scanner.nextLine());
            }else if(i == 1){
                String[] weight = scanner.nextLine().split(" ");
                for (String w : weight){
                    w_arrayList.add(Integer.parseInt(w));
                }
            }else{
                String[] val = scanner.nextLine().split(" ");
                for (String v : val){
                    v_arrayList.add(Integer.parseInt(v));
                }
            }
        }
        int n = v_arrayList.size(); //物品个数

        boolean flag = false;
        for(int t = 0; t < n; t++){
            if(w_arrayList.get(t) < m){
                flag = true;
                break;
            }
        }

        if(flag){
            int[][] f = new int[n + 1][m + 1];
            int[][] path = new int[n + 1][m + 1];
            //初始化第一列和第一行
            for(int i = 0;i < f.length; i++){
                f[i][0] = 0;
            }
            for(int i = 0;i < f[0].length; i++){
                f[0][i] = 0;
            }

            for(int i = 1;i < f.length; i++){
                for(int j = 1; j < f[0].length; j++){
                    if(w_arrayList.get(i - 1) > j)
                        f[i][j] = f[i-1][j];
                    else{
                        if(f[i-1][j] < f[i-1][j - w_arrayList.get(i - 1)] + v_arrayList.get(i - 1)){
                            f[i][j] = f[i-1][j - w_arrayList.get(i - 1)] + v_arrayList.get(i - 1);
                            path[i][j] = 1;
                        }else{
                            f[i][j] = f[i-1][j];
                        }
                    }
                }
            }
            ArrayList<Integer> res_arrayList = new ArrayList<Integer>();
            int i = f.length - 1;
            int j = f[0].length - 1;
            while(i > 0 && j > 0){
                if(path[i][j] == 1){
                    res_arrayList.add(i);
                    j -= w_arrayList.get(i - 1);
                }
                i--;
            }
            Collections.sort(res_arrayList);
            if(res_arrayList.size() == 1)
                System.out.println(res_arrayList.get(0));
            else{
                for(int ii = 0; ii < res_arrayList.size() - 1; ii++){
                    System.out.print(res_arrayList.get(ii));
                    System.out.print(" ");
                }
                System.out.print(res_arrayList.get(res_arrayList.size() - 1));
            }
        }

    }
}
