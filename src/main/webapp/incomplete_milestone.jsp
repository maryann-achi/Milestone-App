<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="model.Project, model.MilestoneBoard, model.Milestone" %>
<%@ page import="database.H2Milestone, database.H2Project, database.H2User" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Incomplete Milestone</title>
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
            font-family: 'Montserrat', sans-serif;
        }

        .col-lg-6 a:link, a:visited {
            background-color: #E25F6D;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }

        .col-lg-6 a:hover, a:active {
            background-color: #E25F6D;
            color: #121212;
            margin-top: 20px;
        }

    </style>
</head>
<body>
<!--image div-->
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>

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
            pageContext.setAttribute("projectName", projectName);
        %>
        <div class="col-lg-6">
            <h1>${projectName}: Incomplete Milestones</h1>

            <c:forEach var="milestone" items="${theMilestones}">
                <%

                    Object mile = pageContext.getAttribute("milestone");
                    Milestone tester = (Milestone) mile;
                    String mtitle = tester.getTitle();
                    String mDescription = tester.getDescription();
                    Date mExp = tester.getExpDueDate();
                    Date mAct = tester.getCompletionDate();
                    String status = "incomplete";
                    if(tester.getCompletionDate().before(tester.getExpDueDate())){
                        status = "complete";
                        break;
                    }
                    else if(tester.getCompletionDate().equals(tester.getExpDueDate()) && tester.getCompletionDate().before(new Date())){
                        status = "complete";
                        break;
                    }
                    else{

                        out.println("<p>"+mtitle+"</p><br>");
                        out.println("<p><strong>Description</strong>: "+mDescription+"</p><br>");
                        out.println("<p><strong>Due Date</strong>: "+mExp+"</p><br>");
                        out.println("<p><strong>Completion Date</strong>: "+mAct+"</p><br>");
                        out.println("<hr>");
                    }
                %>
            </c:forEach>

            <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=${projectName}&userid=${userid}">Back to project</a>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
