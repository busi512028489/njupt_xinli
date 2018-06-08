$(document).ready(function() {
	$.ajax({
        type: "Get",
        url: 'InformationAction', // 目标地址
        data: "ActionFlag=Information_all" , // 数据
        cache: false,
        dataType : 'json',
        error: function(eer) {
            $.messager.alert('错误信息', '请求发生错误！', 'error');
        },
        success: function(data) {
        	var pager = $("#tt").datagrid("getPager"); 
        	      pager.pagination({ 
        	        total:eval(data).length, 
        	        onSelectPage:function (pageNo, pageSize) { 
        	          var start = (pageNo - 1) * pageSize; 
        	          var end = start + pageSize; 
        	          $("#tt").datagrid("loadData", data.slice(start, end)); 
        	          pager.pagination('refresh', { 
        	            total:eval(data).length, 
        	            pageNumber:pageNo 
        	          }); 
        	        } 
        	      }); 

        },
	});
      

})
function getSelected(){
	var row = $('#tt').datagrid('getSelected');
	if (row){
		location.href="Detail.htm?xh="+row.xh+"&zcdate="+row.zcdate+"";
	}
}

function submit_history(){
	var dd1 = document.getElementById("dd1").value;
	var dd2 = document.getElementById("dd2").value;
	$.ajax({
        type: "Get",
        dataType: "json", // 数据格式:JSON
        url: 'InformationAction', // 目标地址
        cache: false,
        data: "ActionFlag=Informationhistory&dd1="+dd1+"&dd2="+dd2+"" , // 数据
        error: function(eer) {
            $.messager.alert('错误信息', '请求发生错误！', 'error');
        },
        success: function(data) {
        	var pager = $("#tt").datagrid("getPager"); 
        	      pager.pagination({ 
        	        total:eval(data).length, 
        	        onSelectPage:function (pageNo, pageSize) { 
        	          var start = (pageNo - 1) * pageSize; 
        	          var end = start + pageSize; 
        	          $("#tt").datagrid("loadData", data.slice(start, end)); 
        	          pager.pagination('refresh', { 
        	            total:eval(data).length, 
        	            pageNumber:pageNo 
        	          }); 
        	        } 
        	      }); 
        }
    });
}
function del() {
	var cc= $("#tt").datagrid("getSelected").xh;
	var dd= $("#tt").datagrid("getSelected").zcdate;
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	         $.ajax({
				url : 'InformationAction',
				type : 'Get',
				data : "ActionFlag=del&xh="+cc+"&zcdate="+dd+"",
				success : function(data) {
					if (data == 1) {
						$.messager.alert("提示","删除成功");
						location.reload();
					} else if(data == 0) {
						$.messager.alert("提示","删除失败");
					} else {
						$.messager.alert("提示","没有选中行");
					}
				}
			});  
	    }    
	});
}