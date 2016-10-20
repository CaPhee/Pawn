package model.bo;

import model.dao.UsersDAO;
/**
 * UsersBO.java
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
public class UsersBO {
	UsersDAO userdao = new UsersDAO();
	/**
	 * kiem tra dangnhap
	 * @param userName
	 * @param password
	 * @return checkLogin
	 */
	public boolean checkLogin(String userName, String password){
		return userdao.checkLogin(userName,password);
	}
}
