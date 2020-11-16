<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
							</li>

							<li>
								<a href="#">用户管理</a>
							</li>
							<li class="active">添加用户</li>
						</ul><!-- /.breadcrumb -->
					</div>
				</div>
				<div class="main-content-inner">
					<div class="page-content" style="padding-top: 50px;">
								<form class="col-sm-7 col-sm-offset-2 form-horizontal" action="${pageContext.request.contextPath }/servlet/UserDadaAddServlet" method="post">
												<fieldset>
													<div class="form-group">
														<label for="uid" class="col-sm-2 control-label no-padding-right">用户编号</label>
														<div class="col-sm-7">
															<span class="block input-icon input-icon-right">
																<input type="text" name="uid" value="${formBean.uid}" class="form-control" placeholder="请输入用户号" /><span class="red">${formBean.errors.uid}${errorMsg}</span>
																<i class="ace-icon fa fa-user"></i>
															</span>
														</div>
													</div>
													<div class="form-group">
														<label for="name" class="col-sm-2 control-label no-padding-right">用户姓名</label>
														<div class="col-sm-7">
														<span class="block input-icon input-icon-right">
															<input type="text" name="name" value="${formBean.name}" class="form-control" placeholder="请输入姓名" /><span class="red">${formBean.errors.name}</span>
															<i class="ace-icon fa fa-user"></i>
														</span>
														</div>
													</div>
													<div class="form-group">
														<label for="password" class="col-sm-2 control-label no-padding-right">用户密码</label>
														<div class="col-sm-7">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control" placeholder="请输入密码" /><span class="red">${formBean.errors.password}</span>
															<i class="ace-icon fa fa-lock"></i>
														</span>
														</div>
													</div>

													<div class="form-group">
														<label for="password2" class="col-sm-2 control-label no-padding-right">确认密码</label>
														<div class="col-sm-7">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password2" class="form-control" placeholder="请再次输入密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
														</div>
													</div>
													<div class="form-group">
														<label for="tel" class="col-sm-2 control-label no-padding-right">用户电话</label>
														<div class="col-sm-7">
														<span class="block input-icon input-icon-right">
															<input type="text" name="tel" value="${formBean.tel}" class="form-control" placeholder="请输入电话" /><span class="red">${formBean.errors.tel}</span>
															<i class="ace-icon fa fa-retweet"></i>
														</span>
														</div>
													</div>
													<div class="form-group">
														<label for="" class="col-sm-2 control-label no-padding-right">用户身份</label>
														<div class="col-sm-7">
															<label for="vill" class="col-sm-2.5 control-label no-padding-right">工作者</label> <input type="radio" name="level" class="ace" value="1" ${formBean.level==1?'checked':''}><span class="lbl"></span>&nbsp;
															<label for="vill" class="col-sm-2.5 control-label no-padding-right">学   生</label> <input type="radio" name="level" class="ace" value="0" ${formBean.level==0?'checked':''}><span class="lbl"></span>
															<span class="red">${formBean.errors.level}</span>
														</div>
													</div>
													
													<div class="space-6"></div>
													
													<div class="clearfix">
														<label for="" class="col-sm-2 control-label no-padding-right"></label>
														<div class="col-sm-7">
															<button type="submit" class="btn btn-big btn-success form-control">
																<span class="bigger-110">添加</span>
																<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
															</button>
														</div>
													</div>
												</fieldset>
											</form>
					</div>
				</div>
			</div><!-- /.main-content -->
		
			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder" style="margin-right: 20px;">
							<img src="${pageContext.request.contextPath }/assets/img/2.png" style="width: 23px;margin-top: -3px; margin-right: 4px;">
							课程设计
							</span>
							图书馆管理系统
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
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
		<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath }/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/ace.min.js"></script>
		<script>
			$(function(){
				var li = $('.submenu').find('li');
				$(li).eq(4).addClass('active');
			});
		</script>
	</body>
</html>
