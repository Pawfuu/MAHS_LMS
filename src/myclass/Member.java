
package myclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.alerts.MessageAlerts;


public class Member {
    
    private int id, level;
    private String firstName, lastName, strand, gender ;
    private byte[] picture;
    
    public Member(){}
    
    
    public Member(int _id, String f_name, String l_name, int _level, String _strand, String _gender, byte[] _picture){
    
        this.id = _id;
        this.firstName = f_name;
        this.lastName = l_name;
        this.level = _level;
        this.strand = _strand;
        this.gender = _gender;
        this.picture = _picture;
        
        
    }

    // GETTER
    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStrand() {
        return strand;
    }

    public String getGender() {
        return gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    // FUNCTIONS
    
    // insert a new member function
    public void addMember(String _fname, String _lname, int _level, String _strand, String _gender, byte[] _pic){
    
        String insertQuery = "INSERT INTO `members`(`firstName`, `lastName`, `level`, `strand`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setInt(3, _level);
            ps.setString(4, _strand);
            ps.setString(5, _gender);
            ps.setBytes(6, _pic);
            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Student Added ", "Successfully added a new student into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
              MessageAlerts.getInstance().showMessage("Failed to Add Student ", "Oops! Error has occured could not add a new student into the system", MessageAlerts.MessageType.ERROR);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    // insert a new member function
    public void editMember(Integer _id, String _fname, String _lname, int _level, String _strand, String _gender, byte[] _pic){
    
        String editQuery = "UPDATE `members` SET `firstName`=?, `lastName`=?, `level`=?, `strand`=?, `gender`=?, `picture`=? WHERE `id` =?";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setInt(3, _level);
            ps.setString(4, _strand);
            ps.setString(5, _gender);
            ps.setBytes(6, _pic);
            ps.setInt(7, _id);
            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Student Edited ", "Successfully edited student information into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
              MessageAlerts.getInstance().showMessage("Failed to Edit Student ", "Oops! Error has occured could not edit the student information into the system", MessageAlerts.MessageType.ERROR);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    // remove member by id
    public void removeMember(int _id){
    
        String removeQuery = "DELETE FROM `members` WHERE `id` = ?";
        
        try {
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0){
              MessageAlerts.getInstance().showMessage("Student Deleted", "Successfully deleted the student into the system", MessageAlerts.MessageType.SUCCESS);
            }else{
               MessageAlerts.getInstance().showMessage("Failed to Delete Student", "Oops! Error has occured could not delete the student into the system", MessageAlerts.MessageType.ERROR);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    //get member by id
    public Member getMemberById(Integer _id) throws SQLException
    {
        Func_Class func = new Func_Class();
        
        String query = "SELECT * FROM `members` WHERE `id` = " + _id;
        
        ResultSet rs = func.getData(query);
        
        if(rs.next())
        {
            return new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6), rs.getBytes(7));
        }
        else
        {
            return null;
        }
    }      
        //funtion to populate an arrayList with authors 
    public ArrayList<Member> membersList() {

        ArrayList<Member> mList = new ArrayList<>();

        myclass.Func_Class func = new Func_Class();

        try {
            ResultSet rs = func.getData("SELECT * FROM `members`");

            Member member;

            while (rs.next()) {
                member = new Member(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("level"),
                        rs.getString("strand"),
                        rs.getString("gender"),
                        rs.getBytes("picture")
                );
                mList.add(member);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mList;
    }

}
