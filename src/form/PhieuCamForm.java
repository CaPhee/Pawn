package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KhachHang;
import model.bean.LaiSuat;
import model.bean.NhanVien;

@SuppressWarnings("serial")
public class PhieuCamForm extends ActionForm {
	private String maPhieuCam;
	private String ngayCam;
	private String ngayChuocDuKien;
	private String maKH;
	private ArrayList<KhachHang> dsKhachHang;
	private String maNV;
	private ArrayList<NhanVien> dsNhanVien;
	private String tensp;
	private int soLuong;
	private double soTienCam;
	private String maLS;
	private ArrayList<LaiSuat> dsLaiSuat;
	private String moTa;
	private String hinhAnh;
	private String button;
	private String thongBao;

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public String getMaLS() {
		return maLS;
	}

	public void setMaLS(String maLS) {
		this.maLS = maLS;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaPhieuCam() {
		return maPhieuCam;
	}

	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
	}

	public String getNgayCam() {
		return ngayCam;
	}

	public void setNgayCam(String ngayCam) {
		this.ngayCam = ngayCam;
	}

	public String getNgayChuocDuKien() {
		return ngayChuocDuKien;
	}

	public void setNgayChuocDuKien(String ngayChuocDuKien) {
		this.ngayChuocDuKien = ngayChuocDuKien;
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getSoTienCam() {
		return soTienCam;
	}

	public void setSoTienCam(double soTienCam) {
		this.soTienCam = soTienCam;
	}

	public ArrayList<LaiSuat> getDsLaiSuat() {
		return dsLaiSuat;
	}

	public void setDsLaiSuat(ArrayList<LaiSuat> dsLaiSuat) {
		this.dsLaiSuat = dsLaiSuat;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors=new ActionErrors();
		return actionErrors;
	}
}
