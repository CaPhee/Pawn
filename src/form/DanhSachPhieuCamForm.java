package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.ChiTietPhieuCamDo;
import model.bean.PhieuCamDo;

@SuppressWarnings("serial")
public class DanhSachPhieuCamForm extends ActionForm{

	private ArrayList<PhieuCamDo> dsPhieuCam ;
	private String maPhieuCam;
	private ArrayList<ChiTietPhieuCamDo> listChiTietCam ;
	public String getMaPhieuCam() {
		return maPhieuCam;
	}
	public void setMaPhieuCam(String maPhieuCam) {
		this.maPhieuCam = maPhieuCam;
	}
	public ArrayList<ChiTietPhieuCamDo> getListChiTietCam() {
		return listChiTietCam;
	}
	public void setListChiTietCam(ArrayList<ChiTietPhieuCamDo> listChiTietCam) {
		this.listChiTietCam = listChiTietCam;
	}

	public ArrayList<PhieuCamDo> getDsPhieuCam() {
		return dsPhieuCam;
	}

	public void setDsPhieuCam(ArrayList<PhieuCamDo> dsPhieuCam) {
		this.dsPhieuCam = dsPhieuCam;
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
