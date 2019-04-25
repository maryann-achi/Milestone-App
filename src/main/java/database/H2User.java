package database;

import model.PasswordHash;
import model.User;
import org.h2.tools.Server;

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
                "  name VARCHAR(255),\n" +
                "  email VARCHAR(255),\n" +
                "  hashpassword VARCHAR(255),\n" +
                "  salt VARBINARY(16)\n" +
                ");";

        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) {
        final String ADD_PERSON_QUERY = "INSERT INTO users (name, email, hashpassword, salt) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_PERSON_QUERY)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setBytes(4, user.getSalt());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public User findUser(String name, String password) {
        final String LIST_USER_QUERY = "SELECT id, name, email, hashpassword, salt  FROM users where name=?";
        User out = null;

        try (PreparedStatement ps = connection.prepareStatement(LIST_USER_QUERY)) {
            ps.setString(1, name);
            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBytes(5));
                if(user.getPassword().equals(PasswordHash.getHashPassword(password, user.getSalt()))){
                    out = user;
                    break;
                }
                System.out.println("Found user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public boolean removeUser(int id) {
       final String DELETE_USER_QUERY = "DELETE FROM  users WHERE id = " + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY)) {
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
