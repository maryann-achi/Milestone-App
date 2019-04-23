<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>

<html>
<head>
    <title>Dashboard</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            /*float: left;*/
            padding: 5px;
        }
        .imgdiv {
            width: 50%;
            height: 100%;
            float: left;
            padding: 10px;
        }
    </style>
</head>
<%--<% SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy"); %>--%>
<%--<h1>Welcome to Tomcat! Today is <%= sdf.format(new Date()) %></h1>--%>
<body>
<div class="imgdiv">
    <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
</div>
<div>
    <h1>${dashName}: Remove Project(s)</h1>
    <form name="remove_project_form" action="RemoveProjectServlet" method="post">


            <c:forEach var="project" items="${projects}">
                <input type="checkbox" name="removals" value="${project.title}"> ${project.title} <br>
                <%--<c:out value="${project.title}"/> <br>--%>
                <hr>
            </c:forEach>

        <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
        <input type= "submit" value= "OK" onclick="successMsg()"/> <a href="${pageContext.request.contextPath}/dashboards">back to projects</a>
    </form>
</div>
</body>
</html>
