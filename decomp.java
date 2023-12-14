package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decomp {
    public static void method(File file)throws IOException
    {
        String fileDirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);//input file is in compressed format
        GZIPInputStream gzip=new GZIPInputStream(fis);//decompressing input file
        FileOutputStream fos=new FileOutputStream(fileDirectory+"Decompressed File");
        byte[] buffer=new byte[1024];
        int len;
        while((len=gzip.read())!=-1)// i want to write every byte of i/p gzip file into outputstream to display o/p
        {
            fos.write(buffer,0,len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args)throws IOException
    {
        File path=new File("C");
        method(path);
    }
}
