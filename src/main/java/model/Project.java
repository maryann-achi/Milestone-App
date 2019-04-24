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

    public Project(int userid, String ProjectTitle){
        this.userid = userid;
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

    public Milestone getMilestoneByName(String name){
        Milestone valid = null;
        for(Milestone milestone :this.milestones){
            if(milestone.getTitle().equals(name)){
                valid = milestone;
            }
        }
        return valid;
    }

    public void addMilestone(Milestone milestone) {
        this.milestones.add(milestone);
    }

    public void removeMilestone(int index){
        if (index < 0 || index > milestones.size()) return;
        milestones.remove(index);
    }


    public void removeMilestones(List<Milestone> milestones) {
        this.milestones.removeAll(milestones);
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

    public int getId(){ return id; }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
