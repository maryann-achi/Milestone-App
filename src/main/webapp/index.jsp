<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">


<head>
    <title>The first page</title>
    <style type="text/css">
        body{
            background-image: url("celebration-close-up-color-1930384.jpg");
        }
        .login{
            margin: auto;
            width: 60%;
            border: black;
            padding: 20px;
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

    </style>
</head>
<body>
<div id="navigation">
            <ul>
                <li><a href="login.jsp">Login</a></li>
                <li> <a href="">Help</a></li>
            </ul>
</div>
<div class="topic">
    <jsp:include page="header.html"></jsp:include>
</div>
</body>
</html>
