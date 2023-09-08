
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    public static Connection getConnection() throws SQLException{
       Connection con = null;
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb","root","");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }   
}
