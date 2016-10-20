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
					<h1 class="page-header">Trang chủ website Quản lý cầm đồ</h1>
				</div>				
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="background">
				</div>
			</div>



		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<jsp:include page="block/JSPath.jsp"></jsp:include>

</body>

</html>