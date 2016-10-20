package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietPhieuChuocDo;
import model.bean.PhieuChuocDo;

/**
 * PhieuChuocDAO.java
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
 *  Aug 3, 2016        	QuyenHT          Create
 *  */

public class PhieuChuocDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo;";
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
	 * danh sach  Chi tiet phieu chuoc
	 * @return danh sach chi tiet phieu chuoc
	 * @exception SQLException
	 */
	
	public ArrayList<ChiTietPhieuChuocDo> getListCTPhieuChuoc(
			String maPhieuChuoc) {
		connect();
		ResultSet rs = null;
		ArrayList<ChiTietPhieuChuocDo> dsCTPCH = new ArrayList<ChiTietPhieuChuocDo>();
		try {
			// lay du lieu tu cac bang SANPHAMQUAHAN,KHACHHANG,PHIEUCHUOC,CT_PHIEUCHUOC
			ps = connection
					.prepareStatement("select ct.TenSP,ct.SoLuong,q.SoTienCam, ct.SoTienChuoc,ct.SoNgayQuaHan "
							+ "from SANPHAMQUAHAN as q JOIN KHACHHANG as k ON q.MaKH=k.MaKH "
							+ "JOIN PHIEUCHUOC as pc ON k.MaKH= pc.MaKH "
							+ "JOIN CT_PHIEUCHUOC as ct ON pc.MaPhieuChuoc = ct.MaPhieuChuoc"
							+ " where c.MaPhieuChuoc = ?");
			ps.setString(1, maPhieuChuoc);
			rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieuChuocDo ctpch = new ChiTietPhieuChuocDo();
				ctpch.setTensp(rs.getString("TenSP"));
				ctpch.setSoLuong(rs.getInt("SoLuong"));
				ctpch.setSoTienChuoc(rs.getBigDecimal("SoTienChuoc"));
				dsCTPCH.add(ctpch);
			}
		} catch (SQLException e) {
			System.out.println("Error: getListCTPhieuChuoc SQL");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: getListCTPhieuChuoc Null");
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
		return dsCTPCH;
	}

	/**
	 * danh sach  phieu chuoc do
	 * @return danh sach phieu chuoc
	 * @exception SQLException
	 */
	
	public ArrayList<PhieuChuocDo> getListPhieuChuoc() {
		connect();
		ResultSet rs = null;
		ArrayList<PhieuChuocDo> dsPCH = new ArrayList<PhieuChuocDo>();
		try {
			// lay du lieu tu bang  PHIEUCHUOC
			ps = connection
					.prepareStatement("select pch.MaPhieuChuoc,pch.MaNV,pch.MaKH,pch.NgayChuocThucTe,pch.TongTienChuoc,pch.MaPhieuCam"
							+ " from PHIEUCHUOC pch");

			rs = ps.executeQuery();
			while (rs.next()) {
				PhieuChuocDo pch = new PhieuChuocDo();
				pch.setMaPhieuChuoc(rs.getString("MaPhieuChuoc"));
				pch.setManv(rs.getString("MaNV"));
				pch.setMakh(rs.getString("MaKH"));
				pch.setTongTienChuoc(rs.getBigDecimal("TongTienChuoc"));
				pch.setNgayChuocThucTe(rs.getString("NgayChuocThucTe"));
				pch.setMaPhieuCam(rs.getString("MaPhieuCam"));
				dsPCH.add(pch);
			}
		} catch (SQLException e) {
			System.out.println("Error: getListPhieuChuoc SQL");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: getListPhieuChuoc Null");
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
		return dsPCH;
	}


	/**
	 * kiem tra xem da   them  phieu chuoc
	 * @param maPhieuChuoc
	 * @param maPhieuCam
	 * @param ngayChuocThucTe
	 * @param maNV
	 * @param maKH
	 * @return true or false
	 * @exception SQLException
	 */
	public boolean themPhieuChuoc(String maPhieuChuoc, String maPhieuCam,
			String ngayChuocThucTe, String maNV, String maKH) {
		connect();
		ResultSet rs;
		try {
			// lay du lieu tu bang PHIEUCHUOC
			ps = connection
					.prepareStatement("select MaPhieuChuoc from PHIEUCHUOC where MaPhieuChuoc= ?");

			ps.setString(1, maPhieuChuoc);

			rs = ps.executeQuery();
			if (rs.next())
				return false;
			else {
				ps = connection
						.prepareStatement("insert into PHIEUCHUOC(MaPhieuChuoc,MaPhieuCam,NgayChuocThucTe,MaNV,MaKH) values(?,?,?,?,?)");
				ps.setString(1, maPhieuChuoc);
				ps.setString(2, maPhieuCam);
				ps.setString(3, ngayChuocThucTe);
				ps.setString(4, maNV);
				ps.setString(5, maKH);

				ps.executeUpdate();
				return true;
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
		return false;
	}

	/**
	  * kiem traxem da  them  chi tiet phieu chuoc
	 * @param maPhieuChuoc
	 * @param tensp
	 * @param soLuong
	 * @param soTienChuoc
	 * @return true or false
	 * @exception SQLException
	 */
	
	public boolean themChiTietPhieuChuoc(String maPhieuChuoc, String tensp,
			int soLuong, double soTienChuoc) {
		connect();
		ResultSet rs = null;
		try {
			// lay du lieu tu cac bang  CT_PHIEUCAM,PHIEUCHUOC
			ps = connection
					.prepareStatement("select ca.SoLuong from CT_PHIEUCAM ca inner join PHIEUCHUOC pch "
							+ "on ca.MaPhieuCam =pch.MaPhieuCam "
							+ "where MaPhieuChuoc = ?");
			ps.setString(1, maPhieuChuoc);
			rs = ps.executeQuery();
			while(rs.next()) {
				int soLuongCam = rs.getInt("SoLuong");
				if (soLuongCam > soLuong) {
					// them  chi tiet phieu chuoc
					ps = connection
							.prepareStatement("insert into CT_PHIEUCHUOC(MaPhieuChuoc,TenSP,SoLuong,SoTienChuoc)"
									+ "values(?,?,?,?) ");
					ps.setString(1, maPhieuChuoc);
					ps.setString(2, tensp);
					ps.setInt(3, soLuong);
					ps.setDouble(4, soTienChuoc);

					ps.executeUpdate();
					System.out.println("return true");
					return true;
				} else{
					return false;
				}
					
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
		return false;
	}

	public String getMaPhieuCam(String maPhieuChuoc) {
		connect();
		ResultSet rs = null;
		String maPhieuCam = "";
		try {
			ps = connection.prepareStatement("select ca.MaPhieuCam from PHIEUCAM ca inner join PHIEUCHUOC ch"
					+ " on ca.MaPhieuCam = ch.MaPhieuCam "
					+ " where ch.MaPhieuChuoc = ?");
			ps.setString(1, maPhieuChuoc);
			rs  = ps.executeQuery();
			while(rs.next()){
				maPhieuCam = rs.getString("MaPhieuCam");
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
		return maPhieuCam;
	}

	public ArrayList<ChiTietPhieuChuocDo> getListCTPhieuCam(String maPhieuChuoc) {
		connect();
		ResultSet rs = null;
		ArrayList<ChiTietPhieuChuocDo> dsct = new ArrayList<ChiTietPhieuChuocDo>();
		try {
			ps = connection.prepareStatement("Select * from CT_PHIEUCHUOC where MaPhieuChuoc = ?");
			ps.setString(1, maPhieuChuoc);
			rs = ps.executeQuery();
			while(rs.next()){
				ChiTietPhieuChuocDo ctch = new ChiTietPhieuChuocDo();
				ctch.setTensp(rs.getString("TenSP"));
				ctch.setSoLuong(rs.getInt("SoLuong"));
				ctch.setSoTienChuoc(rs.getBigDecimal("SoTienChuoc"));
				ctch.setSoNgayQuaHan(rs.getInt("SoNgayQuaHan"));
				dsct.add(ctch);
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
		return dsct;
	}

}
