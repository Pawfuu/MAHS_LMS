package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
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






public class IssueBookForm extends SimpleForm {
    myclass.Issue_Book issue = new myclass.Issue_Book();
    myclass.Genre genre = new myclass.Genre();
    myclass.Author author = new myclass.Author();
    myclass.Member member = new myclass.Member();
    myclass.Book book = new myclass.Book();
    myclass.Func_Class func = new myclass.Func_Class();

    public IssueBookForm() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY_SEMIBOLD, Font.PLAIN, 14));
        
        datePicker1.setTextField(txt_Date1);
        datePicker2.setTextField(txt_Date2);
      


    }

    
    
    private void init() {
//        txt_Date1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Select Issue Date");
        
          // Create a panel with FlowLayout for the title
          JPanel titlePanelBook = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanelBook.add(lbTitleIssueBook);
        titlePanelBook.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Table.background");
        
        centerpanel_IssueBook.add(titlePanelBook, BorderLayout.NORTH);
        lbTitleIssueBook.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +50;");
        
         jLabel1.putClientProperty(FlatClientProperties.STYLE,""
            + "font:bold +1");
         
         jLabel2.putClientProperty(FlatClientProperties.STYLE,""
            + "font:bold +1");
         
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
        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");

          tbl_Members.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Members));
    
        search_book.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("raven/resources/icon/search.svg"));
        search_book.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        search_book.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        
        search_student.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("raven/resources/icon/search.svg"));
        search_student.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        search_student.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        
//        Border JlabelImageBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(22, 36, 86));
//        lbl_image.setBorder(JlabelImageBorder);

populateJTableWithBooks();
populateJTableWithMembers();

    }
    
    // insert issue book details to database 
   public boolean issueBook()
   {
   boolean isIssued = false;
   int bookId = Integer.parseInt(txt_BookId.getText());
   int studentId = Integer.parseInt(txt_StudentId.getText());
   String bookName = lbl_bookname.getText();
   String studentName = lb_studentName.getText();
   String notes = txt_note.getText();
   
      // Retrieve the selected date from the Date Picker
        Date issueDate = datePicker1.getSelectedDate();
        Date dueDate = datePicker2.getSelectedDate();

        // Convert to SQL Date
        java.sql.Date sqlIssueDate = new java.sql.Date(issueDate.getTime());
        java.sql.Date sqlDueDate = new java.sql.Date(dueDate.getTime());
        
        try {
           Connection con = DBConnection.getConnection();
            String issueQuery = "insert into issue_book_details(book_id, book_name, student_id," 
                    + "student_name, issue_date, due_date, status, note) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(issueQuery);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sqlIssueDate);
            pst.setDate(6, sqlDueDate);
            pst.setString(7, "pending");
            pst.setString(8, notes);
            
            //EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                isIssued = true;
            }else{
                    isIssued = false;
            }
            
       } catch (Exception e) {
           e.printStackTrace();
       }
   return isIssued;
   }
   
   // updating the amount of book issued
   public void updateBookCount()
   {
       int bookId = Integer.parseInt(txt_BookId.getText());
       try {
           // establish database connection
           Connection con = DBConnection.getConnection();
           // sql command to decrease the book quantity by 
           String updateQuery = "update books set quantity = quantity - 1 where id = ? ";
           // Prepare the SQL statement
           PreparedStatement pst = con.prepareCall(updateQuery);
           pst.setInt(1, bookId);
           
           // execure the update. It returns an int indicating the number of rows affected
            int RowCount = pst.executeUpdate();
            if (RowCount > 0) {
                MessageAlerts.getInstance().showMessage("Book Inventory Updated", "The book count has been updated in the system.", MessageAlerts.MessageType.SUCCESS);
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            } else {
               MessageAlerts.getInstance().showMessage("Error", "Unable to update the book count.", MessageAlerts.MessageType.ERROR);
            }
           
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
            
    // RESULT SET SINCE IT NEEDS TO SEE IF DATA RECORD EXIST FROM DATABASE (MYSQL)
    //checking wether book already allocated or not to a user
   public boolean isAlreadyIssued()
   {
       boolean isAlreadyIssued = false;
       int bookId = Integer.parseInt(txt_BookId.getText());
       int studentId = Integer.parseInt(txt_StudentId.getText());
       
       try {
            Connection con = DBConnection.getConnection();
           String sql = "Select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, bookId);
           pst.setInt(2, studentId);
           pst.setString(3, "pending");
           
              ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
       } catch (Exception e) {
             e.printStackTrace();
       }
        return isAlreadyIssued;
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker1 = new com.raven.datechooser.DateChooser();
        datePicker2 = new com.raven.datechooser.DateChooser();
        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Members = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        search_book = new javax.swing.JTextField();
        scroll1 = new javax.swing.JScrollPane();
        tbl_Books = new javax.swing.JTable();
        search_student = new javax.swing.JTextField();
        jButton_select_BookId = new javax.swing.JButton();
        jButton_select_studentId = new javax.swing.JButton();
        centerpanel_IssueBook = new javax.swing.JPanel();
        lbTitleIssueBook = new javax.swing.JLabel();
        txt_Date1 = new javax.swing.JTextField();
        lb_student = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        txt_StudentId = new javax.swing.JTextField();
        lbl_book = new javax.swing.JLabel();
        lb_studentName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        lbl_fullName = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_level = new javax.swing.JLabel();
        lbl_strand = new javax.swing.JLabel();
        lbl_Gender = new javax.swing.JLabel();
        lbl_bookimage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_isbn = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_genre = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_book1 = new javax.swing.JLabel();
        txt_BookId = new javax.swing.JTextField();
        lbl_book2 = new javax.swing.JLabel();
        txt_Date2 = new javax.swing.JTextField();
        jButton_IssueBook = new javax.swing.JButton();
        lbl_book3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextArea();

        datePicker1.setTextField(txt_Date1);

        datePicker2.setTextField(txt_Date2);

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

        search_book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_bookKeyReleased(evt);
            }
        });

        scroll1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tbl_Books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_Books.getTableHeader().setReorderingAllowed(false);
        tbl_Books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BooksMouseClicked(evt);
            }
        });
        scroll1.setViewportView(tbl_Books);

        search_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_studentActionPerformed(evt);
            }
        });
        search_student.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_studentKeyReleased(evt);
            }
        });

        jButton_select_BookId.setText("SELECT BOOK ");
        jButton_select_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_BookIdActionPerformed(evt);
            }
        });

        jButton_select_studentId.setText("SELECT STUDENT ");
        jButton_select_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_studentIdActionPerformed(evt);
            }
        });

        centerpanel_IssueBook.setLayout(new java.awt.BorderLayout());

        lbTitleIssueBook.setText("ISSUE BOOK");
        lbTitleIssueBook.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        centerpanel_IssueBook.add(lbTitleIssueBook, java.awt.BorderLayout.NORTH);

        txt_Date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Date1ActionPerformed(evt);
            }
        });

        lb_student.setText("Enter Sudent:");

        lbl_bookname.setText("Book Name");

        txt_StudentId.setEnabled(false);

        lbl_book.setText("Enter Book:");

        lb_studentName.setText("Student Full Name");

        jLabel1.setText("Student Details");

        lbl_image.setBackground(new java.awt.Color(204, 204, 204));
        lbl_image.setOpaque(true);

        lbl_fullName.setText("Full Name");

        lbl_id.setText("Student ID");

        lbl_level.setText("Grade Level");

        lbl_strand.setText("Strand");

        lbl_Gender.setText("Gender");

        lbl_bookimage.setBackground(new java.awt.Color(204, 204, 204));
        lbl_bookimage.setOpaque(true);

        jLabel2.setText("Book Details");

        lbl_isbn.setText("ISBN");

        lbl_Name.setText("Title");

        lbl_author.setText("Author");

        lbl_genre.setText("Genre");

        lbl_quantity.setText("Quantity");

        lbl_book1.setText("Issue Date:");

        txt_BookId.setEnabled(false);
        txt_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookIdActionPerformed(evt);
            }
        });

        lbl_book2.setText("Return Date:");

        txt_Date2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Date2ActionPerformed(evt);
            }
        });

        jButton_IssueBook.setText("ISSUE BOOK");
        jButton_IssueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IssueBookActionPerformed(evt);
            }
        });

        lbl_book3.setText("Note:");

        txt_note.setColumns(20);
        txt_note.setRows(5);
        jScrollPane1.setViewportView(txt_note);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(centerpanel_IssueBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_IssueBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(search_book)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(lbl_bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_isbn)
                                                    .addComponent(lbl_Name)
                                                    .addComponent(lbl_author)
                                                    .addComponent(lbl_genre)
                                                    .addComponent(lbl_quantity)))
                                            .addComponent(jLabel2)))
                                    .addComponent(scroll1)
                                    .addComponent(jButton_select_BookId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search_student, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_select_studentId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_fullName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_id)
                                            .addComponent(lbl_level)
                                            .addComponent(lbl_strand)
                                            .addComponent(lbl_Gender)
                                            .addComponent(jLabel1))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(lb_student)
                                .addGap(18, 18, 18))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(lbl_book)
                                .addGap(1, 1, 1)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_BookId)
                            .addComponent(txt_StudentId, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bookname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_studentName, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_book2)
                            .addComponent(lbl_book1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Date1)
                            .addComponent(txt_Date2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_book3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(centerpanel_IssueBook, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_book3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_book)
                                    .addComponent(lbl_bookname)
                                    .addComponent(txt_BookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_student)
                                    .addComponent(txt_StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_studentName)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_book1)
                                    .addComponent(txt_Date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_book2)
                                    .addComponent(txt_Date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_IssueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_fullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(9, 9, 9)
                                .addComponent(lbl_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_level)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_strand)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Gender))
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lbl_isbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_author)
                                .addGap(5, 5, 5)
                                .addComponent(lbl_genre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_quantity))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_select_BookId)
                    .addComponent(jButton_select_studentId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(scroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
  public static void displayStudentData(int id, String fullName)
    {
        lb_studentName.setText(fullName);
        txt_StudentId.setText(String.valueOf(id));
    }
  
  public static void displayBookData(int id, String _name)
    {
        lbl_bookname.setText(_name);
        txt_BookId.setText(String.valueOf(id));
    }


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
                func.displayImage(118, 108, image, "", lbl_image);

            } else {
                MessageAlerts.getInstance().showMessage("No Member  With This Information Is Found ", "Oops! Error has occured the student does not exist in the system", MessageAlerts.MessageType.ERROR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tbl_MembersMouseClicked

    private void search_bookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bookKeyReleased
        DefaultTableModel ob = (DefaultTableModel) tbl_Books.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tbl_Books.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(search_book.getText()));
    }//GEN-LAST:event_search_bookKeyReleased

    private void tbl_BooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BooksMouseClicked
// display the selected book data
        myclass.Book SelectedBook = null;

        try {

            Integer rowIndex = tbl_Books.getSelectedRow();
            Integer id = Integer.parseInt(tbl_Books.getModel().getValueAt(rowIndex, 0).toString());

            SelectedBook = book.getBookById(id);
            if (SelectedBook != null) {

                lbl_isbn.setText(SelectedBook.getIsbn());
                lbl_Name.setText(SelectedBook.getName());
                
                // we need to display the author name
                lbl_author.setText(author.getAuthorById(SelectedBook.getAuthor_id()).getFirstName() + " " +
                author.getAuthorById(SelectedBook.getAuthor_id()).getLastName()  );
                
                // we need to display the genre name
                lbl_genre.setText(genre.getGenreById(SelectedBook.getGenre_id()).getName());

                lbl_quantity.setText(String.valueOf(SelectedBook.getQuantity()));

                //display the book cover image
                byte[] image = SelectedBook.getCover();
                // dispalys the image using the imagebyte
                func.displayImage(118, 108, image, "", lbl_bookimage);

            } else {
                MessageAlerts.getInstance().showMessage("No Book With This Information Is Found ", "Oops! Error has occured the book does not exist in the system", MessageAlerts.MessageType.ERROR);
            }
        } catch (Exception ex) {
            Logger.getLogger(BookListForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_BooksMouseClicked

    private void search_studentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_studentKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search_studentKeyReleased

    private void jButton_select_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_studentIdActionPerformed
       //         display the selected student
         
       //         get the selected row index

        int index = tbl_Members.getSelectedRow();

        // get values
        int id = Integer.parseInt(tbl_Members.getValueAt(index, 0).toString());
        String firstName = tbl_Members.getValueAt(index, 1).toString();
        String lastName = tbl_Members.getValueAt(index, 2).toString();
        
        String full_name = firstName + " " + lastName; 
        
        //14:31 FormType
        
        IssueBookForm.displayStudentData(id, full_name);
    }//GEN-LAST:event_jButton_select_studentIdActionPerformed

    private void search_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_studentActionPerformed

    private void jButton_select_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_BookIdActionPerformed
         //         display the selected book
         
       //         get the selected row index

        int index = tbl_Books.getSelectedRow();

        // get values
        int id = Integer.parseInt(tbl_Books.getValueAt(index, 0).toString());
        String name = tbl_Books.getValueAt(index, 2).toString();
       
        
        IssueBookForm.displayBookData(id, name);
    }//GEN-LAST:event_jButton_select_BookIdActionPerformed

    private void txt_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIdActionPerformed

    private void txt_Date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Date1ActionPerformed

    private void txt_Date2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Date2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Date2ActionPerformed

    private void jButton_IssueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IssueBookActionPerformed
       // Retrieve the selected date from the Date Picker
        Date issueDate = datePicker1.getSelectedDate();
        Date dueDate = datePicker2.getSelectedDate();
        
        // Check if the return date comes after the issued date
        if (dueDate.before(issueDate)) {
        MessageAlerts.getInstance().showMessage("Invalid Input in Date Field", "Return date cannot be before issue date.", MessageAlerts.MessageType.ERROR);
        return;
    }
        // issue a book
if (lbl_quantity.getText().equals("0")) {
            MessageAlerts.getInstance().showMessage("Book Unavailable", "The selected book is currently out of stock.", MessageAlerts.MessageType.WARNING);
        } else {
            if (isAlreadyIssued() == false) {
                if (issueBook() == true) {
                    updateBookCount(); // call updateBookCount here 
                    MessageAlerts.getInstance().showMessage("Success", "The book has been issued successfully.", MessageAlerts.MessageType.SUCCESS);
                } else {
                    MessageAlerts.getInstance().showMessage("Issue Failed", "Unable to issue the book. Please try again.", MessageAlerts.MessageType.ERROR);
                }    
            } else {
                 MessageAlerts.getInstance().showMessage("Duplicate Issue", "This student has already issued this book.", MessageAlerts.MessageType.WARNING);
            }}
// refreshes
populateJTableWithBooks();

    }//GEN-LAST:event_jButton_IssueBookActionPerformed


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
    
    // create a function to populate the jtable with books
    public void populateJTableWithBooks(){
    
        ArrayList<myclass.Book> booksList = book.booksList();
        
        // wont display the BookcoverImage and description
        // jtable colummns
        String [] colNames = {"ID", "ISBN", "Title",  "Author", "Genre", "Quantity", "Publisher"};
        
        // row
        Object[][] rows = new Object[booksList.size()] [colNames.length];
        
        for(int i = 0; i < booksList.size(); i++){
        
            rows[i][0] = booksList.get(i).getId();
            rows[i][1] = booksList.get(i).getIsbn();
            rows[i][2] = booksList.get(i).getName();
            
            // Convert author_id to author name before adding to the table
            rows[i][3] = author.getAuthorById(booksList.get(i).getAuthor_id()).getFirstName() + " "
                    + author.getAuthorById(booksList.get(i).getAuthor_id()).getLastName();
            
            // Convert genre_id to genre name before adding to the table
            rows[i][4] = genre.getGenreById(booksList.get(i).getGenre_id()).getName();
            rows[i][5] = booksList.get(i).getQuantity();
            rows[i][6] = booksList.get(i).getPublisher();
        }

        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        tbl_Books.setModel(model);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerpanel_IssueBook;
    private com.raven.datechooser.DateChooser datePicker1;
    private com.raven.datechooser.DateChooser datePicker2;
    private javax.swing.JButton jButton_IssueBook;
    private javax.swing.JButton jButton_select_BookId;
    private javax.swing.JButton jButton_select_studentId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitleIssueBook;
    private javax.swing.JLabel lb_student;
    private static javax.swing.JLabel lb_studentName;
    private javax.swing.JLabel lbl_Gender;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_book;
    private javax.swing.JLabel lbl_book1;
    private javax.swing.JLabel lbl_book2;
    private javax.swing.JLabel lbl_book3;
    private javax.swing.JLabel lbl_bookimage;
    private static javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_fullName;
    private javax.swing.JLabel lbl_genre;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_isbn;
    private javax.swing.JLabel lbl_level;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_strand;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JTextField search_book;
    private javax.swing.JTextField search_student;
    private javax.swing.JTable tbl_Books;
    private javax.swing.JTable tbl_Members;
    private static javax.swing.JTextField txt_BookId;
    private static javax.swing.JTextField txt_Date1;
    private static javax.swing.JTextField txt_Date2;
    private static javax.swing.JTextField txt_StudentId;
    private javax.swing.JTextArea txt_note;
    // End of variables declaration//GEN-END:variables
}
