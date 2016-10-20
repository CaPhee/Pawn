package model.bean;

import java.math.BigDecimal;
/**
 * ChiTietPhieuCamDo.java
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

public class ChiTietPhieuCamDo {
	private String maPhieuCam;
	private String tensp;
	private int soLuong;
	private BigDecimal soTienCam;
	private String moTa;
	private String hinhAnh;
	private String tenls;
	public String getMaPhieuCam() {
		return maPhieuCam;
	}
	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
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

	public BigDecimal getSoTienCam() {
		return soTienCam;
	}
	public void setSoTienCam(BigDecimal soTienCam) {
		this.soTienCam = soTienCam;
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
	public String getTenls() {
		return tenls;
	}
	public void setTenls(String tenls) {
		this.tenls = tenls;
	}
	
}
