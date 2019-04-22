package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MilestoneBoard {
    static final Logger lOG = LoggerFactory.getLogger(MilestoneBoard.class);

    private static MilestoneBoard instance = null;

    private String name;
    private List<Project> Projects;

    public static MilestoneBoard getInstance(String name){
        if (instance == null || !instance.getName().equals(name)) {
            instance = new MilestoneBoard(name);
        }
        return instance;
    }

    public MilestoneBoard(String boardName){
        this.name = boardName;
        Projects = new ArrayList<>();

        this.Projects.add(new Project("project1"));
        this.Projects.add(new Project("project2"));

    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return Projects;
    }

    public void addProject(Project project){
        this.Projects.add(project);
    }

    public Project getProject(int index){
        if(index < 0 || index > Projects.size()) return null;
        return Projects.get(index);
    }

    public int getNumberOfProjects(){
        return Projects.size();
    }

}
