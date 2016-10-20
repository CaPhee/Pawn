package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.*;

/**
 * KhachHangDAO.java
 * 
 * Version 1.0
 * 
 * Date: Aug 3, 2016
 * 
 * Copyright
 * 
 * ModificaSStion Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Aug
 * 3, 2016 UyenLB Create
 */

public class KhachHangDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

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
	 * danh sach KhachHang
	 * 
	 * @exception SQLException
	 * @return list ( danh sách KhachHang)
	 */

	public ArrayList<KhachHang> getListKhachHang() {
		connect();
		// lay tu bang KhachHang
		String sql = "SELECT MaKH,TenKH,CMND,DiaChi,SoDT,TinhTrang FROM KHACHHANG";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		KhachHang kh;
		try {
			while (rs.next()) {
				kh = new KhachHang();
				kh.setMakh(rs.getString("MaKH"));
				kh.setTenkh(rs.getString("TenKH"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSodt(rs.getString("SoDT"));
				kh.setTinhTrang(rs.getString("TinhTrang"));
				list.add(kh);
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
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
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
	 * chèn dữ liệu cho Khách Hàng
	 * 
	 * @exception SQLException
	 * @param makh
	 * @return list( danh sach khach hang)
	 */

	public ArrayList<KhachHang> getListKhachHang(String makh) {
		connect();
		String sql = String.format("SELECT * FROM KHACHHANG WHERE MaKH='&s'",
				makh);
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		KhachHang kh;
		try {
			while (rs.next()) {
				kh = new KhachHang();
				kh.setMakh(rs.getString("MaKH"));
				kh.setTenkh(rs.getString("TenKH"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSodt(rs.getString("SoDT"));
				kh.setTinhTrang(rs.getString("TinhTrang"));
				list.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
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
	 * kiem tra them khach hang da duoc hay chua
	 * 
	 * @param makh
	 * @param tenKH
	 * @param cmnd
	 * @param diaChi
	 * @param soDT
	 * @param tinhTrang
	 * @return true or false
	 * @exception SQLException
	 */

	public boolean themKhachHang(String makh, String tenKH, String cmnd,
			String diaChi, String soDT, String tinhTrang) {
		connect();
		ResultSet rs = null;
		String sql = String.format(
				"SELECT MaKH FROM KHACHHANG WHERE MaKH='%s'", makh);
		String sql1 = String.format(
				"INSERT INTO KHACHHANG(MaKH,TenKH,CMND,DiaChi,SoDT,TinhTrang) "
						+ " VALUES ( '%s',N'%s','%s',N'%s','%s','%s')", makh,
				tenKH, cmnd, diaChi, soDT, tinhTrang);
		System.out.println("SQL: " + sql);
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return false;
			} else {
				stmt.executeUpdate(sql1);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
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
	 * lay tat ca thong tin khach hang
	 * 
	 * @param makh
	 * @return khach hang
	 * @exception SQLException
	 */
	public KhachHang getThongTinKhachHang(String makh) {
		connect();
		String sql = String.format("SELECT * FROM KHACHHANG WHERE MaKH='%s'",
				makh);
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		KhachHang kh = new KhachHang();
		try {
			while (rs.next()) {

				kh.setMakh(rs.getString("MaKH"));
				kh.setTenkh(rs.getString("TenKH"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSodt(rs.getString("SoDT"));
				kh.setTinhTrang(rs.getString("TinhTrang"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
		return kh;

	}

	/**
	 * sửa KhachHang
	 * 
	 * @param makh
	 * @param tenKH
	 * @param cmnd
	 * @param diaChi
	 * @param soDT
	 * @param tinhTrang
	 *            * SQLException
	 */

	public void suaKhachHang(String makh, String tenKH, String cmnd,
			String diaChi, String soDT, String tinhTrang) {
		connect();
		String sql = String
				.format("UPDATE KHACHHANG "
						+ " SET TenKH = N'%s', CMND = '%s', DiaChi = N'%s',SoDT='%s',TinhTrang= '%s' "
						+ " WHERE MaKH = '%s'", tenKH, cmnd, diaChi, soDT,
						tinhTrang, makh);
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
				connection = null;
			}
		}
	}

	/**
	 * xoa khach hang
	 * 
	 * @param makh
	 *            SQLException
	 */

	public void xoaKhachHang(String makh) {
		connect();
		Statement stmt = null;
		String sql = String.format("DELETE FROM KHACHHANG WHERE MaKH = '%s'",
				makh);
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}
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
