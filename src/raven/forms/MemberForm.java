package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import myclass.DBConnection;
import myclass.Member;
import myclass.TableHeaderAlignment;
import raven.alerts.MessageAlerts;
import raven.components.SimpleForm;



public class MemberForm extends SimpleForm {

    myclass.Member member = new myclass.Member();
    
    myclass.Func_Class func = new myclass.Func_Class();

    public MemberForm() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));



        // show table contents
       populateJTableWithMembers();

    }

    
    
    private void init() {
        
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        tbl_Members.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold +2;");

        tbl_Members.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +7;");

        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");

          tbl_Members.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Members));
    
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("raven/resources/icon/search.svg"));
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        
        Border JlabelImageBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(22, 36, 86));
        lbl_image.setBorder(JlabelImageBorder);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Members = new javax.swing.JTable();
        lbTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        createStudent1 = new raven.forms.CreateStudent();
        lbl_image = new javax.swing.JLabel();
        lbl_fullName = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_Gender = new javax.swing.JLabel();
        lbl_level = new javax.swing.JLabel();
        lbl_strand = new javax.swing.JLabel();

        scroll.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tbl_Members.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_Members.getTableHeader().setReorderingAllowed(false);
        tbl_Members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MembersMouseClicked(evt);
            }
        });
        scroll.setViewportView(tbl_Members);

        lbTitle.setText("MANAGE STUDENTS");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lbl_image.setBackground(new java.awt.Color(204, 204, 204));
        lbl_image.setOpaque(true);

        lbl_fullName.setText("Full Name");

        lbl_id.setText("Student ID");

        lbl_Gender.setText("Gender");

        lbl_level.setText("Grade Level");

        lbl_strand.setText("Strand");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_fullName)
                            .addComponent(lbl_id)
                            .addComponent(lbl_Gender)
                            .addComponent(lbl_level)
                            .addComponent(lbl_strand)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addGap(18, 18, 18)
                .addComponent(createStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(createStudent1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_fullName)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_id)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_level)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_strand)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Gender)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tbl_MembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MembersMouseClicked

        // display the selected member data
        Member SelectedMember;

        Integer rowIndex = tbl_Members.getSelectedRow();
        Integer id = Integer.parseInt(tbl_Members.getModel().getValueAt(rowIndex, 0).toString());

        try {
            SelectedMember = member.getMemberById(id);
            if (SelectedMember != null) {

                lbl_fullName.setText(SelectedMember.getFirstName() + " " + SelectedMember.getLastName());
                lbl_id.setText(String.valueOf(SelectedMember.getId()));
                lbl_level.setText(String.valueOf(SelectedMember.getLevel()));
                lbl_strand.setText(String.valueOf((SelectedMember.getStrand())));
                lbl_Gender.setText(SelectedMember.getGender());

                //display the member image
                byte[] image = SelectedMember.getPicture();
                // dispalys the image using the imagebyte
                func.displayImage(215, 165, image, "", lbl_image);

            } else {
                MessageAlerts.getInstance().showMessage("No Member  With This Information Is Found ", "Oops! Error has occured the student does not exist in the system", MessageAlerts.MessageType.ERROR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tbl_MembersMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel ob = (DefaultTableModel) tbl_Members.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tbl_Members.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased


   // create a function to populate the jtable with authors
    public void populateJTableWithMembers(){
    
        ArrayList<myclass.Member> membersList = member.membersList();
        
        // jtable colummns
        String [] colNames = {"ID", "First Name",  "Last Name",  "Level",  "Stand", "Gender"};
        
        // row
        Object[][] rows = new Object[membersList.size()] [colNames.length];
        
        for(int i = 0; i < membersList.size(); i++){
        
            rows[i] [0] = membersList.get(i).getId();
            rows[i] [1] = membersList.get(i).getFirstName();
            rows[i] [2] = membersList.get(i).getLastName();
            rows[i] [3] = membersList.get(i).getLevel();
            rows[i] [4] = membersList.get(i).getStrand();
            rows[i] [5] = membersList.get(i).getGender();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        tbl_Members.setModel(model);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.forms.CreateStudent createStudent1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbl_Gender;
    private javax.swing.JLabel lbl_fullName;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_level;
    private javax.swing.JLabel lbl_strand;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_Members;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
