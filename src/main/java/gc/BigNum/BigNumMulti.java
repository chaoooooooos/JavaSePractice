package gc.BigNum;

/*
* 没有对特殊情况做处理，只实现最基本的功能
* */
public class BigNumMulti {
    public static String bigNumMulti(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(!check(s1,s2))
            return "0";
        boolean f = false;
        if(s1.charAt(0)=='-'){
            s1 = s1.substring(1);
            f = !f;
        }
        if(s2.charAt(0)=='-'){
            s2 = s2.substring(1);
            f = !f;
        }
        String res = bigNumMultiHelper(s1,s2);

        if(f)
            res = '-'+res;
        return res;
    }

    public static String bigNumMultiHelper(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(!check(s1,s2))
            return "0";

        int[] arr1 = string2arr(s1);
        int[] arr2 = string2arr(s2);
        int[] res = new int[n1+n2];
        int k = n1+n2-1;
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--) {
                //int idx = k - (n1 - 1 - i) - (n2 - 1 - j); //比如i和j都是最后一位，则此时相乘的结果应该放在最后一位，即坐标为n1+n2-1
                int idx = i+j+1;
                res[idx] += arr1[i] * arr2[j];
            }
        }

        for(int i=k;i>=1;i--){
            if(res[i]>9){
                res[i-1] += res[i] / 10 ;
                res[i] %= 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int x : res)
            sb.append(x);

        int idx = 0;
        while (idx<sb.length() && sb.charAt(idx)=='0')
            idx++;
        return sb.toString().substring(idx);
    }

    public static boolean check(String s1,String s2){
        if(s1.length()==0 || s2.length()==0 || s1.charAt(0)=='0' || s2.charAt(0)=='0')
            return false;
        return true;
    }

    public static int[] string2arr(String s){
        int[] arr = new int[s.length()];
        int n = s.length();
        for(int i=0;i<n;i++)
            arr[i] = s.charAt(i)-'0';
        return arr;
    }
}
