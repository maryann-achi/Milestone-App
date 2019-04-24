package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Project {
    static final Logger LOG = LoggerFactory.getLogger(Project.class);

    private String title;
    private List<Milestone> milestones;

    public Project(String ProjectTitle){
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

    public void removeMilestones(List<Milestone> milestones){
        this.milestones.removeAll(milestones);
    }
}
