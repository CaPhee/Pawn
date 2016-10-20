package model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ThongKe;

/**
 * ThongKeDAO.java
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
 *  */

public class ThongKeDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyCamDo;";
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
			connection = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi sql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi class not found");
		}
	}
	/**
	 * dua ra danh sach  Thong ke
	 * @param tuNgay
	 * @param denNgay
	 * @return danh sach Thong ke
	 * @exception SQLException
	 */
	
	public ArrayList<ThongKe> getListDaChuoc(String tuNgay, String denNgay) {
		connect();
		ResultSet rs = null;
		ArrayList<ThongKe> dsThongKe = new ArrayList<ThongKe>();
		try {
			//lay du lieu tu cac bang SANPHAM,PHIEUCAM,CT_PHIEUCAM,PHIEUCHUOC,CT_PHIEUCHUOC
			ps = connection.prepareStatement("SELECT distinct s.TenSP,c.MaNV,c.NgayCam,s.TinhTrang,pch.SoTienChuoc as TienLai "
					+ "from SANPHAM s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN CT_PHIEUCAM pc "
					+ "on pc.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam "
					+ "FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc "
					+ "where s.TinhTrang=N'Đã chuộc' and c.NgayCam between  ? and ?");
			ps.setString(1, tuNgay);
			ps.setString(2, denNgay);
			rs = ps.executeQuery();
			
			int stt = 1;
			while(rs.next()){
				ThongKe tk = new ThongKe();				
				tk.setStt(stt);
				tk.setTensp(rs.getString("TenSP"));
				tk.setTennv(rs.getString("MaNV"));
				tk.setNgayCam(rs.getString("NgayCam"));
				tk.setTinhTrang(rs.getString("TinhTrang"));
				tk.setTienLai(rs.getBigDecimal("TienLai"));			
				dsThongKe.add(tk);
				stt++;
			}
		} catch (SQLException e) {
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
		return dsThongKe;
	}
	
	/**
	 * danh sach Thong Ke theo ngay (tu ngay đen ngay)
	 * @param tuNgay
	 * @param denNgay
	 * @return null
	 * @exception SQLException
	 */
	public ArrayList<ThongKe> getListTienLai(String tuNgay, String denNgay) {
		connect();
		ResultSet rs = null;
		ArrayList<ThongKe> dsThongKe = new ArrayList<ThongKe>();
		try {
			ps = connection.prepareStatement("SELECT distinct s.TenSP,c.MaNV,c.NgayCam,s.TinhTrang, "
					+ "(ISNULL(pch.SoTienChuoc,pc.SoTienCam)-pc.SoTienCam) as TienLai "
					+ "from SANPHAM s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam "
					+ "FULL OUTER JOIN CT_PHIEUCAM pc on pc.MaPhieuCam = c.MaPhieuCam "
					+ "FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam  "
					+ "FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc "
					+ "where s.TenSP is not null and c.NgayCam between ? and ?");
			ps.setString(1, tuNgay);
			ps.setString(2, denNgay);
			rs = ps.executeQuery();
			int stt = 1;
			while(rs.next()){
				ThongKe tk = new ThongKe();
				tk.setStt(stt);
				tk.setTensp(rs.getString("TenSP"));
				tk.setTennv(rs.getString("MaNV"));
				tk.setNgayCam(rs.getString("NgayCam"));
				tk.setTinhTrang(rs.getString("TinhTrang"));
				tk.setTienLai(rs.getBigDecimal("TienLai"));
				dsThongKe.add(tk);
				stt++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKe;
	}


	/**
	* danh sach Thong ke theo ngay(tu ngay den ngay)=
	 * @param tuNgay
	 * @param denNgay
	 * @return danh sach Thong ke
	 * @exception SQLException
	 */
	
	public ArrayList<ThongKe> getListKhongChuoc(String tuNgay, String denNgay) {
		connect();
		ResultSet rs = null;
		ArrayList<ThongKe> dsThongKe = new ArrayList<ThongKe>();
		try {
			//lay du lieu tu cac bang SANPHAMQUAHAN,PHIEUCAM,CT_PHIEUCAM,PHIEUCHUOC,CT_PHIEUCHUOC
			ps = connection.prepareStatement("SELECT distinct s.TenSP,c.MaNV,c.NgayCam,N'Quá hạn' as TinhTrang,ISNULL(pch.SoTienChuoc,0)  as TienLai "
					+ "from SANPHAMQUAHAN s FULL OUTER JOIN PHIEUCAM c on s.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN CT_PHIEUCAM pc "
					+ "on pc.MaPhieuCam = c.MaPhieuCam FULL OUTER JOIN PHIEUCHUOC ch on c.MaPhieuCam = ch.MaPhieuCam "
					+ "FULL OUTER JOIN CT_PHIEUCHUOC pch on pch.MaPhieuChuoc = ch.MaPhieuChuoc "
					+ "where s.MaSP is not null and c.NgayCam between ? and ?");
			ps.setString(1, tuNgay);
			ps.setString(2, denNgay);
			rs = ps.executeQuery();
			int stt = 1;
			while(rs.next()){
				ThongKe tk = new ThongKe();
				tk.setStt(stt);
				tk.setTensp(rs.getString("TenSP"));
				tk.setTennv(rs.getString("MaNV"));
				tk.setNgayCam(rs.getString("NgayCam"));
				tk.setTinhTrang(rs.getString("TinhTrang"));
				tk.setTienLai(rs.getBigDecimal("TienLai"));
				dsThongKe.add(tk);
				stt++;
			}
		} catch (SQLException e) {
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
		return dsThongKe;
	}
	public BigDecimal tinhTongLai(ArrayList<ThongKe> dsThongKe) {
		BigDecimal tongLai = new BigDecimal(0);
		for(int i = 0;i< dsThongKe.size();i++){
			ThongKe tk = new ThongKe();
			tk= dsThongKe.get(i);
			tongLai = tongLai.add(tk.getTienLai());
		}
		return tongLai;
	}

	

}
