package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TogetData {
     Connection c; // connection to the database
     Statement s;
     String query;
     ResultSet r;

     data getData(int ID) {
        connection c1 = new connection();
        try {
            c = c1.connect(); // connect to database and get connection object c
            s = c.createStatement(); //create statement object to execute query with database
            String f = Integer.toString(ID); // convert ID to string
            query = "select * from employees where ID = " + f; // query to get data from database
            r = s.executeQuery(query); // execute the query by sending it to the database
            r.next(); // move to the next row of the result set object r and get the data from the row in the form of a result set object r
            data u1= new data (r.getString("Name"),r.getString("ID"),r.getString("Password"),r.getString("National_ID"),r.getString("Phone"),
            r.getNString("gender"),r.getString("Address"),r.getString("DateOfBirth"),r.getString("Position"),r.getString("Salary"),r.getString("Bonus"));
            //object from class data that re
            return u1;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}


