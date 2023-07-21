package com.jsp.JDBC_preparedStatement_CRUD_mobile.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMobileData {
	
	static Connection connection = null;
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the mobile ID ");
		int id = scanner.nextInt();
		
		System.out.println("Enter the name of the mobile");
		String name = scanner.next();

		System.out.println("Enter the color of the mobile");
		String color = scanner.next();

		System.out.println("Enter the price of the mobile ");
		double price = scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root1234";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			String insertQuery = "insert into mobile values(?,?,?,?)";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, color);
			preparedStatement.setDouble(4, price);
			
			preparedStatement.execute();
				
			
			
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
			System.out.println("Data inserted successfully !");
		}
		
		
	}
}
