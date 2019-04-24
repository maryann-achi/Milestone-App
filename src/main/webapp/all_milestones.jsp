<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Milestone</title>
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
                        <hr>
                    </c:forEach>

                <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=${projectName}">back to project</a>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
