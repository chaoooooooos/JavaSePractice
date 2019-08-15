package gc.utils.files;

import java.io.File;

public class FileNum {
    private static int num = 0;
    public static void main(String[] args) {
        File f = new File("D:\\ssm\\SpringBoot-Dubbo-Docker-Jenkins-master\\Gaoxi-User");
        getFileList(f);
        System.out.println("num="+num);

    }

    public static void getFileList(File file){
        File[] files = file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                getFileList(f);
            }else{
                String name = f.getName();
                String[] strs = name.split("\\.");
                if(strs.length>=2){
                    String suffix = strs[1];
                    if(suffix.equals("java"))
                        num++;
                }

            }
        }
    }
}
