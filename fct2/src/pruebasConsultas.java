
import java.sql.*;

public class pruebasConsultas {
    public static void main(String[] args) {
        try {
            Connection conn = ConexionDB.getConnection();
            PreparedStatement statement;
            String sql;
            ResultSet rs;
            /*
             * Consulta 1. Todas las incidencias, ordenadas por fecha de entrada
             */
            sql =   """
                    SELECT FEntrada, idClinica, estado, numContacto
                    FROM incidencias
                    ORDER BY FEntrada;
                    """;

            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();


            while (rs.next()) {
                System.out.printf("%s - %d - %s - %d\n",rs.getDate(1),rs.getInt(2),rs.getString(3), rs.getInt(4));
            }

            System.out.println("\n\n\n\n\n\n");

            /*
             * Consulta 2. Todas las incidencias ABIERTAS, ordenadas por fecha de entrada
             */
            sql =   """
                    SELECT FEntrada, idClinica, estado, numContacto
                    FROM incidencias
                    WHERE estado = 'Abierta'
                    ORDER BY FEntrada;
                    """;

            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();


            while (rs.next()) {
                System.out.printf("%s - %d - %s - %d\n",rs.getDate(1),rs.getInt(2),rs.getString(3), rs.getInt(4));
            }

            System.out.println("\n\n\n\n\n\n");

            /*
             * Consulta 3. Información de las incidencias que ha resuelto el trabajador con id 2 y en la que ha colaborado el estudiante de prácticas 5
             */
            sql =   """
                    SELECT INC.FEntrada, INC.FCierre, INC.descIncidencia, ASI.idAsistente, COL.idTrabajador
                    FROM incidencias INC, asistencias ASI, colaboraciones COL
                    WHERE INC.estado = 'Cerrada'
                    AND ASI.idIncidencia = INC.idIncidencia
                    AND ASI.idClinica = INC.idClinica
                    AND ASI.idAsistente = 2
                    AND COL.idIncidencia = INC.idIncidencia
                    AND COL.idClinica = INC.idClinica
                    AND COL.idTrabajador = 5
                    ORDER BY INC.FEntrada;
                    """;

            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();


            while (rs.next()) {
                System.out.printf("%s - %s - %s - %d - %d\n",rs.getDate(1),rs.getDate(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
            }



        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
    }

}
