$(document).ready(function() {
	$.ajax({
        type: "Get",
        url: 'InformationAction', // 目标地址
        data: "ActionFlag=Information_no" , // 数据
        cache: false,
        dataType : 'json',
        error: function(eer) {
            $.messager.alert('错误信息', '请求发生错误！', 'error');
        },
        success: function(data) {
        	var str="超过3天未处理的消息，请及时处理";
        	str+="<ul>";
        	var xqo = eval(data);
        	for(var i in xqo){
        		str+="<li>学号为"+xqo[i].xh+"</li>";
        	}
        	str+="</ul>";
        	var e1 = document.getElementById("tixing");
			e1.innerHTML=str;
        },
	});
})