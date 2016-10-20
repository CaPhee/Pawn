<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ - Website Quản lý cầm đồ</title>

<jsp:include page="block/cssPath.jsp"></jsp:include>
</head>

<body>
	<div id="wrapper">
		<!-- Header -->
		<jsp:include page="block/header.jsp"></jsp:include>
		<!-- /Header -->
		<div id="page-wrapper">
			<h3 class="page-header">Sửa khách hàng có mã:
			<bean:write name="khachHangForm" property="makh"/>
			</h3>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body">

							<div class="row">
								<div class="col-lg-6">
									<html:form action="/suaKH" method="post">
										<div>
											<label>Mã khách hàng: </label>
											<html:text property="makh" styleClass="form-control"
												readonly="true"></html:text>
										</div>
										<div>
											<label>Họ và tên</label>
											<html:text property="hoTen" styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Số CMND</label>
											<html:text property="cmnd" styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Địa chỉ</label>
											<html:text property="diaChi" styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Số điện thoại</label>
											<html:text property="soDT" styleClass="form-control"></html:text>
										</div>
										<html:submit styleClass="btn btn-default" property="submit"
											value="submit">Lưu</html:submit>
										<html:reset styleClass="btn btn-default">Hủy</html:reset>
									</html:form>
								</div>
							</div>
							<!-- /.row (nested) -->
						</div>

						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
			<jsp:include page="block/JSPath.jsp"></jsp:include>
	</div>
</body>
</html>