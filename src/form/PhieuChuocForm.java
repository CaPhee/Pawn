package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KhachHang;
import model.bean.NhanVien;
import model.bean.PhieuCamDo;
import model.bean.SanPham;

@SuppressWarnings("serial")
public class PhieuChuocForm extends ActionForm {
	private String maPhieuCam;
	private ArrayList<PhieuCamDo> dsPhieuCam;
	private String maPhieuChuoc;
	private String ngayChuocThucTe;
	private String maKH;
	private ArrayList<KhachHang> dsKhachHang;
	private String maNV;
	private ArrayList<NhanVien> dsNhanVien;
	private String masp;
	private String tensp;
	private ArrayList<SanPham> dsSanPham;
	private int soLuong;
	private double soTienChuoc;
	private int soNgayQuaHan;
	private String button;
	private String thongBao;

	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public String getMaPhieuCam() {
		return maPhieuCam;
	}
	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
	}

	public ArrayList<PhieuCamDo> getDsPhieuCam() {
		return dsPhieuCam;
	}

	public void setDsPhieuCam(ArrayList<PhieuCamDo> dsPhieuCam) {
		this.dsPhieuCam = dsPhieuCam;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}

	public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public String getMaPhieuChuoc() {
		return maPhieuChuoc;
	}

	public void setMaPhieuChuoc(String maPhieuChuoc) {
		this.maPhieuChuoc = maPhieuChuoc;
	}

	public String getNgayChuocThucTe() {
		return ngayChuocThucTe;
	}

	public void setNgayChuocThucTe(String ngayChuocThucTe) {
		this.ngayChuocThucTe = ngayChuocThucTe;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getSoTienChuoc() {
		return soTienChuoc;
	}

	public void setSoTienChuoc(double soTienChuoc) {
		this.soTienChuoc = soTienChuoc;
	}

	public int getSoNgayQuaHan() {
		return soNgayQuaHan;
	}

	public void setSoNgayQuaHan(int soNgayQuaHan) {
		this.soNgayQuaHan = soNgayQuaHan;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
