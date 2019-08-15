package gc.longestCommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "gcgcaatg";
        String s2 = "gccctagcg";
        List<String> res = lcs(s1,s2);
        System.out.println(res);
    }
    public static List lcs(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int maxLen = 0;
        List<String> list = new ArrayList<>();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        if(n1==0 || n2==0)
            return list;
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        for(int[] arr:dp)
            System.out.println(Arrays.toString(arr));
        int i = n1;
        int j = n2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb1.insert(0,s1.charAt(i-1));
                sb2.insert(0,s2.charAt(j-1));
                i--;
                j--;
            }else if(dp[i][j-1]>=dp[i-1][j])
                j--;
            else
                i--;
        }
        maxLen = dp[n1][n2];
        list.add(sb1.toString());
        list.add(sb2.toString());
        return list;
    }
}
