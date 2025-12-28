<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ProfileBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Directory</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        .search-container { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; color: white; }
        th, td { border: 1px solid rgba(255,255,255,0.3); padding: 12px; text-align: left; }
        th { background-color: rgba(255,255,255,0.2); }
        tr:hover { background-color: rgba(255,255,255,0.1); }
    </style>
</head>
<body class="profile-body">

    <div class="intro-container" style="max-width: 1000px;">
        <h1>Student Directory</h1>

        <div class="search-container">
            <form action="ViewProfilesServlet" method="get">
                <input type="text" name="searchId" placeholder="Enter Student ID..." style="width: 70%; display: inline-block;">
                <button type="submit" style="width: 25%; display: inline-block;">Search</button>
            </form>
            <br>
            <a href="ViewProfilesServlet" style="color: #ffe600;">Show All Students</a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>ID</th>
                    <th>Program</th>
                    <th>Email</th>
                    <th>Hobbies</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<ProfileBean> list = (List<ProfileBean>) request.getAttribute("listProfile");
                    
                    if (list != null && !list.isEmpty()) {
                        for (ProfileBean p : list) {
                %>
                <tr>
                    <td><%= p.getName() %></td>
                    <td><%= p.getStudentId() %></td>
                    <td><%= p.getProgram() %></td>
                    <td><%= p.getEmail() %></td>
                    <td><%= p.getHobbies() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" style="text-align:center;">No profiles found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <br>
        <a href="index.html" style="color: white; text-decoration: underline;">Register New Student</a>
    </div>

</body>
</html>