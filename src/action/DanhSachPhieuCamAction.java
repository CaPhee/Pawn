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
import model.bean.PhieuCamDo;
import model.bo.PhieuCamBO;

/**
 * DanhSachPhieuCamAction.java
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

public class DanhSachPhieuCamAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (Detail.nullValue((String) session.getAttribute("userName"))) {
			return mapping.findForward("login");
		}
		DanhSachPhieuCamForm dsPCAForm = (DanhSachPhieuCamForm) form;
		
		//lay danh sach phieu cam
		PhieuCamBO dspcabo = new PhieuCamBO();
		ArrayList<PhieuCamDo> dspca = dspcabo.getListPhieuCam();
		dsPCAForm.setDsPhieuCam(dspca);
		return mapping.findForward("dsPhieuCam");
	}
}
