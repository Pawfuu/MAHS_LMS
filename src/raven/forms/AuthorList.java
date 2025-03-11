/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import myclass.Member;
import myclass.TableHeaderAlignment;
import raven.alerts.MessageAlerts;
import raven.components.SimpleForm;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

public class AuthorList extends SimpleForm {

    
    // create a Func Class instance
    myclass.Func_Class func = new myclass.Func_Class();
    
    myclass.Author author = new myclass.Author();
    
    // create a variable to store the profile picture path
    String imagePath = null;
    
    public AuthorList() {
         initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));

        
        // show table contents
       populateJTableWithAuthors();

    }

    
    
    private void init() {
        
         // Create a panel with FlowLayout for the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(lbTitle);
        titlePanel.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Table.background");

// Add the panel to the north position
        centerpanel.add(titlePanel, BorderLayout.NORTH);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +30;");
        
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
        

          tbl_Authors.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Authors));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Authors = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        centerpanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();

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

        centerpanel.setLayout(new java.awt.BorderLayout());

        lbTitle.setText("Author List");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        centerpanel.add(lbTitle, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(centerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(451, 451, 451))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scroll))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(centerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_AuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AuthorsMouseClicked


        // get the selected row index
        int index = tbl_Authors.getSelectedRow();

        // get values
        String id = tbl_Authors.getValueAt(index, 0).toString();
        String firstName = tbl_Authors.getValueAt(index, 1).toString();
        String lastName = tbl_Authors.getValueAt(index, 2).toString();
        String expertise = tbl_Authors.getValueAt(index, 3).toString();
        String about = tbl_Authors.getValueAt(index, 4).toString();

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerpanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    public javax.swing.JTable tbl_Authors;
    // End of variables declaration//GEN-END:variables
}
