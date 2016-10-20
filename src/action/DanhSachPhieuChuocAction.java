package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachPhieuChuocForm;
import model.bean.PhieuChuocDo;
import model.bo.PhieuChuocBO;

/**
 * DanhSachPhieuChuocAction.java
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
 *  Aug 3, 2016        	QuyenHT         Create
 */

public class DanhSachPhieuChuocAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest requests,
			HttpServletResponse response) {
		DanhSachPhieuChuocForm dsPCHForm = (DanhSachPhieuChuocForm) form;
		
		//lay danh sach phieu chuoc
		PhieuChuocBO dspchbo = new PhieuChuocBO();
		ArrayList<PhieuChuocDo> dspch = dspchbo.getListPhieuChuoc();
		dsPCHForm.setDsPhieuChuoc(dspch);
		return mapping.findForward("dsPhieuChuoc");
	}
}

