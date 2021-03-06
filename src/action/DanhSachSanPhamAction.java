package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Detail;

import form.DanhSachSanPhamForm;
import model.bean.SanPham;
import model.bo.SanPhamBO;

/**
 * DanhSachSanPhamAction.java
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

public class DanhSachSanPhamAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping , ActionForm form,
			HttpServletRequest request , HttpServletResponse response)
	        throws Exception {
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		DanhSachSanPhamForm sanphamForm = (DanhSachSanPhamForm) form;
		//lau danh sach san pham
		ArrayList<SanPham> listSanPham ;
		SanPhamBO sanPhamBO= new SanPhamBO();
		listSanPham = sanPhamBO.getListSanPham();
		sanphamForm.setListSanPham(listSanPham);	
		return mapping.findForward("dsSanPham");
	}
}
