package hom2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class thread implements Runnable {

    int i = 1;
    FileReader fr = null;
    FileWriter fw =null;
Object obj =new Object();

    @Override
    public void run() {
        try {
            fw = new FileWriter("hebing.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(i<=13){
            synchronized (obj){
                if(i<=13)
                {
                    try {
                        fr= new FileReader(i+".part.txt");
                        i++;
                        char[] cbuf = new char[30];
                        int len;
                        while((len=fr.read(cbuf))!=-1)
                        {
                            String name = Thread.currentThread().getName();
                            fw.write(name);
                            fw.write(cbuf,0,len);
                            System.out.println(cbuf);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }


        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
