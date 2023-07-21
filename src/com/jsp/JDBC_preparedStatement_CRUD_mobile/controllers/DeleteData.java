package com.jsp.JDBC_preparedStatement_CRUD_mobile.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	static Connection connection = null;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the mobile Id that you want to delete :");
		int id = scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root1234";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			String deleteQuery = "delete from mobile where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			
			preparedStatement.setInt(1, id);
			
			int a = preparedStatement.executeUpdate();
			
			
			if(a == 1) {
				System.out.println("Product deleted successfully!");
			}else {
				System.err.println("Please enter a valid Id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
