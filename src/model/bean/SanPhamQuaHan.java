package model.bean;
/**
 * SanPhamQuaHan.java
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

public class SanPhamQuaHan {
	private String tensp;
	private double soTienCam;
	private String madm;
	private String ngayCam;
	private String makh;
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public double getSoTienCam() {
		return soTienCam;
	}
	public void setSoTienCam(double soTienCam) {
		this.soTienCam = soTienCam;
	}
	public String getMadm() {
		return madm;
	}
	public void setMadm(String madm) {
		this.madm = madm;
	}
	public String getNgayCam() {
		return ngayCam;
	}
	public void setNgayCam(String ngayCam) {
		this.ngayCam = ngayCam;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
}
