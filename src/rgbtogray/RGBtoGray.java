/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgbtogray;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
//import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.awt.Image;
//import javax.swing.Icon;
//import package.ImageProcessing;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.File;
import java.awt.Graphics;
import java.awt.EventQueue;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.Dimension;
/**
 *
 * @author lenovo
 */
public class RGBtoGray extends javax.swing.JFrame {

    /**
     * Creates new form RGBtoGray
     */
    public RGBtoGray() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Converter to Grayscale");

        jButton1.setText("Convert with Average");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Convert with Luminosity");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Convert with BufferedImage - java built in ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.setToolTipText("");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Import Image");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save Converted Image");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem5.setText("Delete Image");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private BufferedImage img, grayscale;
    JLabel jlabel1 = new JLabel();
    JLabel jlabel2 = new JLabel();
    ImageProcessing imp = new ImageProcessing();
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    if(evt.getSource()==jMenuItem1){ //jika event yang dilakukan = event jMenuItem1
        jFileChooser1.showOpenDialog(null); // sebelum jMenuItem1 diklik atau dilakukan, nilai dari suatu bufferedimage (img) = null
        String[] extensions = ImageIO.getReaderFileSuffixes();
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Image files", extensions));
        File f = jFileChooser1.getSelectedFile();
        try{ //try - catch adalah error handler
        img = ImageIO.read(f); // saat sudah dilakukan event jMenuItem1, maka img membaca file yang di pilih oleh jFileChooser1
        ImageIcon icon = new ImageIcon(img); //membuat ImageIcon dai img
        jlabel1.setIcon(icon); //set icon/gambar jLabel1
        Dimension imageSize = new Dimension(icon.getIconWidth(),icon.getIconHeight()); //ambil dimensi dari icon / img yg tlh diubah ke icon
        jlabel1.setPreferredSize(imageSize); //set dimensinya ke jlabel1
        jlabel1.revalidate(); //validasi ulang jlabel1
        jlabel1.repaint(); //gambar ulang jlabel1
        jlabel1.setHorizontalAlignment(JLabel.CENTER); //buat alignmentnya center
        jScrollPane1.getViewport().add(jlabel1); // masukan apa yg ada di jlabel1 ke jScrollPane1
        }
        catch(IOException e1){} //jika error, lakukan IOException e1
        
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
    // Convert R, G, B, Alpha ke standard 8 bit, kenapa? karena 8-bit (256) murni R,G, dan B (masing-masing kanal trpisah). 
    //ada format lain misalnya 16-bit dimana terdapat warna-wana lain selain RGB karena pencampuran RGB itu sndiri
    //misalnya cyan, magenta, white
    private static int colorToRGB(int alpha, int red, int green, int blue) {
 
        int newPixel = 0;
        // x += y artinya x = x + y
        newPixel += alpha; 
        // tanda >> artinya geser bit ke kiri sejauh blablabla, contoh: 
        // 00100011 35 >> 2
        // 00001000 8
        // dan begitu juga sebaliknya
        // atau bisa juga >> diterjemahin jadi i/(2^k), klo << jadi kali-nya. tapi sebaiknya jgn pakai cara ini.
        newPixel = newPixel << 8;
        newPixel += red; newPixel = newPixel << 8;
        newPixel += green; newPixel = newPixel << 8;
        newPixel += blue;
 
        return newPixel;
 
    }
    

    // The luminance method
    private static BufferedImage luminosity(BufferedImage original) {
 
    int alpha, red, green, blue, gray;
    int newPixel;
 
    BufferedImage lum = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
 
    for(int i=0; i<original.getWidth(); i++) {
        for(int j=0; j<original.getHeight(); j++) {
 
            // Get pixels by R, G, B
            alpha = new Color(original.getRGB(i, j)).getAlpha();
            red = new Color(original.getRGB(i, j)).getRed();
            green = new Color(original.getRGB(i, j)).getGreen();
            blue = new Color(original.getRGB(i, j)).getBlue();
 
            gray = (int) (0.21 * red + 0.71 * green + 0.07 * blue); 
            // Return back to original format
            newPixel = colorToRGB(alpha, gray, gray, gray);
 
            // Write pixels into image
            lum.setRGB(i, j, newPixel);
 
        }
    }
 
    return lum;
 
}


// The average grayscale method
private static BufferedImage avg(BufferedImage original) {
 
    int alpha, red, green, blue;
    int newPixel;
 
    BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
    int[] avgLUT = new int[766];
    for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
 
    for(int i=0; i<original.getWidth(); i++) {
        for(int j=0; j<original.getHeight(); j++) {
 
            // Get pixels by R, G, B
            alpha = new Color(original.getRGB(i, j)).getAlpha();
            red = new Color(original.getRGB(i, j)).getRed();
            green = new Color(original.getRGB(i, j)).getGreen();
            blue = new Color(original.getRGB(i, j)).getBlue();
 
            newPixel = red + green + blue;
            newPixel = avgLUT[newPixel];
            // Return back to original format
            newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
 
            // Write pixels into image
            avg_gray.setRGB(i, j, newPixel);
 
        }
    }
 
    return avg_gray;
 
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
     grayscale = avg(img); // dengan algoritma average 
     ImageIcon ico = new ImageIcon(grayscale); 
        jlabel2.setIcon(ico); // set gambar di jlabel2
        Dimension imageSizes = new Dimension(ico.getIconWidth(),ico.getIconHeight());  // dapetin dimensinya, simpan di imageSizes
        jlabel2.setPreferredSize(imageSizes); // set jlabel2 sesuaikan dengan dimensi gambar 
        jlabel2.revalidate();  // validasi ulang
        jlabel2.repaint();  // gambar ulang di jlabel2
        jlabel2.setHorizontalAlignment(JLabel.CENTER);  // set di tengah
        jScrollPane2.getViewport().add(jlabel2);  // simpan apa yg ada di jlabel2 ke jScrollPane2
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    grayscale = luminosity(img); // dengan algoritma luminosity
     ImageIcon ico = new ImageIcon(grayscale);
        jlabel2.setIcon(ico); // set gambar di jlabel2
        Dimension imageSizes = new Dimension(ico.getIconWidth(),ico.getIconHeight()); // dapetin dimensinya, simpan di imageSizes
        jlabel2.setPreferredSize(imageSizes); // set jlabel2 sesuaikan dengan dimensi gambar 
        jlabel2.revalidate(); // validasi ulang
        jlabel2.repaint();  // gambar ulang di jlabel2
        jlabel2.setHorizontalAlignment(JLabel.CENTER); // set di tengah
        jScrollPane2.getViewport().add(jlabel2);        // simpan apa yg ada di jlabel2 ke jScrollPane2
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Icon ico = jlabel2.getIcon();
    img = new BufferedImage(ico.getIconWidth(),ico.getIconHeight(),BufferedImage.TYPE_BYTE_GRAY);   
    Graphics g = img.createGraphics(); // buat graphic dari bufferedimage
    ico.paintIcon(null, g, 0, 0); // gambarkan ke bentuk icon  
    g.dispose(); //dispose
    jlabel2.setIcon(new ImageIcon(img));  // set gambar pada jlabel2
    jlabel2.setHorizontalAlignment(JLabel.CENTER);  // set di tengah
    jScrollPane2.getViewport().add(jlabel2); // simpan apa yg ada di jlabel2 ke jScrollPane2
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RGBtoGray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RGBtoGray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RGBtoGray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RGBtoGray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //ImageProcessing imp = new ImageProcessing();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //ImageProcessing imp = new ImageProcessing();
                new RGBtoGray().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}