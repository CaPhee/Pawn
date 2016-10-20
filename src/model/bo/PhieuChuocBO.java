package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietPhieuChuocDo;
import model.bean.PhieuChuocDo;
import model.dao.PhieuChuocDAO;
/**
 * PhieuChuocBO.java
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
 */
public class PhieuChuocBO {
	PhieuChuocDAO pchdao = new PhieuChuocDAO();
	/**
	 * PHIEU CHUOC DO
	 * @return ListPhieuChuoc
	 */
	public ArrayList<PhieuChuocDo> getListPhieuChuoc() {		
		 return pchdao.getListPhieuChuoc();
	}
/**
 * them phieu chuoc
 * @param maPhieuChuoc
 * @param maPhieuCam
 * @param ngayChuocThucTe
 * @param maNV
 * @param maKH
 * @return themPhieuChuoc
 */
	public boolean themPhieuChuoc(String maPhieuChuoc, String maPhieuCam,
			String ngayChuocThucTe, String maNV, String maKH) {
		return pchdao.themPhieuChuoc(maPhieuChuoc,maPhieuCam,ngayChuocThucTe,maNV,maKH);
		
	}
/**
 * them chi tiet phieu chuoc
 * @param maPhieuChuoc
 * @param tensp
 * @param soLuong
 * @param soTienChuoc
 * @param soNgayQuaHan
 * @return themChiTietPhieuChuoc
 */
	public boolean themChiTietPhieuChuoc(String maPhieuChuoc, String tensp, int soLuong, double soTienChuoc,
			int soNgayQuaHan) {
		return pchdao.themChiTietPhieuChuoc(maPhieuChuoc,tensp,soLuong,soTienChuoc);
	}
public String getMaPhieuCam(String maPhieuChuoc) {
		return pchdao.getMaPhieuCam(maPhieuChuoc);
}
public ArrayList<ChiTietPhieuChuocDo> getListChiTietPhieuChuoc(String maPhieuChuoc) {
	return pchdao.getListCTPhieuCam(maPhieuChuoc);
}

	

}
