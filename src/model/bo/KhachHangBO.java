package model.bo;

import java.util.ArrayList;

import model.bean.KhachHang;
import model.dao.KhachHangDAO;
/**
 * KhachHangBO.java
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
 *  Aug 3, 2016        	UyenLB          Create
 */
public class KhachHangBO {
	KhachHangDAO khachHangDAO= new KhachHangDAO();
	/**
	 * goi khach hang o khachHangDAO
	 * @return ListKhachHang
	 */
	public ArrayList<KhachHang> getListKhachHang(){
		return khachHangDAO.getListKhachHang();
	}
	/**
	 *  goi ham kiem tra them khach hang o khachHangDAO
	 * @param makh
	 * @param tenKH
	 * @param cmnd
	 * @param diaChi
	 * @param soDT
	 * @param tinhTrang
	 * @return true, false
	 */
	public boolean themKhachHang(String makh, String tenKH, String cmnd, String diaChi, String soDT, String tinhTrang){
		
		return khachHangDAO.themKhachHang(makh, tenKH, cmnd, diaChi, soDT, tinhTrang);
			
	}
	/**
	 * goi ham sua khach hang o khachHangDAO
	 * @param makh
	 * @param tenKH
	 * @param cmnd
	 * @param diaChi
	 * @param soDT
	 * @param tinhTrang
	 */
	
	public void suaKhachHang(String makh, String tenKH, String cmnd, String diaChi, String soDT, String tinhTrang){
		khachHangDAO.suaKhachHang(makh, tenKH, cmnd, diaChi, soDT, tinhTrang);
	}
	/**
	 *  goi ham xoa khach hang o khachHangDAO
	 * @param makh
	 */
	public void xoaKhachHang(String makh){
		khachHangDAO.xoaKhachHang(makh);
	}
	/**
	 *  goi ham thong tin cua khach hang o khachHangDAO
	 * @param makh
	 * @return thong tin khach hang
	 */
	public KhachHang getThongTinKhachHang(String makh) {
		return khachHangDAO.getThongTinKhachHang(makh);
	}
	

}
