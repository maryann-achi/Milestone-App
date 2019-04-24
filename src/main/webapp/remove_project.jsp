<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>

<html>

<link rel="stylesheet" type="text/css" href="css/style.css"/>

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">



<head>
    <title>Remove Project</title>
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

<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>
        <div class="col-lg-6">
            <h1>${user.getName()} Remove Project(s)</h1>
            <form name="remove_project_form" action="RemoveProjectServlet" method="post">


                <c:forEach var="project" items="${projects}">
                    <input type="checkbox" name="removals" value="${project.title}"> ${project.title} <br>
                    <%--<c:out value="${project.title}"/> <br>--%>
                    <hr>
                </c:forEach>
                <input type="hidden" name="userid" value="<%= request.getParameter("userid") %>"><br>
                <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                <input type= "submit" value= "OK" onclick="successMsg()"/> <br>
                <a href="${pageContext.request.contextPath}/dashboards?userid=<%= request.getParameter("userid") %>">Back to projects</a>
            </form>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
