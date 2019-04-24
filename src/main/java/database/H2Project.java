package database;

import model.Project;
import org.h2.tools.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Project {

    public static final String DATABASE = "jdbc:h2:~/milestone_db";

    private Connection connection;
    private Server server;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.

        return DriverManager.getConnection(db, "admin", "admin");  // default password, ok for embedded.

    }

    public H2Project() {

        this(DATABASE);
        createTable();
    }

    public H2Project(String db) {
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
        String query = "CREATE TABLE IF NOT EXISTS projects (\n" +
                "  id int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  userid INT,\n" +
                "  title VARCHAR(255),\n" +
                "  FOREIGN KEY(userid) REFERENCES users(id) ON DELETE CASCADE" +
                ");";

        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProject(Project project) {
        final String ADD_PROJECT_QUERY = "INSERT INTO projects (userid, title) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_PROJECT_QUERY)) {
            ps.setInt(1, project.getUserid());
            ps.setString(2, project.getTitle());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Project> findProjects() {
        final String LIST_PROJECTS_QUERY = "SELECT id, title, userid  FROM projects";
        List<Project> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_PROJECTS_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.add(new Project(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public Project findProject(int userid) {
        final String LIST_PROJECTS_QUERY = "SELECT id, title, userid  FROM projects where userid=?";
        Project out = null;

        try (PreparedStatement ps = connection.prepareStatement(LIST_PROJECTS_QUERY)) {
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();
            out = new Project(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public ArrayList<Project> findProjects(int userid) {
        final String LIST_PROJECTS_QUERY = "SELECT id, title, userid  FROM projects where userid=?";
        ArrayList<Project> out = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(LIST_PROJECTS_QUERY)) {
            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                out.add(new Project(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Project project : out){
            System.out.println(project.getTitle());
        }
        return out;
    }

    public boolean removeProject(int id) {
        final String REMOVE_PROJECTS_QUERY = "DELETE FROM projects WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(REMOVE_PROJECTS_QUERY )) {
            ps.setInt(1, id);
            return ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public ArrayList<Project> removeProjects(int userid) {
//        final String REMOVE_PROJECTS_QUERY = "SELECT id, title, userid  FROM projects where userid=?";
//        ArrayList<Project> out = new ArrayList<>();
//
//        try (PreparedStatement ps = connection.prepareStatement(REMOVE_PROJECTS_QUERY)) {
//            ps.setInt(1, userid);
//
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                out.remove(new Project(rs.getInt(1), rs.getString(2), rs.getInt(3)));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return out;
//    }

    public boolean editProject(int userid, String newTitle) {
        String EDIT_PROJECTS_QUERY = "UPDATE  + projects +  SET name = '" + newTitle + "' WHERE userid = " + userid;
        try (PreparedStatement ps = connection.prepareStatement(EDIT_PROJECTS_QUERY )) {
            return ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
