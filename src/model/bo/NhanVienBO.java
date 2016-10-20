package model.bo;

import java.util.ArrayList;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;
/**
 * NhanVienBO.java
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
public class NhanVienBO {
	NhanVienDAO nvdao = new NhanVienDAO();
	/**
	 * danh sach nhan vien
	 * @return ListNhanVien
	 */
	public ArrayList<NhanVien> getListNhanVien() {
		return nvdao.getListNhanVien();
	}

}
