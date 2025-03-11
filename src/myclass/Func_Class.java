
package myclass;

import java.awt.Image;
import java.io.File;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Func_Class {
    
    //create a function to display the image in jlabel
    public void displayImage(int width, int height, byte[] imagebyte, String imagePath, JLabel label)
    {
        // get the image
        
        ImageIcon imgIco;
        if (imagebyte != null) // get image using bytes
        {
          imgIco = new ImageIcon(imagebyte);
        }
        else // get image using path
        {
            try {
                //get the image from tehe project resources 
                imgIco = new ImageIcon(getClass().getResource(imagePath));
            } catch (Exception e) {
                //get the image from tehe project resources 
                imgIco = new ImageIcon(imagePath);
            }
        }
        
        // make the image fit the label
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        // set the image into the jlabel
        label.setIcon (new ImageIcon(image));
    
    }
    
    // Create a fimtopm tp select image
    // the function will return the image path
    public String selectImage()
    {
    // Select picture from the computer
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");
        
        fileChooser.setCurrentDirectory(new File("D:\\images"));
        
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Image", ".png", ".jpg", "jpeg");
        fileChooser.addChoosableFileFilter(extensionFilter);
        
        int fileState = fileChooser.showSaveDialog(null);
        String path = "";
        
        if(fileState == JFileChooser.APPROVE_OPTION){
            path =fileChooser.getSelectedFile().getAbsolutePath();
          
        }
        return path; 
    }
    
    
    // create a function to return a resultSet
    // we will use this function to reduce the code when populating the arraylist
    public ResultSet getData(String query)
    {
   
       PreparedStatement ps;
       ResultSet rs = null;
       
       try {
           ps = DBConnection.getConnection().prepareStatement(query);
           rs = ps.executeQuery();
           
      } 
       catch (SQLException ex) {
           Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
       }

       return rs;
    }
    
    // create a funtion to count the number of data
    public int countData(String tableName)
    {
        int total =0;
        ResultSet rs;
        Statement st;
       
        try {
            st = DBConnection.getConnection().createStatement();
            rs = st.executeQuery("SELECT COUNT (*) as total FROM `"+tableName+"`");
            if(rs.next())
            {
                total = rs.getInt("total");
            }
        }  catch (SQLException e) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, e);
        }
    return total;
    }
}
