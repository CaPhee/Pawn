package action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Detail;
import form.PhieuCamForm;
import model.bean.KhachHang;
import model.bean.LaiSuat;
import model.bean.NhanVien;
import model.bo.KhachHangBO;
import model.bo.LaiSuatBO;
import model.bo.NhanVienBO;
import model.bo.PhieuCamBO;

/**
 * ThemPhieuCamnAction.java
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

public class ThemPhieuCamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		HttpSession session = request.getSession();
		if(Detail.nullValue((String)session.getAttribute("userName"))){
			return mapping.findForward("login");
		}
		request.setCharacterEncoding("UTF-8");
		PhieuCamForm phieuCamForm = (PhieuCamForm) form;
		KhachHangBO khbo = new KhachHangBO();
		NhanVienBO nvbo = new NhanVienBO();
		LaiSuatBO lsbo = new LaiSuatBO();

		PhieuCamBO pcbo ;
		//lay danh sach khach hang
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		//lay danh sach nhan vien
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		//lay danh sach lai suat
		ArrayList<LaiSuat> dsLS = new ArrayList<LaiSuat>();
		dsKH = khbo.getListKhachHang();
		dsNV = nvbo.getListNhanVien();
		dsLS = lsbo.getListLaiSuat();
		
		String maPhieuCam = phieuCamForm.getMaPhieuCam();
		String ngayCam = phieuCamForm.getNgayCam();
		String ngayChuocDuKien = phieuCamForm.getNgayChuocDuKien();
		String maNV = phieuCamForm.getMaNV();
		String maKH = phieuCamForm.getMaKH();
		
		phieuCamForm.setDsNhanVien(dsNV);
		phieuCamForm.setDsKhachHang(dsKH);
		phieuCamForm.setDsLaiSuat(dsLS);
		
		ActionErrors actionErrors= new ActionErrors();
		//validate du lieu
		if("Thêm".equals(phieuCamForm.getButton())){
			actionErrors = new ActionErrors();
			if (Detail.nullValue(maPhieuCam)||Detail.nullValue(ngayCam)||Detail.nullValue(ngayChuocDuKien)||Detail.nullValue(maNV)||Detail.nullValue(maKH)){
				actionErrors.add("maPhieuCamError", new ActionMessage("error.maPhieuCam.null"));
			}else if(!Detail.checkDate(ngayCam, ngayChuocDuKien)){
				actionErrors.add("dateError", new ActionMessage("error.date.notValid"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themphieucam");
			}
		}
		//nhan nut them o trangThem phieu cam
		if("Thêm".equals(phieuCamForm.getButton())){			
			
			pcbo= new PhieuCamBO();
			if(!pcbo.themPhieuCam(maPhieuCam,ngayCam,ngayChuocDuKien,maNV,maKH)){
				actionErrors = new ActionErrors();
				actionErrors.add("maPhieuCamError", new ActionMessage("error.maPhieuCam.exists"));
				saveErrors(request, actionErrors);
				return mapping.findForward("themphieucam");
			}else{
				//chuyen sang trang Chi tiet phieu cam
				return mapping.findForward("themchitiet");
			}
			//validate du lieu
		}else if("Thêm chi tiết".equals(phieuCamForm.getButton())){
			maPhieuCam = phieuCamForm.getMaPhieuCam();
			String tensp = phieuCamForm.getTensp();
			int soLuong = phieuCamForm.getSoLuong();
			double soTienCam = phieuCamForm.getSoTienCam();
			String mals = phieuCamForm.getMaLS();
			String moTa = phieuCamForm.getMoTa();
			String hinhAnh = phieuCamForm.getHinhAnh();
			pcbo= new PhieuCamBO();
			actionErrors = new ActionErrors();
			if(Detail.nullValue(tensp)){
				actionErrors.add("chiTietCamError", new ActionMessage("error.chiTietCam.null"));
			}
			if(Detail.notVaildQuatity(String.valueOf(soLuong))){
				actionErrors.add("soLuongError", new ActionMessage("error.chiTietCam.soLuong"));
				
			}
			if(Detail.notVaildMoney((String.valueOf(soTienCam)))){
				actionErrors.add("soTienCamError", new ActionMessage("error.chiTietCam.soTienCam"));
					
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themchitiet");
			}else{
				pcbo.themChiTietPhieuCam(maPhieuCam, tensp, soLuong, soTienCam, mals, moTa, hinhAnh);
				phieuCamForm.setThongBao("Thêm thành công");
				return mapping.findForward("themchitiet");
			}
			//validate du lieu
			//chuyen sang trang Danh sach phieu cam
		}else if("Hoàn tất".equals(phieuCamForm.getButton())){
			maPhieuCam = phieuCamForm.getMaPhieuCam();
			String tensp = phieuCamForm.getTensp();
			int soLuong = phieuCamForm.getSoLuong();
			double  soTienCam = phieuCamForm.getSoTienCam();
			String mals = phieuCamForm.getMaLS();
			String moTa = phieuCamForm.getMoTa();
			String hinhAnh = phieuCamForm.getHinhAnh();
			pcbo= new PhieuCamBO();
			actionErrors = new ActionErrors();
			if(Detail.nullValue(tensp)){
				actionErrors.add("chiTietCamError", new ActionMessage("error.chiTietCam.null"));
			}
			if(Detail.notVaildQuatity(String.valueOf(soLuong))){
				actionErrors.add("soLuongError", new ActionMessage("error.chiTietCam.soLuong"));
				
			}
			if(Detail.notVaildMoney(String.valueOf(soTienCam))){
				actionErrors.add("soTienCamError", new ActionMessage("error.chiTietCam.soTienCam"));

			}

			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				//chuyen sang Them chi tiet phieu cam
				return mapping.findForward("themchitiet");
			}else{
				pcbo.themChiTietPhieuCam(maPhieuCam, tensp, soLuong, soTienCam, mals, moTa, hinhAnh);
				return mapping.findForward("hoantat");
			}
		}
		//chuyen sang Them phieu cam
		else{						
			return mapping.findForward("themphieucam");
		}
	}
}
