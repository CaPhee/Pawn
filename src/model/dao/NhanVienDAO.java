package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.NhanVien;

/**
 * NhanVienDAO.java
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
 * Aug  3, 2016        	UyenLB         Create
 */

public class NhanVienDAO {
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
	 * dua ra danh sach NhanVien 
	 * @return danh sach nhan vien 
	 * @exception SQLException
	 */
	public ArrayList<NhanVien> getListNhanVien() {
		connect();
		ResultSet rs =null;
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			// lay du lieu tu bang NHANVIEN
			ps = connection.prepareStatement("select MaNV,TenNV from NHANVIEN");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				NhanVien nv = new NhanVien();
				nv.setManv(rs.getString("MaNV"));
				nv.setTennv(rs.getString("TenNV"));
				dsNV.add(nv);
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
		return dsNV;
	}

}
