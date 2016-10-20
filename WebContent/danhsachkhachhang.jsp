<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
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
<title>Trang danh sách khách hàng - Website Quản lý cầm đồ</title>
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
					<h1 class="page-header">Danh sách khách hàng</h1>
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
											<th>Mã khách hàng</th>
											<th>Họ và tên</th>
											<th>Số CMND</th>
											<th>Địa Chỉ</th>
											<th>Số điện thoại</th>
											<th>Tình trạng</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<logic:iterate name="danhSachKhachHangForm"
											property="listKhachHang" id="kh">
											<tr class="odd gradeX">
												<td class="center"><bean:write name="kh"
														property="makh" /></td>
												<td class="center"><bean:write name="kh"
														property="tenkh" /></td>
												<td class="center"><bean:write name="kh"
														property="cmnd" /></td>
												<td class="center"><bean:write name="kh"
														property="diaChi" /></td>
												<td class="center"><bean:write name="kh"
														property="sodt" /></td>
												<td class="center"><bean:write name="kh"
														property="tinhTrang" /></td>
												<td class="center"><bean:define id="makh" name="kh"
														property="makh"></bean:define> <html:link
														action="/suaKH?makh=${makh}">
														<span class="glyphicon glyphicon-edit"></span>
													</html:link></td>
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