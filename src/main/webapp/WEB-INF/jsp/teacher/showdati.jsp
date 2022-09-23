<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>课程信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">作业列表</h1>


						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>学生</th>
									<th>作业名称</th>
									<th>作业描述</th>
									<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${dati}" var="item">
								<tr>
									<td>${item.userName}</td>
									<td>${item.filename}</td>
									<td>${item.bz}</td>
									<td>

											<button class="btn btn-danger btn-xs btn-info"  onClick="location.href='/teacher/download?filename=${item.filename}'">下载</button>

									</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				    <div class="panel-footer">

				    </div>
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>

</body>
	<script type="text/javascript">
		<%--设置菜单中--%>
		$("#nav li:nth-child(1)").addClass("active")
        <c:if test="${pagingVO != null}">
        if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
            $(".pagination li:last-child").addClass("disabled")
        };

        if (${pagingVO.curentPageNo} == ${1}) {
            $(".pagination li:nth-child(1)").addClass("disabled")
        };
        </c:if>

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }



        $('.selectcource').on('click',function () {
			var a=$(this).parent('td').siblings('.nopeople').html();
            var id=$(this).parent('td').siblings('.id').html();
            var count =$('#count').val();
            if(count>0){
                $('#myModalcount').modal("show")
            }
            else if(a<=0){
			   // alert('此课程已满，请选择别的课程')
                $('#myModal').modal("show")
			}
			else{
			    window.location.href='/student/stuSelectedCourse?id='+id;
			}
        })
	</script>
</html>