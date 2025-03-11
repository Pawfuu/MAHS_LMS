/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import myclass.Member;
import raven.alerts.MessageAlerts;
import raven.components.SimpleForm;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

public class CreateStudent extends SimpleForm {
    // create a Func Class instance
    myclass.Func_Class func = new myclass.Func_Class();
    
    //create a member object
    myclass.Member member = new myclass.Member();
    
    // create a variable to store the profile picture path
    String imagePath = null;
    
    public CreateStudent() {
        initComponents();
        init();
        
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));
        
        // hide the jlabel "empty the first and last name message"
        jLabel_EmptyFName.setVisible(false);
        jLabel_EmptyLName.setVisible(false);
        jLabel_Emptyid.setVisible(false);
        
    }

   private void init(){
       
    jLabel1.putClientProperty(FlatClientProperties.STYLE,""
            + "font:bold +10");
     jLabel2.putClientProperty(FlatClientProperties.STYLE,""
            + "font:bold +1");
     
      jButton_Add_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
    
    jButton_Delete_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
    
    jButton_Edit_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
    
    //add a black boder to the jlabel image
    Border  JlabelImageBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(22, 36, 86));
    jLabel_image.setBorder(JlabelImageBorder);
    
    txt_fName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First");
    txt_lName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Last");
    txt_studentId.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter Student Member ID...");
    }
  

   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_level = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fName = new javax.swing.JTextField();
        txt_lName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combo_Strand = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        combo_Gender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lbl_ImagePath = new javax.swing.JLabel();
        jButton_SelectProfilePicture = new javax.swing.JButton();
        jButton_Edit_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        jButton_Add_ = new javax.swing.JButton();
        jLabel_EmptyLName = new javax.swing.JLabel();
        jLabel_EmptyFName = new javax.swing.JLabel();
        jButton_Search = new javax.swing.JButton();
        jLabel_image = new javax.swing.JLabel();
        jLabel_Emptyid = new javax.swing.JLabel();

        jLabel1.setText("Student Details");

        jLabel2.setText("Insert Student Details");

        jLabel3.setText("Full Name:");

        txt_level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_levelActionPerformed(evt);
            }
        });

        jLabel4.setText("Student ID:");

        txt_lName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Level:");

        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });

        jLabel6.setText("Strand:");

        combo_Strand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HUMSS", "ICT", "STEM", "HE", "ABM", " " }));

        jLabel7.setText("Gender:");

        combo_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel8.setText("Profile Picture:");

        lbl_ImagePath.setForeground(new java.awt.Color(22, 36, 86));
        lbl_ImagePath.setText("choose profile picture....");

        jButton_SelectProfilePicture.setText("Select Profile");
        jButton_SelectProfilePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectProfilePictureActionPerformed(evt);
            }
        });

        jButton_Edit_.setText("Edit");
        jButton_Edit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Edit_ActionPerformed(evt);
            }
        });

        jButton_Delete_.setText("Delete");
        jButton_Delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Delete_ActionPerformed(evt);
            }
        });

        jButton_Add_.setText("Add");
        jButton_Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ActionPerformed(evt);
            }
        });

        jLabel_EmptyLName.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyLName.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyLName.setText("* enter the last name");
        jLabel_EmptyLName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyLNameMouseClicked(evt);
            }
        });

        jLabel_EmptyFName.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyFName.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyFName.setText("* enter the first name");
        jLabel_EmptyFName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyFNameMouseClicked(evt);
            }
        });

        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jLabel_image.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_image.setOpaque(true);

        jLabel_Emptyid.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_Emptyid.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_Emptyid.setText("* you must enter student ID");
        jLabel_Emptyid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(txt_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_lName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Add_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Edit_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_EmptyFName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_EmptyLName)
                        .addGap(47, 47, 47))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_Strand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_SelectProfilePicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_ImagePath)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Emptyid)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_lName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_EmptyFName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyLName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Search))
                .addGap(2, 2, 2)
                .addComponent(jLabel_Emptyid, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_Strand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_SelectProfilePicture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_ImagePath))
                    .addComponent(jLabel8)
                    .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_levelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_levelActionPerformed

    private void txt_lNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lNameActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jButton_Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ActionPerformed
        
        // add a new student
        String fname = txt_fName.getText();
        String lname = txt_lName.getText();
        int level = Integer.parseInt(txt_level.getText());
        String strand = combo_Strand.getSelectedItem().toString();
        String gender = combo_Gender.getSelectedItem().toString();
        
        // check if the textfieds are empty
        if(fname.isEmpty())
        {
            jLabel_EmptyFName.setVisible(true);
        }
        else if(lname.isEmpty())
        {
            jLabel_EmptyLName.setVisible(true);
        }
        else // if textfields are not empty
        {
            byte[] img = null;

            if (imagePath != null) {
                
                try {
                    Path path = Paths.get(imagePath);
                    img = Files.readAllBytes(path);

                    member.addMember(fname, lname, level, strand, gender, img);
                } catch (IOException ex) {
                    Logger.getLogger(CreateStudent.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else
            {
             MessageAlerts.getInstance().showMessage("Select a Profile Picture For This Member ", "Oops! Error has occured a picture has not been selected for the student", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed
        
        String fname = txt_fName.getText();
        String lname = txt_lName.getText();
        int level = Integer.parseInt(txt_level.getText());
        String strand = combo_Strand.getSelectedItem().toString();
        String gender = combo_Gender.getSelectedItem().toString();
        
        // check if the textfieds are empty
        if(fname.isEmpty())
        {
            jLabel_EmptyFName.setVisible(true);
        }
        else if(lname.isEmpty())
        {
            jLabel_EmptyLName.setVisible(true);
        }
        else // if textfields are not empty
        {
          byte[] img = null;

            if (imagePath != null) {
                
                try {
                    Integer id = Integer.parseInt(txt_studentId.getText());
                    Path path = Paths.get(imagePath);
                    img = Files.readAllBytes(path);

                    member.editMember(id, fname, lname, level, strand, gender, img);
                } catch (IOException ex) {
                    Logger.getLogger(CreateStudent.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else
            {
             MessageAlerts.getInstance().showMessage("Select a Profile Picture For This Member ", "Oops! Error has occured a picture has not been selected for the student", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed
       //delete the selected member
       
       // get the member id
       
        try {
            Integer id = Integer.parseInt(txt_studentId.getText());

            //show a confimation message before delete
            MessageAlerts.getInstance().showMessage("Are You Sure You Want To Delete This Member?", "Careful! Are you sure you want to delete this student member? This action cannot be undone.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                @Override
                public void action(PopupController pc, int i) {
                    if (i == MessageAlerts.YES_NO_OPTION) {
                        member.removeMember(id);
                    } else {
                           System.out.println("Cancel");
                    }
                }
            });
        } catch (Exception e) 
        {
             jLabel_Emptyid.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void jButton_SelectProfilePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectProfilePictureActionPerformed
        
            // select the picture from the image computer
            String path = func.selectImage();
            lbl_ImagePath.setText(path);
            imagePath = path;
            
            //display the image on size
            func.displayImage(185, 170, null, imagePath, jLabel_image);
        
    }//GEN-LAST:event_jButton_SelectProfilePictureActionPerformed

    private void jLabel_EmptyLNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyLNameMouseClicked
        //hides the label on click
        jLabel_EmptyLName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyLNameMouseClicked

    private void jLabel_EmptyFNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyFNameMouseClicked
         //hides the label on click
        jLabel_EmptyFName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyFNameMouseClicked

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed

        
        // get member  data
        Member SelectedMember;
        try {
             // search member by id and display data
        Integer id = Integer.parseInt(txt_studentId.getText()); // Changed from txt_fName to txt_studentId
        
        SelectedMember = member.getMemberById(id);
        if (SelectedMember != null) {
            txt_studentId.setText(String.valueOf(SelectedMember.getId()));
            txt_fName.setText(SelectedMember.getFirstName());
            txt_lName.setText(SelectedMember.getLastName());
            txt_level.setText(String.valueOf(SelectedMember.getLevel()));
            combo_Strand.setSelectedItem(SelectedMember.getStrand());
            combo_Gender.setSelectedItem(SelectedMember.getGender());
            
            // display the number image
            byte[] image = SelectedMember.getPicture();
            // display the image using the imagebyte so set the image path empty
            func.displayImage(185, 170, image, "", jLabel_image);
            
        } else {
            MessageAlerts.getInstance().showMessage("Student Not Found", "No student found with the provided ID.", MessageAlerts.MessageType.ERROR);
        }
    } catch (SQLException | NumberFormatException ex) {
        MessageAlerts.getInstance().showMessage("Enter a Valid Student ID", "Oops! Error has occurred, invalid ID", MessageAlerts.MessageType.ERROR);
    }


    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jLabel_EmptyidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyidMouseClicked
        jLabel_Emptyid.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyidMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Gender;
    private javax.swing.JComboBox<String> combo_Strand;
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_SelectProfilePicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_EmptyFName;
    private javax.swing.JLabel jLabel_EmptyLName;
    private javax.swing.JLabel jLabel_Emptyid;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel lbl_ImagePath;
    private javax.swing.JTextField txt_fName;
    private javax.swing.JTextField txt_lName;
    private javax.swing.JTextField txt_level;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
