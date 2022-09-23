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
	<script src="/js/My97DatePicker/WdatePicker.js"></script>
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
						<h1 style="text-align: center;">选课时间设置</h1>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form" action="/admin/saveData" id="editfrom" method="post">
						<c:if test="${not empty  cdate}">
						<div class="form-group">
							<label  class="col-sm-2 control-label">上次设置选课时间为</label>
							<div class="col-sm-10">
								${cdate.starttime}至${cdate.endtime}
								</div>
						</div>
						</c:if>
						<div class="form-group">
							<label  class="col-sm-2 control-label">选课开始时间</label>
							<div class="col-sm-10">
								<input type="text" name="starttime" class="form-control" id="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}',minDate:'now()'})" value="" />
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">选课结束时间</label>
							<div class="col-sm-10">
								<input type="text" name="endtime" id="endTime" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'})"  value="" name="courseid" >
							</div>
						</div>
						<div class="form-group" style="text-align: center">
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
    $("#nav li:nth-child(5)").addClass("active")


   /* var now = Date.parse(new Date().format("yyyy-MM-dd hh:mm").replace('-','/'));
    /!**
     * 开始时间的最小时间
     *
     *!/
    var startMinDate = function(){
        var endTime = $("#endTime").val();
        var time = Date.parse(endTime.replace('-','/'));
        //结束时间不能超过当前时间+7天
        if(endTime!=""&&(time-7*24*60*60*1000)>now){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
        //结束时间不能小于当前时间，诺小于则返回当前时间
        if(endTime!=""&&(time-1*24*60*60*1000)<=now){
            return new Date(now).format("yyyy-MM-dd hh:mm");
        }
        if(endTime==""){
            return new Date(now).format("yyyy-MM-dd hh:mm");
        }else{
            return new Date(time-1*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
    }
    /!**
     * 开始时间的最大时间
     *!/
    var startMaxDate = function(){
        var endTime = $("#endTime").val();
        var time = Date.parse(endTime.replace('-','/'));
        //结束时间不能超过当前时间+7天
        if(endTime!=""&&(time-7*24*60*60*1000)>now){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
        //结束时间不能小于当前时间，诺小于则返回当前时间
        if(endTime!=""&&(time-1*24*60*60*1000)<=now){
            return new Date(time).format("yyyy-MM-dd hh:mm");
        }
        if(endTime==""){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }else{
            return new Date(time).format("yyyy-MM-dd hh:mm");
        }
    }
    /!**
     * 结束时间的最小时间
     *!/
    var endMinDate = function(){
        var startTime = $("#startTime").val();
        var time = Date.parse(startTime.replace('-','/'));
        //开始时间不能大于当前时间+7天
        if(startTime!=""&&(time-7*24*60*60*1000)>=now){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
        //开始时间不能小于当前时间
        if(startTime!=""&&time<now){
            return new Date(now).format("yyyy-MM-dd hh:mm");
        }
        if(startTime==""){
            return new Date(now).format("yyyy-MM-dd hh:mm");
        }else{
            return new Date(time).format("yyyy-MM-dd hh:mm");
        }
    }

    /!**
     * 结束时间的最大时间
     *!/
    var endMaxDate= function(){
        var startTime = $("#startTime").val();
        var time = Date.parse(startTime.replace('-','/'));
        //开始时间不能大于当前时间+7天
        if(startTime!=""&&(time-7*24*60*60*1000)>=now){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");

        }
        //开始时间不能小于当前时间
        if(startTime!=""&&time<now){
            return new Date(time+1*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
        if(startTime==""){
            return new Date(now+7*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }else{
            return new Date(time+1*24*60*60*1000).format("yyyy-MM-dd hh:mm");
        }
    }*/
</script>
</html>