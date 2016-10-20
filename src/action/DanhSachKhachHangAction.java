package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Detail;

import form.DanhSachKhachHangForm;

/**
 * DanhSachKhachHangAction.java
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

public class DanhSachKhachHangAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		DanhSachKhachHangForm khachHangForm = (DanhSachKhachHangForm) form;
		// lay danh sach sinh vien
		ArrayList<KhachHang> listKhachHang;
		KhachHangBO khachHangBO = new KhachHangBO();
		listKhachHang = khachHangBO.getListKhachHang();
		khachHangForm.setListKhachHang(listKhachHang);
		return mapping.findForward("dsKhachHang");
	}

}
