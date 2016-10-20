package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.SanPham;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class DanhSachSanPhamForm extends ActionForm{

	private ArrayList<SanPham> listSanPham;

	public ArrayList<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(ArrayList<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
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
