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
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestones (projectid, title, description, expDueDate, completionDate) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)) {
            ps.setInt(1, goal.getProjectid());
            ps.setString(2, goal.getTitle());
            ps.setString(3, goal.getDescription());
            java.sql.Date exptDate = new java.sql.Date(goal.getExpDueDate().getTime());
            ps.setDate(4, exptDate);
            java.sql.Date compltDate = new java.sql.Date(goal.getCompletionDate().getTime());
            ps.setDate(5, compltDate);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeMilestone(int id){
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestones WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)){
            ps.setInt(1, id);
            return ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean removeMilestones(int projectId){
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestones WHERE projectid = ?";
        try(PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)){
            ps.setInt(1, projectId);//projectId that is passed in as a parameter
            return ps.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateMilestoneCompDate(int id, Date date){

        final String UPDATE_MILESTONE_QUERY = "UPDATE milestones SET "+"completiondate = ?"+" WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_MILESTONE_QUERY)){
            ps.setInt(2, id);
            ps.setDate(1, date);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Milestone findMilestone(int id){
        final String FIND_MILESTONE_QUERY = "SELECT id, projectid, title, description, expDueDate, completionDate FROM milestones WHERE id = ?";
        Milestone milestone = null;
        try(PreparedStatement ps = connection.prepareStatement(FIND_MILESTONE_QUERY)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Date expt = new Date(rs.getDate(5).getTime());
                Date cpt = new Date(rs.getDate(6).getTime());
                milestone = new Milestone(rs.getInt(1),rs.getString(3), rs.getString(4), expt, cpt, rs.getInt(2));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return milestone;
    }

    public List<Milestone> findMilestones(){
        final String LIST_MILESTONES_QUERY = "SELECT id, projectid, title, description, expDueDate, completionDate FROM milestones";
        List<Milestone> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date expt = new Date(rs.getDate(5).getTime());
                Date cpt = new Date(rs.getDate(6).getTime());
                out.add(new Milestone(rs.getInt(1),rs.getString(3), rs.getString(4), expt, cpt, rs.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public List<Milestone> findMilestones(int projectid){
        final String LIST_MILESTONES_QUERY = "SELECT id, projectid, title, description, expDueDate, completionDate FROM milestones WHERE projectid = ?";
        List<Milestone> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            ps.setInt(1, projectid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date expt = new Date(rs.getDate(5).getTime());
                Date cpt = new Date(rs.getDate(6).getTime());
                out.add(new Milestone(rs.getInt(1),rs.getString(3), rs.getString(4), expt, cpt, rs.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }
}
