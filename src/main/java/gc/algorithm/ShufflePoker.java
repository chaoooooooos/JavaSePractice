package gc.algorithm;

import java.util.Arrays;
import java.util.Random;

public class ShufflePoker {
    public static int[] shuffle(int n) {
        int[] arr = new int[n];
        for(int i=1;i<=n;i++)
            arr[i-1] = i;
        Random random = new Random();
        for (int i = n - 1; i >= 0; i--) {
            int rd = random.nextInt(1000)%(i+1);
            int t = arr[i];
            arr[i] = arr[rd];
            arr[rd] = t;
        }
        return arr;
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++)
            System.out.println(Arrays.toString(shuffle(10)));
    }

}
/*   保证每个位置的概率都是1/n
*  算法步骤为：
  1. 建立一个数组大小为 n 的数组 arr，分别存放 1 到 n 的数值；
  2. 生成一个从 0 到 n - 1 的随机数 x；
  3. 输出 arr 下标为 x 的数值，即为第一个随机数；
  4. 将 arr 的尾元素和下标为 x 的元素互换；
  5. 同2，生成一个从 0 到 n - 2 的随机数 x；
  6. 输出 arr 下标为 x 的数值，为第二个随机数；
  7. 将 arr 的倒数第二个元素和下标为 x 的元素互换；
      ……
   如上，直到输出 m 个数为止
该算法是经典洗牌算法。它的proof如下：
对于arr[i],洗牌后在第n-1个位置的概率是1/n（第一次交换的随机数为i），在n-2个位置概率是[(n-1)/n] * [1/(n-1)] = 1/n，（第一次交换的随机数不为i，第二次为arr[i]所在的位置（注意，若i=n-1，第一交换arr[n-1]会被换到一个随机的位置））
在第n-k个位置的概率是[(n-1)/n] * [(n-2)/(n-1)] *...* [(n-k+1)/(n-k+2)] *[1/(n-k+1)] = 1/n（第一个随机数不要为i，第二次不为arr[i]所在的位置(随着交换有可能会变)……第n-k次为arr[i]所在的位置）.
 */