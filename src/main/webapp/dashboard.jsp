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
        <title>Dashboard</title>
        <style>
            .halfimg {
                width: 500px;
                height: 500px;
                object-fit: cover;
                float: left;
                padding: 5px;
            }
        </style>
    </head>
    <%--<% SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy"); %>--%>
    <%--<h1>Welcome to Tomcat! Today is <%= sdf.format(new Date()) %></h1>--%>
    <body>
        <div>
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>
        <div>
            <h1>${dashName}</h1>
            <c:forEach var="project" items="${projects}">
                <%--<c:out value="${project.title}"/> <br>--%>
                <a href="<%=request.getContextPath()%>/MilestoneServlet?name=${project.title}">${project.title}</a><br>
                <hr>
            </c:forEach>

            <a href="add_project.html"> add project</a>

            <a href="<%=request.getContextPath()%>/RemovalServlet"> remove project</a>
        </div>
    </body>
</html>
