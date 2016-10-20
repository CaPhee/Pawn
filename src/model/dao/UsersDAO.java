package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UsersDAO.java
 *
 * Version 1.0
 *
 * Date: Aug 3, 2016
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Aug  3, 2016        	QuyNH         Create
 */

public class UsersDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	PreparedStatement ps =null;
	/**
	 * ket noi co so du lieu
	 */
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi sql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi class not found");
		}
	}
	/**
	 *  Kiem tra checkLogin 
	 *  @return true or false 
	 *  @exception SQLException
	 */
	public boolean checkLogin(String userName, String password) {
		connect();
		ResultSet rs = null;
		// lay du lieu tu bang USERS
		try {
			ps = connection.prepareStatement("SELECT username FROM USERS WHERE username = ? AND password = ?");
			ps.setString(1,userName);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error: UserDAO SQL checkLogin");
			e.printStackTrace();
		} catch(NullPointerException e){
			System.out.println("Error: UserDAO Null checkLogin");
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
		return false;
	}
}
