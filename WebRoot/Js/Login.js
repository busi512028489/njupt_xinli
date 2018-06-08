$(document).ready(function() {
	$("#btn_Ok").click(function() {
		CheckLogin();
	});
});

function CheckLogin() {
	var UserName = document.getElementById("txtUserName").value;
	var UserPwd = document.getElementById("txtUserPwd").value;
	var msg = "";
	if (UserName == "") {
		msg = msg + "用户名不能为空！\n";
	}
	if (UserPwd == "") {
		msg = msg + "密码不能为空！\n";
	}
	if (msg != "") {
		$.messager.alert('错误信息', msg, 'error');
		return false;
	} else {
		$.ajax({
			type : "POST",
			url : 'LoginAction', // 目标地址
			cache : false,
			data : "ActionFlag=login&username="+UserName+"&password="+UserPwd,
			error : function(eer) {
				$.messager.alert('错误信息', '请求发生错误！', 'error');
			},
			success : function(data) {
				if (data=="1") {
					location.href = "Student.htm";
				}else if (data=="0"){
					location.href = "Teacher.htm";
				}else if (data=="2"){
					location.href = "zixuntea.htm?tea="+UserName+"";
				} else {
					alert("账号或密码错误");
				}
			}
		});
	}
}