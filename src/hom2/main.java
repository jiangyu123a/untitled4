package hom2;

import java.io.*;
import java.util.List;

public class main {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        spilit(file);
        thread th = new thread();
        Thread th1 = new Thread(th);
        Thread th2 =new Thread(th);
        th1.start();
        th2.start();
    }

    private static void spilit(File file) {
        FileReader fr=null;
        try {
            fr = new FileReader(file);
            int account=1;
            int len;
            char[] cbuf = new char[30];
            while((len=fr.read(cbuf))!=-1){
                FileWriter fw = new FileWriter(account+".part.txt");
                fw.write(cbuf,0,len);
                account++;
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}