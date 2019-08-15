package gc.BigNum;

/*
 * 只是处理2个正数相减问题，
 * 其他情况可以做相应转换
 * */

public class BigNumSub {

    public static String bigNumSub2(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return "0";
        boolean f = false;
        if (s1.length() < s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
            f = true;
        } else if (s1.length() == s2.length()) {
            int idx = 0;
            while (idx < s1.length()) {
                if(s1.charAt(idx)>s2.charAt(idx))
                    break;
                else if (s1.charAt(idx) < s2.charAt(idx)) {
                    String t = s1.substring(idx);
                    s1 = s2.substring(idx);
                    s2 = t;
                    f = true;
                    break;
                }
                idx++;
                if(idx==s1.length()-1 && s1.charAt(idx)==s2.charAt(idx))
                    return "0";
            }
        }
        String s = bigNumSubHelper2(s1, s2);

        if (f && !s.equals("0"))
            s = '-' + s;
        return s;
    }
    public static String bigNumSubHelper2(String s1,String s2){
        if (s1.length() == 0 || s2.length() == 0)
            return "0";
        int[] res = new int[s1.length()>s2.length() ? s1.length() : s2.length()];
        int i = s1.length()-1;
        int j = s2.length()-1;
        int k = res.length-1;
        while(i>=0 || j>=0){
            if(i>=0)
                res[k] = s1.charAt(i--)-'0';
            if(j>=0)
                res[k] -= (s2.charAt(j--)-'0');
            k--;
        }
        k = res.length-1;
        for(int idx=k;idx>=1;idx--){
            if(res[idx]<0){
                res[idx-1] -= 1;
                res[idx] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int x : res){
            if(sb.length()==0 && x ==0)
                continue;
            sb.append(x);
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }

    public static String bigNumSub(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return "0";
        boolean f = false;
        if (s1.length() < s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
            f = true;
        } else if (s1.length() == s2.length()) {
            int idx = 0;
            while (idx < s1.length()) {
                if(s1.charAt(idx)>s2.charAt(idx))
                    break;
                else if (s1.charAt(idx) < s2.charAt(idx)) {
                    String t = s1.substring(idx);
                    s1 = s2.substring(idx);
                    s2 = t;
                    f = true;
                    break;
                }
                idx++;
                if(idx==s1.length()-1 && s1.charAt(idx)==s2.charAt(idx))
                    return "0";
            }
        }
        String s = bigNumSubHelper(s1, s2);

        if (f && !s.equals("0"))
            s = '-' + s;
        return s;
    }
    public static String bigNumSubHelper(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len1];
        int[] res = new int[len1 > len2 ? len1 : len2];
        for (int i = 0; i < len1; i++)
            arr1[len1 - i - 1] = s1.charAt(i) - '0';
        for (int i = 0; i < len2; i++)
            arr2[len2 - i - 1] = s2.charAt(i) - '0';
        int i = 0;
        int j = 0;
        int k = 0;
        int temp = 0;

        while (i < len1 && j < len1) {
            temp += arr1[i++];
            if (temp >= arr2[j]) {
                temp -= arr2[j++];
                res[k++] = temp;
                temp = 0;
            } else {
                temp = temp + 10 - arr2[j++];
                res[k++] = temp;
                temp = -1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int n : res)
            sb.append(n);
        sb.reverse();
        for (i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) != '0')
                break;
        }
        return sb.toString().substring(i);
    }

}
