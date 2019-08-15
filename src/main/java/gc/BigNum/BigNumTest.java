package gc.BigNum;

import java.math.BigInteger;
import java.util.Random;

public class BigNumTest {
    public static void main(String[] args) {
        Random random = new Random();
        int len1 = random.nextInt(10);
        int len2 = random.nextInt(10);
        int N = 30;
        for(int time = 0;time<N;time++){
            int a = 0;
            int b = 0;
            for(int i=0;i<len1;i++)
                a = random.nextInt(10)+a*10;
            for(int i=0;i<len2;i++)
                b = random.nextInt(10)+10*b;
//            int flag = 0;
//            flag = random.nextInt(10)>5 ? 1: -1;
//            a *= flag;
//            flag = random.nextInt(10)>5 ? 1: -1;
//            b *= flag;

            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            System.out.println("s1="+s1+",s2="+s2);
            System.out.println(BigNumSub.bigNumSub(s1,s2));
            System.out.println(BigNumSub.bigNumSub2(s1,s2));
            System.out.println(new BigInteger(s1).subtract(new BigInteger(s2)));
            System.out.println("----------------------------------------------------------");
        }

    }
}
