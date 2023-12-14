package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class comp
{
    public static void method(File file)throws IOException
    {
        String fileDirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);//input file
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/CompressedFile.gz");//we are going to push output file in this directory
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        byte[] buffer=new byte[1024];//data
        int len;
        while((len=fis.read(buffer))!=-1)// i want to write every byte input file into gzip for compression
        {
            gzip.write(buffer,0,len);//here o/p file will be compressed and buffer=data, 0=start point, len=no. of bytes to write
        }
        gzip.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args)throws IOException
    {
        File path=new File("\"D:\\KidneyTestPic\"");
        method(path);
    }
}
