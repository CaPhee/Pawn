<%@page import="common.Detail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Login - Website Quản lý cầm đồ</title>

<!-- Bootstrap Core CSS -->
<jsp:include page="block/cssPath.jsp"></jsp:include>

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<html:form styleId="login-form" action="/login" method="post">
							<div class="form-group">
								<html:text property="userName" maxlength="50"
									styleClass="form-control" value="admin"></html:text>

							</div>
							<div class="form-group">
								<html:password property="password" maxlength="50"
									styleClass="form-control" value="123"></html:password>

							</div>
							<div class="checkbox">
								<label> <input name="remember" type="checkbox"
									value="Remember Me">Remember Me
								</label>
							</div>

							<!-- Change this to a button or input when using this as a form -->
							<html:submit styleClass="btn btn-lg btn-success btn-block">Đăng nhập</html:submit>
						</html:form>
						<div class="thongbao" style="width:320px ;color: red; margin: 15px 4px 0 4px;">
							<ul style="list-style: none;">
								<li><html:errors property="userNameError" /></li>
								<html:errors property="passwordError" />
								<logic:notEmpty name="UsersForm" property="thongBao">
									<li><bean:write name="UsersForm" property="thongBao" /></li>
								</logic:notEmpty>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<jsp:include page="block/JSPath.jsp"></jsp:include>

</body>

</html>