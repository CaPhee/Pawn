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
import form.DanhSachPhieuChuocForm;
import model.bean.ChiTietPhieuChuocDo;
import model.bo.PhieuChuocBO;

/**
 * DanhSachChiTietPhieuChuocAction.java
 *
 * Version 1.0
 *
 * Date: Aug 3, 2016
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Aug
 * 3, 2016 QuyenHT Create
 */

public class DanhSachChiTietPhieuChuocAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (Detail.nullValue((String) session.getAttribute("userName"))) {
			return mapping.findForward("login");
		}

		// lay danh sach chi tiet phieu cam va tra ve dsChiTiet
		DanhSachPhieuChuocForm dsChiTietChuocForm = (DanhSachPhieuChuocForm) form;
		PhieuChuocBO pchbo = new PhieuChuocBO();
		ArrayList<ChiTietPhieuChuocDo> listctc = new ArrayList<ChiTietPhieuChuocDo>();
		String maPhieuChuoc = request.getParameter("mapch");
		listctc = pchbo.getListChiTietPhieuChuoc(maPhieuChuoc);
		dsChiTietChuocForm.setMaPhieuChuoc(maPhieuChuoc);
		dsChiTietChuocForm.setListChiTietChuoc(listctc);

		return mapping.findForward("dsChiTietChuoc");

	}
}
