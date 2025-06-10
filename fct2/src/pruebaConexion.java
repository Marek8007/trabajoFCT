
import java.sql.*;

public class pruebaConexion {
    public static void main(String[] args) {

        Connection conn = ConexionDB.getConnection();
        ConexionDB.closeConnection();
    }

}
