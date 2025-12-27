<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ProfileBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Saved</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="profile-body">

    <% 
        ProfileBean currentUser = (ProfileBean) request.getAttribute("profile");
    %>

    <div class="intro-container">
        <h1>Profile Saved!</h1>
        <h2>Hi, <span class="highlight"><%= currentUser.getName() %></span></h2>
        <p class="intro-text">
            <%= currentUser.getIntro() %>
        </p>
        
        <br>
        <form action="ViewProfilesServlet" method="get">
            <button type="submit">View All Profiles</button>
        </form>
    </div>

    <div class="details-card">
        <h3>My Details</h3>
        <div class="details-grid">
            <div class="detail-item">
                <span class="label">Student ID</span>
                <span class="value"><%= currentUser.getStudentId() %></span>
            </div>
            <div class="detail-item">
                <span class="label">Program</span>
                <span class="value"><%= currentUser.getProgram() %></span>
            </div>
            <div class="detail-item">
                <span class="label">Email</span>
                <span class="value"><%= currentUser.getEmail() %></span>
            </div>
            <div class="detail-item">
                <span class="label">Hobbies</span>
                <span class="value"><%= currentUser.getHobbies() %></span>
            </div>
        </div>
    </div>
</body>
</html>