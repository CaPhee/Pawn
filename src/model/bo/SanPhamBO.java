package model.bo;
import java.util.ArrayList;

import model.bean.SanPham;
import model.dao.SanPhamDAO;
/**
 * SanPhamBO.java
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
 *  Aug 3, 2016        	NhuTT          Create
 */
public class SanPhamBO {
	SanPhamDAO sanPhamDAO = new SanPhamDAO();
	/**
	 * danh sachsan pham
	 * @return ArrayList<SanPham>
	 */
     public ArrayList<SanPham> getListSanPham(){
		return sanPhamDAO.getListSanPham();
     }
/**
 * cap nhat san pham
 * @return capNhatSanPham
 */
	public ArrayList<SanPham> capNhatSanPham() {
		return sanPhamDAO.capNhatSanPham();
	}
	/**
	 * Danh sachsan pham
	 * @param maPhieuCam
	 * @return ListSanPham
	 */
	public ArrayList<SanPham> getListSanPham(String maPhieuCam) {
		return sanPhamDAO.getListSanPham(maPhieuCam);
	}
    
}