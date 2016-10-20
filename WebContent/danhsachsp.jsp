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

<title>Trang danh sách sản phẩm - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Danh sách sản phẩm</h1>
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
											<th>Mã sản phẩm</th>
											<th>Tên sản phẩm</th>
											<th>Số lượng</th>
											<th>Số tiền cầm</th>
											<th>Tình trạng</th>
											<th>Mã danh mục</th>
																					</tr>
									</thead>
									<tbody>
										<logic:iterate id="dsSp" name="danhSachSanPhamForm"
											property="listSanPham">
											<tr class="odd gradeX">
												<td class="center"><bean:write name="dsSp"
														property="masp" /></td>
												<td class="center"><bean:write name="dsSp"
														property="tensp" /></td>

												<td class="center"><bean:write name="dsSp"
														property="soLuong" /></td>

												<td class="center"><bean:write name="dsSp"
														property="sotienCam" /></td>

												<td class="center"><bean:write name="dsSp"
														property="tinhTrang" /></td>

												<td class="center"><bean:write name="dsSp"
														property="madm" /></td>
											</tr>
										</logic:iterate>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
							<div class="col-md-4 col-md-offset-5">
								<button type="button" class="btn btn-primary"
									onclick="location.href='http://localhost:8080/Mock/cap-nhat-sp.do'">Cập
									nhật danh sách</button>
							</div>
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