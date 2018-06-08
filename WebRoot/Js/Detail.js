function getQueryString(name) {    
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");   
	var r = window.location.search.substr(1).match(reg);   
	if (r != null) return decodeURI(r[2]); return null;
}
function save(){
	var id=document.getElementById("xh").value;
	var name=document.getElementById("name").value;
	var sex=document.getElementById("sex").value;
	var tel=document.getElementById("tel").value;
	var academy=document.getElementById("academy").value;
	var grade=document.getElementById("grade").value;
	var reason=document.getElementById("reason").value;
	var state=document.getElementById("state").value;
	var require=document.getElementById("require").value;
	var emergency=document.getElementById("emergency").value;
	var timelist=document.getElementById("timelist").value;
	var xinli_tea=document.getElementById("xinli_tea").value;
	var zcdate=getQueryString("zcdate");
	$.ajax({
		type : "GET",
		url : 'DetailAction', // 目标地址
		cache : true,
		data : "ActionFlag=detail_update&xh="+id+"&zcdate="+zcdate+"&name="+name+"&sex="+sex+"&tel="+tel+"&academy="+academy+"&grade="+grade+"&reason="+reason+"&state="+state+"&require="+require+"&emergency="+emergency+"&timelist="+timelist+"&xinli_tea="+xinli_tea+"",
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(msg) {
			if (msg == "yes") {
				alert("保存成功");
				window.history.back();
				location.reload();
			} else {
				alert("保存失败");
			}
		}
	});
}
$(document).ready(function() {
	$("#btn_Ok").click(function() {
		save();
	});
	var xh=getQueryString("xh");
	var zcdate=getQueryString("zcdate");
	$.ajax({
		type : "GET",
		url : 'DetailAction', // 目标地址
		cache : true,
		data : "ActionFlag=detail_list_all&xh="+xh+"&zcdate="+zcdate+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			$.each(JSON.parse(data), function(i, data) {
				$("#xh").val(data.xh);
				$("#emergency").val(data.emergency);
				$("#timelist").val(data.timelist);
				$("#reason").val(data.reason);
				$("#state").val(data.state);
				$("#require").val(data.require1);
				$("#xinli_tea").val(data.tea);
			});
		}
	});
	$.ajax({
		type : "GET",
		url : 'DetailAction', // 目标地址
		cache : true,
		data : "ActionFlag=detail_list_all1&xh="+xh+"&zcdate="+zcdate+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			$.each(JSON.parse(data), function(i, data) {
				$("#name").val(data.name);
				$("#sex").val(data.sex);
				$("#academy").val(data.academy);
				$("#tel").val(data.tel);
				$("#grade").val(data.grade);
			});
		}
	});
})
