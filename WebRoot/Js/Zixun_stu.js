$(document).ready(function(){
	sel_5();
});


function save1(){
	var dd1 = document.getElementById("dd1").value;
	    var tableInfo = "";
	    var data_table=[];
	    var tableObj = document.getElementById("no_arrange1");
	    for (var i = 1; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
	        for (var j = 1; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
	        	if (tableObj.rows[i].cells[j].innerText != "") {
	        		tableInfo = "星期"+j+"第"+i+"时间段"+tableObj.rows[i].cells[j].innerText;   //获取Table中单元格的内容
	        		data_table.push(tableInfo);
	        	}
	        }
	    }
	    $.ajax({
			type : "GET",
			url : 'ArrangeAction', // 目标地址
			cache : true,
			data : "ActionFlag=save1&data_table="+data_table+"&room=1&dd1="+dd1+"", // 数据
			error : function(eer) {
				$.messager.alert('错误信息', '请求发生错误！', 'error');
			},
			success : function(data) {
				if (data == "yes") {
					alert("保存成功");
				} else {
					alert("保存失败");
				}
			}
		});
}
function save2(){
	var dd1 = document.getElementById("dd1").value;
    var tableInfo = "";
    var data_table=[];
    var tableObj = document.getElementById("no_arrange2");
    for (var i = 1; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
        for (var j = 1; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
        	if (tableObj.rows[i].cells[j].innerText != "") {
        		tableInfo += "星期"+j+"第"+i+"时间段"+tableObj.rows[i].cells[j].innerText;   //获取Table中单元格的内容
        		data_table.push(tableInfo);
        	}
        }
    }
    $.ajax({
		type : "GET",
		url : 'ArrangeAction', // 目标地址
		cache : true,
		data : "ActionFlag=save1&data_table="+data_table+"&room=2&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			if (data == "yes") {
				alert("保存成功");
			} else {
				alert("保存失败");
			}
		}
	});
}
function save3(){
	var dd1 = document.getElementById("dd1").value;
    var tableInfo = "";
    var data_table=[];
    var tableObj = document.getElementById("no_arrange3");
    for (var i = 1; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
        for (var j = 1; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
        	if (tableObj.rows[i].cells[j].innerText != "") {
        		tableInfo += "星期"+j+"第"+i+"时间段"+tableObj.rows[i].cells[j].innerText;   //获取Table中单元格的内容
        		data_table.push(tableInfo);
        	}
        }
    }
    $.ajax({
		type : "GET",
		url : 'ArrangeAction', // 目标地址
		cache : true,
		data : "ActionFlag=save1&data_table="+data_table+"&room=3&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			if (data == "yes") {
				alert("保存成功");
			} else {
				alert("保存失败");
			}
		}
	});
}
function save4(){
	var dd1 = document.getElementById("dd1").value;
    var tableInfo = "";
    var data_table=[];
    var tableObj = document.getElementById("no_arrange4");
    for (var i = 1; i < tableObj.rows.length; i++) {    //遍历Table的所有Row
        for (var j = 1; j < tableObj.rows[i].cells.length; j++) {   //遍历Row中的每一列
        	if (tableObj.rows[i].cells[j].innerText != "") {
        		tableInfo += "星期"+j+"第"+i+"时间段"+tableObj.rows[i].cells[j].innerText;   //获取Table中单元格的内容
        		data_table.push(tableInfo);
        	}
        }
    }
    $.ajax({
		type : "GET",
		url : 'ArrangeAction', // 目标地址
		cache : true,
		data : "ActionFlag=save1&data_table="+data_table+"&room=4&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			if (data == "yes") {
				alert("保存成功");
			} else {
				alert("保存失败");
			}
		}
	});
}
function sel_5(){
	$.ajax({
		type : "GET",
		url : 'ArrangeAction', // 目标地址
		data : "ActionFlag=getinformation", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(data) {
			var str="<table>";
			$.each(JSON.parse(data), function(i, obj) {
				str += "<tr><td><div class='item'><a href='Detail.htm?xh="+obj.xh+"&zcdate="+obj.zcdate+"'>"+obj.xh+"</a></div></td></tr>";  
			});  
			str +="<tr><td><div class='item'><a href='Detail.htm'>点我添加预约学生信息</a></div></td></tr>";
			str +="</table>";
			var e1 = document.getElementById("e1");
			e1.innerHTML=str;
			var e2 = document.getElementById("e2");
			e2.innerHTML=str;
			var e3 = document.getElementById("e3");
			e3.innerHTML=str;
			var e4 = document.getElementById("e4");
			e4.innerHTML=str;
			$(function(){
				$('.left .item').draggable({
					revert:true,
					proxy:'clone'
				});
				$('.right td.drop').droppable({
					onDragEnter:function(){
						$(this).addClass('over');
					},
					onDragLeave:function(){
						$(this).removeClass('over');
					},
					onDrop:function(e,source){
						$(this).removeClass('over');
						if ($(source).hasClass('assigned')){
							$(this).append(source);
						} else {
							var c = $(source).clone().addClass('assigned');
							$(this).empty().append(c);
							c.draggable({
								revert:true
							});
						}
					}
				});
			});
		}
	});      
}

