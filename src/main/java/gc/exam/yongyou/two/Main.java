package gc.exam.yongyou.two;

/**
 * @author gengchao
 * @date 2019/9/11 13:56
 * @description：
 */
public class Main {
    public static int[] string2arr(String s, String separator) {
        String[] ss = s.split(separator);
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        return arr;
    }
}
