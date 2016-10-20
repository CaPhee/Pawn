package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.ChiTietPhieuChuocDo;
import model.bean.PhieuChuocDo;
@SuppressWarnings("serial")
public class DanhSachPhieuChuocForm extends ActionForm {

	private ArrayList<PhieuChuocDo> dsPhieuChuoc ;
	public ArrayList<PhieuChuocDo> getDsPhieuChuoc() {
		return dsPhieuChuoc;
	}
	public void setDsPhieuChuoc(ArrayList<PhieuChuocDo> dsPhieuChuoc) {
		this.dsPhieuChuoc = dsPhieuChuoc;
	}
	public String getMaPhieuChuoc() {
		return maPhieuChuoc;
	}
	public void setMaPhieuChuoc(String maPhieuChuoc) {
		this.maPhieuChuoc = maPhieuChuoc;
	}
	public ArrayList<ChiTietPhieuChuocDo> getListChiTietChuoc() {
		return listChiTietChuoc;
	}
	public void setListChiTietChuoc(ArrayList<ChiTietPhieuChuocDo> listChiTietChuoc) {
		this.listChiTietChuoc = listChiTietChuoc;
	}
	private String maPhieuChuoc;
	private ArrayList<ChiTietPhieuChuocDo> listChiTietChuoc ;
}

