package model.bean;

import java.math.BigDecimal;

/**
 * ChiTietPhieuChuocDo.java
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

public class ChiTietPhieuChuocDo {
	private String maPhieuChuoc;
	private String tensp;
	private int soLuong;
	private BigDecimal soTienChuoc;
	private int soNgayQuaHan = 0;

	public String getMaPhieuChuoc() {
		return maPhieuChuoc;
	}

	public void setMaPhieuChuoc(String maPhieuChuoc) {
		this.maPhieuChuoc = maPhieuChuoc;
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

	public BigDecimal getSoTienChuoc() {
		return soTienChuoc;
	}

	public void setSoTienChuoc(BigDecimal soTienChuoc) {
		this.soTienChuoc = soTienChuoc;
	}

	public int getSoNgayQuaHan() {
		return soNgayQuaHan;
	}

	public void setSoNgayQuaHan(int soNgayQuaHan) {
		this.soNgayQuaHan = soNgayQuaHan;
	}
}
