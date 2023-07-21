package com.jsp.JDBC_preparedStatement_CRUD_mobile.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAllMobile {
	static Connection connection = null;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root1234";

			connection = DriverManager.getConnection(url, user, pass);

			String displayQuery = "select * from mobile";

			PreparedStatement preparedStatement = connection.prepareStatement(displayQuery);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String color = resultSet.getNString("color");
				double price = resultSet.getDouble("price");
				System.out.println("Mobile Id = " + id + " Mobile Name = " + name + " Mobile Price = " + price
						+ " Mobile Color = " + color);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
