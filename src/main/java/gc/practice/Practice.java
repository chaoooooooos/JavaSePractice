package gc.practice;

public class Practice {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.delete(0,sb.length());


    }

    public static int helper(int i){
        try {
            ++i;
            return i;
        }catch (Exception e){
            return i;
        }finally {
            ++i;
        }

    }






}
