
package myclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.alerts.MessageAlerts;


public class Book {

    Func_Class func = new Func_Class();

    private Integer id;
    private String isbn;
    private String name;
    private Integer author_id;
    private Integer genre_id;
    private Integer quantity;
    private String publisher;
    private String description;
    private byte[] cover;

    public Book(){}
    


    public Book( Integer _id,String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, String _description, byte[] _cover) 
    {       

        this.id = _id;
        this.isbn = _isbn;
        this.name = _name;
        this.author_id = _author_id;
        this.genre_id = _genre_id;
        this.quantity = _quantity;
        this.publisher = _publisher;
        this.description = _description;
        this.cover = _cover;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    //GETTER
    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getCover() {
        return cover;
    }
    
    //SETTER
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
    
    
     // FUNCTIONS
    
    // insert a new book function
    public void addBook(String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, String _description, byte[] _cover){
    
        String insertQuery = "INSERT INTO `books`(`isbn`, `name`, `author_id`, `genre_id`, `quantity`, `publisher`, `description`, `cover_image`) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _isbn);
            ps.setString(2, _name);
            ps.setInt(3, _author_id);
            ps.setInt(4, _genre_id);
            ps.setInt(5, _quantity);
            ps.setString(6, _publisher);
            ps.setString(7, _description);
            ps.setBytes(8, _cover);
            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Book Added ", "Successfully added a new book into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
              MessageAlerts.getInstance().showMessage("Failed to Add Book ", "Oops! Error has occured could not add a new book into the system", MessageAlerts.MessageType.ERROR);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
          // edit the selected book info function
    public void editBook(int _id, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, String _description, byte[] _cover){
    
        String updateQuery = "";
        PreparedStatement ps;
        
        try {
            
        if (_cover != null) // if you want to update the book image
        {
        updateQuery = "UPDATE `books` SET `name`= ?,`author_id`=?,`genre_id`=?,`quantity`=?,`publisher`=?,`description`=?,`cover_image`=? WHERE `id` =?";
         
        ps = DBConnection.getConnection().prepareStatement(updateQuery);
        //ps.setString(1, _isbn);
            ps.setString(1, _name);
            ps.setInt(2, _author_id);
            ps.setInt(3, _genre_id);
            ps.setInt(4, _quantity);
            ps.setString(5, _publisher);
            ps.setString(6, _description);
            ps.setBytes(7, _cover);
            ps.setInt(8, _id);
        }
        else // if not 
        {
        updateQuery = "UPDATE `books` SET `name`= ?,`author_id`=?,`genre_id`=?,`quantity`=?,`publisher`=?,`description`=? WHERE `id` =?";
     
        ps = DBConnection.getConnection().prepareStatement(updateQuery);
        //ps.setString(1, _isbn);
            ps.setString(1, _name);
            ps.setInt(2, _author_id);
            ps.setInt(3, _genre_id);
            ps.setInt(4, _quantity);
            ps.setString(5, _publisher);
            ps.setString(6, _description);
//            ps.setBytes(7, _cover);
            ps.setInt(7, _id);
        }
        

            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Book Edited ", "Successfully edited the book into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
              MessageAlerts.getInstance().showMessage("Failed to Edit Book ", "Oops! Error has occured could not edit book into the system", MessageAlerts.MessageType.ERROR);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
      // remove book by id
    public void removeBook(int _id){
    
        String removeQuery = "DELETE FROM `books` WHERE `id` = ?";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Book Deleted", "Successfully deleted the book into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
               MessageAlerts.getInstance().showMessage("Failed to Delete Book", "Oops! Error has occured could not delete the book into the system", MessageAlerts.MessageType.ERROR);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    // create a funtion to check if the isbn already exists
    public boolean isISBNexists(String _isbn){
        
        // Remove surrounding spaces from the ISBN
        _isbn = _isbn.trim();

        // Fix the SQL query - remove the spaces around the value
        String query = "SELECT * FROM `books` WHERE `isbn` = '" + _isbn + "'";
        
        ResultSet rs = func.getData(query);
        try {
            return rs.next(); // Simply return whether we found a match
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Return false on error
        }
    }

    public Book searchBookbyId_Isbn(int _id, String _isbn)
    {
        // Remove surrounding spaces from the ISBN
        _isbn = _isbn.trim();
        String query = "SELECT * FROM `books` WHERE `id` = " +_id+ " or `isbn` = '"+_isbn+"'";

        ResultSet rs = func.getData(query);
        Book book = null;
        try {
            if(rs.next()){
            book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                    rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBytes(9));
        }else{
            return book;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
        return book;
    }
    
     //get book by id
    public Book getBookById(Integer _id) throws SQLException
    {
      
        // query to get teh book by the id 
        String query = "SELECT * FROM `books` WHERE `id` = " + _id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next())
        {
            // return the book
            return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                    rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBytes(9));
        }
        else
        {
            // return null
            return null;
        }
    }    
    
    //funtion to populate an arrayList with books 
    public ArrayList<Book> booksList() {

        ArrayList<Book> bList = new ArrayList<>();

        myclass.Func_Class func = new Func_Class();

        try {
            ResultSet rs = func.getData("SELECT * FROM `books`");

            Book book;

            while (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                    rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBytes(9));
                bList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bList;
    }

}
