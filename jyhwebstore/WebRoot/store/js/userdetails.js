$("#input_nickname").val().length;
	myajax();
	function myajax()
	{
		$.get({
			async:true,
			type:"post",
			url:"/jyhwebstore/ShowUserDetails",
			data:"",
			success:function(result){
				var jsons =JSON.parse(result);
				var picture = jsons.pic;
				var uname = jsons.uname;
				var birth = jsons.birth;
				var sex = jsons.sex;
				var phone = jsons.uphone;
				var mail = jsons.mail;
				var address = jsons.setadd;
				var userbirth = birth.split("-");
				$("#uimg").attr('src',picture);
				$("#lable_nickname").html(uname);
				$("#lable_birth").html(birth);
				$("#lable_sex").html(sex);
				$("#lable_phone").html(phone);
				$("#lable_mail").html(mail);
				$("#lable_address").html(address);
				$("#button_modify").click(function(){
					//给单选框赋值
					if(sex!="nulls")
					{
						if(sex=="男")
						{
							$("input[type='radio']").eq(0).attr("checked",true);
						}
						else
						{ 
							$("input[type='radio']").eq(1).attr("checked",true);
						}
					}	
					$("#uimg").attr('src',picture);
					$("#img").attr('src',picture);
					$("#input_nickname").val(uname);
					$("#input_phone").val(phone);
					$("#input_mail").val(mail);
					$("#input_address").val(address);
					$("#form_userinform").hide();
					$("#form_modify").show();
					//日期下拉框的js赋值==============================================
					var optionyear =document.createElement("option");
					$(optionyear).val(userbirth[0]);
					$(optionyear).text(userbirth[0]);
					$('#birth_year').append(optionyear);
					var optionmonth =document.createElement("option");
					$(optionmonth).val(userbirth[1]);
					$(optionmonth).text(userbirth[1]);
					$('#birth_month').append(optionmonth);
					var optionday =document.createElement("option");
					$(optionday).val(userbirth[2]);
					$(optionday).text(userbirth[2]);
					$('#birth_day').append(optionday);
					//===============================================================
				});
			}
		});
	}
	
	var content;
	function show(obj){
		var fr =new  FileReader();
		var f = obj.files[0];
		fr.readAsDataURL(f);
		fr.onload=function(e){
		content = e.target.result;
		var filemin = 0;
		var filemax = 1024;
		var filesize = f.size/1024;
		//预览
		document.getElementById("img").src=content;
		if(filesize>filemax)
		{
			$("#limitpicmax").fadeIn(1000);
			$("#limitpicmax").fadeOut(2000);
			//alert("文件大小不能超过1MB");
			$("#button_save").attr("disabled","disabled");
			return false;
		}
		else if(filesize<filemin)
		{
			$("#limitpicmin").fadeIn(1000);
			$("#limitpicmin").fadeOut(2000);
			//alert("文件大小不能小于0MB");
			$("#button_save").attr("disabled","disabled");
			return false;
		}
		if(filemin<=filesize && filesize<=filemax)
		{
			$("#button_save").removeAttr("disabled");			
		}
		};
	}
	function picselect(){
		document.getElementById("input_picture").click();
	}
	//保存信息
	$("#button_save").click(function(){
		$("#loading").show();
		//alert($("input:radio:checked").val());
		if($("#input_nickname").val()==""||($("input:radio:checked").val()!="男" && $("input:radio:checked").val()!="女" )||$("#input_phone").val()==""||($("#input_mail").val()=="nulls" || $("#input_mail").val()=="")||($("#input_address").val()=="nulls" || $("#input_address").val()=="")||$("#birth_year").val()==""||$("#birth_month").val()==""||$("#birth_day").val()=="")
			{
			$("#input_nickname").focus();
			alert("抱歉昵称/出生年月/性别/电话/邮箱/住址不能为空");
			$("#loading").hide();
			}
		else
			{
				var nickname = $("#input_nickname").val();
				var userbirth = $("#birth_year").val()+"-"+$("#birth_month").val()+"-"+$("#birth_day").val();
				var usersex = $("input:radio:checked").val();
				var userphone = $("#input_phone").val();
				var usermail = $("#input_mail").val();
				var useradd = $("#input_address").val();
				var reg =/^1[3-5678]\d{9}$/;
				var mailreg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/g;
				if(reg.test(userphone) && mailreg.test(usermail))
				{
					$.get({
						type:"post",
						url:"/jyhwebstore/uploadServlet",
						data:{"nickname":nickname,"userbirth":userbirth,"usersex":usersex,"userphone":userphone,"usermail":usermail,"useraddress":useradd,"picture":content},
						success:function(result){
							var jsons =JSON.parse(result);
							if(jsons.flag==true)
							{
								$("#loading").hide();
								$("#message").show();
								$("#message").fadeOut(2000);
								myajax();
								$("#form_modify").hide();
								$("#form_userinform").show();
								location.reload();
							}	
							else
							{
								if(jsons.error==false)
								{
									alert("手机号或用户名已存在！");
									$("#loading").hide();
									
								}
								else
								{
									alert("系统错误！");
									location.href = "/jyhwebstore/store/html/login.jsp?id=systemerror";
								}
							}
						}
					});
				}
				else
				{
					if(reg.test(userphone)==false)
					{
						$("#input_phone").focus();
						alert("请检查您的手机号是否正确");
						$("#loading").hide();
					}
					else if(!mailreg.test(usermail))
					{
						$("#input_mail").focus();
						alert("请检查您的邮箱是否正确");
						$("#loading").hide();
					}	
				}
			}
	});