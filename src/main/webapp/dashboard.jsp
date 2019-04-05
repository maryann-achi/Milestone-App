<%--
      Created by IntelliJ IDEA.
      User: Ari
      Date: 05/04/2019
      Time: 11:38 AM
      To change this template use File | Settings | File Templates.
    --%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html>
        <head>
            <title>Dashboard</title>
        </head>
        <body>
            <c:forEach var="aFruit" items="${projects}">

                 <p> ${aFruit} </p>
            </c>
        </body>
     </html>
