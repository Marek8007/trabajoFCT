import java.sql.*;
import java.util.Scanner;

public class CargaInicial {
    public static void main(String[] args) {

        try {
            /*
             * CREAR CONEXIÓN
             */
            Connection conn = ConexionDB.getConnection();


            /*
             * CREAR OBJETO STATEMENT EJECUTABLE
             */
            PreparedStatement insert;
            String comandoSQL;

            Scanner sc = new Scanner(System.in);
            System.out.print("Deseas borrar todos los datos actuales de la base de datos? (FORZAR REINICIO) s/N: \n>>");
            String borrar = sc.nextLine();
            if (borrar.matches("s|S|si|SI|Si|sI")) {

                String[] tablas = {
                        "colaboraciones",
                        "asistencias",
                        "tiempo_completo",
                        "Practicas",
                        "correos",
                        "telefonos",
                        "morosos",
                        "servicios",
                        "codigos_supremos",
                        "incidencias",
                        "Trabajadores",
                        "centros",
                        "Clinicas"
                };

                Statement stmt = conn.createStatement();
                stmt.execute("SET FOREIGN_KEY_CHECKS=0");


                for (String tabla : tablas) {
                    stmt.executeUpdate("DELETE FROM " + tabla);
                    System.out.println("Tabla vaciada: " + tabla);
                }

                stmt.execute("SET FOREIGN_KEY_CHECKS=1");
                System.out.println("TODO BORRADO");

            }


            System.out.println("****** TABLAS TRABAJADORES ******");

            /////////////////////////////////////////////////////////
            //          INSERTS INFORMACIÓN TRABAJADORES           //
///////////////////////////////////////////////////////////////////////////////////////////////////////////
            /*                                                                                           //
             * INSERT TABLA Trabajadores                                                                 //
             */                                                                                          //
            comandoSQL = """                                                                             
                    INSERT INTO Trabajadores
                        (idTrabajadores, Nombre, Apellido, Edad)
                    VALUES
                        (1, 'Miquel', 'Gonzalez', 26),
                        (2, 'Pablo', 'Hernandez', 27),
                        (3, 'Paco', 'Hierro', 46),
                        (4, 'Javier', 'Manchado', 55),
                        (5, 'Marcos', 'Miquel', 18),
                        (6, 'Daniel', 'Negrete', 19);
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla trabajadores insertada");

            /*
             * INSERT TABLA tiempo_completo
             */
            comandoSQL = """
                    INSERT INTO tiempo_completo
                        (idTrabajador, Sueldo)
                    VALUES
                        (1, 1600),
                        (2, 1600),
                        (3, 2100),
                        (4, 2300);
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla tiempo_completo insertada");


            /*
             * INSERT TABLA centros
             */
            comandoSQL= """
                    INSERT INTO centros
                        (idCentro, nomCentro)
                    VALUES
                        (1, 'IES ABASTOS');
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla centros insertada");


            /*
             * INSERT TABLA Practicas
             */
            comandoSQL = """
                    INSERT INTO Practicas
                        (idTrabajador, comienzaPracticas, terminaPracticas, idCentro)
                    VALUES
                        (5, '2024/03/13', '2024/05/26', 1),
                        (6, '2024/03/13', '2025/06/11', 1);
                    """;
            insert = conn.prepareStatement(comandoSQL);                                                  //
            insert.executeUpdate();                                                                      //
            System.out.println("Tabla practicas insertada");                                             //
///////////////////////////////////////////////////////////////////////////////////////////////////////////


            System.out.println("****** TABLAS CLINCAS ******");

            /////////////////////////////////////////////////////////
            //             INSERTS INFORMACIÓN CLÍNICAS            //
///////////////////////////////////////////////////////////////////////////////////////////////////////////
            /*                                                                                           //
             * INSERT TABLA Clinicas                                                                     //
             */                                                                                          //
            comandoSQL= """
                    INSERT INTO Clinicas
                        (idClinica, NombreClinica, Ubicacion, informacion)
                    VALUES
                        (1, 'Clinica Blanc', 'C/ficticia 17', 'La señora es maja'),
                        (2, 'Clinica CariesGone', 'C/dentaduras 2', ''),
                        (3, 'Clinica PainLess', 'C/huerto 3', 'Tienen la instalacion de radio a medio hacer'),
                        (4, 'Clinica Dgs', 'C/megadan 12', '13 meses de retraso en los pagos. *MOROSOS*'),
                        (5, 'Clinica Gutierrez', 'C/jannah 18', 'Cita pendiente instalar radio');
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla Clinicas insertada");                                          //


            /*
             * INSERT TABLE morosos
             */
            comandoSQL = """
                    INSERT INTO morosos
                        (idClinica, deuda)
                    VALUES
                        (4, 21000);
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla morosos insertada");                                          //


            /*
             * INSERT TABLE telefonos
             */
            comandoSQL = """
                    INSERT INTO telefonos
                        (idClinica, telefono)
                    VALUES
                        (1, 123456789),
                        (2, 561258292),
                        (3, 918273654),
                        (3, 142536475),
                        (4, 019282736),
                        (5, 928471294),
                        (5, 123897341),
                        (5, 091274784);
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla telefonos insertada");                                          //

            /*
             * INSERT TABLE correos
             */
            comandoSQL = """
                    INSERT INTO correos
                        (idClinica, correo)
                    VALUES
                        (1, 'clinicaBlanc@gmail.com'),
                        (1, 'blanc@gmail.com'),
                        (2, 'cariesgone@gmail.com'),
                        (3, 'painlessClinicas@gmail.com'),
                        (4, 'dgsclinicadental@gmail.com'),
                        (5, 'clinicagutierrez@gmail.com');
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla correos insertada");                                          //

            /*
             * INSERT TABLE codigos_supremo
             */
            comandoSQL = """
                    INSERT INTO codigos_supremos
                        (idClinica, codigoSupremo)
                    VALUES
                        (1, 12345678),
                        (2, 98765432),
                        (2, 11223344),
                        (3, 55550000),
                        (3, 66669999),
                        (3, 10102020),
                        (4, 24681357),
                        (5, 71829304),
                        (5, 09182736),
                        (5, 63542198),
                        (5, 87654321);
                    """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla codigos_supremo insertada");                                          //

            /*
             * INSERT TABLE servicios
             */
            comandoSQL = """
                    INSERT INTO servicios
                        (idClinica, suscripcion, firmaDigitalBiometrica, conexionRadioDigital, espacioIlimitado)
                    VALUES
                        (1, 'Plan normal', 0, 1, 0),
                        (2, 'Plan normal', 1, 1, 0),
                        (3, 'Plan premium', 1, 1, 1),
                        (4, 'Plan normal', 0, 0, 1),
                        (5, 'Plan gratuito', 0, 0, 0);
                    """;
            insert = conn.prepareStatement(comandoSQL);                                                  //
            insert.executeUpdate();                                                                      //
            System.out.println("Tabla serivcios insertada");                                             //
///////////////////////////////////////////////////////////////////////////////////////////////////////////


            System.out.println("****** TABLAS INCIDENCIAS ******");

            ///////////////////////////////////////////////////////
            //          INSERTS INFORMACIÓN INCIDENCIAS          //
///////////////////////////////////////////////////////////////////////////////////////////////////////////
            /*                                                                                           //
             * INSERT TABLA incidencias                                                                  //
             */                                                                                          //
            comandoSQL = """
        INSERT INTO incidencias
            (idIncidencia, idClinica, nomContacto, numContacto, descIncidencia, codSup, FEntrada, estado, FCierre)
        VALUES
            (1, 2, 'Marta', 123456789, 'El software de gestión de pacientes no se abre.', NULL, '2025/01/05', 'Cerrada', '2025/01/05'),
            (2, 2, 'Ramón', 102938476, 'Problemas con la impresora de etiquetas. No imprime bien.', NULL, '2025/01/12', 'Cerrada', '2025/01/13'),
            (1, 1, NULL, NULL, 'No hay conexión a internet en uno de los ordenadores.', NULL, '2025/01/18', 'Cerrada', '2025/01/18'),
            (1, 5, 'Nathie', NULL, 'Lentitud general en el sistema informático.', 10293847, '2025/01/25', 'Cerrada', '2025/01/25'),
            (2, 5, 'Flores', NULL, 'Olvidé mi contraseña para acceder al programa de citas.', 97863452, '2025/02/01', 'Cerrada', '2025/02/02'),
            (1, 3, NULL, 876954032, 'Olvidé mi contraseña para acceder al programa de citas.', 123234345, '2025/02/08', 'Cerrada', '2025/02/09'),
            (3, 2, 'Ayuda', NULL, 'Error al intentar generar un informe de facturación.', NULL, '2025/02/15', 'Cerrada', '2025/02/15'),
            (1, 4, 'Lucía', 654789321, 'El ratón de un ordenador no funciona correctamente.', 98765432, '2025/02/22', 'Cerrada', '2025/02/23'),
            (2, 1, 'Carlos', NULL, 'Necesito instalar un nuevo software para radiografías.', 11223344, '2025/03/01', 'Cerrada', '2025/03/01'),
            (2, 3, NULL, 555111999, 'Fallo en la copia de seguridad de los datos.', 22334455, '2025/03/09', 'Cerrada', '2025/03/09'),
            (3, 5, 'Elena', NULL, 'El teclado de un portátil no responde.', 33445566, '2025/03/16', 'Cerrada', '2025/03/18'),
            (4, 2, 'Javier', 777888999, 'Problemas al enviar correos electrónicos desde el programa.', 44556677, '2025/03/23', 'Cerrada', '2025/03/23'),
            (2, 4, NULL, NULL, 'Se ha desconfigurado la fecha y hora del sistema.', 55667788, '2025/03/30', 'Cerrada', '2025/03/30'),
            (3, 1, 'Sofía', 111222333, 'No puedo acceder a la base de datos de los pacientes.', 66778899, '2025/04/06', 'Cerrada', '2025/04/06'),
            (3, 3, 'Miguel', NULL, 'La pantalla de un ordenador parpadea constantemente.', 77889900, '2025/04/13', 'Cerrada', '2025/04/14'),
            (4, 5, NULL, 999000111, 'Necesito ayuda para configurar una nueva cuenta de usuario.', 88990011, '2025/04/20', 'Cerrada', '2025/04/21'),
            (5, 2, 'Isabel', NULL, 'El antivirus ha detectado una amenaza.', 99001122, '2025/04/27', 'Cerrada', '2025/04/29'),
            (3, 4, 'Pablo', 222333444, 'No se escucha el audio en las videollamadas.', 11223344, '2025/05/01', 'Abierta', NULL),
            (4, 1, NULL, NULL, 'Dificultad para imprimir documentos a doble cara.', 22334455, '2025/05/01', 'Abierta', NULL),
            (4, 3, 'Carmen', 333444555, 'El programa de gestión se cierra inesperadamente.', 33445566, '2025/05/08', 'Abierta', NULL);
        """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla incidencias insertada");

            /*
             * INSERT TABLA asistencias
             */
            comandoSQL = """
        INSERT INTO asistencias
            (idAsistente, idClinica, idIncidencia, descripcionAsistencia)
        VALUES
            (3, 2, 1, 'Se reinició el servicio del software de gestión y se comprobó su correcto funcionamiento.'),
            (1, 2, 2, 'Se reemplazó el cartucho de tinta y se limpiaron los cabezales de la impresora.'),
            (1, 1, 1, 'Se revisó la conexión de red y se restableció la configuración IP del equipo.'),
            (2, 5, 1, 'Se optimizó el rendimiento del sistema eliminando archivos temporales y reiniciando.'),
            (4, 5, 2, 'Se restableció la contraseña del usuario. Se recomienda cambiarla periódicamente.'),
            (3, 3, 1, 'Se verificó la conexión del monitor y se actualizó el controlador de la tarjeta gráfica.'),
            (1, 2, 3, 'Se revisaron los datos de facturación y se corrigió el error en la generación del informe.'),
            (3, 4, 1, 'Se reemplazó el ratón defectuoso por uno nuevo.'),
            (2, 1, 2, 'Se instaló y configuró el nuevo software de radiografías. Se proporcionó formación básica.'),
            (2, 3, 2, 'Se verificó la integridad de la copia de seguridad y se realizó una nueva copia completa.'),
            (4, 5, 3, 'Se reemplazó el teclado del portátil.'),
            (4, 2, 4, 'Se revisó la configuración del correo electrónico y se solucionaron los problemas de envío.'),
            (1, 4, 2, 'Se sincronizó la fecha y hora del sistema y se configuró la zona horaria correcta.'),
            (3, 1, 3, 'Se verificaron las credenciales de acceso a la base de datos y se restableció la conexión.'),
            (1, 3, 3, 'Se revisó el cableado del monitor y se actualizó el controlador de la tarjeta gráfica.'),
            (2, 5, 4, 'Se creó y configuró la nueva cuenta de usuario con los permisos correspondientes.'),
            (3, 2, 5, 'Se puso en cuarentena y eliminó la amenaza detectada por el antivirus. Se actualizó la base de datos de firmas.');
        """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla asistencias insertada");

            /*
             * INSERT TABLA aportaciones
             */
            comandoSQL = """
            INSERT INTO colaboraciones
                (idTrabajador, idClinica, idIncidencia, aportaciones)
                    VALUES
            (6, 2, 1, 'Colaboración en la identificación de procesos conflictivos del software de gestión. Documentación de pasos de reinicio.'),
            (5, 2, 2, 'Asistencia en la prueba de diferentes configuraciones de impresión y en la limpieza de la impresora.'),
            (5, 1, 1, 'Ayuda en la verificación de cables de red y en la ejecución de diagnósticos básicos de conectividad.'),
            (5, 5, 1, 'Soporte en la monitorización del uso de recursos del sistema para identificar cuellos de botella.'),
            (6, 5, 2, 'Asistencia al usuario durante el proceso de cambio de contraseña y verificación de acceso.'),
            (6, 3, 1, 'Investigación de posibles soluciones online para el problema de olvido de contraseña y documentación de las mismas.'),
            (5, 2, 3, 'Apoyo en la revisión de datos para la generación de informes y en la verificación de la configuración del módulo de facturación.'),
            (6, 4, 1, 'Prueba del funcionamiento del nuevo ratón y confirmación de la resolución del problema.'),
            (5, 1, 2, 'Asistencia en la descarga del software de radiografías y en la preparación del entorno para la instalación.'),
            (5, 3, 2, 'Colaboración en la monitorización del proceso de copia de seguridad y en la verificación de logs.'),
            (6, 5, 3, 'Ayuda en la identificación del modelo exacto del portátil para asegurar la compatibilidad del teclado de reemplazo.'),
            (6, 2, 4, 'Soporte en la revisión de la configuración del cliente de correo y en el envío de correos de prueba.'),
            (5, 4, 2, 'Asistencia en la verificación de la configuración regional y horaria del sistema operativo.'),
            (6, 1, 3, 'Colaboración en las pruebas de conectividad a la base de datos con diferentes herramientas y usuarios.'),
            (5, 3, 3, 'Investigación de causas comunes de parpadeo de pantalla y sugerencia de revisión de drivers.'),
            (5, 5, 4, 'Apoyo en la documentación de los pasos para la creación de cuentas de usuario y asignación de permisos.'),
            (6, 2, 5, 'Asistencia en la búsqueda de información sobre la amenaza detectada y en la confirmación de su eliminación.');
        """;
            insert = conn.prepareStatement(comandoSQL);
            insert.executeUpdate();
            System.out.println("Tabla colaboraciones insertada");
///////////////////////////////////////////////////////////////////////////////////////////////////////////

            ConexionDB.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException("Error "+e);
        }
    }
}
