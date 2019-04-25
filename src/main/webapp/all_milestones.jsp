<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="model.Project, model.MilestoneBoard, model.Milestone" %>
<%@ page import="database.H2Milestone, database.H2Project, database.H2User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Milestone</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            float: left;
            position: relative;
        }

        .col-lg-6{
            left: 0;
            height: 100%;

        }

        .row{
            width: 100%;
            height: 200%;
            margin-left: 0;
        }
        .container-fluid{
            width: 100%;
            height: 500px;
            padding-left: -15px;
            font-family: 'Montserrat', sans-serif;
            overflow: auto;
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

        <!--form div-->
        <div class="col-lg-6">
                <h1>${projectName}: All Milestones</h1>

                    <c:forEach var="milestone" items="${milestones}">
                        <c:out value="${milestone.title}"/> <br>
                        <p><strong>Description</strong>: ${milestone.description}</p><br>
                        <p><strong>Due Date</strong>: ${milestone.expDueDate}</p><br>
                        <p><strong>Completed Date</strong>: ${milestone.completionDate}</p><br>
                        <%

                            Object mile = pageContext.getAttribute("milestone");
                            Milestone tester = (Milestone) mile;
                            String status = "incomplete";
                            if(tester.getCompletionDate().before(tester.getExpDueDate())){
                                status = "complete";
                            }
                            else if(tester.getCompletionDate().equals(tester.getExpDueDate()) && tester.getCompletionDate().before(new Date())){
                                status = "complete";
                            }
                            pageContext.setAttribute("status", status);
                        %>
                        <p><strong>Status</strong>: ${status}</p><br>
                        <hr>
                    </c:forEach>

                <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=${projectName}&userid=${userid}">Back to project</a>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
