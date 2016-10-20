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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang chi tiết phiếu chuộc - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Danh sách chi tiết phiếu chuộc</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="row form-group">
					<label class="col-lg-2" style="margin: 5px 0 5px 20px;">Mã
						Phiếu: </label>
					<div class="col-lg-3">
						<bean:define id="mapch" name="danhSachPhieuChuocForm"
							property="maPhieuChuoc"></bean:define>
						<input id="disabledInput" class="form-control " type="text"
							disabled="disabled" value="${mapch }">
					</div>
				</div>
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Danh sách</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Sản phẩm</th>
											<th>Số lượng</th>
											<th>Số tiền chuộc</th>
											<th>Số quá hạn</th>
										</tr>
									</thead>
									<tbody>
										<logic:iterate id="listct" name="danhSachPhieuChuocForm"
											property="listChiTietChuoc">
											<tr class="odd gradeX">
												<td class="center"><bean:write name="listct"
														property="tensp" /></td>
												<td class="center"><bean:write name="listct"
														property="soLuong" /></td>
												<td class="center"><bean:write name="listct"
														property="soTienChuoc" /></td>
												<td class="center"><bean:write name="listct"
														property="soNgayQuaHan" /></td>
												<td class="center"><a href="suakhachhang.html"> <i
														class="fa fa-pencil"></i></a></td>
												<td class="center"><a><i class="fa fa-trash-o"></i></a></td>
											</tr>
										</logic:iterate>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->

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
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>

</html>