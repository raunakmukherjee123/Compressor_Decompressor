import comp_decomp.comp;
import comp_decomp.decomp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
// data compression-reduction in number of bits of data
//File Input stream is a class, used for reading byte oriented data. ex-data,video,audio,images,etc
//File output stream is used for writing data(raw bytes) in a file
//GZIP Output stream is used for writing compressed data in GZIP File format
//File Input stream is compressed => GZIP Output stream
//GZIP input stream is sued to decompress file that is compressed with GZIP compression algorithm
// Decompression -> File output stream to show output data
public class Compressor_and_Decompressor extends JFrame implements ActionListener {
   JButton compress;
   JButton decompress;
  Compressor_and_Decompressor()
  {
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// i want to exit on click of close button
      compress=new JButton("Compress");
      compress.addActionListener(this);
      decompress=new JButton("Decompress");
      decompress.addActionListener(this);
      this.add(compress);
      this.add(decompress);
      this.setSize(1000,700);
      this.getContentPane().setBackground(Color.pink);
      this.setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
   if(e.getSource()==compress)//if we pressed compress button
   {
     JFileChooser fileChooser=new JFileChooser();
     int response=fileChooser.showSaveDialog(null);
     if(response==JFileChooser.APPROVE_OPTION)
     {
         File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
         try
         {
             comp.method(file);
         }
         catch (Exception ee)
         {
             JOptionPane.showMessageDialog(null,ee.toString());
         }
     }
   }
      if(e.getSource()==decompress)
      {
          JFileChooser fileChooser=new JFileChooser();
          int response=fileChooser.showSaveDialog(null);
          if(response==JFileChooser.APPROVE_OPTION)
          {
              File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
              try
              {
                  decomp.method(file);
              }
              catch (Exception ee)
              {
                  JOptionPane.showMessageDialog(null,ee.toString());
              }
          }
      }
  }
}
