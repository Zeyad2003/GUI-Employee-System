
package finalproject;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class connection {
    private String user="root";
    private String pass="";
    private  String add="jdbc:mysql://localhost/sqljava";
    
    public Connection connect() throws SQLException{
        Connection r = DriverManager.getConnection(add,user , pass);
        return r;
    }
}