    package gc.exam.wuba.one;

    import java.util.*;

    /**
     * @author gengchao
     * @date 2019/9/12 19:52
     * @description：
     */
    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = Integer.valueOf(in.nextLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.valueOf(in.nextLine());
            }
            System.out.println(candy(arr));
        }

        public static int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);
            boolean flag = true;
            int sum = 0;
            while (flag) {
                flag = false;
                for (int i = 0; i < ratings.length; i++) {
                    if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                        candies[i] = candies[i + 1] + 1;
                        flag = true;
                    }
                    if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                        candies[i] = candies[i - 1] + 1;
                        flag = true;
                    }
                }
            }
            for (int candy : candies) {
                sum += candy;
            }
            return sum;
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
