#How to run the app#
This is a description of how to run the milestone webapp.

## Requirements
To run the milestone app, you need Java 11, Maven, H2, Tomcat and Intellij. 

## Steps to follow
1. Click on **Clone** to clone the milestonewebapp repository.
2. Open the project on Intellij as a Maven project.
3. Configure Tomcat server(local).
4. Setup the H2 database on intellij - go to View > Tool Windows > Database.
5. Click + and select H2.
6. Enter Name: milestone_db, username: admin, password: admin, URL: jdbc:h2:~/milestone_db
7. Click on **Test Connection** and verify that connection is successful then click ok.
8. Run the project. It should launch the app on the browser.


---

