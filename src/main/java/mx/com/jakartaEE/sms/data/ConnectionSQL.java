package mx.com.jakartaEE.sms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionSQL {
                 //"jdbc:sqlserver://'servername';Database='databasename';properties..."
    String URL = "jdbc:sqlserver://PC-ISAAC;Database=test0;IntegratedSecurity=true";
    Connection conn = null;
    
    public void getConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(URL); 
            System.out.println("Connection established");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM person";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Id: " + rs.getString("id_person"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace(System.out);
        } finally {
            conn.close();
        }
    }
    
}
