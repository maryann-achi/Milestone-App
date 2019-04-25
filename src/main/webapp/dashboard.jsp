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

<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">



<head>
        <title>Dashboard</title>
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

            .col-lg-6 a:link, a:visited{
                color: #121212;
                text-decoration: none;
            }

            .col-lg-6 a:hover, a:active {
                color: #121212;
                text-decoration: none;
            }

            .add a:link, a:visited {
                background-color: #E25F6D;
                color: #121212;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                margin-top: 20px;
            }

            .add a:hover, a:active {
                background-color: #E25F6D;
                color: #121212;
                margin-top: 20px;
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

        </style>
    </head>
    <%--<% SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy"); %>--%>
    <%--<h1>Welcome to Tomcat! Today is <%= sdf.format(new Date()) %></h1>--%>
    <body>

        <jsp:include page="head.jsp"></jsp:include>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
                </div>
                <div class="col-lg-6">

                    <h1>Projects</h1>
                    <c:forEach var="project" items="${projects}">
                        <%--<c:out value="${project.title}"/> <br>--%>
                        <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=${project.title}&userid=${userid}">${project.title}</a><br>
                        <hr>
                    </c:forEach>
                    <%--Id: ${user.id}--%>


                    <div class="add">

                    <a href="add_project.jsp?userid=${userid}"> Add project</a>

                    <a href="<%=request.getContextPath()%>/RemovalServlet?userid=${userid}"> Remove project</a>

                    </div>

                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
