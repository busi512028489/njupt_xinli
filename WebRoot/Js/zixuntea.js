function getQueryString(name) {    
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");    
	var r = window.location.search.substr(1).match(reg);    
	if (r != null) return unescape(r[2]); return null;    
}
$(document).ready(function() {
	sel();
})
function sel(){
	var tea=getQueryString("tea");
	$.ajax({
		type : "GET",
		url : 'TeaAction', // 目标地址
		cache : true,
		data : "ActionFlag=tea2&tea="+tea+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var obj=document.getElementById('sel');
			$.each(JSON.parse(arr), function(i, arr) {
				 var xh = arr.xh;
				 obj.add(new Option(xh,xh)); 
			})
		}
	});
}

function submit_history(){
	
	sel_1();
	sel_2();
}
function sel_1(){
	var dd1 = document.getElementById("dd1").value;
	var tea=getQueryString("tea");
	$.ajax({
		type : "GET",
		url : 'TeaAction', // 目标地址
		cache : true,
		data : "ActionFlag=tea&dd1="+dd1+"&tea="+tea+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var tt = document.getElementById("tt");
			$.each(JSON.parse(arr), function(i, arr) {
				 var str="";
				 var xh = arr.xh;
				 var zcdate = arr.zcdate;
		         var week = arr.week1;
		         var time = arr.time1;
		         var room = arr.room-6;
		         str +="<a href='Detail.htm?xh="+xh+"&zcdate="+zcdate+"'>"+xh+"</a>";
		         tt.rows[time*2].cells[room+week*5].innerHTML=str;
			})
		}
	});
}
function sel_2(){
	var dd1 = document.getElementById("dd1").value;
	var tea=getQueryString("tea");
	$.ajax({
		type : "GET",
		url : 'TeaAction', // 目标地址
		cache : true,
		data : "ActionFlag=all&dd1="+dd1+"&tea="+tea+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var tt = document.getElementById("tt");
			var str="";
			$.each(JSON.parse(arr), function(i, arr) {
				 var xh = arr.xh;
				 var zcdate = arr.zcdate;
		         var week = arr.week1;
		         var time = arr.time1;
		         var room = arr.room-6;
		         tt.rows[time*2].cells[room+week*5].innerHTML="占用";
			})
		}
	});
}
function sub(){
	
	var time1=document.getElementById("time1").value;
	var week1=document.getElementById("week1").value;
	var dd2=document.getElementById("dd2").value;
	var xh=document.getElementById("sel").value;
	$.ajax({
		type : "GET",
		url : 'TeaAction', // 目标地址
		cache : true,
		data : "ActionFlag=upd&week1="+week1+"&dd2="+dd2+"&time1="+time1+"&xh="+xh+"",
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			alert("修改成功");
		}
	});
}