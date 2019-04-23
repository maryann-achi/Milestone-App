package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Project {
    static final Logger LOG = LoggerFactory.getLogger(Project.class);

    private int id;
    private String title;
    private List<Milestone> milestones;
    private int userid;

    public Project(String ProjectTitle){
        this.title = ProjectTitle;
        milestones = new ArrayList<>();
    }

    public Project(int id, String ProjectTitle, int userid){
        this.id = id;
        this.userid = userid;
        this.title = ProjectTitle;
        milestones = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Milestone> getMilestones() {
        return milestones;
    }

    public void addMilestone(Milestone milestone) {
        this.milestones.add(milestone);
    }

    public void removeMilestone(int index){
        if (index < 0 || index > milestones.size()) return;
        milestones.remove(index);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
