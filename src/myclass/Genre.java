
package myclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.alerts.MessageAlerts;


public class Genre {
    
    private int id;
    private String name;
    
    // constractors
    public Genre(){
    }
   
    //getters
    public Genre(int _id, String _name)
    {
        this.id = _id;
        this.name = _name;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    
    // setters
    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return name;
    }
    
    //FUNCTIONS
     myclass.Func_Class func = new Func_Class();

   //funtion to populate an arrayList with genres
   public ArrayList<Genre> genreList(){
   
       ArrayList<Genre> gList = new ArrayList<>();

       try {
          ResultSet rs = func.getData("SELECT * FROM `book_genres`");
           
           Genre genre;
           
           while(rs.next()){
               genre = new Genre(rs.getInt("id"), rs.getString("genre_name"));
               gList.add(genre);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return gList;
   }
   
   // CREATE A FUNTION TO RETURN A HASHMAP
   // STRING IS THE KEY
   // INTEGERER IS THE VALUE
   
   public HashMap<String, Integer> getGenresMap()
   {
       HashMap<String, Integer> map = new HashMap<>();
    
      try {
          ResultSet rs = func.getData("SELECT * FROM `book_genres`");
           
           Genre genre;
           
           while(rs.next())
           {
               genre = new Genre(rs.getInt("id"), rs.getString("genre_name"));
               map.put(genre.getName(), genre.getId());
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
       }
    return map;
   }
   
    //create a function to get genre by id
    public Genre getGenreById(Integer id) 
    {
      
         ResultSet rs = func.getData("SELECT * FROM `book_genres` where id = " +id);
           
           Genre genre = null;
           
        try {
            if (rs.next()) {
                genre = new Genre(rs.getInt("id"), rs.getString("genre_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
           return genre;
   }
}
