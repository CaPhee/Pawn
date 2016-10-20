package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.LaiSuat;

/**
 * LaiSuatDAO.java
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
 * Aug  3, 2016        	QuyNH          Create
 */

public class LaiSuatDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	PreparedStatement ps = null;
	/**
	 * ket noi co so du lieu
	 */
	void connect() {
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
	 * dua ra danh sach LaiSuat
	 * @exception SQLException
	 * @return  dsLS(danh sach lai suat)
	 */
	public ArrayList<LaiSuat> getListLaiSuat() {
		connect();
		ResultSet rs =null;
		ArrayList<LaiSuat> dsLS = new ArrayList<LaiSuat>();
		try {
			//lay du lieu tu bang LAISUAT
			ps = connection.prepareStatement("select *from LAISUAT");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				LaiSuat ls = new LaiSuat();
				ls.setMals(rs.getString("MaLS"));
				ls.setTenls(rs.getString("TenLS"));
				dsLS.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return dsLS;
	}

}
