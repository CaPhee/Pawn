package model.bean;

import java.math.BigDecimal;
/**
 * ThongKe.java
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

public class ThongKe {
	private int stt;
	private String tensp;
	private String tennv;
	private String ngayCam;
	private String tinhTrang;
	private BigDecimal tienLai;
	
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	
	public String getNgayCam() {
		return ngayCam;
	}
	public void setNgayCam(String ngayCam) {
		this.ngayCam = ngayCam;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public BigDecimal getTienLai() {
		return tienLai;
	}
	public void setTienLai(BigDecimal tienLai) {
		this.tienLai = tienLai;
	}
}
