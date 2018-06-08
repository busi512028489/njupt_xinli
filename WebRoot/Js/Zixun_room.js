function submit_history(){
	sel_1();
	sel_2();
	sel_3();
	sel_4();
};
function sel_1(){
	var dd1 = document.getElementById("dd1").value;
	$.ajax({
		type : "GET",
		url : 'RoomAction', // 目标地址
		cache : true,
		data : "ActionFlag=Information_list_A&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var arr1=[["咨询室1时间段","星期一","星期二","星期三","星期四","星期五"]];
			for(var i = 1 ; i < 5 ; i++){
		          arr1.push([i+""]);
		          for(var j = 0 ; j < 5 ; j++){
		              arr1[arr1.length-1].push(" ");
		          }
		    }
			$.each(JSON.parse(arr), function(i, arr) {
				 var name = arr.xh;
		         var week = arr.week1;
		         var start = arr.time1;
		         zcdate1 = arr.zcdate;
		         arr1[start][week]={content:name};
			})
				      var str = "";
				      str += "<table border>";
				      for(var i = 0 ; i < arr1.length ; i++){
				          str+="<tr>"
				          for(var j = 0 ; j < arr1[i].length ; j++){
				              if(arr1[i][j] == null){

				              }else if((typeof arr1[i][j]) == "string"){
				                  str+="<td>"+arr1[i][j]+"</td>";
				              }else{
				                  str+="<td><a href='Detail.htm?xh="+arr1[i][j].content+"&zcdate="+zcdate1+"'>"+arr1[i][j].content+"</a></td>"
				              }
				          }    
				          str+="</tr>"
				      }
				      str += "</table>";
				      var a = document.getElementById("a");
				      a.innerHTML=str;
		}
	});
	

}
function sel_2(){
	var dd1 = document.getElementById("dd1").value;
	$.ajax({
		type : "GET",
		url : 'RoomAction', // 目标地址
		cache : true,
		data : "ActionFlag=Information_list_B&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var arr1=[["咨询室1时间段","星期一","星期二","星期三","星期四","星期五"]];
			for(var i = 1 ; i < 5 ; i++){
		          arr1.push([i+""]);
		          for(var j = 0 ; j < 5 ; j++){
		              arr1[arr1.length-1].push(" ");
		          }
		    }
			$.each(JSON.parse(arr), function(i, arr) {
				 var name = arr.xh;
		         var week = arr.week1;
		         var start = arr.time1;
		         zcdate2 = arr.zcdate;
		         arr1[start][week]={content:name};
			})
				      var str = "";
				      str += "<table border>";
				      for(var i = 0 ; i < arr1.length ; i++){
				          str+="<tr>"
				          for(var j = 0 ; j < arr1[i].length ; j++){
				              if(arr1[i][j] == null){

				              }else if((typeof arr1[i][j]) == "string"){
				                  str+="<td>"+arr1[i][j]+"</td>";
				              }else{
				                  str+="<td><a href='Detail.htm?xh="+arr1[i][j].content+"&zcdate="+zcdate2+"'>"+arr1[i][j].content+"</a></td>"
				              }
				          }    
				          str+="</tr>"
				      }
				      str += "</table>";
				      var a = document.getElementById("b");
				      a.innerHTML=str;
		}
	});
	

}
function sel_3(){
	var dd1 = document.getElementById("dd1").value;
	$.ajax({
		type : "GET",
		url : 'RoomAction', // 目标地址
		cache : true,
		data : "ActionFlag=Information_list_C&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var arr1=[["咨询室1时间段","星期一","星期二","星期三","星期四","星期五"]];
			for(var i = 1 ; i < 5 ; i++){
		          arr1.push([i+""]);
		          for(var j = 0 ; j < 5 ; j++){
		              arr1[arr1.length-1].push(" ");
		          }
		    }
			$.each(JSON.parse(arr), function(i, arr) {
				 var name = arr.xh;
		         var week = arr.week1;
		         var start = arr.time1;
		         zcdate3 = arr.zcdate;
		         arr1[start][week]={content:name};
			})
				      var str = "";
				      str += "<table border>";
				      for(var i = 0 ; i < arr1.length ; i++){
				          str+="<tr>"
				          for(var j = 0 ; j < arr1[i].length ; j++){
				              if(arr1[i][j] == null){

				              }else if((typeof arr1[i][j]) == "string"){
				                  str+="<td>"+arr1[i][j]+"</td>";
				              }else{
				                  str+="<td><a href='Detail.htm?xh="+arr1[i][j].content+"&zcdate="+zcdate3+"'>"+arr1[i][j].content+"</a></td>"
				              }
				          }    
				          str+="</tr>"
				      }
				      str += "</table>";
				      var a = document.getElementById("c");
				      a.innerHTML=str;
		}
	});
	

}
function sel_4(){
	var dd1 = document.getElementById("dd1").value;
	$.ajax({
		type : "GET",
		url : 'RoomAction', // 目标地址
		cache : true,
		data : "ActionFlag=Information_list_D&dd1="+dd1+"", // 数据
		error : function(eer) {
			$.messager.alert('错误信息', '请求发生错误！', 'error');
		},
		success : function(arr) {
			var arr1=[["咨询室1时间段","星期一","星期二","星期三","星期四","星期五"]];
			for(var i = 1 ; i < 5 ; i++){
		          arr1.push([i+""]);
		          for(var j = 0 ; j < 5 ; j++){
		              arr1[arr1.length-1].push(" ");
		          }
		    }
			$.each(JSON.parse(arr), function(i, arr) {
				 var name = arr.xh;
		         var week = arr.week1;
		         var start = arr.time1;
		         zcdate4 = arr.zcdate;
		         arr1[start][week]={content:name};
			})
				      var str = "";
				      str += "<table border>";
				      for(var i = 0 ; i < arr1.length ; i++){
				          str+="<tr>"
				          for(var j = 0 ; j < arr1[i].length ; j++){
				              if(arr1[i][j] == null){

				              }else if((typeof arr1[i][j]) == "string"){
				                  str+="<td>"+arr1[i][j]+"</td>";
				              }else{
				                  str+="<td><a href='Detail.htm?xh="+arr1[i][j].content+"&zcdate="+zcdate4+"'>"+arr1[i][j].content+"</a></td>"
				              }
				          }    
				          str+="</tr>"
				      }
				      str += "</table>";
				      var a = document.getElementById("d");
				      a.innerHTML=str;
		}
	});
	

	      
}