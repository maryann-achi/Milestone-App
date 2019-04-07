package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Milestone {
    static final Logger lOG = LoggerFactory.getLogger(Milestone.class);

    private String title, description;
    private Date expDueDate, completionDate;

    public Milestone(String theTitle, String theDescription, Date dueDate, Date compdate){
        title = theTitle;
        description = theDescription;
        expDueDate = dueDate;
        completionDate = compdate;
    }

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

    @Override
    public String toString(){
        return String.format("Title: %s\nDescription: %s\nExpected due date: %s\n Actual Completed date: %s",
                title, description, expDueDate, completionDate);
    }
}
