package model.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
/**
 * PhieuCamnDo.java
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

public class PhieuCamDo {
	private String maPhieuCam;
	private String ngayCam;
	private String ngayChuocDuKien;
	private String manv;
	private String makh;
	private BigDecimal tongTienCam;
	private ArrayList<ChiTietPhieuCamDo> dsctPhieuCam ;

	public ArrayList<ChiTietPhieuCamDo> getDsctPhieuCam() {
		return dsctPhieuCam;
	}
	public void setDsctPhieuCam(ArrayList<ChiTietPhieuCamDo> dsctPhieuCam) {
		this.dsctPhieuCam = dsctPhieuCam;
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
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public BigDecimal getTongTienCam() {
		return tongTienCam;
	}
	public void setTongTienCam(BigDecimal tongTienCam) {
		this.tongTienCam = tongTienCam;
	}
	
	
	
}
