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

<title>Trang thống kê - Website Quản lý cầm đồ</title>

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
					<h1 class="page-header">Thống kê</h1>
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
								<html:form action="/thong-ke">
									<div class="form-group">
										<h4>Thống kê theo</h4>
										<select name="chon" class="form-control" style="width: 30%;">
											<option value="1">Sản phẩm đã chuộc</option>
											<option value="2" selected="selected">Sản phẩm không
												chuộc</option>
											<option value="3">Tiền lãi</option>
										</select>
									</div>
									<div class="form-group">
										<label style="float: left; margin: 10px 5px 0 0;">Từ
											ngày</label> <input class="form-control" name="tuNgay" type="date"
											data-date="01/01/2016" data-date-format="yyyy-MM-dd"
											style="width: 20%; float: left; margin: 5px 0px 20px 5px;">
										<h4 style="float: left;" class="fa fa-table fa-fw"></h4>
									</div>
									<div class="form-group">
										<label style="float: left; margin: 10px 5px 0 20px;">Đến
											ngày ngày</label> <input class="form-control" name="denNgay"
											type="date" data-date="31-12-2016"
											data-date-format="yyyy-MM-dd"
											style="width: 20%; float: left; margin: 5px 0px 20px 5px;">
										<h4 style="float: left;" class="fa fa-table fa-fw"></h4>
									</div>
									<div class="row form-group thongbao"
										style="width: 280px; margin: 5px 5px 15px 5px;">
										<ul style="list-style: none;">
											<li><bean:write name="thongKeForm" property="thongBao" /></li>
										</ul>
									</div>


									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>STT</th>
												<th>Tên sản phẩm</th>
												<th>Tên nhân viên</th>
												<th>Ngày cầm</th>
												<th>Tình trạng</th>
												<th>Tiền lãi</th>
											</tr>
										</thead>
										<tbody>
											<logic:iterate id="list" name="thongKeForm"
												property="listThongke">
												<tr class="odd gradeX">
													<td class="center"><bean:write name="list"
															property="stt" /></td>
													<td class="center"><bean:write name="list"
															property="tensp" /></td>
													<td class="center"><bean:write name="list"
															property="tennv" /></td>
													<td class="center"><bean:write name="list"
															property="ngayCam" /></td>
													<td class="center"><bean:write name="list"
															property="tinhTrang" /></td>
													<td class="center"><bean:write name="list"
															property="tienLai" /></td>
												</tr>

											</logic:iterate>
										</tbody>
									</table>
									<div class="form-group"
										style="float: right; margin: 30px 50px 0 0;">
										<label for="disabledSelect">Tổng tiền</label>
										<html:text property="tongTienLai" styleId="disabledInput"
											disabled="disabled" styleClass="form-control" readonly="true"></html:text>
									</div>
									<div class="col-md-9 col-md-offset-4"
										style="margin-top: 50px; float: left;">
										<html:submit styleClass=" btn btn-primary"
											style="margin-right:50px; width:90px;" property="button">Thống kê</html:submit>
										<button class="btn btn-primary" type="submit">In Báo
											cáo</button>
									</div>

								</html:form>
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