package action;

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

import form.KhachHangForm;
/**
 * SuaKhachHangAction.java
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
public class SuaKhachHangAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		request.setCharacterEncoding("UTF-8");
		KhachHangForm khachHangForm= (KhachHangForm) form;
		
		KhachHangBO khachHangBO = new KhachHangBO();
		String makh= khachHangForm.getMakh();
		if("submit".equals(khachHangForm.getSubmit())){
			String hoTen= khachHangForm.getHoTen();
			String cmnd= khachHangForm.getCmnd();
			String diaChi= khachHangForm.getDiaChi();
			String soDT= khachHangForm.getSoDT();
			String tinhTrang= khachHangForm.getTinhTrang();
			khachHangBO.suaKhachHang(makh, hoTen, cmnd, diaChi, soDT, tinhTrang);
			return mapping.findForward("suaKHxong");
		}
		else {
			KhachHang khachHang= khachHangBO.getThongTinKhachHang(makh);
			khachHangForm.setHoTen(khachHang.getTenkh());
			khachHangForm.setCmnd(khachHang.getCmnd());
			khachHangForm.setDiaChi(khachHang.getDiaChi());
			khachHangForm.setSoDT(khachHang.getSodt());
			khachHangForm.setTinhTrang(khachHang.getTinhTrang());
			return mapping.findForward("suaKH");
		}
	}

}
