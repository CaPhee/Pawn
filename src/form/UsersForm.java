package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Detail;

@SuppressWarnings("serial")
public class UsersForm  extends ActionForm{
	private String userName;
	private String password;
	private String thongBao;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors actionErrors=new ActionErrors();
		
		
		if(Detail.maxLength(50, userName)){
			actionErrors.add("userNameError",new ActionMessage("error.userName.maxlength"));
		}
		if(Detail.maxLength(50,password)){
			actionErrors.add("passwordError",new ActionMessage("error.password.maxlength"));
		}
		if(Detail.minLength(4, userName)){
			if(Detail.nullValue(userName)){
				actionErrors.add("userNameError",new ActionMessage("error.userName.null"));
			}
			else
			actionErrors.add("userNameError",new ActionMessage("error.userName.minlength"));
		}
		if(Detail.minLength(2, password)){
			if(Detail.nullValue(password)){
				actionErrors.add("passwordError",new ActionMessage("error.password.null"));
			}else
			actionErrors.add("passwordError",new ActionMessage("error.password.minlength"));
		}
		return actionErrors;
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
