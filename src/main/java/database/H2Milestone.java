package database;

import org.h2.tools.Server;
import model.Milestone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Milestone {

    public static final String DATABASE = "jdbc:h2:~/milestone_db";

    private Connection connection;
    private Server server;
    private String milestones;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver"); // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.

        return DriverManager.getConnection(db, "admin", "admin"); // default password, ok for embedded.
    }

    public H2Milestone() {

        this(DATABASE);
        createTable();
    }

    public H2Milestone(String db) {
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
        String query = "CREATE TABLE IF NOT EXISTS milestones (\n" +
                " id int AUTO_INCREMENT PRIMARY KEY,\n" +
                " projectid INT,\n" +
                " title VARCHAR(255),\n" +
                " description VARCHAR(255),\n" +
                " expDueDate DATE, \n" +
                " completionDate DATE, \n" +
                "  FOREIGN KEY(projectid) REFERENCES projects(id) ON DELETE CASCADE" +
                ");";

        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMilestone(Milestone goal) {
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestones (projectid, title, description, expDueDate, completionDate) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)) {
            ps.setInt(1, goal.getProjectid());
            ps.setString(2, goal.getTitle());
            ps.setString(3, goal.getDescription());
            ps.setString(4, goal.getExpDueDate());
            ps.setString(5, goal.getCompletionDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeMilestone(int id){
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM" + milestones + "WHERE id =" + id;
        try(PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)){
            return ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Milestone> findMilestones(){
        final String LIST_MILESTONES_QUERY = "SELECT id, projectid, title, description, expDueDate, completionDate FROM milestones";
        List<Milestone> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.add(new Milestone(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

}
