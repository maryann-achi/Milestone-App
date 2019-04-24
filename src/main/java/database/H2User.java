package database;

import org.h2.tools.Server;
import model.User;

import java.sql.*;

public class H2User {

    public static final String DATABASE = "jdbc:h2:~/milestone_db";

    private Connection connection;
    private Server server;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.

        return DriverManager.getConnection(db, "admin", "admin");  // default password, ok for embedded.

    }

    public H2User() {

        this(DATABASE);
        createTable();
    }

    public H2User(String db) {
        try {
            this.server = Server.createTcpServer().start();
            System.out.println("created server");
            connection = getConnection(db);
            System.out.println("connection" + connection.toString());

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(){
        String query = "CREATE TABLE IF NOT EXISTS users (\n" +
                "  id int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  first VARCHAR(255),\n" +
                "  last VARCHAR(255),\n" +
                "  email VARCHAR(255)\n" +
                ");";

        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPerson(User person) {
        final String ADD_PERSON_QUERY = "INSERT INTO users (first, last, email) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_PERSON_QUERY)) {
            ps.setString(1, person.getFirst());
            ps.setString(2, person.getLast());
            ps.setString(3, person.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
