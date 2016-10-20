package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SanPham;

/**
 * SanPhamDAO.java
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
 * Aug  3, 2016        	NhuTT         Create
 */

public class SanPhamDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	PreparedStatement ps;
	/**
	 * ket noi co so du lieu
	 */
	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}
	
	/**
	 * dua radanh sach SanPham                    	
	 * @return danh sach SanPham
	 *@exception SQLException
	 */

	public ArrayList<SanPham> getListSanPham() {
		connect();
		// lay du lieu tu bang SANPHAM 
		String sql = "select * from SANPHAM";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		SanPham sanPham;
		try {
			while (rs.next()) {
				sanPham = new SanPham();
				sanPham.setMasp(rs.getString("MaSP"));
				sanPham.setTensp(rs.getString("TenSP"));
				sanPham.setSoLuong(rs.getString("SoLuong"));
				sanPham.setSotienCam(rs.getBigDecimal("SoTienCam"));
				sanPham.setTinhTrang(rs.getString("TinhTrang"));
				sanPham.setMadm(rs.getString("MaDM"));
				sanPham.setMaPhieuCam(rs.getString("MaPhieuCam"));
				sanPham.setMaPhieuChuoc(rs.getString("MaPhieuChuoc"));

				list.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
		return list;
	}
	
	/**
	 * dua radanh sach SanPham                	
	 * @param maPhieuCam
	 * @return  danh sách  Sản Phẩm  
	  *@exception  SQLException
	 */

	public ArrayList<SanPham> getListSanPham(String maPhieuCam) {
		connect();
		String sql = "select * from SANPHAM where MaPhieuCam='"+maPhieuCam+"'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		SanPham sanPham;
		try {
			while (rs.next()) {
				sanPham = new SanPham();
				sanPham.setMasp(rs.getString("MaSP"));
				sanPham.setTensp(rs.getString("TenSP"));
				sanPham.setSoLuong(rs.getString("SoLuong"));
				sanPham.setSotienCam(rs.getBigDecimal("SoTienCam"));
				sanPham.setTinhTrang(rs.getString("TinhTrang"));
				sanPham.setMadm(rs.getString("MaDM"));
				sanPham.setMaPhieuCam(rs.getString("MaPhieuCam"));
				sanPham.setMaPhieuChuoc(rs.getString("MaPhieuChuoc"));

				list.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
		return list;
	}
	
	/**
	 * cap nhat San Pham
	 * @return danh sách sản phẩm 
	 *  @exception  SQLException 
	 */

	public ArrayList<SanPham> capNhatSanPham() {
		connect();
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ps = connection.prepareStatement("exec sp_UpdateSanPham");
			
			ps.executeUpdate();
			dsSP = getListSanPham();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
		return dsSP;
	}

}
