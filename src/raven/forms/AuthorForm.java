package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import myclass.DBConnection;
import myclass.TableHeaderAlignment;
import raven.alerts.MessageAlerts;
import raven.components.SimpleForm;



public class AuthorForm extends SimpleForm {

    myclass.Author author = new myclass.Author();

    public AuthorForm() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));

        // hide the jlabel "empty the first and last name message"
        jLabel_EmptyFName.setVisible(false);
        jLabel_EmptyLName.setVisible(false);

        // show table contents
       populateJTableWithAuthors();

    }

    
    
    private void init() {
        
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        tbl_Authors.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold +2;");

        tbl_Authors.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +30;");

        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");
        
            txt_FirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "first");
            txt_LastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "last");
             
          tbl_Authors.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Authors));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Authors = new javax.swing.JTable();
        lbTitle = new javax.swing.JLabel();
        jButton_Add_ = new javax.swing.JButton();
        jButton_Edit_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jLabel_EmptyFName = new javax.swing.JLabel();
        txt_LastName = new javax.swing.JTextField();
        jLabel_EmptyLName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Expertise = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_About = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        txt_FirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        scroll.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tbl_Authors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_Authors.getTableHeader().setReorderingAllowed(false);
        tbl_Authors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_AuthorsMouseClicked(evt);
            }
        });
        scroll.setViewportView(tbl_Authors);

        lbTitle.setText("MANAGE AUTHORS");

        jButton_Add_.setText("Add");
        jButton_Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ActionPerformed(evt);
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

        jLabel3.setText("Expertise");

        jLabel_EmptyFName.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyFName.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyFName.setText("* enter the first name");
        jLabel_EmptyFName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyFNameMouseClicked(evt);
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

        jLabel4.setText("ID:");

        jLabel5.setText("About");

        txt_About.setColumns(20);
        txt_About.setRows(5);
        jScrollPane1.setViewportView(txt_About);

        jLabel6.setText("Full Name");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_Expertise))
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel_EmptyFName)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel_EmptyLName)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_LastName))))
                        .addContainerGap())))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_EmptyLName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_EmptyFName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Expertise, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    String fname, lname, expertise, about;
    int author_id;
    
    public boolean addAuthor(){
    boolean isAdded = false;
        //to get the text typed in the textbox
        author_id = Integer.parseInt(txt_Id.getText());
         fname = txt_FirstName.getText();
         lname = txt_LastName.getText();
         expertise = txt_Expertise.getText();
         about = txt_About.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO author VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
           
              pst.setInt(1, author_id);
              pst.setString(2, fname);
              pst.setString(3, lname);
              pst.setString(4, expertise);
              pst.setString(5, about);
            
              int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                  isAdded = true;
            }
            else{
                  isAdded = false;
            }

        } catch (Exception e) {
        }
        return isAdded;
    }
    
      // to edit book to book_details table
    public boolean editGenre() {
        boolean isUpdated = false;
        //to get the text typed in the textbox
        author_id = Integer.parseInt(txt_Id.getText());
         fname = txt_FirstName.getText();
         lname = txt_LastName.getText();
         expertise = txt_Expertise.getText();
         about = txt_About.getText();

        try {
             Connection con = DBConnection.getConnection();
            String sql = "  UPDATE `author` SET `firstName`= ?,`lastName`= ? ,`expertise`= ? ,`about`= ? WHERE `id` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, expertise);
            ps.setString(4, about);
            ps.setInt(5, author_id);
              
            
             //It checks if the command was updated
            int rowCount = ps.executeUpdate();
            if (rowCount > 0){
                  isUpdated = true;
            }else{
                isUpdated = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
     public boolean deleteAuthor() {
        boolean isDeleted = false;
        //to get the text typed in the textbox
        author_id = Integer.parseInt(txt_Id.getText());


        try {
             Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM `author` WHERE `id` = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
              pst.setInt(1, author_id);
            
              int rowCount = pst.executeUpdate();
              
             if(rowCount > 0){
            isDeleted = true;
            }else{
            isDeleted = false;
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
        return isDeleted;
    }
    

    private void jButton_Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ActionPerformed

        // add a new author 
        String fname = txt_FirstName.getText();
        String lname = txt_LastName.getText();

        // check if the textfield is empty
        if (fname.isEmpty()) {
            jLabel_EmptyFName.setVisible(true);
        } else if (lname.isEmpty()) {
            jLabel_EmptyLName.setVisible(true);
        } else { // if the textfields are not empty
            if (addAuthor() == true) {
                // refresh the table with genres
                populateJTableWithAuthors();
                MessageAlerts.getInstance().showMessage("Author Added ", "Successfully added a new author into the system", MessageAlerts.MessageType.SUCCESS);
            } else {
                MessageAlerts.getInstance().showMessage("Failed to Add Author ", "Oops! Error has occured could not add a new author into the system", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed

        // edit the selected author
        String fname = txt_FirstName.getText();
        String lname = txt_LastName.getText();

         // check if the textfield is empty
        if (fname.isEmpty()) {
            jLabel_EmptyFName.setVisible(true);
        } else if (lname.isEmpty()) {
            jLabel_EmptyLName.setVisible(true);
        }  else { // if the textfields are not empty
            if (editGenre()==true){
            // refresh the table with genres
            populateJTableWithAuthors();
             MessageAlerts.getInstance().showMessage("Author Edited ", "Successfully edited author information into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
             MessageAlerts.getInstance().showMessage("Failed to Edit Author", "Oops! Error has occured could not edit this author information into the system", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed

         if (deleteAuthor()== true) {
          // show table contents
          populateJTableWithAuthors();
           MessageAlerts.getInstance().showMessage("Author Deleted", "Successfully deleted the author into the system", MessageAlerts.MessageType.SUCCESS);
     } else {
       MessageAlerts.getInstance().showMessage("Failed to Delete Author", "Oops! Error has occured could not delete the author into the system", MessageAlerts.MessageType.ERROR);
     }

    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void tbl_AuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AuthorsMouseClicked

        // display the selected author
        // get the selected row index
        int index = tbl_Authors.getSelectedRow();

        // get values
        String id = tbl_Authors.getValueAt(index, 0).toString();
        String firstName = tbl_Authors.getValueAt(index, 1).toString();
        String lastName = tbl_Authors.getValueAt(index, 2).toString();
        String expertise = tbl_Authors.getValueAt(index, 3).toString();
        String about = tbl_Authors.getValueAt(index, 4).toString();


        // show data in textfields
        txt_Id.setText(id);
        txt_FirstName.setText(firstName);
        txt_LastName.setText(lastName);
        txt_Expertise.setText(expertise);
        txt_About.setText(about);
        
    }//GEN-LAST:event_tbl_AuthorsMouseClicked


    // create a function to populate the jtable with authors
    public void populateJTableWithAuthors(){
    
        ArrayList<myclass.Author> authorsList = author.authorsList();
        
        // jtable colummns
        String [] colNames = {"ID", "First Name",  "Last Name",  "Expertise",  "About"};
        
        // row
        Object[][] rows = new Object[authorsList.size()] [colNames.length];
        
        for(int i = 0; i < authorsList.size(); i++){
        
            rows[i] [0] = authorsList.get(i).getId();
            rows[i] [1] = authorsList.get(i).getFirstName();
            rows[i] [2] = authorsList.get(i).getLastName();
            rows[i] [3] = authorsList.get(i).getField_Of_Expertise();
            rows[i] [4] = authorsList.get(i).getAbout();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        tbl_Authors.setModel(model);
    } 

    private void jLabel_EmptyFNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyFNameMouseClicked
        //hides the label on click
        jLabel_EmptyFName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyFNameMouseClicked

    private void jLabel_EmptyLNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyLNameMouseClicked
        //hides the label on click
        jLabel_EmptyLName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyLNameMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_EmptyFName;
    private javax.swing.JLabel jLabel_EmptyLName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_Authors;
    private javax.swing.JTextArea txt_About;
    private javax.swing.JTextField txt_Expertise;
    private javax.swing.JTextField txt_FirstName;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_LastName;
    // End of variables declaration//GEN-END:variables
}
