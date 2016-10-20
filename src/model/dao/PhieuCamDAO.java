package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietPhieuCamDo;
import model.bean.PhieuCamDo;

/**
 * PhieuCamDAO.java
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
 *  Aug 3, 2016        	QuyNH          Create
 */

public class PhieuCamDAO {
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
	* dua ra danh sach Chi tiet phieu cam 
	 * @param maPhieuCam
	 * @return danh sach chi tiet phieu cam
	 *  @exception SQLException
	 */
	
	public ArrayList<ChiTietPhieuCamDo> getListCTPhieuCam(String maPhieuCam) {
		connect();
		ResultSet rs = null;
		ArrayList<ChiTietPhieuCamDo> dsCTPCA = new ArrayList<ChiTietPhieuCamDo>();
		try {
			//lay du lieu tu cac bang PHIEUCAM,CT_PHIEUCAM,LaiSuat
			ps = connection.prepareStatement(
					"select c.TenSP,c.SoLuong,c.SoTienCam,c.MoTa,l.TenLS from PHIEUCAM p inner join CT_PHIEUCAM c "
							+ " on p.MaPhieuCam = c.MaPhieuCam inner join LaiSuat l " + "on c.MaLS = l.MaLS"
							+ " where c.MaPhieuCam = ?");
			ps.setString(1, maPhieuCam);
			rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieuCamDo ctpca = new ChiTietPhieuCamDo();
				ctpca.setTensp(rs.getString("TenSP"));
				ctpca.setSoLuong(rs.getInt("SoLuong"));
				ctpca.setTenls(rs.getString("TenLS"));
				ctpca.setMoTa(rs.getString("MoTa"));
				ctpca.setSoTienCam(rs.getBigDecimal("SoTienCam"));
				dsCTPCA.add(ctpca);
			}
		} catch (SQLException e) {
			System.out.println("Error: getListCTPhieuCam SQL");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: getListCTPhieuCam Null");
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
		return dsCTPCA;
	}

	/**
	 * dua ra danh sach  phieu cam do
	 * @return danh sach phieu cam
	 * @exception SQLException
	 */
	
	public ArrayList<PhieuCamDo> getListPhieuCam() {
		connect();
		ResultSet rs = null;
		ArrayList<PhieuCamDo> dsPCA = new ArrayList<PhieuCamDo>();
		try {
			//lay du lieu tu  bang PHIEUCAM
			ps = connection.prepareStatement(
					"select p.MaPhieuCam,p.NgayCam,p.NgayChuocDuKien,p.MaNV,p.MaKH,p.TongTienCam" + " from PHIEUCAM p");

			rs = ps.executeQuery();
			while (rs.next()) {
				PhieuCamDo pca = new PhieuCamDo();
				pca.setMaPhieuCam(rs.getString("MaPhieuCam"));
				pca.setNgayCam(rs.getString("NgayCam"));
				pca.setNgayChuocDuKien(rs.getString("NgayChuocDuKien"));
				pca.setManv(rs.getString("MaNV"));
				pca.setMakh(rs.getString("MaKH"));
				pca.setTongTienCam(rs.getBigDecimal("TongTienCam"));
				dsPCA.add(pca);
			}
		} catch (SQLException e) {
			System.out.println("Error: getListPhieuCam SQL");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: getListPhieuCam Null");
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
		return dsPCA;
	}

	/**
	 * kiem tra xem da them khach hang chua
	 * @param maPhieuCam
	 * @param ngayCam
	 * @param ngayChuocDuKien
	 * @param maNV
	 * @param maKH
	 * @return true 
	 * @return false
	* @exception SQLException
	 */
	
	public boolean themPhieuCam(String maPhieuCam, String ngayCam, String ngayChuocDuKien, String maNV, String maKH) {
		connect();
		ResultSet rs = null;
		try {
			//lay du lieu tu bang PHIEUCAM
			ps = connection.prepareStatement("select MaPhieuCam from PHIEUCAM where MaPhieuCam=?");
			ps.setString(1, maPhieuCam);

			rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			} else {
				// insert du lieu vao bang PHIEUCAM
				ps = connection.prepareStatement(
						"insert into PHIEUCAM(MaPhieuCam,NgayCam,NgayChuocDuKien,MaNV,MaKH) values(?,?,?,?,?)");

				ps.setString(1, maPhieuCam);
				ps.setString(2, ngayCam);
				ps.setString(3, ngayChuocDuKien);
				ps.setString(4, maNV);
				ps.setString(5, maKH);

				ps.executeUpdate();

				return true;
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
		return false;
	}

	/**
	*  them  chi tiet phieu cam
	 * @param maPhieuCam
	 * @param tensp
	 * @param soLuong
	 * @param soTienCam
	 * @param mals
	 * @param moTa
	 * @param hinhAnh
	 *@exception  SQLException
	 */
	public void themChiTietPhieuCam(String maPhieuCam, String tensp, int soLuong, double soTienCam, String mals,
			String moTa, String hinhAnh) {
		connect();
		try {
			// them Chi tiet phieu cam
			ps = connection.prepareStatement("insert into CT_PHIEUCAM(MaPhieuCam,TenSP,SoLuong,SoTienCam,MoTa,HinhAnh,MaLS)"
							+ " values(?,?,?,?,?,?,?)");

			ps.setString(1, maPhieuCam);
			ps.setString(2, tensp);
			ps.setInt(3, soLuong);
			ps.setDouble(4, soTienCam);
			ps.setString(5, moTa);
			ps.setString(6, hinhAnh);
			ps.setString(7, mals);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	}

}
