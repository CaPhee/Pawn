<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang thêm phiếu chuộc - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Thêm phiếu chuộc</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Nhập thông tin phiếu chuộc</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<html:form action="/them-phieu-chuoc">
										<div class="form-group">
											<label>Mã phiếu chuộc *</label>
											<html:text property="maPhieuChuoc" maxlength="10"
												styleClass="form-control"></html:text>
										</div>
										<div class="form-group">
											<label>Mã phiếu cầm *</label>
											<html:select property="maPhieuCam" styleClass="form-control">
												<html:optionsCollection name="phieuChuocForm"
													property="dsPhieuCam" label="maPhieuCam" value="maPhieuCam" />
											</html:select>

										</div>
										<div class="form-group">
											<label>Ngày chuộc thực tế *</label> <input
												class="form-control" type="date" name="ngayChuocThucTe">
										</div>
										<div class="form-group">
											<label>Tên khách hàng *</label>
											<html:select property="maKH" styleClass="form-control">
												<html:optionsCollection name="phieuChuocForm"
													property="dsKhachHang" label="tenkh" value="makh" />
											</html:select>

										</div>
										<div class="form-group">
											<label>Tên nhân viên *</label>
											<html:select property="maNV" styleClass="form-control">
												<html:optionsCollection name="phieuChuocForm"
													property="dsNhanVien" label="tennv" value="manv" />
											</html:select>
										</div>
										<html:submit styleClass="btn btn-success" style="width:90px"
											property="button" value="Thêm"></html:submit>
										<button type="reset" class="btn btn-default">Hủy</button>
									</html:form>
								</div>
								<div class="row form-group thongbao"
									style="color: red; width: 450px; margin: 25px 15px 0 15px; float: left">
									<ul style="list-style: none;">
										<li><html:errors property="maPhieuChuocError" /></li>
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
