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
import javax.swing.JLabel;
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



public class BookListForm extends SimpleForm {
    myclass.Genre genre = new myclass.Genre();
    myclass.Book book = new myclass.Book();
    myclass.Author author = new myclass.Author();
    myclass.Func_Class func = new myclass.Func_Class();

    public BookListForm() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));



        // show table contents
       populateJTableWithBooks();

    }

    
    
    private void init() {
        JLabel[] labels = {lbl_isbn1, lbl_Name1, lbl_author1, lbl_genre1, lbl_publisher1, lbl_quantity1}; // Add all labels here
        for (JLabel label : labels) {
         label.setFont(new Font(FlatRobotoFont.FAMILY_SEMIBOLD, Font.PLAIN, 14)); // Replace 12 with your desired size
        }
        
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        tbl_Books.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold +2;");

        tbl_Books.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +20;");

        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");

          tbl_Books.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Books));
    
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
        lbl_bookimage.setBorder(JlabelImageBorder);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_Books = new javax.swing.JTable();
        lbTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        lbl_bookimage = new javax.swing.JLabel();
        lbl_isbn = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_publisher = new javax.swing.JLabel();
        lbl_genre = new javax.swing.JLabel();
        lbl_isbn1 = new javax.swing.JLabel();
        lbl_Name1 = new javax.swing.JLabel();
        lbl_author1 = new javax.swing.JLabel();
        lbl_genre1 = new javax.swing.JLabel();
        lbl_publisher1 = new javax.swing.JLabel();
        lbl_quantity1 = new javax.swing.JLabel();

        scroll.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

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
        scroll.setViewportView(tbl_Books);

        lbTitle.setText("Book List");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lbl_bookimage.setBackground(new java.awt.Color(204, 204, 204));
        lbl_bookimage.setOpaque(true);

        lbl_isbn.setText("ISBN");

        lbl_Name.setText("Title");

        lbl_quantity.setText("Quantity");

        lbl_author.setText("Author");

        lbl_publisher.setText("Publisher");

        lbl_genre.setText("Genre");

        lbl_isbn1.setText("ISBN:");

        lbl_Name1.setText("Title:");

        lbl_author1.setText("Author:");

        lbl_genre1.setText("Genre:");

        lbl_publisher1.setText("Publisher:");

        lbl_quantity1.setText("Quantity:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_isbn1)
                                    .addComponent(lbl_author1)
                                    .addComponent(lbl_Name1)
                                    .addComponent(lbl_genre1)
                                    .addComponent(lbl_publisher1)
                                    .addComponent(lbl_quantity1))
                                .addGap(30, 30, 30)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_publisher)
                                    .addComponent(lbl_genre)
                                    .addComponent(lbl_isbn)
                                    .addComponent(lbl_Name)
                                    .addComponent(lbl_author)
                                    .addComponent(lbl_quantity))))
                        .addGap(18, 18, 18)
                        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lbl_bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_isbn1)
                            .addComponent(lbl_isbn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Name1)
                            .addComponent(lbl_Name))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_author1)
                            .addComponent(lbl_author))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_genre1)
                            .addComponent(lbl_genre))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_publisher1)
                            .addComponent(lbl_publisher))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_quantity1)
                            .addComponent(lbl_quantity))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
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
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


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
                
                
                lbl_publisher.setText(SelectedBook.getPublisher());
                lbl_quantity.setText(String.valueOf(SelectedBook.getQuantity()));

                //display the book cover image
                byte[] image = SelectedBook.getCover();
                // dispalys the image using the imagebyte
                func.displayImage(222, 165, image, "", lbl_bookimage);

            } else {
                MessageAlerts.getInstance().showMessage("No Book With This Information Is Found ", "Oops! Error has occured the book does not exist in the system", MessageAlerts.MessageType.ERROR);
            }
        } catch (Exception ex) {
            Logger.getLogger(BookListForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tbl_BooksMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel ob = (DefaultTableModel) tbl_Books.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tbl_Books.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased


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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Name1;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_author1;
    private javax.swing.JLabel lbl_bookimage;
    private javax.swing.JLabel lbl_genre;
    private javax.swing.JLabel lbl_genre1;
    private javax.swing.JLabel lbl_isbn;
    private javax.swing.JLabel lbl_isbn1;
    private javax.swing.JLabel lbl_publisher;
    private javax.swing.JLabel lbl_publisher1;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_Books;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
