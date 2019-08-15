package gc.BigNum;

/*
 *
 * 只是处理2个正数相加问题，若有一正一负，可以转换为
 * 大数相减，若是两负，可以相加后取相反数
 * */

public class BigNumAdd {
     public static String bigNumAdd2 (String s1, String s2){
            if (s1.length() == 0 || s2.length() == 0)
                return "0";
            int len1 = s1.length();
            int len2 = s2.length();
            int[] res = new int[1 + (len1 > len2 ? len1 : len2)];
            int k = res.length - 1;
            int i = len1 - 1;
            int j = len2 - 1;
            while (i >= 0 || j >= 0) {
                if (i >= 0)
                    res[k] += (s1.charAt(i--) - '0');
                if (j >= 0)
                    res[k] += (s2.charAt(j--) - '0');
                k--;
            }

            for (int idx = res.length - 1; idx >= 1; idx--) {
                if (res[idx] > 9) {
                    res[idx - 1] += 1;
                    res[idx] %= 10;
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int x : res) {
                if (sb.length() == 0 && x == 0)
                    continue;
                sb.append(x);
            }
            if(sb.length()==0) return "0";
            return sb.toString();
        }

        public static String bigNumAdd (String s1, String s2){
            if (s1.length() == 0 || s2.length() == 0)
                return "0";
            int len1 = s1.length();
            int len2 = s2.length();
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];
            int[] res = new int[1 + (len1 > len2 ? len1 : len2)];
            for (int i = 0; i < len1; i++)
                arr1[len1 - i - 1] = s1.charAt(i) - '0';
            for (int i = 0; i < len2; i++)
                arr2[len2 - i - 1] = s2.charAt(i) - '0';
            int i = 0;
            int j = 0;
            int k = 0;
            int temp = 0;
            while (i < len1 || j < len2) {
                if (i < len1)
                    temp += arr1[i++];
                if (j < len2)
                    temp += arr2[j++];
                res[k++] = temp % 10;
                temp /= 10;
            }
            if (temp > 0)
                res[k] = temp;
            StringBuffer sb = new StringBuffer();

            boolean f = true;
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
