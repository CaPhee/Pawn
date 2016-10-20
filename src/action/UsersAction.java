package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Detail;
import form.UsersForm;
import model.bo.UsersBO;

/**
 * UsersAction.java
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

public class UsersAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if("logout".equalsIgnoreCase(action)){
			session.removeAttribute("userName");
			return mapping.findForward("fail");
		}
		UsersForm userform = (UsersForm) form;
		UsersBO userbo = new UsersBO();
		String userName = userform.getUserName();
		String passwordmd5 = Detail.encodeMD5(userform.getPassword());
		//kiem tra neu chinh xac
		if(userbo.checkLogin(userName, passwordmd5)){
			session.setAttribute("userName",userName);
			return mapping.findForward("success");
			//kiem tra neu khong chinh xac
		}else {
			userform.setThongBao("Login Failed");
			return mapping.findForward("fail");
		}
	}
}
