<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="model.Project, model.MilestoneBoard, model.Milestone" %>
<%@ page import="database.H2Milestone, database.H2Project, database.H2User" %>

<html>
<head>
    <title>Edit Milestone</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            float: left;
            position: relative;
            /*padding-right: 5px;*/
        }

        .col-lg-6{
            left: 0;

        }

        .row{
            width: 100%;
            margin-left: 0;
        }
        .container-fluid{
            width: 100%;
            padding-left: -15px;
        }

    </style>
</head>

<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>

        <div>
            <%
                //initialise both the milestone and project database objects
                H2Project h2Project = new H2Project();
                H2Milestone h2Milestone = new H2Milestone();

                int userid = Integer.parseInt(request.getParameter("userid"));
                String projectName = request.getParameter("projectTitle");
                List<Project> theProjects = h2Project.findProjects(userid);

                int id = 0;
                List<Milestone> theMilestones = null;
                for(Project proj: theProjects){
                    if(proj.getTitle().equals(projectName)){
                        id = proj.getId();
                        theMilestones = h2Milestone.findMilestones(id);
                    }
                }

                pageContext.setAttribute("userid", userid);
                pageContext.setAttribute("theMilestones", theMilestones);
            %>

            <h1>Edit Milestone(s)</h1>
            <form name="edit_milestone_form" action="EditMilestoneServlet" method="post">

                <p>select a milestone to edit</p>
                <c:forEach var="milestone" items="${theMilestones}">
                    <input type="radio" name="edit" value="${milestone.id}" required> ${milestone.title} <br>
                    <hr>
                </c:forEach>
                <br>
                <p>enter your changes below</p>
                <label>
                    add actual completion date
                    <input type="date" name="milestoneComplete" required/><br>
                </label>

                <label>
                    <!--input for the project, must always be checked-->
                    <input type="hidden" name="projTitle" value="<%= request.getParameter("projectTitle") %>"> <br>
                    <input type="hidden" name="userid" value="<%= request.getParameter("userid")%>"><br>
                </label><br>

                <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                <input type= "submit" value= "OK"/><br>
                <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=<%= request.getParameter("projectTitle")%>&userid=<%= request.getParameter("userid")%>">Back to project</a>
            </form>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
