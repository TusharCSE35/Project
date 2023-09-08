
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class course {
    public void insertUpdateDelateStudent(char operation, Integer id, String label, Integer hours) {
        Connection con;
        PreparedStatement ps;
        
        
        if(operation=='i'){
            try {
                con = MyConnection.getConnection();
                ps = con.prepareStatement("INSERT INTO `course`(`label`, `hours_number`) VALUES (?,?)");
                ps.setString(1,label);
                ps.setInt(2,hours);
                
                if(ps.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, " New Cours Added ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        if(operation=='u'){
//            try {
//                con = MyConnection.getConnection();
//                ps = con.prepareStatement("UPDATE `student` SET `first_name`= ?, `last_name`= ?, `sex`=?, `birthdate`= ?, `phone`=?, `address`= ? WHERE `id`= ?");
//                ps.setString(1,fname);
//                ps.setString(2,lname);
//                ps.setString(3,sex); 
//                ps.setString(4,bdate);
//                ps.setString(5,phone);
//                ps.setString(6,address);
//                ps.setInt(7, id);
//                
//                if(ps.executeUpdate()>0){
//                    JOptionPane.showMessageDialog(null, "Student Data Updated");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        //delate
//         if(operation=='d'){
//            try {
//                con = MyConnection.getConnection();
//                ps = con.prepareStatement("DELETE FROM `student` WHERE `id`= ?");
//                ps.setInt(1, id);
//                
//                if(ps.executeUpdate()>0){
//                    JOptionPane.showMessageDialog(null, "Student Data Delated");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
    
    public boolean isCourseExist(String courseName){
        boolean isExist = false;
        Connection con;
        PreparedStatement ps;
        try {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM `course` WHERE `label`= ?");
            ps.setString(1,courseName);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               isExist = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isExist;
    }
}
