package model.bean;

import java.math.BigDecimal;
/**
 * SanPham.java
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
 *  Aug 3, 2016        	NhuTT          Create
 */

public class SanPham {
	private String masp;
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	private String tensp;
	private String soLuong;
	private BigDecimal sotienCam;
	private String tinhTrang;
	private String madm;
	private String maPhieuCam;
	private String maPhieuChuoc;
	public BigDecimal getSotienCam() {
		return sotienCam;
	}
	public void setSotienCam(BigDecimal sotienCam) {
		this.sotienCam = sotienCam;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
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
	public String getMadm() {
		return madm;
	}
	public void setMadm(String madm) {
		this.madm = madm;
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
}
