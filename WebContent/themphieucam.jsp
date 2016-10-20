<%@page import="common.Detail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang thêm phiếu cầm - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Thêm phiếu cầm</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Nhập thông tin phiếu cầm</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<html:form action="/them-phieu-cam">
										<div class="form-group">
											<label>Mã phiếu cầm *</label>
											<html:text property="maPhieuCam" maxlength="10" styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Ngày cầm *</label> <input class="form-control" min=2014-01-01 max=2016-12-31
												type="date" name="ngayCam">
										</div>
										<div class="form-group">
											<label>Ngày chuộc dự kiến *</label> 
											<input class="form-control" min=2014-01-01 max=2016-12-31
												type="date" name="ngayChuocDuKien">
										</div>
										<div class="form-group">
											<label>Tên khách hàng *</label>											
											<html:select property="maKH" styleClass="form-control">
												<html:optionsCollection name="phieuCamForm"
													property="dsKhachHang" label="tenkh" value="makh" />
											</html:select>
										</div>
										<div class="form-group">
											<label>Tên nhân viên *</label>
											<html:select property="maNV" styleClass="form-control">
												<html:optionsCollection name="phieuCamForm"
													property="dsNhanVien" label="tennv" value="manv" />
											</html:select>
										</div>
										<html:submit styleClass="btn btn-success" style="width:90px"
											property="button" value="Thêm"></html:submit>
										<button type="reset" class="btn btn-default">Cancel</button>
									</html:form>
								</div>
								<div class="row form-group thongbao">
									<ul style="list-style: none;">
										<li><html:errors property="maPhieuCamError" /></li>
										<li><html:errors property="chiTietCamError" /></li>
										<li><html:errors property="dateError"/></li>
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
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<jsp:include page="block/JSPath.jsp"></jsp:include>

</body>

</html>