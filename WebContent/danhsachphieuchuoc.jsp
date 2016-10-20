<%@page import="common.Detail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang danh sách phiếu chuộc - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Danh sách phiếu chuộc</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
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
											<th>Mã phiếu chuộc</th>
											<th>Mã phiếu cầm</th>
											<th>Ngày chuộc</th>
											<th>Tổng tiền</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<logic:iterate id="dsPch" name="danhSachPhieuChuocForm"
											property="dsPhieuChuoc">
											<tr class="odd gradeX">
												<td class="center"><bean:write name="dsPch"
														property="maPhieuChuoc" /></td>
												<td class="center"><bean:write name="dsPch"
														property="maPhieuCam" /></td>

												<td class="center"><bean:write name="dsPch"
														property="ngayChuocThucTe" /></td>
												<td class="center"><bean:write name="dsPch"
														property="tongTienChuoc" /></td>
												<td><bean:define id="maPhieuChuoc" name="dsPch"
														property="maPhieuChuoc"></bean:define> <html:link
														action="/list-chi-tiet-phieu-chuoc?mapch=${maPhieuChuoc}">Xem chi tiết</html:link>
												</td>
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

		<!-- /#wrapper -->
	</div>
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
