package form;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.ThongKe;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class ThongKeForm extends ActionForm {
	private int chon = 2;
	private String tuNgay = "2016-01-01";
	private String denNgay = "2016-12-31";
	private ArrayList<ThongKe> listThongke;
	private BigDecimal tongTienLai;
	private String thongBao;
	
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public BigDecimal getTongTienLai() {
		return tongTienLai;
	}
	public void setTongTienLai(BigDecimal tongTienLai) {
		this.tongTienLai = tongTienLai;
	}
	public int getChon() {
		return chon;
	}
	public void setChon(int chon) {
		this.chon = chon;
	}
	public String getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}
	public String getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}
	public ArrayList<ThongKe> getListThongke() {
		return listThongke;
	}
	public void setListThongke(ArrayList<ThongKe> listThongke) {
		this.listThongke = listThongke;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
