package gc.exam.bilibili;

/**
 * @author gengchao
 * @date 2019/9/10 18:55
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
