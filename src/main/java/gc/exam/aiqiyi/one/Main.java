package gc.exam.aiqiyi.one;

import java.util.*;

/**
 * @author gengchao
 * @date 2019/9/8 15:01
 * @description：
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String s = in.nextLine();
        StringBuffer sb = new StringBuffer();
        for(char ch : s.toCharArray()){
            if(ch == '0')
                sb.append('I');
            if(ch == '1')
                sb.append('D');
        }
        System.out.println(helper(sb.toString()));
    }

    public static int helper(String S) {
        int n=S.length();
        int mod=1000000007;
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(dp[i],0);
        }
        Arrays.fill(dp[0],1);
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=i;j++) {
                if(S.charAt(i-1)=='D') {
                    for(int k=j;k<i;k++) {
                        dp[i][j]+=dp[i-1][k];
                        dp[i][j]%=mod;
                    }
                }
                else {
                    for(int k=0;k<j;k++) {
                        dp[i][j]+=dp[i-1][k];
                        dp[i][j]%=mod;
                    }
                }
                //System.out.printf("%d,%d=%d\n",i,j,dp[i][j]);
            }
        }
        int ans=0;
        for(int i=0;i<=n;i++) ans=(ans+dp[n][i])%mod;

        return ans;
    }

    public static int[] string2arr(String s, String separator) {
        String[] ss = s.split(separator);
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        return arr;
    }
}
