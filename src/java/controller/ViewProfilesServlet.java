/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import model.ProfileBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ViewProfilesServlet", urlPatterns = {"/ViewProfilesServlet"})
public class ViewProfilesServlet extends HttpServlet {

    private String jdbcURL = "jdbc:derby://localhost:1527/StudentProfileDB;create=true";
    private String jdbcUsername = "app";
    private String jdbcPassword = "app";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProfileBean> listProfile = new ArrayList<>();
        String searchId = request.getParameter("searchId"); // Get search term

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql;
            
            // UNIQUE FEATURE: Logic to switch between Search and View All
            if (searchId != null && !searchId.trim().isEmpty()) {
                sql = "SELECT * FROM profile WHERE studentId LIKE ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + searchId + "%");
            } else {
                sql = "SELECT * FROM profile";
                stmt = conn.prepareStatement(sql);
            }

            rs = stmt.executeQuery();

            // Loop through results and add to List
            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                p.setName(rs.getString("name"));
                p.setStudentId(rs.getString("studentId"));
                p.setProgram(rs.getString("program"));
                p.setEmail(rs.getString("email"));
                p.setHobbies(rs.getString("hobbies"));
                // intro is typically too long for a list view, so we skip it here
                listProfile.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        request.setAttribute("listProfile", listProfile);
        request.getRequestDispatcher("viewProfiles.jsp").forward(request, response);
    }
}




