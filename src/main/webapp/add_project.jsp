<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>
<html lang="en">
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
                <form name="add_project_form" action="AddProjectServlet" method="post">
                    <!--label for the project title-->
                    <label>
                        title
                        <!--input box for the project title-->
                        <input type="text" name="projectTitle"/>
                    </label><br>
                    <!--label for the project description-->
                    <label>
                        description
                        <!--input box for the project title-->
                        <input type="text" name="projectDesc"/>
                    </label><br>
                    <input type="radio" name="userid" value="<%= request.getParameter("userid") %>" checked> <%= request.getParameter("userid") %> <br>
                    <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                    <input type= "submit" value= "OK"/> <a href="/dashboards">back to projects</a>
                </form>
            </div>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
