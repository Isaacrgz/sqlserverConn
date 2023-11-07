package mx.com.jakartaEE.sms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionSQL {
                 //"jdbc:sqlserver://'servername';Database='databasename';properties..."
    private static final String URL = "jdbc:sqlserver://PC-ISAAC;Database=test0;IntegratedSecurity=true";
    Connection conn = null;
    
    public void getConnection() throws SQLException, ClassNotFoundException {
        
        String hostName = "localhost"; //Server name
        String sqlInstanceName = ""; //Server name
        String sqlDatabase = "";
        String sqlUser = "";
        String sqlPass = "";
        
        // El puerto se puede ver en Sql Server Configuration Manager
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String URLsum = "jdbc:sqlserver://" + hostName + ":port_hare" + ";instance=" + sqlInstanceName + 
                        ";databaseName=" + sqlDatabase;
        
        try {
            
            conn = DriverManager.getConnection(URL); 
            //conn = DriverManager.getConnection(URLsum, sqlUser, sqlPass); //Alternative
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
