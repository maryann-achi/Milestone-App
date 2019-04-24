<!DOCTYPE html>
<html lang="en">
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
                <form name="add_milestone_form" action="AddMilestoneServlet" method="post">

                    <label>
                        title
                        <input type="text" name="milestoneTitle"/>
                    </label><br>
                    <label>
                        description
                        <input type="text" name="milestoneDesc"/>
                    </label><br>

                    <label>
                        due date
                        <input type="date" name="milestoneDue"/>
                    </label><br>

                    <label>
                        project
                        <!--input for the project, must always be checked-->
                        <input type="radio" name="projTitle" value="<%= request.getParameter("projectTitle") %>" checked> <%= request.getParameter("projectTitle") %> <br>
                    </label><br>

                    <!--submit button, triggers confirmation message once clicked and send form answers to post method-->
                    <input type= "submit" value= "OK"/>
                    <a href="<%=request.getContextPath()%>/MilestoneMenuServlet?name=<%= request.getParameter("projectTitle") %>">back to project</a>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
