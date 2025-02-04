package com.homepage.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/homepage")
public class Home extends HttpServlet {
	private static final String DB_URL = "jdbc:orcale:thin:@localhost:1521:xe";
	private static final String DB_USER = "parth";
	private static final String DB_PASSWORD = "parth";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String firstName = req.getParameter("first-name");
		String middleName = req.getParameter("middle-name");
		String lastName = req.getParameter("last-name");
		String dob = req.getParameter("dob");
		String age = req.getParameter("age");
		String country = req.getParameter("country");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		String pincode = req.getParameter("pincode");
		String grade = req.getParameter("class");
		String marks = req.getParameter("marks");
		String yop = req.getParameter("year-of-passing");
		String collegeName = req.getParameter("college-name");

		Connection connection = null;
		PreparedStatement studentStatement = null;
		PreparedStatement educationStatement = null;

		try {
			RequestDispatcher dispatcher;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				String studentInfoQuery = "INSERT INTO studentInfo (firstname, middlename, lastname, dob, age, country, state, city, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				studentStatement = connection.prepareStatement(studentInfoQuery);
				studentStatement.setString(1, firstName);
				studentStatement.setString(2, middleName);
				studentStatement.setString(3, lastName);
				studentStatement.setDate(4, java.sql.Date.valueOf(dob));
				studentStatement.setString(5, age);
				studentStatement.setString(6, country);
				studentStatement.setString(7, state);
				studentStatement.setString(8, city);
				studentStatement.setString(9, pincode);
				studentStatement.executeUpdate();

				String educationQuery = "INSERT INTO educationinfo (grade, marks, yop, collegename) VALUES (?, ?, ?, ?)";
				educationStatement = connection.prepareStatement(educationQuery);
				educationStatement.setString(1, grade);
				educationStatement.setString(2, marks);
				educationStatement.setString(3, yop);
				educationStatement.setString(4, collegeName);
				int count = educationStatement.executeUpdate();

				if (count > 0) {
					out.print("<h3 style='color:green'>Student's Information saved Successfully!!</h3>");
				} else {
					out.print("<h3 style='color:red'>Some error occured</h3>");
				}
				dispatcher = req.getRequestDispatcher("/index.jsp");
				dispatcher.include(req, resp);	
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Exception Occured: " + e.getMessage() + "</h3>");
				dispatcher = req.getRequestDispatcher("/index.jsp");
				dispatcher.include(req, resp);
			}
		} finally {
			try {
				if (educationStatement != null) {
					educationStatement.close();
				}
				if (studentStatement != null) {
					studentStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
