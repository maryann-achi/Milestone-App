<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet" type="text/css" href="css/style.css"/>

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">



<head>
    <meta charset="UTF-8">
    <title>Add Milestone</title>
    <style>
        .halfimg {
            width: 100%;
            height: 100%;
            object-fit: cover;
            float: left;
            position: relative;
        }

        .col-lg-6{
            left: 0;
            height: 100%;
            /*margin-top: 100px;*/

        }

        .row{
            width: 100%;
            height: 200%;
            margin-left: 0;
        }
        .container-fluid{
            width: 100%;
            height: 500px;
            padding-left: -15px;
            font-family: 'Montserrat', sans-serif;
        }

        .mform{
            width: 100%;
            font-size: 15px;
        }
        .mform a:link, a:visited {
            background-color: #E25F6D;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }

        .mform a:hover, a:active {
            background-color: #E25F6D;
            color: #121212;
            margin-top: 20px;
        }


    </style>
</head>
<body>
<!--image div-->
    <jsp:include page="head.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <img src="composition-materials-notebook-760710.jpg" alt="projects for image" class="halfimg">
            </div>

            <!--form div-->
            <div class="col-lg-6">
                <h1><%= request.getParameter("projectTitle") %>: Add new Milestone</h1>
                <!--this form adds a new project to the dashboard once completed-->
                <form class="mform" name="add_milestone_form" action="AddMilestoneServlet" method="post">

                    <label>
                        Title <br>
                        <input type="text" name="milestoneTitle" required/>
                    </label><br>
                    <label>
                        Description <br>
                        <input type="text" name="milestoneDesc" required/>
                    </label><br>

                    <label>
                        Due Date <br>
                        <input type="date" name="milestoneDue" required/>
                    </label><br>

                    <label>
                        Project
                        <!--input for the project, must always be checked-->
                        <input type="hidden" name="projTitle" value="<%= request.getParameter("projectTitle") %>" > <br>
                        <input type="hidden" name="userid" value="<%= request.getParameter("userid") %>" ><br>
                    </label><br>

                    <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                    <input type= "submit" value= "OK"/><br>
                    <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=<%= request.getParameter("projectTitle")%>&userid=<%= request.getParameter("userid")%>">Back to project</a>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
