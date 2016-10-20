package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Detail;
import form.KhachHangForm;

/**
 * ThemKhachHangAction.java
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

public class ThemKhachHangAction  extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		request.setCharacterEncoding("UTF-8");
		KhachHangForm khachHangForm= (KhachHangForm) form;
		//validate du lieu
		if("submit".equals(khachHangForm.getSubmit())){
			ActionErrors actionErrors=new ActionErrors();
			if(Detail.nullValue(khachHangForm.getMakh())){
				actionErrors.add("mkhError", new ActionMessage("error.mkh.trong"));				
			}
			if(Detail.nullValue(khachHangForm.getHoTen())){
				actionErrors.add("tenkhError", new ActionMessage("error.tenkh.trong"));				
			}
			if(Detail.notVaildNumbercm(khachHangForm.getCmnd())){
				actionErrors.add("cmndError", new ActionMessage("error.cmnd.trong"));				
			}
			if(Detail.nullValue(khachHangForm.getDiaChi())){
				actionErrors.add("diachiError", new ActionMessage("error.diachi.trong"));				
			}
			if(Detail.notVaildNumber(khachHangForm.getSoDT())){
				actionErrors.add("sodtError", new ActionMessage("error.sodt.trong"));				
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themKH");
			}
		}
		//nhan nut xac nhan o trang Them khach hang
		if("submit".equals(khachHangForm.getSubmit())){
			String makh= khachHangForm.getMakh();
			String hoTen= khachHangForm.getHoTen();
			String cmnd= khachHangForm.getCmnd();
			String diaChi=khachHangForm.getDiaChi();
			String soDT= khachHangForm.getSoDT();
			String tinhTrang=khachHangForm.getTinhTrang();
			KhachHangBO khachHangBO= new KhachHangBO();
			if(khachHangBO.themKhachHang(makh, hoTen, cmnd, diaChi, soDT, tinhTrang)){
				return mapping.findForward("themKHxong");
				//chuyen sang trang Danh sach khach hang
			}else{
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add("mkhError", new ActionMessage("error.mkh.trung"));
				saveErrors(request, actionErrors);
				return mapping.findForward("themKH");
			}	
		}
		else{
			
			return mapping.findForward("themKH");
		}
	}

}
