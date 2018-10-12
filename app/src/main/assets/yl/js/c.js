//慧联系 JavaScript Document
var pengyouquan,pengyouquan1;
function startwitcontact(u){//调用慧联系APP
	var tg=document.createElement("textarea");tg.value=u;
	document.body.appendChild(tg);
	tg.setSelectionRange(0,u.length);tg.focus();//光标选中范围
	document.execCommand("Cut","false",null);tg.blur();
	if(browser=="micromessenger"||browser=="qq"){
		location.href="http://sj.qq.com/myapp/detail.htm?apkName=com.witknow.witcontact"}else{location.href="witbrowser://com.witknow.witcontact?json="+u;}
}
function getpengyouquan(){//获得朋友圈数组
	pengyouquan=localStorage.pengyouquan?JSON.parse(localStorage.pengyouquan):[];
	pengyouquan1=_u.user_phone;//获得朋友圈手机号组串
	for(var i=0;i<pengyouquan.length;i++){pengyouquan1+=","+pengyouquan[i].user_phone;}
} 
function select_person(f){//调用人脉;f==1表示回调生成列表
	lastobj=event.srcElement.tagName=="IMG"?event.srcElement.parentNode:event.srcElement;
	if(f){lastobj.dataset.ft=f};
	if(flag!=8){postmessage({functionname:'selectperson',witparams:{mode:(f==2?"single":"")},callback:"selectCard"})}
	else{window.open('http://www.witknow.com/ljj/c/select.html?t=selectCard'+(f==2?'&mode=single':''))}
}     
function selectCard(m){
	if(m){
		if(lastobj.dataset.ft==1){//回调生成列表
		    for(var i=0,ln=m.length;i<ln;i++){
				if(pengyouquan.findIndex(function(a){return a.user_phone==m[i].user_phone;})<0)pengyouquan.unshift(m[i])}				
			localStorage.pengyouquan = JSON.stringify(pengyouquan);
			setpersonli();
		}else if(lastobj.dataset.ft==2){//单选，回填手机号和姓名
			var ob=lastobj.previousSibling;
			ob.value=m[0].user_phone;
			ob.previousSibling.value=m[0].per_full_name;
		}else{//多选，回填多个姓名，手机号写入title中
			var ob=lastobj.previousSibling;
			ob.dataset.person=ob.value=m[0].per_full_name;ob.title=m[0].user_phone;
			for(var i=1;i<m.length;i++){ob.dataset.person+=","+m[i].per_full_name;
				ob.value+=","+m[i].per_full_name;ob.title+=","+m[i].user_phone;}
	}}
}
var l = [{v:1},{v:2},{v:3}];
var i = l.findIndex(function(v){return v.v === 2;});

function setpersonli(){//生成朋友列表
	var ln=pengyouquan.length,cont="";console.log(pengyouquan);
	for(var i=0;i<ln;i++){cont+='<li class="FL W11 H ALP bordB bgc9" title="'+pengyouquan[i].user_phone+'" >'+pengyouquan[i].per_full_name+'<img src="../img/btn/delx.png" class="FR ICON" onclick="delfriend('+i+')" /></li>'
	}
	document.getElementById("friends").innerHTML=cont;
}
function delfriend(d){//删除朋友
	del_parent();	pengyouquan.splice(d,1);
	localStorage.pengyouquan = JSON.stringify(pengyouquan);
}

function post_score(){//提交成绩
	var json={},map=new Map();
	json.user_guid=_u.user_guid;json.nickname=_u.per_nick_name;
	json.create_datetime="2017-01-08 00:00:00";json.id=0;
	json.user_phone=_u.user_phone;json.score=timestop(); 
	json.gamegrade=sq*100000000+parseInt(document.getElementById("pintu").title);
	map.put("token",_u.token); map.put("userguid",_u.user_guid);
	map.put("pintuscorejson",json); console.log(map);
    WITAJAX.ajaxmap(map,"http://121.43.233.185/mavenwitbrowser/pintu/createscore.do",score_order,error);
}
function score_order(d){//返回全国排名
	console.log(d);
	document.getElementById("worldod").innerHTML='<div class="clear W11 F8 LH2 AC colorR">全球第'+(d.grade+1)+'名</div><div class="W11 F8 LH2 ffKT">'+_u.per_nick_name+'</div>';hide("postbtn");
}
function get_score(){//获取成绩朋友圈排名
	var map = new Map();
	map.put("token",_u.token); map.put("userguid",_u.user_guid);
	map.put("gamegrade",sq*100000000+parseInt(document.getElementById("pintu").title));
    map.put("userphone",pengyouquan1);console.log(map);
    WITAJAX.ajaxmap(map,"http://121.43.233.185/mavenwitbrowser/pintu/retrievescore.do",scoretable,error);
}
function scoretable(d){//生成朋友圈排名
	var scores=d.message,ln=scores.length,cont="";console.log(d);
	for(var i=0;i<ln;i++){cont+='<div class="clear W11 H bordB" ><span class="FL ALP colorR">第'+(i+1)+'名</span><span >'+scores[i].nickname+'</span><span class="FR F3 ACP">成绩'+scores[i].score+'秒</span></div>'
	}
	document.getElementById("result").innerHTML=cont;
}

function goInfo_page(p){//跳转到详情页
	var p=actobj?actobj.title:_u.user_phone;
	if(AgentInfo.indexOf("witknowc")>=0){postmessage({functionname: "goInfo",witparams:{userphone: p}})
	}else if(flag==8){if(browser == "witknow") {console.log("详情跳转",p);
        var per = JSON.parse(externalfun.perexistsbyuserphone(p));
         per?(window.open("../c/card.html?lid="+per.local_id)):alert("无此用户信息！");
    	} 
	}else{startwitcontact("wit_XQ$"+p)}
}
function postcloudcard(p){//发名片
	var p=actobj?actobj.title:_u.user_phone;
   if(AgentInfo.indexOf("witknowc")>=0){postmessage({functionname: "cloudcard",witparams: {card:p}})
   }else if(flag==8){if(browser=="witknow"){console.log("发送名片：",p);
		externalfun.sendcard(function (msg){alert(JSON.parse(msg).result>=1?"名片发送成功":"名片发送失败！")},p,JSON.parse(externalfun.getmyusercard(localStorage.getItem("lastCard")||1)).card.user_content);}
    }else{startwitcontact("wit_FS$"+p)}
}
function sendpmes(){//跳转去发消息
	var p=actobj?actobj.title:_u.user_phone;n =_u.per_full_name||_u.per_nick_name;
 	if(AgentInfo.indexOf(witknow)>=0){postmessage({functionname:"sendmessage",witparams:{user_phone: p, user_name:""}})
 	}else if(flag==8){if(browser=="witknow"){window.open('../c/message.html?u='+p+'&n='+encodeURIComponent(n))}
	}else{startwitcontact("wit_XX$"+p)}
}
function callphone(tel){//拨打电话  
  var tel_n=tel||(actobj?actobj.title:event.srcElement.previousSibling.value);
  if(tel_n){if(flag<3){window.location.href = "tel:"+tel_n;}
  		else{alert("当前设备不支持拨号")}}
}

