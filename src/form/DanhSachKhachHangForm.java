package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KhachHang;

@SuppressWarnings("serial")
public class DanhSachKhachHangForm extends ActionForm{
	private ArrayList<KhachHang> listKhachHang;

	public ArrayList<KhachHang> getListKhachHang() {
		return listKhachHang;
	}

	public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
		this.listKhachHang = listKhachHang;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
