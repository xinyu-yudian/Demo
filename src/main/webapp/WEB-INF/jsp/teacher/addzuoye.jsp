<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
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

				</div>
				<div class="panel-body">
					<form class="form-horizontal"  enctype="multipart/form-data"  role="form" action="/teacher/addzuoye" id="editfrom" method="post">


						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">作业名称</label>
							<div class="col-sm-10">
								<input type="text" name="filename" class="form-control" id="inputPassword3" placeholder="请输入">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">作业描述</label>
							<div class="col-sm-10">
								<input type="text" name="bz" class="form-control" id="inputPassword3" placeholder="请输入">
							</div>
						</div>

						<div class="form-group" style="margin-left: 200px">
							<button class="btn btn-default" type="submit">提交</button>
							<button class="btn btn-default" type="reset">重置</button>
						</div>
					</form>
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
    $("#nav li:nth-child(2)").addClass("active")
    $('input[id=lefile]').change(function() {
        $('#photoCover').val($(this).val());
    });
</script>
</html>