/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
/* File: src/java/controller/ProfileServlet.java */
package controller;

import model.ProfileBean;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {


    private String jdbcURL = "jdbc:derby://localhost:1527/StudentProfileDB;create=true";
    private String jdbcUsername = "app";
    private String jdbcPassword = "app";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String intro = request.getParameter("intro");


        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStudentId(studentId);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbies(hobbies);
        profile.setIntro(intro);


        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // SQL Insert
            String sql = "INSERT INTO profile (name, studentId, program, email, hobbies, intro) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, studentId);
            stmt.setString(3, program);
            stmt.setString(4, email);
            stmt.setString(5, hobbies);
            stmt.setString(6, intro);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        // 4. Pass the Bean to the View (JSP)
        request.setAttribute("profile", profile);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
