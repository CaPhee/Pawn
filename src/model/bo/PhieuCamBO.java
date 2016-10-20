package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietPhieuCamDo;
import model.bean.PhieuCamDo;
import model.dao.PhieuCamDAO;

/**
 * PhieuCamBO.java
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
public class PhieuCamBO {
	PhieuCamDAO pcadao = new PhieuCamDAO();
	/**
	 * danh sach phieu cam
	 * @return ListPhieuCam
	 */ 
	public ArrayList<PhieuCamDo> getListPhieuCam() {		
		 return pcadao.getListPhieuCam();
	}
/**
 * chi tiet phieu cam
 * @param mapca
 * @return ListCTPhieuCam
 */
	public ArrayList<ChiTietPhieuCamDo> getListChiTietPhieuCam(String mapca) {
		return pcadao.getListCTPhieuCam(mapca);
	}
/**
 * them phieu cam
 * @param maPhieuCam
 * @param ngayCam
 * @param ngayChuocDuKien
 * @param maNV
 * @param maKH
 * @return themPhieuCam
 */
	public boolean themPhieuCam(String maPhieuCam, String ngayCam, String ngayChuocDuKien, String maNV, String maKH) {
		return pcadao.themPhieuCam(maPhieuCam,ngayCam,ngayChuocDuKien,maNV,maKH);
		
	}
/**
 * them chi tiet phieu cam
 * @param maPhieuCam
 * @param tensp
 * @param soLuong
 * @param soTienCam
 * @param mals
 * @param moTa
 * @param hinhAnh
 */
	public void themChiTietPhieuCam(String maPhieuCam, String tensp, int soLuong, double soTienCam, String mals, String moTa, String hinhAnh){
		pcadao.themChiTietPhieuCam(maPhieuCam,tensp,soLuong,soTienCam,mals,moTa,hinhAnh);
		
	}


}
