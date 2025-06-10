
import java.sql.*;

public class ConexionDB {
    private static Connection conn = null;

    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="marcos";
    private static final String pass="7856";
    private static final String url="jdbc:mysql://localhost:3307/mydb";

    private ConexionDB() {
        try{
            System.out.println("***CONNECTING TO THE DATABASE... THIS MAY TAKE A WHILE***\n");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("***CONNECTED***");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        if (conn == null){
            new ConexionDB();
        }

        return conn;
    }

    public static void closeConnection() {
        try{
            if (conn != null){
                System.out.println("\n***CLOSING CONNECTION***");
                conn.close();
            } else {
                System.out.println("\nERROR: ***NO CONNECTION HAS BEEN CREATED***");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
