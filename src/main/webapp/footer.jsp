<%--
  Created by IntelliJ IDEA.
  User: machieng15
  Date: 4/8/2019
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<head>
<style type="text/css">
    .foot{
        background-color: #923F48;
        height: 50px;
        width: 100%;
        bottom: 0;
        position: fixed;
        padding: 20px;
    }

</style>
</head>
<body>
<div class="foot">
<p align="center">
    Last updated: <%= new java.util.Date() %>
</p>
</div>
</body>
</html>
