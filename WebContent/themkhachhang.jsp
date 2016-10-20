<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Thêm khách hàng</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading"></div>

						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<html:form action="/themKH" method="post">
										<div class="form-group">
											<label>Mã khách hàng</label>
											<html:text property="makh" maxlength="10"
												styleClass="form-control"></html:text>

										</div>
										<div class="form-group">
											<label>Họ và tên</label>
											<html:text property="hoTen" styleClass="form-control"></html:text>

										</div>
										<div class="form-group">
											<label>Số CMND</label>
											<html:text property="cmnd" maxlength="12" styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Địa chỉ</label>
											<html:text property="diaChi" styleClass="form-control"></html:text>

										</div>
										<div class="form-group">
											<label>Số điện thoại</label>
											<html:text property="soDT" styleClass="form-control"></html:text>

										</div>
										<div class="form-group">
											<label>tình trạng</label>
											<html:text property="tinhTrang" styleClass="form-control"></html:text>
										</div>
										<html:submit property="submit" value="submit"
											styleClass="btn btn-default"> Thêm mới</html:submit>
										<html:reset styleClass="btn btn-default">Hủy</html:reset>
									</html:form>

								</div>
								<div class="row form-group alert alert-danger"
									style="color: red; width: 450px; margin: 25px 15px 0 15px; float: left">
									<ul style="list-style: none;">
										<li><html:errors property="mkhError" /></li>
										<li><html:errors property="tenkhError" /></li>
										<li><html:errors property="cmndError" /></li>
										<li><html:errors property="diachiError" /></li>
										<li><html:errors property="sodtError" /></li>
									</ul>
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