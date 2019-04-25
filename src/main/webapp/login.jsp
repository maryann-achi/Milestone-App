<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-04-05
  Time: 05:13
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
    <title>Login Page</title>
    <style type="text/css">
        body{
            background:linear-gradient(0deg,rgba(89,37,43,0.5),rgba(89,37,43,0.5)),url("celebration-close-up-color-1930384.jpg");
            background-size:cover;
        }
        #navigation{
            margin-top: 20px;
        }

        ul{
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        li{
            display: inline;
            float: right;
            margin-right: 20px;
        }
        a{
            display: block;
        }
        a:link, a:visited{
            background-color: #121212;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        a:hover, a:active{
            background-color: white;
            color: #121212;
        }

        .form-horizontal{
            margin-left: 100%;
            margin-top: 50%;
            width: 100%;
            color: white;
            font-size: 18px;
            font-family: 'Montserrat', sans-serif;
        }

    </style>
</head>
<body>
<div id="navigation">
    <ul>
        <li><a href="login.jsp">Login</a></li>
    </ul>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6"></div>
        <div class="col-md-6">
            <form class="form-horizontal" action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="inputUsername3" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputUsername3" placeholder="name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" value="login" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
