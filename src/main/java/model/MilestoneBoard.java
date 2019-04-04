package model;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

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
