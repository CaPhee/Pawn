<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang thêm chi tiết phiếu chuộc - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Chi tiết phiếu chuộc</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Nhập chi tiết phiếu chuộc</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<html:form action="/them-phieu-chuoc">
										<div class="form-group">
											<label for="disabledSelect">Mã phiếu chuộc</label>
											<html:text property="maPhieuChuoc" styleId="disabledInput"
												styleClass="form-control" readonly="true"></html:text>
										</div>
										<div class="form-group">
											<label>Sản phẩm</label>
											<html:select property="tensp" styleClass="form-control">
												<html:optionsCollection name="phieuChuocForm"
													property="dsSanPham" label="tensp" value="tensp" />
											</html:select>
										</div>
										<div class="form-group">
											<label>Số lượng</label>
											<html:text property="soLuong" styleClass="form-control"></html:text>
										</div>
										<html:submit styleClass="btn btn-primary" property="button"
											value="Thêm chi tiết"></html:submit>
										<html:submit styleClass="btn btn-default" property="button"
											value="Hoàn tất"></html:submit>
									</html:form>
								</div>
								<div class="row form-group thongbao"
									style="color: red; width: 400px; margin: 25px 15px 0 15px; float: left;">
									<ul style="list-style: none;">
										<li><html:errors property="themPhieuChuocError" /></li>
										<li><p style="color: green;">
												<bean:write name="phieuChuocForm" property="thongBao" />
											</p></li>
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
	</div>
	<!-- /#wrapper -->

	<jsp:include page="block/JSPath.jsp"></jsp:include>

</body>

</html>
