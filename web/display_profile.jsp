<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Profile</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body class="profile-body">

    <!-- INTRO SECTION -->
    <div class="intro-container">
        <h1>
            Hi, my name is 
            <span class="highlight"><%= request.getAttribute("name") %></span>
        </h1>

        <h2>A little bit about me</h2>

        <p class="intro-text">
            <%= request.getAttribute("intro") %>
        </p>
    </div>

    <!-- DETAILS SECTION -->
    <div class="details-card">
        <h3>My Details</h3>

        <div class="details-grid">

            <div class="detail-item">
                <span class="label">Student ID</span>
                <span class="value"><%= request.getAttribute("studentId") %></span>
            </div>

            <div class="detail-item">
                <span class="label">Program</span>
                <span class="value"><%= request.getAttribute("program") %></span>
            </div>

            <div class="detail-item">
                <span class="label">Email</span>
                <span class="value"><%= request.getAttribute("email") %></span>
            </div>

            <div class="detail-item">
                <span class="label">Hobbies</span>
                <span class="value"><%= request.getAttribute("hobbies") %></span>
            </div>

        </div>
    </div>

</body>
</html>