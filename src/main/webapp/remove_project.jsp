<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.*,java.util.*" %>

<html>
<head>
    <title>Remove Project</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            float: left;
<<<<<<< HEAD
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
=======
            /*padding: 5px;*/
        }
>>>>>>> 95fad108da63d650f3b21c5c1cf910aa4479cca3

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

        <div>
            <h1>${dashName}: Remove Project(s)</h1>
            <form name="remove_project_form" action="RemoveProjectServlet" method="post">


                    <c:forEach var="project" items="${projects}">
                        <input type="checkbox" name="removals" value="${project.title}"> ${project.title} <br>

                        <hr>
                    </c:forEach>

                <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                <input type= "submit" value= "OK" onclick="successMsg()"/> <a href="${pageContext.request.contextPath}/dashboards">back to projects</a>
            </form>
        </div>
    </div>
</div>
=======

<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
        </div>
        <div class="col-lg-6">
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

        <jsp:include page="footer.jsp"></jsp:include>
>>>>>>> 95fad108da63d650f3b21c5c1cf910aa4479cca3
</body>
</html>
