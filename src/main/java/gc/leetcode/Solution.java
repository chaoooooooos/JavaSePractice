package gc.leetcode;


class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0')
            return "0";
        int n1 = num1.length();
        int n2 = num1.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int v1 = num1.charAt(i) - '0';
                int v2 = num2.charAt(j) - '0';
                int v = v1 * v2;
                res[i + j + 1] = v;
            }
        }
        for (int i = res.length - 1; i >= 0; i--)
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        StringBuffer sb = new StringBuffer();
        for (int x : res)
            sb.append(x);
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) != 0)
            idx++;
        return  sb.toString().substring(idx);

    }
}