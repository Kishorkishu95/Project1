package com.wct.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String connectionUsername = "root";
		String connectionPassword = "root";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to the DB : " +connectionUrl);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
			out.print("Done...");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
