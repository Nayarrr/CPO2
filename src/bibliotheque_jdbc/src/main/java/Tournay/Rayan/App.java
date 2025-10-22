package src.bibliotheque_jdbc.src.main.java.Tournay.Rayan;

import java.sql.*;
import java.io.*;

public class App {

    private static final String URL = "jdbc:postgresql://postgres-db:5432/bibliotheque";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    
    private static void createTable(Connection conn) throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS livres(" + "id SERIAL PRIMARY KEY,"
                        + "titre VARCHAR(100) NOT NULL," 
                        + "auteur VARCHAR(100) NOT NULL,"
                        + "description TEXT,"
                        + "couverture BYTEA)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Table 'livres' créee ou déjà existante.");
        stmt.close();
    }
    public static void main( String[] args ){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
