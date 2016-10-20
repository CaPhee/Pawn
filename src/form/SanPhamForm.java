package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.SanPham;
@SuppressWarnings("serial")
public class SanPhamForm extends ActionForm {
	private String maSP;
	private String tenSP;
	private String soLuong;
	private String tinhTrang;
	private String maDM;
	private String maPhieuCam;
	private String maPhieuChuoc;
	private String action;
	private ArrayList<SanPham> listSanPham;
	private String submit;
	private SanPham sanpham;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public String getMaPhieuCam() {
		return maPhieuCam;
	}
	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
	}
	public String getMaPhieuChuoc() {
		return maPhieuChuoc;
	}
	public void setMaPhieuChuoc(String maPhieuChuoc) {
		this.maPhieuChuoc = maPhieuChuoc;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ArrayList<SanPham> getListSanPham() {
		return listSanPham;
	}
	public void setListSanPham(ArrayList<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

}
