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
            width: 500px;
            height: 500px;
            object-fit: cover;
            float: left;
            padding: 5px;
        }
    </style>
</head>

<body>
<div>
    <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
</div>
<div>
    <h1>${url}</h1>

    <a href="add_milestone.html">add milestone</a>
    <input type= "submit" value= "OK"/> <a href="/dashboards">back to projects</a>
</div>
</body>
</html>
