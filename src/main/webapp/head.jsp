<%--
  Created by IntelliJ IDEA.
  User: machieng15
  Date: 4/22/2019
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">


<head>
    <title>Title</title>
    <style type="text/css">
        a {
            text-decoration: none;
        }

        .first{
            width: 100%;
            height: 75px;
            top: 0;
            margin-left: 700px;
            background-color: #E25F6D;
            float: right;
            padding: 20px;
            margin: 0;
            font-family: 'Montserrat', sans-serif;
            /*position: fixed;*/
        }

        .first ul {
            background: #E25F6D;
            list-style: none;
            margin: 0;
            padding-left: 0;
        }

        li {
            color: #fff;
            background: #E25F6D;
            display: block;
            float: right;
            padding: 1rem;
            position: relative;
            text-decoration: none;
            transition-duration: 0.5s;
            margin-right: 0;
        }

        li a {
            color: #fff;
            text-decoration: none;
        }

        a:hover{
            color: black;
            text-decoration: none;
        }

        li:hover {
            background: white;
            cursor: pointer;
            color: black;
        }

        ul li ul {
            background: #E25F6D;
            visibility: hidden;
            opacity: 0;
            min-width: 5rem;
            position: absolute;
            transition: all 0.5s ease;
            margin-top: 1rem;
            left: 0;
            display: none;
        }

        ul li:hover > ul,
        ul li ul:hover {
            visibility: visible;
            opacity: 1;
            display: block;
        }

        ul li ul li {
            clear: both;
            width: 100%;
        }

    </style>
</head>
<body>
<div class="navigate">
    <ul class="first">
        <li><a href="<%=request.getContextPath()%>/LogoutServlet">LOGOUT</a></li>
        <li><a href="dashboard.jsp">HOME</a></li>
    </ul>
</div>
</body>
</html>
