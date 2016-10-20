package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Detail;
import form.PhieuChuocForm;
import model.bean.KhachHang;
import model.bean.NhanVien;
import model.bean.PhieuCamDo;
import model.bean.SanPham;
import model.bo.KhachHangBO;
import model.bo.NhanVienBO;
import model.bo.PhieuCamBO;
import model.bo.PhieuChuocBO;
import model.bo.SanPhamBO;

/**
 * ThemPhieuChuocAction.java
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
 *  Aug 3, 2016        	QuyenHT          Create
 */

public class ThemPhieuChuocAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest requests, HttpServletResponse response)
			throws UnsupportedEncodingException {
		requests.setCharacterEncoding("UTF-8");
		PhieuChuocForm phieuChuocForm = (PhieuChuocForm) form;
		KhachHangBO khbo = new KhachHangBO();
		NhanVienBO nvbo = new NhanVienBO();
		PhieuCamBO pcbo = new PhieuCamBO();
		SanPhamBO spbo = new SanPhamBO();
		PhieuChuocBO pchbo = new PhieuChuocBO();
		//lay danh sach khach hang
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		//lay danh sach nhan vien
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		//lay danh sach phieu cam do
		ArrayList<PhieuCamDo> dsMaPC = new ArrayList<PhieuCamDo>();
		dsKH = khbo.getListKhachHang();
		dsNV = nvbo.getListNhanVien();
		dsMaPC = pcbo.getListPhieuCam();
		/* set may cái list chop trang thêm */
		phieuChuocForm.setDsNhanVien(dsNV);
		phieuChuocForm.setDsKhachHang(dsKH);
		phieuChuocForm.setDsPhieuCam(dsMaPC);
		String maPhieuChuoc = phieuChuocForm.getMaPhieuChuoc();
		
		String maPhieuCam = phieuChuocForm.getMaPhieuCam();
		String ngayChuocThucTe = phieuChuocForm.getNgayChuocThucTe();
		String maNV = phieuChuocForm.getMaNV();
		String maKH = phieuChuocForm.getMaKH();
		ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
		
		dsSanPham = new ArrayList<SanPham>();
		
		dsSanPham = spbo.getListSanPham(maPhieuCam);
		ActionErrors actionErrors;
		//validate du lieu
		// nhan nut them o trang them phieu chuoc
		if ("Thêm".equals(phieuChuocForm.getButton())) {
			actionErrors = new ActionErrors();
			if (Detail.nullValue(phieuChuocForm.getMaPhieuChuoc())||Detail.nullValue(ngayChuocThucTe)) {
				actionErrors.add("maPhieuChuocError", new ActionMessage(
						"error.maPhieuChuoc.null"));
			}
			saveErrors(requests, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("themphieuchuoc");
			}
		}
		if ("Thêm".equals(phieuChuocForm.getButton())) {
			
			pchbo = new PhieuChuocBO();
			if(!pchbo.themPhieuChuoc(maPhieuChuoc, maPhieuCam, ngayChuocThucTe,
					maNV, maKH)) {
				actionErrors = new ActionErrors();
				actionErrors.add("maPhieuChuocError", new ActionMessage(
						"error.maPhieuChuoc.exists"));
				saveErrors(requests, actionErrors);
				return mapping.findForward("themphieuchuoc");
			} else {			
				phieuChuocForm.setThongBao("Thêm thành công");
				phieuChuocForm.setDsSanPham(dsSanPham);
				return mapping.findForward("themchitietchuoc");
			}
			//validate du lieu
			//nhan nut Them chi tiet o trang Chi tiet phieu chuoc
		} else if ("Thêm chi tiết".equals(phieuChuocForm.getButton())) {    
			maPhieuCam= pchbo.getMaPhieuCam(maPhieuChuoc);
			dsSanPham = spbo.getListSanPham(maPhieuCam);
			phieuChuocForm.setMaPhieuCam(maPhieuCam);
			phieuChuocForm.setDsSanPham(dsSanPham);
			maPhieuChuoc = phieuChuocForm.getMaPhieuChuoc();
			String tensp = phieuChuocForm.getTensp();
			int soLuong = phieuChuocForm.getSoLuong();
			double soTienChuoc = phieuChuocForm.getSoTienChuoc();
			int soNgayQuaHan = phieuChuocForm.getSoNgayQuaHan();
			pchbo = new PhieuChuocBO();
			if(pchbo.themChiTietPhieuChuoc(maPhieuChuoc, tensp, soLuong,
					soTienChuoc, soNgayQuaHan)){
				//chuyen sang trang  Them chi tiet phieu chuoc
				phieuChuocForm.setThongBao("Thêm thành công");
				return mapping.findForward("themchitietchuoc");
			}else{
				actionErrors = new ActionErrors();
				actionErrors.add("themPhieuChuocError", new ActionMessage(
						"error.themphieuchuoc.soluong"));
				saveErrors(requests, actionErrors);
				return mapping.findForward("themchitietchuoc");
			}
			
		}else if("Hoàn tất".equals(phieuChuocForm.getButton())){
			maPhieuCam= pchbo.getMaPhieuCam(maPhieuChuoc);
			dsSanPham = spbo.getListSanPham(maPhieuCam);
			phieuChuocForm.setMaPhieuCam(maPhieuCam);
			phieuChuocForm.setDsSanPham(dsSanPham);
			maPhieuChuoc = phieuChuocForm.getMaPhieuChuoc();
			String tensp = phieuChuocForm.getTensp();
			int soLuong = phieuChuocForm.getSoLuong();
			double soTienChuoc = phieuChuocForm.getSoTienChuoc();
			int soNgayQuaHan = phieuChuocForm.getSoNgayQuaHan();
			pchbo = new PhieuChuocBO();
			if(pchbo.themChiTietPhieuChuoc(maPhieuChuoc, tensp, soLuong,
					soTienChuoc, soNgayQuaHan)){
				return mapping.findForward("hoantat");
			}else{
				actionErrors = new ActionErrors();
				actionErrors.add("themPhieuChuocError", new ActionMessage(
						"error.themphieuchuoc.soluong"));
				saveErrors(requests, actionErrors);
				return mapping.findForward("themchitietchuoc");
			}
			
		}
		else {
			//chuyen sang trang  Them phieu chuoc
			return mapping.findForward("themphieuchuoc");
		}
	}
}
