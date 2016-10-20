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

    <title>Trang danh sách phiếu câm - Website Quản lý cầm đồ</title>

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
                    <h1 class="page-header">Danh sách phiếu cầm</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Mã phiếu</th>
                                            <th>Ngày cầm</th>
                                            <th>Ngày chuộc dự kiến</th>
                                            <th>Tên nhân viên</th>
                                            <th>Tên khách hàng</th>
                                            <th>Tổng tiền</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<logic:iterate id="list" name="danhSachPhieuCamForm" property="dsPhieuCam">
                                        <tr class="odd gradeX">
                                            <td class="center"><bean:write name="list"
														property="maPhieuCam" /></td>
                                            <td class="center">
                                            <bean:write name="list"
														property="ngayCam" />
                                        	</td>
                                            <td class="center"><bean:write name="list"
														property="ngayChuocDuKien" /></td>
                                            <td class="center"><bean:write name="list"
														property="manv" /></td>
                                            <td class="center"><bean:write name="list"
														property="makh" /></td>
                                            <td class="center"><bean:write name="list"
														property="tongTienCam" /></td>
                                            <td class="center">
                                            	<bean:define id="ma" name="list" property="maPhieuCam"></bean:define>
                                            	<html:link action="/ds-chi-tiet-phieu-cam?ma=${ma }" >Xem chi tiết</html:link>
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
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <jsp:include page="block/JSPath.jsp"></jsp:include>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>
