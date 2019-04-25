<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<html lang="en">

<link rel="stylesheet" type="text/css" href="css/style.css"/>

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">



<head>
    <meta charset="UTF-8">
    <title>Add New Project</title>

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

        .pform{
            width: 100%;
            font-size: 15px;
        }
        .pform a:link, a:visited {
            background-color: #E25F6D;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }

        .pform a:hover, a:active {
            background-color: #E25F6D;
            color: #121212;
            margin-top: 20px;
        }

    </style>

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<!--image div-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
            </div>

            <!--form div-->
            <div class="col-lg-6">
                <h1>Add new Project</h1>
                <!--this form adds a new project to the dashboard once completed-->
                <form  class="pform" name="add_project_form" action="AddProjectServlet" method="post">
                    <!--label for the project title-->
                    <label>
                        Project Title <br>
                        <!--input box for the project title-->
                        <input type="text" name="projectTitle" required/>
                    </label><br>
                    <!--label for the project description-->
                    <label>
                        Project Description <br>
                        <!--input box for the project title-->
                        <input type="text" name="projectDesc" />
                    </label><br>
                    <input type="hidden" name="userid" value="<%= request.getParameter("userid") %>"><br>
                    <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                    <input type= "submit" value= "OK"/><br>
                    <%--<a href="dashboard.jsp">Back to projects</a>--%>
                    <a href="<%=request.getContextPath()%>/dashboards?userid=<%= request.getParameter("userid") %>">Back to projects</a>
                </form>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
