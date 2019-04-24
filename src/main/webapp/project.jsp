<%--
      Created by IntelliJ IDEA.
      User: Ari
      Date: 05/04/2019
      Time: 11:38 AM
      To change this template use File | Settings | File Templates.
    --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
    <title>${url}</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            float: left;
<<<<<<< HEAD
            position: relative;
            /*padding-right: 5px;*/
=======
>>>>>>> 95fad108da63d650f3b21c5c1cf910aa4479cca3
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
<<<<<<< HEAD
    <jsp:include page="head.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
            </div>
            <div class="col-lg-6">
                <div>
                    <h1>${url}</h1>
                    <%--I will send the project name as part of the url to retrieve it along with the form--%>
                    <a class ="btn" href="<%=request.getContextPath()%>/add_millestone.jsp?projectTitle=${url}">add milestone</a><br>
                    <a class ="btn" href="<%=request.getContextPath()%>/remove_milestone.jsp?projectTitle=${url}">remove milestone</a><br>
                    <a class ="btn" href="<%=request.getContextPath()%>/edit_milestone.jsp?projectTitle=${url}">edit milestone</a><br>
                    <a class ="btn" href="<%=request.getContextPath()%>/RemoveMilestoneServlet?projectTitle=${url}">all milestones</a>

                    <a href="<%=request.getContextPath()%>/dashboards">back to projects</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
=======
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>
        <div class="col-lg-6">
             <h1>${url}</h1>

    <a href="add_milestone.html">add milestone</a>
    <input type= "submit" value= "OK"/> <br> <a href="/dashboards">back to projects</a>
</div>

<jsp:include page="footer.jsp"></jsp:include>
>>>>>>> 95fad108da63d650f3b21c5c1cf910aa4479cca3
</body>
</html>
