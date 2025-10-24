package Tournay.Rayan;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'livres' créee ou déjà existante.");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertBook(Connection conn, String titre, String auteur) throws SQLException{
        String sql = "INSERT INTO livres(titre, auteur) VALUES (?,?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titre);
            pstmt.setString(2, auteur);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " livre(s) ajouté(s).");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBookDesc(Connection conn, int id) throws SQLException, IOException{
        String sql = "UPDATE livres SET description = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
            InputStreamReader inputStreamReader = new InputStreamReader(App.class.getClassLoader().
                getResourceAsStream("description.txt"))) {
            pstmt.setCharacterStream(1, inputStreamReader);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " description(s) ajoutée(s).");
        }catch(SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addBookCover(Connection conn, int id) throws SQLException, IOException{
        String sql = "UPDATE livres SET couverture = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); 
            InputStream inputStream = App.class.getClassLoader().
                getResourceAsStream("cover.jpg")){
                    pstmt.setBinaryStream(1, inputStream);
                    pstmt.setInt(2,id);
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println(rowsAffected + "description(s) ajoutée(s).");
        } catch(SQLException | IOException e){
            e.printStackTrace();
        }
    }

    private static void listBooks(Connection conn) throws SQLException{
        String sql = "SELECT titre, auteur FROM livres";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                System.out.println("Titre: " + titre + ", Auteur: " + auteur);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main( String[] args ){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            createTable(conn);
            insertBook(conn, "1984", "George Orwell");
            addBookDesc(conn, 1);
            addBookCover(conn, 1);
            listBooks(conn);
        }catch(SQLException | IOException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    conn.close();
                    System.out.println("Connexion fermée.");
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
