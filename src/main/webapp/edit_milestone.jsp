<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<%@ page import="model.Project, model.MilestoneBoard, model.Milestone" %>

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
                Project project = MilestoneBoard.getInstance("Arit's Board").getProjectByName(request.getParameter("projectTitle"));
                List<Milestone> theMilestones = project.getMilestones();
                String dashName2 = MilestoneBoard.getInstance("Arit's Board").getName();
                pageContext.setAttribute("dashName2", dashName2);
                pageContext.setAttribute("theMilestones", theMilestones);
            %>

            <h1> ${dashName2}: Remove Milestone(s)</h1>
            <form name="edit_milestone_form" action="EditMilestoneServlet" method="post">


                <label>
                    milestone to edit
                    <input type="text" name="edit"><br>
                </label>
                <br>
                <p>enter your changes below</p>
                <label>
                    add actual completion date
                    <input type="date" name="milestoneComplete"/><br>
                </label>

                <label>
                    project
                    <!--input for the project, must always be checked-->
                    <input type="radio" name="projTitle" value="<%= request.getParameter("projectTitle") %>" checked> <%= request.getParameter("projectTitle") %> <br>
                </label><br>

                <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                <input type= "submit" value= "OK"/> <a href="${pageContext.request.contextPath}/dashboards">back to projects</a>
            </form>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
