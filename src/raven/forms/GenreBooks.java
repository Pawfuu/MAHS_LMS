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
import raven.menu.FormManager;


public class GenreBooks extends SimpleForm {


    
    public GenreBooks() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        
        // hide the jlabel "empty name message"
        jLabel_EmptyName.setVisible(false);
        jLabel_EmptyID.setVisible(false);
        
        // show table contents
        populateJTableWithGenres();
       
    }
    
    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        tbl_Genre.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        tbl_Genre.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +30;");

        jButton_Add_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "[dark]background:$Drawer.background;");

        jButton_Delete_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "[dark]background:$Drawer.background;");

        jButton_Edit_.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "[dark]background:$Drawer.background;");
        
        tbl_Genre.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Genre));

    }
    
        myclass.Genre genre = new myclass.Genre();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Genre = new javax.swing.JTable();
        lbTitle = new javax.swing.JLabel();
        jButton_Add_ = new javax.swing.JButton();
        jButton_Edit_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_nameGenre = new javax.swing.JTextField();
        jLabel_EmptyName = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel_EmptyID = new javax.swing.JLabel();

        tbl_Genre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_Genre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_GenreMouseClicked(evt);
            }
        });
        scroll.setViewportView(tbl_Genre);

        lbTitle.setText("MANAGE BOOK GENRE");

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

        jLabel3.setText("Genre Name:");

        jLabel_EmptyName.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyName.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyName.setText("* enter the genre name");
        jLabel_EmptyName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyNameMouseClicked(evt);
            }
        });

        jLabel2.setText("Book ID:");

        jLabel_EmptyID.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyID.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_EmptyID.setText("* enter the genre ID");
        jLabel_EmptyID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_EmptyIDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(txt_nameGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_EmptyName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(txt_Id)
                                        .addGap(274, 274, 274)
                                        .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel_EmptyID, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(scroll))
                        .addGap(23, 23, 23))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nameGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_EmptyName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_EmptyID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(14, 14, 14))
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
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    String bookGenre;
    int book_id;
    
    public boolean addGenre(){
    boolean isAdded = false;
        //to get the text typed in the textbox
        book_id = Integer.parseInt(txt_Id.getText());
        bookGenre = txt_nameGenre.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO `book_genres` VALUES (?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
           
              pst.setInt(1, book_id);
              pst.setString(2, bookGenre);
            
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
    
        // to add book to book_details table
    public boolean editGenre() {
        boolean isUpdated = false;
        //to get the text typed in the textbox
        book_id = Integer.parseInt(txt_Id.getText());
        bookGenre = txt_nameGenre.getText();

        try {
             Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_genres SET genre_name = ? WHERE id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, bookGenre);
            pst.setInt(2, book_id);
              
            
             //It checks if the command was updated
            int rowCount = pst.executeUpdate();
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
    
     // to add book to book_details table
    public boolean deleteGenre() {
        boolean isDeleted = false;
        //to get the text typed in the textbox
        book_id = Integer.parseInt(txt_Id.getText());


        try {
             Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM `book_genres` WHERE `id` = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
              pst.setInt(1, book_id);
            
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
        // edit the selected genre
        String name = txt_nameGenre.getText();
        
        //check if the textfield is empty
        if (name.isEmpty() || txt_Id.getText().equals("") ) {
            jLabel_EmptyName.setVisible(true);
             jLabel_EmptyID.setVisible(true);
             MessageAlerts.getInstance().showMessage("Missing Input", "Please enter the following infomations needed", MessageAlerts.MessageType.WARNING);
        }  else {
            if (addGenre() == true) {

                MessageAlerts.getInstance().showMessage("Genre Added ", "Successfully added a new genre into the system", MessageAlerts.MessageType.SUCCESS);

                // show table contents
                populateJTableWithGenres();
            } else {
                MessageAlerts.getInstance().showMessage("Genre Addition Failed ", "Oops! Error has occured could not add a new genre into the system", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed

        // edit the selected genre
        String name = txt_nameGenre.getText();

        //check if the textfield is empty
        if (name.isEmpty()) {
            jLabel_EmptyName.setVisible(true);
            
        } else {
            if (editGenre() == true) {

                MessageAlerts.getInstance().showMessage("Genre Edited", "Successfully edited the genre into the system", MessageAlerts.MessageType.SUCCESS);
                // show table contents
                populateJTableWithGenres();
            } else {
                MessageAlerts.getInstance().showMessage("Genre Not Edited ", "Oops! Error has occured could not edit the genre into the system", MessageAlerts.MessageType.ERROR);
            }
        }
    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed

     if (deleteGenre()== true) {
          // show table contents
            populateJTableWithGenres();
             MessageAlerts.getInstance().showMessage("Genre Deleted", "Successfully deleted the genre into the system", MessageAlerts.MessageType.SUCCESS);
     } else {
       MessageAlerts.getInstance().showMessage("Genre Deletion Failed", "Oops! Error has occured could not delete the genre into the system", MessageAlerts.MessageType.ERROR);
     
     }

    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void tbl_GenreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GenreMouseClicked
      
        // display the selected genre
        
        
        // get the selected row index
        int index = tbl_Genre.getSelectedRow();
        
        // get values
        String id = tbl_Genre.getValueAt(index, 0).toString();
        String name = tbl_Genre.getValueAt(index, 1).toString();
        
        // show data in textfields
        txt_Id.setText(id);
        txt_nameGenre.setText(name);
    }//GEN-LAST:event_tbl_GenreMouseClicked

    
    // create a function to populate the jtable with genres
    public void populateJTableWithGenres(){
    
        ArrayList<myclass.Genre> genresList = genre.genreList();
        
        // jtable colummns
        String [] colNames = {"BOOK ID", "NAME OF GENRE"};
        
        // row
        Object[][] rows = new Object[genresList.size()] [colNames.length];
        
        for(int i = 0; i < genresList.size(); i++){
        
            rows[i] [0] = genresList.get(i).getId();
            rows[i] [1] = genresList.get(i).getName();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        tbl_Genre.setModel(model);
    }
    
    
    private void jLabel_EmptyNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyNameMouseClicked
        //hides the label on click
        jLabel_EmptyName.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyNameMouseClicked

    private void jLabel_EmptyIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_EmptyIDMouseClicked
         //hides the label on click 
        jLabel_EmptyID.setVisible(false);
    }//GEN-LAST:event_jLabel_EmptyIDMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_EmptyID;
    private javax.swing.JLabel jLabel_EmptyName;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_Genre;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_nameGenre;
    // End of variables declaration//GEN-END:variables
}
