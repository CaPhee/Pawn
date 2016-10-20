package model.bo;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.bean.ThongKe;
import model.dao.ThongKeDAO;

/**
 * ThongKeBO.java
 *
 * Version 1.0
 *
 * Date: Aug 3, 2016
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Aug
 * 3, 2016 QuyNH Create
 */
public class ThongKeBO {
	ThongKeDAO thongkedao = new ThongKeDAO();

	/**
	 * Thong ke san pham theo da chuoc
	 * 
	 * @param tuNgay
	 * @param denNgay
	 * @return ListDaChuoc
	 */
	public ArrayList<ThongKe> getListDaChuoc(String tuNgay, String denNgay) {
		return thongkedao.getListDaChuoc(tuNgay, denNgay);
	}

	/**
	 * Thong ke san pham theo tien lai
	 * 
	 * @param tuNgay
	 * @param denNgay
	 * @return ListTienLai
	 */
	public ArrayList<ThongKe> getListTienLai(String tuNgay, String denNgay) {
		return thongkedao.getListTienLai(tuNgay, denNgay);
	}

	/**
	 * Thong ke san pham theo danh sach san pham khong chuoc
	 * 
	 * @param tuNgay
	 * @param denNgay
	 * @return ListKhongChuoc
	 */
	public ArrayList<ThongKe> getListKhongChuoc(String tuNgay, String denNgay) {
		return thongkedao.getListKhongChuoc(tuNgay, denNgay);
	}

	public BigDecimal tinhTongLai(ArrayList<ThongKe> dsThongKe) {
		return thongkedao.tinhTongLai(dsThongKe);
	}

}
