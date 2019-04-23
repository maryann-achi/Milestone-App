package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Milestone {
    static final Logger lOG = LoggerFactory.getLogger(Milestone.class);

    private int id;
    private int projectid;
    private String title, description;
    private Date expDueDate, completionDate;

    public Milestone(String theTitle, String theDescription, Date dueDate, Date compdate){
        title = theTitle;
        description = theDescription;
        expDueDate = dueDate;
        completionDate = compdate;
    }

//    had to add a separate constructor because you don't know completion date as at when you create the milestone
    public Milestone(String theTitle, String theDescription, Date dueDate){
        title = theTitle;
        description = theDescription;
        expDueDate = dueDate;
        completionDate = dueDate;
    }
    //end of additional constructor

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getExpDueDate() {
        return expDueDate.toString();
    }

    public String getCompletionDate() {
        return completionDate.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    //code to set the completion date
    public Date setCompletionDate(String compDate){
        Date completed = null;
        try {
            completed = new SimpleDateFormat("yyyy-MM-dd").parse(compDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return completed;
    }
    //end of code to set the completion date

    @Override
    public String toString(){
        return String.format("Title: %s\nDescription: %s\nExpected due date: %s\n Actual Completed date: %s",
                title, description, expDueDate, completionDate);
    }

}
