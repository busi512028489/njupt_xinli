$(document).ready(function() {
	$("#btn_Ok").click(function() {
		save();
	});
});
function save(){
	var id=document.getElementById("id").value;
	var name=document.getElementById("name").value;
	var sex=document.getElementById("sex").value;
	var tel=document.getElementById("tel").value;
	var academy=document.getElementById("academy").value;
	var grade=document.getElementById("grade").value;
	var reason=document.getElementById("reason").value;
	var state=document.getElementById("state").value;
	var require=document.getElementById("require").value;
	var emergency=document.getElementById("emergency").value;
	var week1=document.getElementById("week1").value;
	var time1=document.getElementById("time1").value;
	var week2=document.getElementById("week2").value;
	var time2=document.getElementById("time2").value;
	$.ajax({
		type : "GET",
		url : 'StudentAction', // 目标地址
		cache : true,
		data : "ActionFlag=stu_order&xh="+id+"&name="+name+"&sex="+sex+"&tel="+tel+"&academy="+academy+"&grade="+grade+"&reason="+reason+"&state="+state+"&require="+require+"&emergency="+emergency+"&week1="+week1+"&time1="+time1+"&week2="+week2+"&time2="+time2+"",
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			if (data == "yes") {
				alert("预约成功");
			} else {
				alert("预约失败");
			}
		}
	});
}