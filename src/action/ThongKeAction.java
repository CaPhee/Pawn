package action;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Detail;

import form.ThongKeForm;
import model.bean.ThongKe;
import model.bo.ThongKeBO;

/**
 * ThongKeAction.java
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

public class ThongKeAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		ThongKeForm thongkeform = (ThongKeForm) form;
		//lay danh sach thong ke
		ThongKeBO thongkebo = new ThongKeBO();
		ArrayList<ThongKe> dsThongKe = new ArrayList<ThongKe>();
		int chon = thongkeform.getChon();
		String tuNgay = thongkeform.getTuNgay();		
		String denNgay = thongkeform.getDenNgay();
		
		if(Detail.nullValue(tuNgay)||Detail.nullValue(denNgay)){
			thongkeform.setThongBao("Bạn phải nhập đầy đủ thông tin");
		}
		
		if(chon==1){
			dsThongKe = thongkebo.getListDaChuoc(tuNgay,denNgay);
			thongkeform.setListThongke(dsThongKe);
			BigDecimal tongLai = thongkebo.tinhTongLai(dsThongKe);
			thongkeform.setTongTienLai(tongLai);
			return mapping.findForward("thongke");	
		}else if(chon==2){
			dsThongKe = thongkebo.getListKhongChuoc(tuNgay,denNgay);
			thongkeform.setListThongke(dsThongKe);
			BigDecimal tongLai = thongkebo.tinhTongLai(dsThongKe);
			thongkeform.setTongTienLai(tongLai);
			return mapping.findForward("thongke");	
		}else if(chon==3){
			dsThongKe = thongkebo.getListTienLai(tuNgay,denNgay);
			thongkeform.setListThongke(dsThongKe);
			BigDecimal tongLai = thongkebo.tinhTongLai(dsThongKe);
			thongkeform.setTongTienLai(tongLai);
			return mapping.findForward("thongke");	
		}else
		return mapping.findForward("thongke");		
	}

}
