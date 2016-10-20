package model.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
/**
 * PhieuChuocDo.java
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
 *  Aug 3, 2016        	QuyenHT         Create
 */

public class PhieuChuocDo {
	private String maPhieuChuoc;
	private String maPhieuCam;
	private String makh;
	private String manv;
	private String ngayChuocThucTe;
	private BigDecimal tongTienChuoc;
	private ArrayList<ChiTietPhieuChuocDo> ctPhieuChuoc;
	public String getMaPhieuChuoc() {
		return maPhieuChuoc;
	}
	public void setMaPhieuChuoc(String maPhieuChuoc) {
		this.maPhieuChuoc = maPhieuChuoc;
	}
	public String getMaPhieuCam() {
		return maPhieuCam;
	}
	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getNgayChuocThucTe() {
		return ngayChuocThucTe;
	}
	public void setNgayChuocThucTe(String ngayChuocThucTe) {
		this.ngayChuocThucTe = ngayChuocThucTe;
	}
	
	
	
	public BigDecimal getTongTienChuoc() {
		return tongTienChuoc;
	}
	public void setTongTienChuoc(BigDecimal tongTienChuoc) {
		this.tongTienChuoc = tongTienChuoc;
	}
	public ArrayList<ChiTietPhieuChuocDo> getCtPhieuChuoc() {
		return ctPhieuChuoc;
	}
	public void setCtPhieuChuoc(ArrayList<ChiTietPhieuChuocDo> ctPhieuChuoc) {
		this.ctPhieuChuoc = ctPhieuChuoc;
	}
	
}
