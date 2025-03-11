
package myclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.alerts.MessageAlerts;


public class Author {
    
    private int id;
    private String firstName, lastName, field_Of_Expertise, about;
    
    public Author(){}
    
    
    public Author(int _id, String f_name, String l_name, String _expertise, String _about){
    
        this.id = _id;
        this.firstName = f_name;
        this.lastName = l_name;
        this.field_Of_Expertise = _expertise;
        this.about = _about;
        
        
    }

    // SET GETTERS
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public String getAbout() {
        return about;
    }

    
    // SET SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
  //FUNCTIONS
    myclass.Func_Class func = new Func_Class();

   //funtion to populate an arrayList with authors 
   public ArrayList<Author> authorsList(){
   
       ArrayList<Author> aList = new ArrayList<>();
       
       try {
           ResultSet rs = func.getData("SELECT * FROM `author`");
           
           Author author;
           
           while (rs.next()) {
               author = new Author(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("expertise"),
                        rs.getString("about"));
               aList.add(author);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return aList;
   }
   
// create a function to get author by id
   public Author getAuthorById(Integer id)
   {
       ResultSet rs = func.getData("SELECT * FROM `author` where id = " +id);
           
           Author author = null;
           
        try {
            if (rs.next()) {
                author = new Author(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("expertise"),
                        rs.getString("about"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
           return author;
   }
   
} 