package gc.utils.files;

import java.io.*;

public class gbk2utf {

    public static void main(String[] args) {
        String directory = "C:/Users/gc/Desktop/gps8";
        String suffix = ".h";
        String fromEncoding = "gb2312";
        String toEncoding = "utf-8";
        change(directory, suffix, fromEncoding, toEncoding);

    }

    /**
     * 将指定目录directory（包含子目录）下的指定后缀名为suffix的文件，统一从编码格式为fromEncoding更改为toEncoding
     */
    public static void change(String directory, String suffix, String fromEncoding, String toEncoding) {
        File dir = new File(directory);
        if (dir.isAbsolute() || dir.isDirectory()) {
            File[] list = dir.listFiles();
            for (int i = 0; i < list.length; i++) {
                File file = list[i];
                if (file.isFile() && file.getName().toLowerCase().endsWith(suffix)) {
                    System.out.println(file.getPath());
                    try {
                        InputStream in = new FileInputStream(file);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in, fromEncoding));
                        File temp = new File(file.getPath() + ".txt");
                        OutputStream out = new FileOutputStream(temp);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, toEncoding));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            bw.write(line+"\r\n");
                        }
                        br.close();
                        in.close();
                        bw.close();
                        out.close();
                        file.delete();
                        temp.renameTo(file);

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else if (file.isDirectory()) {
                    change(file.getPath(), suffix, fromEncoding, toEncoding);
                }
            }

        }
    }

}