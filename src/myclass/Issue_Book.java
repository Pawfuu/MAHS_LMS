
package myclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.alerts.MessageAlerts;


public class Issue_Book {
  
    private int book_id, member_id;
    private String status; // issued -returned - lost
    private String issue_date, return_date, note;

    Book book = new Book();
    
// add a new issue
    public void addIssue(int _book_id, int _member_id, String _status, String _issue_date, String _return_date, String note) 
    {
        String insertQuery = "INSERT INTO `issue_book`(`book_id`, `member_id`, `status`, `issue_date`, `return_date`, `note`) VALUES (?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(insertQuery);
            
            ps.setInt(1, _book_id);
            ps.setInt(2, _member_id);
            ps.setString(3, _status);
            ps.setString(4, _issue_date);
            ps.setString(5, _return_date);
            ps.setString(6, note);

            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Issue Added ", "Successfully issued the book into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
              MessageAlerts.getInstance().showMessage("Failed to Issue the Book ", "Oops! Error has occured could not issue the book into the system", MessageAlerts.MessageType.ERROR);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // checks if the book is available
    // get the book quantity from table books and compare it to the number of book issued in the able issue_book
    public boolean checkBookAvailability(int _book_id)
    {
        boolean availabilty = false;
        try {
            // first get the book quantity
            Book selectedBook = book.getBookById(_book_id);
            int quantity = selectedBook.getQuantity();
            
            // get the number of books issued (the same book)
            int issued_book_count = countData(_book_id);
            
            if(quantity > issued_book_count)
            {
                availabilty = true;
            } else{
                 availabilty = false;
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return availabilty;
    }
        // create a funtion to count the number of issued book
    public int countData(int _book_id)
    {
        int total = 0;
        ResultSet rs;
        PreparedStatement ps;

        try {
            ps = DBConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM `issue_book` WHERE `book_id` = ? and `status` = 'issued'");
        ps.setInt(1, book_id);
        rs = ps.executeQuery();
        if (rs.next()) {
            // Also fix this - the column name is not "total" but likely "COUNT(*)"
            total = rs.getInt(1); // Get the first column instead of by name
            }
        } catch (SQLException e) {
            Logger.getLogger(Issue_Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return total;
    }
}

