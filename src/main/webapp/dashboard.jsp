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

                    <h1>${user.getName()}: All Projects</h1>
                    <c:forEach var="project" items="${projects}">
                        <%--<c:out value="${project.title}"/> <br>--%>
                        <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=${project.title}">${project.title}</a><br>
                        <hr>
                    </c:forEach>
                    Id: ${user.id}

                    <a href="AddProjectServlet?userid=${user.id}"> add project</a>

                    <a href="<%=request.getContextPath()%>/RemovalServlet"> remove project</a>

                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
