package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MilestoneBoard {
    static final Logger lOG = LoggerFactory.getLogger(MilestoneBoard.class);

    private static MilestoneBoard instance = null;

    private String name;
    private List<Project> projects;

    public static MilestoneBoard getInstance(String name){
        if (instance == null || !instance.getName().equals(name)) {
            instance = new MilestoneBoard(name);
        }
        return instance;
    }

    public MilestoneBoard(String boardName){
        this.name = boardName;
        projects = new ArrayList<>();

        this.projects.add(new Project(1, "project1"));
        this.projects.add(new Project(33, "project2"));

    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    public Project getProject(int index){
        if(index < 0 || index > projects.size()) return null;
        return projects.get(index);
    }

//    Ari added a method to get projects by their names
    public Project getProjectByName(String name){
        Project valid = null;
        for(Project project :this.projects){
            if(project.getTitle().equals(name)){
                valid = project;
            }
        }
        return valid;
    }
//    Ari added a remove project method
    public void removeProject(List<Project> projects){
        this.projects.removeAll(projects);
    }

    public int getNumberOfProjects(){
        return projects.size();
    }

}
