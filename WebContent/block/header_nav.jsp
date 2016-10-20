<%@page import="model.bean.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<div class="navbar-default sidebar" >
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<li><a href="trangchu.jsp"><i class="fa fa-dashboard fa-fw"></i>
					Trang chủ</a></li>
			<li><a href="#"><i class="fa fa-book"></i> Quản lý phiếu<span
					class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li><a href="#">Quản lý phiếu cầm đồ<span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level" style="padding-left:15px">
							<li><html:link action="/danh-sach-phieu-cam">Danh sách phiếu cầm</html:link></li>
							<li><html:link action="/them-phieu-cam">Thêm phiếu cầm</html:link></li>
						</ul> <!-- /.nav-third-level --></li>
					<li><a href="#">Quản lý phiếu chuộc<span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level" style="padding-left:15px">
							<li><html:link action="/danh-sach-phieu-chuoc">Danh sách phiếu chuộc</html:link></li>
							<li><html:link action="/them-phieu-chuoc">Thêm phiếu chuộc</html:link></li>
						</ul></li>

				</ul> <!-- /.nav-second-level --></li>
			<li><a href="#"><i class="fa fa-table fa-fw"></i> Quản lý
					khách hàng<span class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li><html:link action="/danh-sachKH">Danh sách khách hàng</html:link></li>
					<li><html:link action="/themKH">Thêm khách hàng</html:link></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
					Quản lý sản phẩm<span class="fa arrow"></span> </a>
				<ul class="nav nav-second-level">
					<li><html:link action="/danh-sach-sp">Danh sách sản phẩm</html:link></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><html:link action="/thong-ke">Thống kê</html:link></li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
