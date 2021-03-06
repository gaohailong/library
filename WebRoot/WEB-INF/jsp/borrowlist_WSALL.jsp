<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header_WS.jsp"%>
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
								<a href="#">图书管理</a>
							</li>
							<li class="active">借阅列表/他人借还处理列表</li>
						</ul><!-- /.breadcrumb -->
					</div>
		</div>
		<div class="main-content-inner">
					<div class="page-content">
						<div class="tableBigDiv">
									<table id="example" class="display" cellspacing="0">
										<thead>
											<tr>
												<!--<th hidden="hidden">图书序号</th> -->
												<th>用户编号</th>
												<th>用户姓名</th>
												<th>用户身份</th>
												<th>图书编号</th>
												<th>图书名称 </th>
												<th>借阅情况</th>
												<th>操作</th>
											</tr>
										</thead>
									</table>
						</div>
					</div>
		</div>
	</div><!-- /.main-content -->
			<style>
				.search_in {
					top: -3px;
				}
				table.dataTable thead .sorting {
					background-image: none;
				}
				.odd>td,.even>td{
					text-align: center;
				}
			</style>
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

		<!--[if lte IE 8]>
		  <script src="${pageContext.request.contextPath }/assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="${pageContext.request.contextPath }/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.gritter.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/bootbox.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.easypiechart.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.hotkeys.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/select2.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/fuelux.spinner.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/bootstrap-editable.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/ace-editable.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.maskedinput.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/jquery.dataTables.js"></script>
		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath }/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath }/assets/js/ace.min.js"></script>
		
	   			<script>
					$(document).ready(function() {
						$('#example').DataTable({
							"dom": '<"toolbar">frtip',
							"aoColumnDefs": [{
							 "bVisible": true,
							 "aTargets": [ 6 ],
							  "sDefaultContent" : ""
							}],
							"ajax": "../json_save/bookborrowlist.json",
							"bInfo" : false,
							"bScrollInfinite" : true,
		     
		          "bSort" : true,//设置自动排序的地方,true表示排序，false表示取消自动排序
							"oLanguage": {
								"oPaginate": {    
			            "sFirst" : "第一页",    
			            "sPrevious" : "上一页",    
			            "sNext" : "下一页",    
			            "sLast" : "最后一页",
			            "sSearch" : "搜索" 
		          	} 
							},
							"fnCreatedRow": function (nRow, aData, iDataIndex) {
								//$('th:eq(0)').hide();
								//$('td:eq(0)', nRow).hide();
								var chakan1 = $('td:eq(0)', nRow).text();
								var chakan2 = $('td:eq(3)', nRow).text();
								var level = $('td:eq(2)', nRow).text();
								var temp = $('td:eq(5)', nRow).text();
								var inhistory = 99999;
								if(temp == "申请还书中") inhistory = -2;
								else if(temp == "申请借书中") inhistory = -1;
								else if(temp == "借过未还") inhistory = 0;
								else inhistory = 1;
								
								var strCookie = document.cookie.split(";");
								var flag = false;
								for(var i = 0;i < strCookie.length;i++){
									var temp = strCookie[i].split("=");
									if(temp[0]=="sError" && temp[1]=="0")
										flag = true;
								}
								if(!flag){	//取消还书借书申请暂时不做了，借过已还又想继续续借的，也暂时不做了
									if(level == "学生"){
										if(inhistory == -2)
							   				$('td:eq(6)', nRow).html("<a href='../servlet/BorrowChaKanServlet?chakan1="+chakan1+"&chakan2="+chakan2+"'>查看</a>"
							   					+"/<a href='../servlet/ReturnFunctionServlet_1?chakan1="+chakan1+"&chakan2="+chakan2+"'>确认其还书</a>");
										else if(inhistory == -1)
											$('td:eq(6)', nRow).html("<a href='../servlet/BorrowChaKanServlet?chakan1="+chakan1+"&chakan2="+chakan2+"'>查看</a>"
								   					+"/<a href='../servlet/BorrowFunctionServlet_1?chakan1="+chakan1+"&chakan2="+chakan2+"'>确认其借书</a>");
										else
											$('td:eq(6)', nRow).html("<a href='../servlet/BorrowChaKanServlet?chakan1="+chakan1+"&chakan2="+chakan2+"'>查看</a>");
									}
									if(level == "工作者"){
										if(inhistory == 0)
							   				$('td:eq(6)', nRow).html("<a href='../servlet/BorrowChaKanServlet?chakan1="+chakan1+"&chakan2="+chakan2+"'>查看</a>"
							   					+"/<a href='../servlet/ReturnFunctionServlet_1?chakan1="+chakan1+"&chakan2="+chakan2+"'>确认其退订</a>");
										else
							   				$('td:eq(6)', nRow).html("<a href='../servlet/BorrowChaKanServlet?chakan1="+chakan1+"&chakan2="+chakan2+"'>查看</a>");
									}
								}
								else
									$('td:eq(6)', nRow).html("");
							}
						});
						
						$("div.toolbar").html("<select id='stype' onChange='window.location=this.options[this.selectedIndex].value'>"
								+"<option value='${pageContext.request.contextPath}/servlet/Borrow_WSALL_UIListServlet' "+
								"onclick='window.location=this.value'>待处理借书列表</option>"
								+"<option value='${pageContext.request.contextPath}/servlet/Borrow_WS_UIListServlet'>个人借书列表</option>"
								+"</select>");
		
						var table = $('#example').DataTable();
						$('#example tbody').on('click','tr',function () {
							// $(this).toggleClass('selected');
							$(this).addClass('selected').siblings().removeClass('selected');
						});
						$('#button').click(function () {
							table.rows('.selected').remove().draw(false);
						});
		
						$("#example_length > label").remove();
						$("#example_filter").html("<form name='search_form' action=../servlet/Borrow_WSAll_UIListServlet method=post><label><input name='searchBorroeInfo' placeholder='请输入书名或用户名' type='search' class='' style='width:280px' aria-controls='example'><input type='submit' value='搜索' class='search_in btn btn-info btn-xs' name='search'></label></form>");
					});
				</script>
		<script>
			$(function(){
				$('.submenu li').removeClass('active').eq(1).addClass('active');
			});
		</script>
	</body>
</html>
