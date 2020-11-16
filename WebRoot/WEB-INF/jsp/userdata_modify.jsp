<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript" src="${pageContext.request.contextPath }/js/laydate.js" >
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
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
								<a href="#">用户管理</a>
							</li>
							<li class="active">用户列表-修改</li>
						</ul><!-- /.breadcrumb -->
					</div>
				</div>
				<div class="main-content-inner">
					<div class="page-content">
					
					<form class="form-horizontal" role="form" action=${pageContext.request.contextPath}/servlet/UserModifyServlet method=post>
						<div class="form-group">
							<label for="name" class="col-sm-3 control-label no-padding-right">用户编号 </label>
							<div class="col-sm-9">
								<input type="text" readonly value=${requestScope.userModifyHuixian.uid}  name="uid" class="col-xs-10 col-sm-5">
							</div>
						</div>
						<div class="form-group">
							<label for="fnum" class="col-sm-3 control-label no-padding-right">用户名称</label>
							<div class="col-sm-9">
								<input type="text" value=${requestScope.userModifyHuixian.name} name="name" class="col-xs-10 col-sm-5">
							</div>
						</div>
						<div class="form-group">
							<label for="tnum" class="col-sm-3 control-label no-padding-right">用户密码</label>
							<div class="col-sm-9">
								<input type="text" value=${requestScope.userModifyHuixian.password} name="password" class="col-xs-10 col-sm-5">
							</div>
						</div>
						<div class="form-group">
							<label for="using" class="col-sm-3 control-label no-padding-right">用户电话</label>
							<div class="col-sm-9">
								<input type="text" value=${requestScope.userModifyHuixian.tel} name="tel" class="col-xs-10 col-sm-5">
							</div>
						</div>
							<div class="form-group">
							<label for="using" class="col-sm-3 control-label no-padding-right">用户身份</label>
							<div class="col-sm-9">
								<label for="vill" class="col-sm-2.5 control-label no-padding-right">管理员</label> <input type="radio" name="level" class="ace" value="2" ${requestScope.userModifyHuixian.level==2?'checked':''}><span class="lbl"></span>&nbsp;
								<label for="vill" class="col-sm-2.5 control-label no-padding-right">工作者</label> <input type="radio" name="level" class="ace" value="1" ${requestScope.userModifyHuixian.level==1?'checked':''}><span class="lbl"></span>&nbsp;
								<label for="vill" class="col-sm-2.5 control-label no-padding-right">学   生</label> <input type="radio" name="level" class="ace" value="0" ${requestScope.userModifyHuixian.level==0?'checked':''}><span class="lbl"></span>;
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-5 col-md-7">
								<input class="btn btn-info" type="submit" value="提交修改" name="book_update">
							</div>
						</div>
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
		<script src="assets/js/jquery.2.1.1.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			$(function(){
				$('.submenu li').removeClass('active').eq(3).addClass('active');
			});
		</script>
	</body>
</html>
