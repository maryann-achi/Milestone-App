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
             <h1>${url}</h1>

    <a href="add_milestone.html">add milestone</a>
    <input type= "submit" value= "OK"/> <br> <a href="/dashboards">back to projects</a>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
