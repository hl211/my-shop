<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/back/Admin/">

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/jquery-ui-1.10.0.custom.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script> 
    <script src="../assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
<script>
    $(function () {
		$("#backid").click(function(){
			window.location.href="getManagers.bg?criteriaManagerName=${param.criteriaManagerName}";
		 });
		var flag = false;
		$("input:password").focus(function(){
			this.style.imeMode = 'disabled';// 禁用输入法,禁止输入中文字符
		});
		$("#managerPassword").blur(function(){
			$(this).parent("td").children("font").remove();
			var pass = $(this).val();
			if(!isPassword(pass)){
				$(this).parent("td").append("<font color='red'></br><i>密码为6-18位的字母、数字、下划线组合</i><font>");
				return;
			}
			flag = true;
		}).tooltip();
		$("#repassword").blur(function(){
			$(this).parent("td").children("font").remove();
			var pass = $("#managerPassword").val();
			var repass = $(this).val();
			if(!isPassword(repass)){
				$(this).parent("td").append("<font color='red'></br><i>密码为6-18位的字母、数字、下划线组合</i><font>");
				return;
			}
			if(pass!=repass){
				$(this).parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
			}
			flag = true;
		});
		$("#editsubmit").click(function() {
			var pass = $("#managerPassword").val();
			var repass = $("#repassword").val();
			$("#repassword").parent("td").children("font").remove();
			if(pass!=repass){
				$("#repassword").parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
				return;
			}
			var managerId = $("#managerId").val();
			var managerPassword = $("#managerPassword").val();
			if($.trim(managerPassword)==""){
				alert("密码不能为空！");
				return;
			};
			if(!flag){
				return;
			}
			var json = {"managerId":managerId,"managerPassword":managerPassword};
			var url = "Admin/editManager.bg";
			$.post(url,json,function(data){
				var addManagerStatus = data[0].addManagerStatus;
				alert(addManagerStatus);
			},"json");
		});

    });
    function isPassword(pass){
    	var reg = /^[a-zA-Z0-9_]{6,18}$/;
    	return reg.test(pass);
    }
</script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
    <tr>
        <td width="10%" class="tableleft">账户名称</td>
        <td>${requestScope.manager.managerName }</td>
    </tr>
    <tr>
        <td class="tableleft">账户密码</td>
        <td ><input title="密码为6-18位的字母、数字、下划线组合" id="managerPassword" type="password" name="managerPassword" value="${requestScope.manager.managerPassword }"/></td>
    </tr> 
    <tr>
		<td class="tableleft">确认密码</td>
		<td><input type="password" id="repassword" value="${requestScope.manager.managerPassword }"></td>
	</tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button id="editsubmit" type="button" class="btn btn-primary" type="button">保存</button> 
            &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
        </td>
    </tr>
</table>
<input type="hidden" id="managerId" name="managerId" value="${requestScope.manager.managerId }"/>
</form>
</body>
</html>
