package raven.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import myclass.DBConnection;
import myclass.Member;
import myclass.TableHeaderAlignment;
import raven.alerts.MessageAlerts;
import raven.components.SimpleForm;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;



public class BookForm extends SimpleForm {
    
    myclass.Func_Class func = new myclass.Func_Class();
    myclass.Book book = new myclass.Book();
    myclass.Author author = new myclass.Author();
    myclass.Member member = new myclass.Member();
    myclass.Genre genre = new myclass.Genre();
    HashMap<String, Integer> genresMap = genre.getGenresMap();
    
    String imagePath = "";
    
    public BookForm() {
        initComponents();
        init();
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));



        // show table contents
       populateJTableWithMembers();

    }
    
  
    
    private void init() {
     
        JLabel[] labels = {lbl_isbn, lbl_author, lbl_bookcover, lbl_bookimage, lbl_description, lbl_genre, lbl_name, lbl_publisher, lbl_quantity}; // Add all labels here
        for (JLabel label : labels) {
         label.setFont(new Font(FlatRobotoFont.FAMILY_SEMIBOLD, Font.PLAIN, 14)); // Replace 12 with your desired size
        }

        // Create a panel with FlowLayout for the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(lbTitle);
        titlePanel.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Table.background");

// Add the panel to the north position
        centerpanel.add(titlePanel, BorderLayout.NORTH);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +30;");

        jScrollPane.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:20;");

        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +10");
        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +1");

        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");

        Border JlabelImageBorder = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(22, 36, 86));
        lbl_bookimage.setBorder(JlabelImageBorder);

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
        
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
            + "trackArc:999;"
            + "trackInsets:3,3,3,3;"
            + "thumbInsets:3,3,3,3;"
            + "background:$Table.background;");
        

          tbl_Authors.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(tbl_Authors));
          
          // show author table
          populateJTableWithAuthors();
          
          // populate jcombox with genres
         fillComboboxWithGenre();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbl_bookimage = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_isbn = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_genre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        txt_ISBN = new javax.swing.JTextField();
        txt_publisher = new javax.swing.JTextField();
        combo_Genre = new javax.swing.JComboBox<>();
        lbl_name = new javax.swing.JLabel();
        txt_Author = new javax.swing.JTextField();
        lbl_publisher = new javax.swing.JLabel();
        lbl_bookcover = new javax.swing.JLabel();
        centerpanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        txt_description = new javax.swing.JTextArea();
        lbl_description = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtspinner_quantity = new javax.swing.JSpinner();
        jButton_SelectProfilePicture = new javax.swing.JButton();
        jButton_Add_ = new javax.swing.JButton();
        jButton_Edit_ = new javax.swing.JButton();
        jButton_Delete_ = new javax.swing.JButton();
        lbl_ImagePath = new javax.swing.JLabel();
        jButton_select_author = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tbl_Authors = new javax.swing.JTable();
        lbl_Author_ID = new javax.swing.JLabel();
        lbl_Genre_ID = new javax.swing.JLabel();
        jButton_Clear_ = new javax.swing.JButton();
        lbl_isbn1 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jButton_Search_ID_ISBN_ = new javax.swing.JButton();

        lbl_bookimage.setBackground(new java.awt.Color(204, 204, 204));
        lbl_bookimage.setOpaque(true);

        lbl_quantity.setText("Quantity:");

        lbl_isbn.setText("ISBN:");

        lbl_author.setText("Author:");

        lbl_genre.setText("Genre:");

        jLabel1.setText("Book Details");

        jLabel2.setText("Insert Student Details");

        combo_Genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_GenreActionPerformed(evt);
            }
        });

        lbl_name.setText("Name:");

        txt_Author.setEnabled(false);
        txt_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AuthorActionPerformed(evt);
            }
        });

        lbl_publisher.setText("Publisher:");

        lbl_bookcover.setText("Book Cover:");

        centerpanel.setLayout(new java.awt.BorderLayout());

        lbTitle.setText("BOOK MANAGEMENT");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        centerpanel.add(lbTitle, java.awt.BorderLayout.NORTH);

        txt_description.setColumns(20);
        txt_description.setRows(5);
        jScrollPane.setViewportView(txt_description);

        lbl_description.setText("Book Description:");

        jButton_SelectProfilePicture.setText("Select Profile");
        jButton_SelectProfilePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelectProfilePictureActionPerformed(evt);
            }
        });

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

        lbl_ImagePath.setForeground(new java.awt.Color(22, 36, 86));
        lbl_ImagePath.setText("choose profile picture....");

        jButton_select_author.setText("select author");
        jButton_select_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_authorActionPerformed(evt);
            }
        });

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

        lbl_Author_ID.setText("ID");

        lbl_Genre_ID.setText("ID");

        jButton_Clear_.setText("Clear");
        jButton_Clear_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Clear_ActionPerformed(evt);
            }
        });

        lbl_isbn1.setText("ID:");

        jButton_Search_ID_ISBN_.setText("Search by ID or ISBN");
        jButton_Search_ID_ISBN_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Search_ID_ISBN_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(centerpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 12, Short.MAX_VALUE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jButton_Add_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton_Edit_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton_Delete_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jButton_Clear_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lbl_publisher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lbl_name)
                                                            .addComponent(lbl_isbn)
                                                            .addComponent(lbl_isbn1)
                                                            .addComponent(lbl_author)
                                                            .addComponent(lbl_genre)
                                                            .addComponent(lbl_quantity))))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_Author)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_ISBN)
                                                            .addComponent(txt_ID))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton_Search_ID_ISBN_))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                        .addComponent(combo_Genre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lbl_Genre_ID)
                                                        .addGap(94, 94, 94))
                                                    .addComponent(txt_Name)
                                                    .addGroup(panelLayout.createSequentialGroup()
                                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtspinner_quantity, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_publisher, javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addGap(93, 93, 93)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(lbl_Author_ID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                            .addComponent(jButton_select_author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(lbl_bookcover)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_ImagePath))
                                            .addComponent(jButton_SelectProfilePicture, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(lbl_bookimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(227, 227, 227))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(lbl_description)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane))))
                        .addContainerGap())))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(centerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(txt_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(jButton_Search_ID_ISBN_, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_name)
                                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lbl_description)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_author)
                                    .addComponent(lbl_Author_ID)
                                    .addComponent(jButton_select_author))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(combo_Genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_genre)
                                            .addComponent(lbl_Genre_ID))
                                        .addGap(17, 17, 17)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtspinner_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_quantity))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_publisher))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Clear_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton_Edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_Add_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_Delete_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(11, 11, 11))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_bookcover)
                                    .addComponent(lbl_ImagePath))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_SelectProfilePicture)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_bookimage, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_isbn1)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_isbn)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void txt_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorActionPerformed

    private void jButton_SelectProfilePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelectProfilePictureActionPerformed
       
       // select the picture from the image computer
            String path = func.selectImage();
            lbl_ImagePath.setText(path);
        
            
            //display the image on size
            func.displayImage(250, 250, null, path, lbl_bookimage);
        
            imagePath = path;
    }//GEN-LAST:event_jButton_SelectProfilePictureActionPerformed

    private void jButton_Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ActionPerformed

        // add a new book
        myclass.Book book = new myclass.Book();
        String isbn = txt_ISBN.getText();

        if (!verif()) {
            MessageAlerts.getInstance().showMessage("Missing Required Information", "Please fill in all the required book details before proceeding.", MessageAlerts.MessageType.WARNING);
        } else if (book.isISBNexists(isbn)) {
            MessageAlerts.getInstance().showMessage("A book with this ISBN already exists", "A book with this ISBN is already registered in the system", MessageAlerts.MessageType.ERROR);
        } else {

            // get the image bytes
            try {
                // get values
                String name = txt_Name.getText();
                String publisher = txt_publisher.getText();
                String description = txt_description.getText();

                Integer author_id = Integer.parseInt(lbl_Author_ID.getText());
                Integer genre_id = Integer.parseInt(lbl_Genre_ID.getText());
                Integer quantity = Integer.parseInt(txtspinner_quantity.getValue().toString());

                Path path = Paths.get(imagePath);
                byte[] img = Files.readAllBytes(path);
                book.addBook(isbn, name, author_id, genre_id, quantity, publisher, description, img);
            } catch (IOException ex) {
                MessageAlerts.getInstance().showMessage("Cover Image Missing", "Please select and add a cover image before proceeding.", MessageAlerts.MessageType.WARNING);
            } catch (NumberFormatException ex) {
                MessageAlerts.getInstance().showMessage("Invalid Input in Number Field", "Please enter a valid numeric value.", MessageAlerts.MessageType.ERROR);
            }
        }


    }//GEN-LAST:event_jButton_Add_ActionPerformed

    private void jButton_Edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_ActionPerformed
// edit the selected book
// we will not edit the isbn
      myclass.Book book = new myclass.Book();
        String isbn = txt_ISBN.getText();

        if (!verif()) {
            MessageAlerts.getInstance().showMessage("Missing Required Information", "Please fill in all the required book details before proceeding.", MessageAlerts.MessageType.WARNING);
            /*
            we will not check if the isbn already exist, since you wont be able to edit it 
        } else if (book.isISBNexists(isbn)) {
            MessageAlerts.getInstance().showMessage("A book with this ISBN already exists", "A book with this ISBN is already registered in the system", MessageAlerts.MessageType.ERROR);*/
        } else {

            // get the image bytes
            try {
                // get values
                int id = Integer.parseInt(txt_ID.getText());
                String name = txt_Name.getText();
                String publisher = txt_publisher.getText();
                String description = txt_description.getText();

                Integer author_id = Integer.parseInt(lbl_Author_ID.getText());
                Integer genre_id = Integer.parseInt(lbl_Genre_ID.getText());
                Integer quantity = Integer.parseInt(txtspinner_quantity.getValue().toString());
                Path path = Paths.get(imagePath);
                
                // get the image bytes 
                try {
                    // if the admin want to update the comver image 
                    byte[] img = Files.readAllBytes(path);
                    book.editBook(id, name, author_id, genre_id, quantity, publisher, description, img);
                } catch (IOException e) { // if not
                    book.editBook(id, name, author_id, genre_id, quantity, publisher, description, null);
                }
            }  catch (NumberFormatException ex) {
                MessageAlerts.getInstance().showMessage("Invalid Input in Number Field", "Please enter a valid numeric value.", MessageAlerts.MessageType.ERROR);
            }
        }

    }//GEN-LAST:event_jButton_Edit_ActionPerformed

    private void jButton_Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete_ActionPerformed
//        //delete the selected book
        
myclass.Book book = new myclass.Book();
 Integer id = Integer.parseInt(txt_ID.getText());
        try {
             //show a confimation message before delete
            MessageAlerts.getInstance().showMessage("Are You Sure You Want To Delete This Book?", "Careful! Are you sure you want to delete this book? This action cannot be undone.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                @Override
                public void action(PopupController pc, int i) {
                    if (i == MessageAlerts.YES_NO_OPTION) {
                        book.removeBook(id);
                    } else {
                           System.out.println("Cancel");
                    }
                }
            });
            
        } catch (Exception e) {
            MessageAlerts.getInstance().showMessage("Deletion Error", "", MessageAlerts.MessageType.ERROR);
        }

    }//GEN-LAST:event_jButton_Delete_ActionPerformed

    private void jButton_select_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_authorActionPerformed
   
        
//         display the selected author
         
//         get the selected row index

        int index = tbl_Authors.getSelectedRow();

        // get values
        int id = Integer.parseInt(tbl_Authors.getValueAt(index, 0).toString());
        String firstName = tbl_Authors.getValueAt(index, 1).toString();
        String lastName = tbl_Authors.getValueAt(index, 2).toString();
        
        String full_name = firstName + " " + lastName; 
        
        //14:31 FormType
        
        BookForm.displayAuthorData(id, full_name);
        
        
    }//GEN-LAST:event_jButton_select_authorActionPerformed

    private void tbl_AuthorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AuthorsMouseClicked
// get the selected row index
        int index = tbl_Authors.getSelectedRow();

        // get values
        String id = tbl_Authors.getValueAt(index, 0).toString();
        String firstName = tbl_Authors.getValueAt(index, 1).toString();
        String lastName = tbl_Authors.getValueAt(index, 2).toString();
    }//GEN-LAST:event_tbl_AuthorsMouseClicked

    private void combo_GenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_GenreActionPerformed
        // display the selected genre id 
        // if the combo box is empty and error will be thrown, so to avoid use try and catch
        try {
            int genreId = genresMap.get(combo_Genre.getSelectedItem().toString());
            lbl_Genre_ID.setText(String.valueOf(genreId));
        } catch (Exception e) {
            System.out.println("Error From JcomboBoxGenre" + e.getMessage());
        }

    }//GEN-LAST:event_combo_GenreActionPerformed

    private void jButton_Clear_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Clear_ActionPerformed
        txt_ID.setText("");
        txt_ISBN.setText("");
        txt_Author.setText("");
        lbl_Author_ID.setText("ID");
        txt_Name.setText("");
        txt_description.setText("");
        txt_publisher.setText("");
        txtspinner_quantity.setValue(0);
        combo_Genre.setSelectedIndex(0);
        
        lbl_bookimage.setIcon(null);
        lbl_ImagePath.setText("picture path........");
    }//GEN-LAST:event_jButton_Clear_ActionPerformed

    private void jButton_Search_ID_ISBN_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Search_ID_ISBN_ActionPerformed
        // Search book by ID or ISBN

        if (txt_ID.getText().equals("") && txt_ISBN.getText().equals("")) {
            MessageAlerts.getInstance().showMessage("Missing Input", "Please enter either ID or ISBN to proceed with the search.", MessageAlerts.MessageType.WARNING);
        } else {

            try {
                int id = 0;
                String isbn = txt_ISBN.getText();
                myclass.Book selectedBook = null;
                try {
                    id = Integer.parseInt(txt_ID.getText());
                    selectedBook = book.searchBookbyId_Isbn(id, isbn);
                }
                catch (Exception e) {
                    selectedBook = book.searchBookbyId_Isbn(id, isbn);
                }

                txt_ID.setText(String.valueOf(selectedBook.getId()));
                txt_ISBN.setText(selectedBook.getIsbn());
                txt_Name.setText(selectedBook.getName());
                txt_publisher.setText(selectedBook.getPublisher());
                txt_description.setText(selectedBook.getDescription());
                txtspinner_quantity.setValue(selectedBook.getQuantity());
                lbl_Author_ID.setText(String.valueOf(selectedBook.getAuthor_id()));
                lbl_Genre_ID.setText(String.valueOf(selectedBook.getGenre_id()));
                
                // display the author full name
                String fullName = (author.getAuthorById(selectedBook.getAuthor_id())).getFirstName() + " " +
                            (author.getAuthorById(selectedBook.getAuthor_id())).getLastName();
                txt_Author.setText(fullName);
                
                // display the genre in the combobox
                for(Map.Entry<String, Integer> entry : genresMap.entrySet())
                {
                    if(Objects.equals(selectedBook.getGenre_id(), entry.getValue()))
                    {
                        combo_Genre.setSelectedItem(entry.getKey());
                        System.out.println(entry.getKey());
                    }
                }
                
                
                //display the member image
                byte[] image =selectedBook.getCover();
                // dispalys the image using the imagebyte
                func.displayImage(215, 245, image, "", lbl_bookimage);
                
            } catch (Exception e) {
                MessageAlerts.getInstance().showMessage("This Book Does Not Exist", "Book not found", MessageAlerts.MessageType.ERROR);
            }

        }


    }//GEN-LAST:event_jButton_Search_ID_ISBN_ActionPerformed

    public static void displayAuthorData(int id, String fullName)
    {
        txt_Author.setText(fullName);
        lbl_Author_ID.setText(String.valueOf(id));
    }

    // create a function to verify  the required fields
    public boolean verif() {

        if (txt_ISBN.getText().equals("") || txt_Author.getText().equals("")
                || txt_Name.getText().equals("") || lbl_Genre_ID.getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }

   // create a function to populate the jtable with members
    public void populateJTableWithMembers(){
    
        
    } 
    
    // display a function to populate the jcombobox with the genre name and id using hashmap
    public void fillComboboxWithGenre(){
     for (String genreName : genresMap.keySet())
     {
         combo_Genre.addItem(genreName);
     }
    }
    
    
    // create a function to populate the jtable with authors
    public void populateJTableWithAuthors(){
    
        ArrayList<myclass.Author> authorsList = author.authorsList();
        
        // jtable colummns
        String [] colNames = {"ID", "First Name",  "Last Name"};
        
        // row
        Object[][] rows = new Object[authorsList.size()] [colNames.length];
        
        for(int i = 0; i < authorsList.size(); i++){
        
            rows[i] [0] = authorsList.get(i).getId();
            rows[i] [1] = authorsList.get(i).getFirstName();
            rows[i] [2] = authorsList.get(i).getLastName();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        tbl_Authors.setModel(model);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerpanel;
    private javax.swing.JComboBox<String> combo_Genre;
    private javax.swing.JButton jButton_Add_;
    private javax.swing.JButton jButton_Clear_;
    private javax.swing.JButton jButton_Delete_;
    private javax.swing.JButton jButton_Edit_;
    private javax.swing.JButton jButton_Search_ID_ISBN_;
    private javax.swing.JButton jButton_SelectProfilePicture;
    private javax.swing.JButton jButton_select_author;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private static javax.swing.JLabel lbl_Author_ID;
    private javax.swing.JLabel lbl_Genre_ID;
    private javax.swing.JLabel lbl_ImagePath;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookcover;
    private javax.swing.JLabel lbl_bookimage;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_genre;
    private javax.swing.JLabel lbl_isbn;
    private javax.swing.JLabel lbl_isbn1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_publisher;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_Authors;
    private static javax.swing.JTextField txt_Author;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_ISBN;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextArea txt_description;
    private javax.swing.JTextField txt_publisher;
    private javax.swing.JSpinner txtspinner_quantity;
    // End of variables declaration//GEN-END:variables
}
