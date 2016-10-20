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

import form.DanhSachPhieuCamForm;
import model.bean.ChiTietPhieuCamDo;
import model.bo.PhieuCamBO;

/**
 * DanhSachChiTietPhieuCamAction.java
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

public class DanhSachChiTietPhieuCamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		
		//lay danh sach chi tiet phieu cam va tra ve dsChiTiet
		DanhSachPhieuCamForm dsChiTietCamForm = (DanhSachPhieuCamForm) form;
		PhieuCamBO pcbo = new PhieuCamBO();
		ArrayList<ChiTietPhieuCamDo> listct = new ArrayList<ChiTietPhieuCamDo>();
		String maPhieuCam = request.getParameter("ma");
		listct = pcbo.getListChiTietPhieuCam(maPhieuCam);
		dsChiTietCamForm.setMaPhieuCam(maPhieuCam);
		dsChiTietCamForm.setListChiTietCam(listct);
		
		return mapping.findForward("dsChiTiet");
		
	}
}
