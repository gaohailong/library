<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
   	<c:when test="${sessionScope.user.level==2}">
   		<%@ include file="header.jsp"%>
   	</c:when>
   	<c:otherwise>
   		<%@ include file="header_WS.jsp"%>
   	</c:otherwise>
 </c:choose>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
					
						<style>
							.laydate_top {
	    						box-sizing: unset;
	    						height: 35px !important;
							}
							.laydate_body .laydate_bottom .laydate_btn {
								top: -1px;
							}
							#laydate_YY {
								width: 122px;
							}
							#laydate_MM {
								width: 101px;
							}
							.laydate_yms {
								top: 30px;
							}
							#laydate_ys {
								width: 121px;
							}
						</style>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
							</li>

							<li>
								<a href="#">个人中心</a>
							</li>
							<li class="active">个人信息</li>
						</ul><!-- /.breadcrumb -->
					</div>
				</div>
				<div class="main-content-inner">
					<div class="page-content">
									<div class="row">
										<div class="col-xs-12 col-sm-4">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">信息查看</h4>

													<div class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-down"></i>
														</a>
													</div>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<form class="form-horizontal" >
															<div class="form-group">
																	<label for="name" class="col-sm-3 control-label no-padding-right">个人编号 </label>
																	<div class="col-sm-9">
																		<input type="text" readonly value=${requestScope.userModifyHuixian.uid}  name="uid" class="col-xs-10 col-sm-10">
																	</div>
															</div>
															<div class="form-group">
																	<label for="name" class="col-sm-3 control-label no-padding-right">个人名称 </label>
																	<div class="col-sm-9">
																		<input type="text" readonly value=${requestScope.userModifyHuixian.name}  name="name" class="col-xs-10 col-sm-10">
																	</div>
															</div>
															<c:if test="${requestScope.userModifyHuixian.level==2}">
																<div class="form-group">
																	<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																	<div class="col-sm-9">
																		<input type="text" readonly value="管理员" name="level" class="col-xs-10 col-sm-10">
																	</div>
																</div>
										   				</c:if>
										   				<c:if test="${requestScope.userModifyHuixian.level==1}">
																<div class="form-group">
																	<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																	<div class="col-sm-9">
																		<input type="text" readonly value="工作者" name="level" class="col-xs-10 col-sm-10">
																	</div>
																</div>
								   						</c:if>
								   						<c:if test="${requestScope.userModifyHuixian.level==0}">
																<div class="form-group">
																	<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																	<div class="col-sm-9">
																		<input type="text" readonly value="学生" name="level" class="col-xs-10 col-sm-10">
																	</div>
																</div>
									   					</c:if>
														</form>
													</div>
												</div>
											</div>
										</div><!-- /.span -->

										<div class="col-xs-12 col-sm-4">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">信息修改</h4>

													<span class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-down"></i>
														</a>
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<form class="form-horizontal" role="form" action=${pageContext.request.contextPath}/servlet/PersonModifyServlet method=post>
															<div class="form-group">
																<label for="name" class="col-sm-3 control-label no-padding-right">个人编号 </label>
																<div class="col-sm-9">
																	<input type="text" readonly value=${requestScope.userModifyHuixian.uid}  name="uid" class="col-xs-10 col-sm-10">
																</div>
															</div>
															<div class="form-group">
																<label for="fnum" class="col-sm-3 control-label no-padding-right">个人名称</label>
																<div class="col-sm-9">
																	<input type="text" value=${requestScope.userModifyHuixian.name} name="name" class="col-xs-10 col-sm-10">
																</div>
															</div>
															<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">个人电话</label>
																<div class="col-sm-9">
																	<input type="text" value=${requestScope.userModifyHuixian.tel} name="tel" class="col-xs-10 col-sm-10">
																</div>
															</div>
															<c:if test="${requestScope.userModifyHuixian.level==2}">
																<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																<div class="col-sm-9">
																	<input type="text" readonly value="管理员" name="level" class="col-xs-10 col-sm-10">
																</div>
															</div>
									   						</c:if>
									   						<c:if test="${requestScope.userModifyHuixian.level==1}">
																<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																<div class="col-sm-9">
																	<input type="text" readonly value="工作者" name="level" class="col-xs-10 col-sm-10">
																</div>
															</div>
									   						</c:if>
									   						<c:if test="${requestScope.userModifyHuixian.level==0}">
																<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
																<div class="col-sm-9">
																	<input type="text" readonly value="学生" name="level" class="col-xs-10 col-sm-10">
																</div>
															</div>
									   						</c:if>
															<div class="form-group">
																<div class="col-md-offset-5 col-md-7">
																	<input class="btn btn-info" type="submit" value="提交修改" name="person_update">
																</div>
															</div>
														</form>				
													</div>
												</div>
											</div>
										</div><!-- /.span -->

										<div class="col-xs-12 col-sm-4">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">密码修改</h4>

													<span class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-down"></i>
														</a>
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<form class="form-horizontal" role="form" action=${pageContext.request.contextPath}/servlet/PersonPwdModifyServlet method=post>
															<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">输入旧密码</label>
																<div class="col-sm-9">
																	<input type="password" placeholder="确认旧密码" name="password0" class="col-xs-10 col-sm-10">
																</div>
															</div>
															<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">输入新密码</label>
																<div class="col-sm-9">
																	<input type="password" placeholder="输入新密码" name="password" class="col-xs-10 col-sm-10">
																</div>
															</div>
															<div class="form-group">
																<label for="using" class="col-sm-3 control-label no-padding-right">确认新密码</label>
																<div class="col-sm-9">
																	<input type="password" placeholder="确认新密码" name="repassword1" class="col-xs-10 col-sm-10">
																</div>
															</div>
														
															<div class="form-group">
																<div class="col-md-offset-5 col-md-7">
																	<input class="btn btn-info" type="submit" value="提交修改" name="pwd_update">
																</div>
															</div>
														</form>	
													</div>
												</div>
											</div>
										</div><!-- /.span -->
									</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			
			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder" style="margin-right: 20px;">
								<img src="${pageContext.request.contextPath }/assets/img/2.png" style="width: 23px;margin-top: -3px; margin-right: 4px;">
								课程设计
							</span>
							小型图书馆管理系统
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

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			$(function(){
				$('.submenu li').removeClass('active').eq(4).addClass('active');
			});
		</script>
	</body>
</html>
