<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>小型图书馆管理系统</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<!--引入头文件图标的一句话-->
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/assets/img/favicon.ico" type="image/x-icon" />
		
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath }/assets/js/html5shiv.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout blur-login" style="font-family: 'Microsoft Yahei'">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container" style="margin-top: 60px;">
							<div class="center">
								<!--<img src="${pageContext.request.contextPath }/assets/img/ht2.png" class="img-responsive">-->
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">小型</span>
									<span class="white" id="id-text2">图书馆管理系统</span>
								</h1>
							</div>
							
							<div class="space-6"></div>

							<div class="position-relative">
						   	<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
								<div id="login-box" class="login-box visible widget-box no-border">
								<div class="toolbar clearfix">
								<h3 class="center" style="color: #fff;line-height: 55px;margin: 0 auto;">登 录</h3>
<!-- 										  	<div>
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>
													I forgot my password
												</a>
											</div>

											<div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													I want to register
													<i class="icon-arrow-right"></i>
												</a>
											</div> -->
										</div>
									<div class="widget-body">
										<div class="widget-main">

											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												请输入你的信息
											</h4>

											<div class="space-6">${errorMsg}</div>
											${errorMsg}
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="uid" class="form-control" placeholder="用户名" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password"  name="password"  class="form-control" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>
													<div class="clearfix">
														<label class="inline col-sm-4">
															<input type="radio" value="2" name="level" class="ace" />
															<span class="lbl"> 管理员 </span>
														</label>
														<label class="inline col-sm-4">
															<input type="radio" value="1" name="level" class="ace" />
															<span class="lbl"> 工作员</span>
														</label>
														<label class="inline col-sm-4">
															<input type="radio" value="0" name="level" class="ace" />
															<span class="lbl"> 学生</span>
														</label>
													</div>
										
													<div class="clearfix">
														<button type="submit" class="btn btn-sm btn-primary col-sm-5">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">登录</span>
														</button>
														<a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet" class="btn btn-sm btn-primary pull-right col-sm-5 btn-info">
																<span class="bigger-110">注册</span>
															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</a>
													</div>
													</div>
													<div class="space-2"></div>
												</fieldset>
											</form>
										</div>
									</div>
								</div>
								
							</div>

							
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath }/assets/js/jquery.2.1.1.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="${pageContext.request.contextPath }/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
		</script>
	</body>
</html>
