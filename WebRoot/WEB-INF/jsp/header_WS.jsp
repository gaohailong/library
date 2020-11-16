<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>小型图书馆管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/other.css">
		
		<!--引入头文件图标的一句话-->
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/img/favicon.ico" type="image/x-icon" />
		
		<meta name="description" content="3 styles with inline editable feature" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jquery.dataTables.min.css">
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jquery.gritter.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/select2.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/datepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bootstrap-editable.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/assets/css/ace-skins.min.css">

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/color.css">
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="${pageContext.request.contextPath }/assets/js/ace-extra.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.2.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/color.js"></script>
		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="${pageContext.request.contextPath }/assets/js/html5shiv.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
			  <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>
				<div class="navbar-header pull-left">
					<a href="" class="navbar-brand">
						<small><b>
						<img src="${pageContext.request.contextPath }/assets/img/2.png" style="height:25px;">
							小型图书馆管理系统
						</b></small>
					</a>
				</div>
				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue" style="width: 170px;">
						 <c:choose>
				   	 		<c:when test="${sessionScope.user.level==1}">
				   	 			<span style="color: #fff;"><big>欢迎您,${sessionScope.user.name}(工作者)</big></span>
				   	 		</c:when>
					   		<c:otherwise>
					   			<span style="color: #fff;"><big>欢迎您,${sessionScope.user.name}(学生)</big></span>
					   		</c:otherwise>
 						</c:choose>
						</li>
						<li class="light-blue" style="width: 70px;border: 0;cursor: pointer;" onclick="window.open('../servlet/LoginOutUIServlet','_self');">
								<span style="color: #fff;"><big>退出</big></span>
						</li>
					</ul><!-- /.ace-nav -->
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn togglecolor1"></button>

						<button class="btn togglecolor2"></button>

						<button class="btn togglecolor3"></button>

						<button class="btn togglecolor4"></button>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active open">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-tag"></i>
							<span class="menu-text"> 图书管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="../servlet/Main_WS_UIServlet">
									<i class="menu-icon fa fa-caret-right"></i>
									图书列表
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
									<a href="../servlet/Borrow_WS_UIListServlet">
									<i class="menu-icon fa fa-caret-right"></i>
									借阅列表 
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

					<li class="active open">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-calendar"></i>
							<span class="menu-text">
								个人中心
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
<%-- //String auth_pid = getStringParam(session, "auth_pid", "");
	String auth_pid = (String)session.getAttribute("auth_pid");
	if(auth_pid.equals("1")){
		--%>
<%--}--%>				<ul class="submenu">
							<li class="">
								<a href="../servlet/PersonDataUIservlet">
									<i class="menu-icon fa fa-caret-right"></i>
									个人信息
								</a>

								<b class="arrow"></b>
							</li>
						</ul>		
					</li>
				</ul><!-- /.nav-list -->
			</div>
