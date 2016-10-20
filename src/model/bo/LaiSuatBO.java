package model.bo;

import java.util.ArrayList;

import model.bean.LaiSuat;
import model.dao.LaiSuatDAO;
/**
 * LaiSuatBO.java
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

public class LaiSuatBO {
	LaiSuatDAO lsdao = new LaiSuatDAO();
/**
 * danh sach lai suat
 * @return ListLaiSuat
 */
	public ArrayList<LaiSuat> getListLaiSuat() {
		return lsdao.getListLaiSuat();
	}
	
}
