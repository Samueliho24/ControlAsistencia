package main;

import javax.swing.*;
import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "acto_grado";
    private static final String ADMIN_USER = "root";
    private static final String ADMIN_PASSWORD = "";
    private static boolean dbExists = false;
    
    public static void initializeDatabase() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, ADMIN_USER, ADMIN_PASSWORD);
            Statement stmt = conn.createStatement();
            
            // Verificar si la base de datos existe
            if (!databaseExists(conn)) {
                createDatabase(stmt);
                JOptionPane.showMessageDialog(null, "Base de datos creada exitosamente");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showError("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Restablece completamente la base de datos (elimina y vuelve a crear)
     */
    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void resetDatabase() {
        try {
            // Confirmación del usuario
            int option = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro que desea restablecer la base de datos?\nEsta acción no se puede deshacer.", 
                "Confirmar restablecimiento", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
            
            if (option != JOptionPane.YES_OPTION) {
                return;
            }
            
            // Autenticación
            String password = JOptionPane.showInputDialog(null, 
                "Ingrese la contraseña de administrador:", 
                "Autenticación requerida", 
                JOptionPane.PLAIN_MESSAGE);
                
            if (password == null || !password.equals("Actogrado2025")) {
                JOptionPane.showMessageDialog(null, 
                    "Contraseña incorrecta. Operación cancelada.", 
                    "Error de autenticación", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Proceso de restablecimiento
            Connection conn = DriverManager.getConnection(DB_URL, ADMIN_USER, ADMIN_PASSWORD);
            Statement stmt = conn.createStatement();
            
            dropDatabase(stmt);
            createDatabase(stmt);
            
            JOptionPane.showMessageDialog(null, 
                "Base de datos restablecida exitosamente", 
                "Operación completada", 
                JOptionPane.INFORMATION_MESSAGE);
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            showError("Error al restablecer la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Métodos auxiliares
    
    private static boolean databaseExists(Connection conn) throws SQLException {
        ResultSet rs = conn.getMetaData().getCatalogs();
        while (rs.next()) {
            if (DB_NAME.equalsIgnoreCase(rs.getString(1))) {
                rs.close();
                return true;
            }
        }
        rs.close();
        return false;
    }
    
    private static void createDatabase(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
        stmt.executeUpdate("USE " + DB_NAME);
        createTables(stmt);
        insertInitialData(stmt);
    }
    
    private static void dropDatabase(Statement stmt) throws SQLException {
        stmt.executeUpdate("DROP DATABASE IF EXISTS " + DB_NAME);
    }
    
    private static void createTables(Statement stmt) throws SQLException {
        if (!dbExists) {        
            // Crear tabla participants
            stmt.executeUpdate(
                "CREATE TABLE participants (" +
                "name VARCHAR(60) NOT NULL, " +
                "cedula INT(8) NOT NULL, " +
                "seat INT(3) NOT NULL AUTO_INCREMENT, " +
                "state INT(1) NOT NULL DEFAULT 0, " +
                "PRIMARY KEY (seat)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
        }
        // Crear tabla users
        stmt.executeUpdate(
            "CREATE TABLE users (" +
            "id_user INT(11) NOT NULL AUTO_INCREMENT, " +
            "user VARCHAR(50) NOT NULL, " +
            "password VARCHAR(50) NOT NULL, " +
            "create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
            "state INT(11) NOT NULL DEFAULT 1, " +
            "PRIMARY KEY (id_user)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci");
    }
    
    private static void insertInitialData(Statement stmt) throws SQLException {
        // Insertar datos iniciales en participants (aquí iría todo el INSERT de participants)
        // Ejemplo simplificado:
        stmt.executeUpdate(
        "INSERT INTO participants (name, cedula, seat, state) VALUES " +
        "('Abreu Rios, Luis José José', 23444077, 1, 0), " +
        "('Acosta Cruz, Francis Paola', 25950523, 2, 0), " +
        "('Acosta Flores, Roselin Paola', 27637149, 3, 0), " +
        "('Acosta Romero, Andrea Paola', 25907967, 4, 0), " +
        "('Acuña Sánchez, Gustavo Adolfo', 25345785, 5, 0), " +
        "('Aguiar Atencio, Patricia Esther', 26490471, 6, 0), " +
        "('Aguiles Aldana, Vanessa Sarahi', 26185927, 7, 0), " +
        "('Agustin Aguilar, Arianna Valentina', 26522964, 8, 0), " +
        "('Alfonzo Mavarez, Marialis Desiree', 26317592, 9, 0), " +
        "('Altuve Sánchez, Romileth Virginia', 24951814, 10, 0), " +
        "('Altuve Tovar, Sonia Gisela', 25195652, 11, 0), " +
        "('Alvarado Castellano, Maria José', 23858991, 12, 0), " +
        "('Alvarez Torres, Luwin Elisaul', 26653481, 13, 0), " +
        "('Angel Migliore, Ligia Biagina', 24955429, 14, 0), " +
        "('Araujo Montero, Dayaine Chiquinquira', 26775953, 15, 0), " +
        "('Ardila Barreto, Verónica Betania', 26191024, 16, 0), " +
        "('Arenas Soto, Gustavo Adolfo', 25490030, 17, 0), " +
        "('Arismendi Uzcategui, Keymari Elvira', 26862459, 18, 0), " +
        "('Arrieta Neuman, Camila Cristina', 25339243, 19, 0), " +
        "('Atencio Rodriguez, Emanuel Anthony', 26635973, 20, 0), " +
        "('Avila Barrios, Nayibeth Nayitzy', 24603128, 21, 0), " +
        "('Avila Cortez, Jakeline Adriana', 27552089, 22, 0), " +
        "('Avila Marcano, Alonso Javier', 25597121, 23, 0), " +
        "('Barazarte Valero, Alexandra Chiquinquira', 25373066, 24, 0), " +
        "('Barboza Hernández, Claudia Del Carmen', 26639126, 25, 0), " +
        "('Barboza Rubio, Othny José', 25988182, 26, 0), " +
        "('Barrera Portillo, Helen Michelle', 25342537, 27, 0), " +
        "('Barroso Flores, Yulied Andreina', 26878140, 28, 0), " +
        "('Bastidas Rivero, Marxel Alejandro', 24617137, 29, 0), " +
        "('Bauza Segovia, Roberto Luis', 26963476, 30, 0), " +
        "('Belzares Diaz, Andres Eduardo', 24965745, 31, 0), " +
        "('Benitez Rodriguez, Luisseyda Paola', 26356291, 32, 0), " +
        "('Bermudez Garcia, Mariana Patricia', 23735334, 33, 0), " +
        "('Bermudez Maldonado, Dollybel Maria', 26417452, 34, 0), " +
        "('Bermudez Quero, Amy Emperatriz', 23760544, 35, 0), " +
        "('Berrios Parra, Andriuw José', 25907722, 36, 0), " +
        "('Betancourt Suarez, Elio', 26023433, 37, 0), " +
        "('Blanco Lomelly, Jesari Loanny', 27512372, 38, 0), " +
        "('Boscan Añez, Maria Beatriz', 25345196, 39, 0), " +
        "('Bozo Graterol, Arianny Natasha', 27635565, 40, 0), " +
        "('Bracho Mesa, Josmary Anyely', 26816830, 41, 0), " +
        "('Bracho Montiel, Beliana Beatriz', 26575767, 42, 0), " +
        "('Bracho Ocando, Denis Carolina', 26639105, 43, 0), " +
        "('Bracho Ysea, Faviana Cristina', 24406701, 44, 0), " +
        "('Caldera Fernández, Marianyeli Andreina', 23894752, 45, 0), " +
        "('Calmon Morales, Anthony Ezequiel', 26236946, 46, 0), " +
        "('Camejo Abreu, Anapatricia', 26236625, 47, 0), " +
        "('Cárdenas Rincón, Tommy Alejandro', 27511020, 48, 0), " +
        "('Cardozo Sanchez, Katerin Gabriela', 23877415, 49, 0), " +
        "('Carrero Moreno, Carla Isabel', 26859632, 50, 0), " +
        "('Castillo Alburguez, Jacne Rosalia', 24266308, 51, 0), " +
        "('Castillo Marmol, Misael Daniel', 27271565, 52, 0), " +
        "('Castillo Rueda Giorgia Sikyu', 19210989, 53, 0), " +
        "('Castillo Villarroel, José Alberto', 27126369, 54, 0), " +
        "('Cedeño Corona, Nelson Andres', 26536951, 55, 0), " +
        "('Cepeda Marin, Patricia Yelimar', 26524548, 56, 0), " +
        "('Chacin Cardozo, Rossana José', 16169339, 57, 0), " +
        "('Chang Fuenmayor, Richard Alexander', 25950152, 58, 0), " +
        "('Chourio Socorro, Victor Manuel', 27089574, 59, 0), " +
        "('Cifuentes Rodriguez, Daniela Margarita', 27284550, 60, 0), " +
        "('Cohen Esaa, Andres Ignacio', 25902028, 61, 0), " +
        "('Dávila Arias, Maria Alexandra', 27263352, 62, 0), " +
        "('Delgado Gomez, Maria Isabel', 26767426, 63, 0), " +
        "('Delgado González, Franny Daniela', 25454867, 64, 0), " +
        "('Delgado Muñoz, Erimel Coromoto', 27030099, 65, 0), " +
        "('Díaz Albornoz, Maria Paula', 26635253, 66, 0), " +
        "('Díaz Avendaño, Nelson Xavier', 24785936, 67, 0), " +
        "('Dominguez Romero, Esteban David', 26912650, 68, 0), " +
        "('Duran Urdaneta, Pablo', 26456690, 69, 0), " +
        "('Echeverría Moran, Moises Daniel', 26963715, 70, 0), " +
        "('Fereira Prado, Gissell Estefania', 27305093, 71, 0), " +
        "('Fernández Gómez, Joseglis Chiquinquira', 25907709, 72, 0), " +
        "('Fernández Fernández, Jesús Leonardo', 26185531, 73, 0), " +
        "('Fernández Montiel, Marlis Coromoto', 21075255, 74, 0), " +
        "('Ferrer Fuenmayor, Diego Andres', 25043603, 75, 0), " +
        "('Ferrer Galban, Alexandra Coromoto', 26481463, 76, 0), " +
        "('Flores Asuaje, Maria Fernanda', 27312257, 77, 0), " +
        "('Flores Soto, Williana Aivle', 26963091, 78, 0), " +
        "('Franco Hernández, Pamela Del Carmen', 22469341, 79, 0), " +
        "('Fuenmayor Berbesi, Eriannysmar', 25763637, 80, 0), " +
        "('Galban Perez, Nestor Andres', 26957740, 81, 0), " +
        "('Garcia Consuegra, Alejandra Carolina', 24956474, 82, 0), " +
        "('Garcia Montaña, Larry De Jesus', 26123537, 83, 0), " +
        "('Garcia Reyes, Dalia Valentina', 27104359, 84, 0), " +
        "('Garrido Paz, Bermary Andrea', 25660685, 85, 0), " +
        "('González González, Roberto Carlos', 26105843, 86, 0), " +
        "('González Hernández, Katherin Andrea', 26185635, 87, 0), " +
        "('González Pinto, Jose Javier', 26560922, 88, 0), " +
        "('González Torres, Yohanly Coromoto', 24725966, 89, 0), " +
        "('González Urdaneta, Yinna Yaitiry', 27887459, 90, 0), " +
        "('Gotera Yoris, Maria Paula Cristina', 27135943, 91, 0), " +
        "('Govea Díaz, Jorge Enrique', 27192154, 92, 0), " +
        "('Gudiño Beltran, Luis Jose', 23262180, 93, 0), " +
        "('Guerra Velasquez, Nelson Enrique', 27511901, 94, 0), " +
        "('Guerra Villasmil, Emily Del Carmen', 26639130, 95, 0), " +
        "('Gutiérrez Arias, Emma María', 24074919, 96, 0), " +
        "('Guzman Calderas, Maria De Los Angeles', 26963214, 97, 0), " +
        "('Hernández Labarca, Ediani Coromoto', 26275161, 98, 0), " +
        "('Hernández Peña, Elizabeth María', 26536218, 99, 0), " +
        "('Hernández Rangel, Daniela Isamar', 26347432, 100, 0), " +
        "('Hernandez Villasmil, Diana Carolina', 26693466, 101, 0), " +
        "('Homberger Matheus, Michelle Andreina', 27406570, 102, 0), " +
        "('Igirio Pacheco, Carolaine Soley', 26032501, 103, 0), " +
        "('Jimenez Añez, Lenin Josue', 26394191, 104, 0), " +
        "('Jordan Monasterio, Gabriela De Los Angeles', 26998119, 105, 0), " +
        "('Jordan Monasterio, Omar David', 26998118, 106, 0), " +
        "('Julio López, Stefany Carolina', 19645788, 107, 0), " +
        "('Labarca Chacin, Analia Tamaiwa', 26091405, 108, 0), " +
        "('Labarca Martinez, Karelsy Daniela', 26711405, 109, 0), " +
        "('Leal Morillo, Isabel Cristina', 24946311, 110, 0), " +
        "('Le Grand Cedeño, Kenneth Keaton', 27491548, 111, 0), " +
        "('León Fernández, Adriana Estefanía', 25853987, 112, 0), " +
        "('León Moreno, Vinicio Jesús', 25790912, 113, 0), " +
        "('Linares Gudiño, Carlos Jesus', 23596211, 114, 0), " +
        "('Lopez Pineda, Yoselyn Paola', 26335850, 115, 0), " +
        "('Lugo Betancourt, Jennileth Daniela', 25883648, 116, 0), " +
        "('Lujano Carrasquero, Geovanny Jose', 25406478, 117, 0), " +
        "('Luzardo González, Victor David', 26211692, 118, 0), " +
        "('Luzardo Pineda, Esthefania', 27682684, 119, 0), " +
        "('Machado Huerta, Julio Augusto', 26657052, 120, 0), " +
        "('Mafilito Finol, Daniela Coromoto', 23736459, 121, 0), " +
        "('Manjarres Zambrano, Anny Gizeh', 26702297, 122, 0), " +
        "('Marapacuto Martinez, Alejandra Daniela', 27435772, 123, 0), " +
        "('Marcano Medina, Sheldry Mared', 27681692, 124, 0), " +
        "('Marin Briceño, Gabriela Cristina', 26827727, 125, 0), " +
        "('Martinez Mendoza, Maria Fernanda', 26091568, 126, 0), " +
        "('Martínez Torres, Jesús Alberto', 26743530, 127, 0), " +
        "('Matos Sandrea, Leonela Maria', 23479765, 128, 0), " +
        "('Matos Sarabia, Maria Gabriela', 27821141, 129, 0), " +
        "('Mayor Mendez, Jhodygmar', 24909801, 130, 0), " +
        "('Medina Diaz, Carlos Jose', 24566592, 131, 0), " +
        "('Mejia Ochoa, Vicky Anneris', 22478762, 132, 0), " +
        "('Melean Barboza, Daliany De Los Angeles', 26529036, 133, 0), " +
        "('Melean Morillo, Dayver Nataly', 26175408, 134, 0), " +
        "('Melendez Garcia, Ahidalys Daniela', 25784723, 135, 0), " +
        "('Mendoza Ceccarelli, Alejandro Enrique', 25190233, 136, 0), " +
        "('Mendoza Morales, Yessenia Yareth', 26208739, 137, 0), " +
        "('Mengual Rodríguez, Mauricio José', 25984490, 138, 0), " +
        "('Meza Diaz, Wendy Alexandra', 26066475, 139, 0), " +
        "('Moncada Gonzalez, Corina Valentina', 26403269, 140, 0), " +
        "('Montiel Lopez, Nohemi Carolina', 26173986, 141, 0), " +
        "('Montiel Marriaga, Emely Alejandra', 27997106, 142, 0), " +
        "('Morales Zambrano, Lusymar Paola', 26068796, 143, 0), " +
        "('Nava Lopez, Genesis Robzely', 26742887, 144, 0), " +
        "('Navarro Marquez, Carolina Del Carmen', 26471363, 145, 0), " +
        "('Naveda Camargo, Jose Luis', 17833664, 146, 0), " +
        "('Nicholls Soto, Karla Daniela', 26353325, 147, 0), " +
        "('Nivar Morales, Angel Andrés De San José', 26241138, 148, 0), " +
        "('Núñez Méndez, Andrea Verónica', 25767355, 149, 0), " +
        "('Nuñez Palencia, Yetsabe Abigail', 27680108, 150, 0), " +
        "('Olano Melean, Nestor Jose', 26906114, 151, 0), " +
        "('Olivares Gonzalez, Ana Virginia', 27139954, 152, 0), " +
        "('Oñatez Rincón, Warnisbeth Gabriella', 27082348, 153, 0), " +
        "('Orta Briceño, Jose Enrique', 25832827, 154, 0), " +
        "('Ortiz Rojas, Alexandra De Los Ángeles', 27528903, 155, 0), " +
        "('Osorio Villasmil, Gustavo Samuel', 26356477, 156, 0), " +
        "('Paccini Márquez, Armando Louis', 15559803, 157, 0), " +
        "('Palmar Diaz, Alejandra Paola', 26560949, 158, 0), " +
        "('Paredes Mendez, Giovanni Javier', 26709446, 159, 0), " +
        "('Paredes Segovia, Elivett Estefani', 21366125, 160, 0), " +
        "('Parra Suniaga, Nathaly Del Mar', 27519656, 161, 0), " +
        "('Peña Mora, Laura Cristina', 25608940, 162, 0), " +
        "('Peña Chourio, Xindi Leonor', 29599274, 163, 0), " +
        "('Perdomo Gomez, Nelmary Del Carmen', 24256034, 164, 0), " +
        "('Pérez Bastidas, Daniela', 26860267, 165, 0), " +
        "('Pérez Boscán, Andrea Paola', 26171118, 166, 0), " +
        "('Pérez Hernández, Daviana Virginia', 28109041, 167, 0), " +
        "('Perez Leal, Yiyed Daniela', 27327640, 168, 0), " +
        "('Perini Tazioli, Rina Maria', 24266266, 169, 0), " +
        "('Pico Velasquez, Valeria Cristina', 26709796, 170, 0), " +
        "('Pineda Arias, María Isabel', 27263353, 171, 0), " +
        "('Pineda Chaparro, Milagro Guadalupe', 25488156, 172, 0), " +
        "('Pineda Rivas, Lenin Andrés', 26043596, 173, 0), " +
        "('Pineda Semeco, Denise De Los Angeles', 26175307, 174, 0), " +
        "('Piña Urdaneta, Maria Valeria', 26410380, 175, 0), " +
        "('Pirona Fernandez, Gabriela Elisa', 26860764, 176, 0), " +
        "('Prada Castro, Elias Jonatan', 27422015, 177, 0), " +
        "('Quevedo Vasquez, Nelson Jose', 19812012, 178, 0), " +
        "('Quijada Rincon, Liliandra Cristina', 26914563, 179, 0), " +
        "('Ramirez Medina, Ivana Raibely', 23739282, 180, 0), " +
        "('Ramírez Rubio, María Daniela', 27236050, 181, 0), " +
        "('Rey Lobo, Loreani Patricia', 25886518, 182, 0), " +
        "('Reyes Perea, Eliana Alejandra', 26892967, 183, 0), " +
        "('Reyes Raga, Stefhany Paola', 26092545, 184, 0), " +
        "('Riganelly Carrera, Thaelis Karilu', 26768647, 185, 0), " +
        "('Rios Soto, Stefhany De Los Angeles', 25970507, 186, 0), " +
        "('Rivero Azuaje, Luis Miguel', 27350651, 187, 0), " +
        "('Roa Rubio, Alvaro Josue', 28497719, 188, 0), " +
        "('Rodriguez Alaña, Nervinson Jose', 24262682, 189, 0), " +
        "('Rodriguez Castellanos, Elizabeth Del Carmen', 23514737, 190, 0), " +
        "('Rodríguez Castellanos, José Andrés', 25853635, 191, 0), " +
        "('Rodriguez Diaz, Maria Alexandra', 26126976, 192, 0), " +
        "('Rodriguez Oliveros, Gleydi Mercedes', 84572063, 193, 0), " +
        "('Rojas Amesty, Katherine Paola', 23739638, 194, 0), " +
        "('Rojas Laignelet, Isabel Johanna', 25962445, 195, 0), " +
        "('Rojas Osorio, Hernan Daniel', 26558551, 196, 0), " +
        "('Romero Bravo, Stephanie Jose', 27444426, 197, 0), " +
        "('Romero Herrera, Andrea Virginia', 25962420, 198, 0), " +
        "('Romero Moran, Albenis Jose', 24714569, 199, 0), " +
        "('Roquez Lugo, Duilio Alexander', 27503145, 200, 0), " +
        "('Rosales Delgado, Jacqueline Rossana', 26202560, 201, 0), " +
        "('Rosales Araujo, Cesar Anderson', 26093407, 202, 0), " +
        "('Rosales Díaz, María José', 25974667, 203, 0), " +
        "('Ruiz Diaz, Angel David', 26410523, 204, 0), " +
        "('Ruiz Villalobos, Jennifer Alexandra', 26709397, 205, 0), " +
        "('Ruz Borjas, Luisennys Irania', 26318804, 206, 0), " +
        "('Salazar Pereira, Adrian Francisco', 26456381, 207, 0), " +
        "('Salmeron Muñoz, Maria Guillermina', 23869272, 208, 0), " +
        "('Sanchez Garcia, Keila Beatriz', 26784414, 209, 0), " +
        "('Sanchez Parra, Mileyvi Romar', 26857666, 210, 0), " +
        "('Santeliz Barrueta, Raquel Gabriela', 26188423, 211, 0), " +
        "('Segovia Segovia, Yairy De Los Angeles', 26690427, 212, 0), " +
        "('Sencial Montiel, Rosmary Joselin', 23769998, 213, 0), " +
        "('Sevilla Nava Magdalena', 28137398, 214, 0), " +
        "('Silva Finol, José Alfonso', 26175512, 215, 0), " +
        "('Silva Polanco, Frixmeris De Los Angeles', 26806156, 216, 0), " +
        "('Silva Rojas, Miguel Angel', 26451096, 217, 0), " +
        "('Sleiman Leal, Zaidne Andrea', 26892422, 218, 0), " +
        "('Solarte Barrios, Anderson De Jesus', 27444322, 219, 0), " +
        "('Sosa Bencomo, Victoria Elena', 27332431, 220, 0), " +
        "('Soto Nuñez, Alejandro Andres', 26241131, 221, 0), " +
        "('Strellow Siu, Alexander', 23607952, 222, 0), " +
        "('Sulbaran Araujo, Gabriel Alejandro', 26235642, 223, 0), " +
        "('Tavares Morillo, Armando Alberto', 22177859, 224, 0), " +
        "('Torres Castro, Ana Camila', 26638508, 225, 0), " +
        "('Torres Rodríguez, Juan José', 26114144, 226, 0), " +
        "('Urbina Romero, Pamela Liz', 26185492, 227, 0), " +
        "('Urdaneta Lima, Karen Siu Ling', 25788682, 228, 0), " +
        "('Uriana Palmar, Jhonatan Manuel', 23736988, 229, 0), " +
        "('Urrutia Vivas, Marien Cristina', 25988893, 230, 0), " +
        "('Uzcategui Morales, Ivan Jose', 27004820, 231, 0), " +
        "('Valbuena González, Roibeliz Carolina', 27284904, 232, 0), " +
        "('Valderrama Caraballo, Carolis Jesus', 27139846, 233, 0), " +
        "('Valles Valero, Jorge Enrique De Jesus', 27071537, 234, 0), " +
        "('Vargas Briceño, Joseily Beatriz', 26710144, 235, 0), " +
        "('Vargas Melendez, Marcos David', 26202879, 236, 0), " +
        "('Vasquez Piña, Antonio Jose', 26709894, 237, 0), " +
        "('Velasquez Briceño, Daniela Cristina', 26185677, 238, 0), " +
        "('Velasquez Mosquera, Madhelen', 26827591, 239, 0), " +
        "('Vera Mejia, Maria Victoria', 25906610, 240, 0), " +
        "('Victora Ferrer, Maria José', 25183501, 241, 0), " +
        "('Villalobos Almarza, Clara Luisa', 24733185, 242, 0), " +
        "('Villalobos Morales, Luis Enrique', 24250247, 243, 0), " +
        "('Villalobos Salazar, Jhovanna Alejandra', 28171204, 244, 0), " +
        "('Villasmil Montiel, Esthefany Andreina', 27530006, 245, 0), " +
        "('Vivas Boscan, Carla Patricia', 26456634, 246, 0), " +
        "('Vivas Labrador, Ivana Paola', 26493397, 247, 0), " +
        "('Yajure Perozo, Esther Elena', 19832469, 248, 0), " +
        "('Yaraure Bustamante, Pahola Jesus', 26776381, 249, 0), " +
        "('Zabaleta Campos, Carol Elizabeth', 25297385, 250, 0)");
        if (!dbExists) {
            stmt.executeUpdate(
            "INSERT INTO users (id_user, user, password, create_time, state) VALUES " +
            "(1, 'admin', 'Actogrado2025', '2025-05-05 22:32:19', 1)");
        }
        dbExists=true;
        // Insertar usuario admin
        
    }
    
    
}