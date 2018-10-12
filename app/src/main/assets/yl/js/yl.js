//医疗共享网JS
var perp=true,pubable=true,sd_data=[],userid,_uu=[{manuf:'',brands:''}],urlpath,actobj,
qx_cata=['血压计','血糖仪','体重计','体温计','胎心仪','心电仪','雾化器','制氧机','通气机','按摩仪','理疗仪','护理床','轮椅','助行器','其它'];
qx_cata3=['心血管','呼吸科','消化科','内分泌','抗肿瘤','营养品','保健屏','五官科','皮肤','骨科','妇产科','其它'];

function href2(){
	location.href="medi"+event.srcElement.title+".html";
}
function wit_disting(){//启动扫描
	actobj=event.srcElement;
	postmessage({functionname:"get2code",callback:"get_codemes"});
}
function get_codemes(d){//二维码信息填充
	var mes=d.message,mesid;
	actobj.nextSibling.innerHTML=mes;actobj.nextSibling.value=mes;
	mesid=mes.split("，硬件版本")[0].slice(-15);
	actobj.previousSibling.value=mesid.slice(-16,-12)+""+mesid.slice(-4);
}

function getcom(t){//查询当前用户是不是供应商、网点、诊所
	if(_u&&_u.user_phone!=""){var map=new Map();
		map.put("token",_u.token);map.put("userguid",_u.user_guid);
		map.put("phone",_u.user_phone);console.log(map);
		WITAJAX.ajaxmap(map,"http://121.43.233.185/mavenmedicalsharing/"+['supply','shop'][t]+"/retrieve.do",function(d){console.log(d);if(d.result==1){_uu=d.message;
		document.getElementById("formf").innerHTML='<div class="ML A11 H AC bordB">'+(t==0?_uu[0].manuf:_uu[0].w_name)+'</div><div class="P1 F3 LH2 ">联系人：'+_uu[0].s_name+'<br> 联系手机：'+_uu[0].phone+'<br>品牌：'+_uu[0].brands+'</div><div class="W11 H AC">厂家介绍</div>';
		hide("form");}else{addcom(t);}},error);}
}//121.43.233.185
function addcom(t){//厂商、网点、诊所申请界面
	var com=['公司名称','药店及分店名称','诊所名称','执业医院名称'],bd=['品牌名称，多个用逗号隔开','连锁品牌名称','连锁品牌名称','科室名称'],
	cont='<div class="W11 H AC bgc73"><div class="FL BTN" onclick="hide(&quot;form&quot;)">&lt;</div>我要加盟<div class="FR BTN" onclick="pubcom('+t+')">提交</div></div>';
	cont+='<input id="manuf" class="clear FL MLT A11 H ALP" placeholder="请输入'+com[t]+'" ><input id="brands" class="clear FL MLT A11 H ALP" placeholder="请输'+bd[t]+'" ><input id="sname" class="FL MLT A21 H AC" readonly placeholder="联系人姓名" value="'+_u.per_full_name+'"><input id="sphone" class="FL MLT A21 H AC" readonly placeholder="联系人手机" value="'+_u.user_phone+'" ><div class="FL W11 P1 F3">备注：联系人姓名和手机必需和账号注册人一致，支持输入多个联系人和手机，用英文逗号隔开。</div>';
	if(t>=1)cont+='<input id="adcode" placeholder="所在地域" readonly class="FL MLT A1T2 H ALP bord_select" onmousedown="c_addr(4,0)" /><input id="addr2" placeholder="门牌地址" class="FL MLT A1T2 H ALP" /><input id="gps" class="FL MLT A11 H ALP" placeholder="经纬度GPS定位" /><div class="FL MT MLN4 ICON bgc73 bgs50" style="background-image:url(../img/a/local.png)" onclick="get_GPS(1)"/></div>';
	cont+='<details><summary class="FL W11 H ALP color1" >加盟方法</summary><p id="brief" class="clear W11 F4 bgc9">平台的目标是为各相关方创造共赢互利的机会，用户在购买设备前可以通过租用的方式充分了解和比较，若短期使用采用租用的方式以减少资金，避免设备闲置；药店通过开展租赁服务增加客户流量和亲和度，增加销售设备、药品和保健屏的机会；厂商通过提供租赁设备，让用户充分了解了设备，增进购买机会，增强品牌知名度；医疗机构通过开展租赁服务，增加客户流量；医师通过提供资讯服务，提高知名度和粉丝量。平台通过用户流量，获得广告收入和销售设备获得佣金。</p></details> ';
	cont+='<details><summary class="clear W11 H ALP color1" >已加盟成员</summary><ul><li class="W11 H ALP bordB">欧姆龙健康医疗有限公司</li><li class="W11 H ALP bordB">和康医疗集团</li><li class="W11 H ALP bordB">慧脑互联网医疗有限公司</li></ul></details>';
	document.getElementById("form").innerHTML=cont;
	show("form");_init("form");
}
function pubcom(t){//厂商、网点、诊所提交
	if(pubable==true&&_u&&_u.user_guid!=""){
		var j=['supply','shop'],map=new Map(),json={};
		if(t<1){json.id=0;json.manuf=document.getElementById('manuf').value;
		}else{var gps=document.getElementById("gps").value.split(",");
			json.id=0;
			json.w_name=document.getElementById('manuf').value;
			json.addr=document.getElementById("addr2").value;
			json.adcode=document.getElementById("adcode").title;
			json.lng=gps[0];json.lat=gps[1];
		};
		json.brands=document.getElementById('brands').value.replace(/，/g,",");
		json.s_name=document.getElementById('sname').value;
		json.phone=document.getElementById('sphone').value;
		map.put("token",_u.token);map.put("userguid",_u.user_guid);
		map.put("json",json);console.log(map);
		WITAJAX.ajaxmap(map,"http://192.168.1.39:8080/mavenmedicalsharing/"+j[t]+"/create.do",function(d){pubable=true;console.log(d);
			if(d.result==1){_uu=d.obj;hide("form")}else{
alertmes(d.message)}},error);
	pubable=false}
}//121.43.233.185

function pubgoods(){
	if(_uu&&_uu.phone!=""){var map=new Map(),json={};
		json.id=0;json.p_code=document.getElementById('p_code').value;
		json.manuf=document.getElementById('manuf').value;
		json.brand=document.getElementById('brand').value;
		json.p_name=document.getElementById('p_name').value;
		json.p_size=document.getElementById('p_size').value;
		json.p_type=document.getElementById('p_type').value;
		json.p_prop=document.getElementById('p_prop').value;
		json.qt=document.getElementById('qt').value;
		json.slife=document.getElementById('slife').value;
		json.appli=document.getElementById('appli').value;
		json.p_char=document.getElementById('p_char').value;
		json.price_unit=document.getElementById('price_unit').value;
		json.price_c=document.getElementById('price_c').value;
		json.price_a=document.getElementById('price_a').value;
		map.put("token",_u.token);map.put("userguid",_u.user_guid);
		map.put("json",json);console.log(map);
		WITAJAX.ajaxmap(map,"http://121.43.233.185/mavenmedicalsharing/product/create.do",successpb,error);}
}
function successpb(d){console.log(d);
	if(d.result==1){
		document.getElementById('p_code').value="";
		document.getElementById('p_size').value="";
		document.getElementById('price_c').value="";
		document.getElementById('price_a').value="";
	}else{alertmes(d.message)}
}
function showsb_tp(){R_show();R_show('w2');
	if(document.getElementById('cata2').innerHTML==""){console.log(123);onclickid('R_BAR',0);}
}
function showsbtp(d){console.log(d)//按类别显示设备
	sbtp_data=d.message;picpath=d.picpath;
	var cont="",ln=sbtp_data.length;
	for(var i=ln-1;i>=0;i--){
		var p=sbtp_data[i].pics.split(",");
		cont+='<div class="clear W11 H12M bordB" onclick="sb_detail('+i+')"><div class="FL H12M B12M bordB bg_cover" style="background-image:url('+picpath+p[0]+')"></div><div class="FR MT05 C18M F4 LH15 ALP">'+sbtp_data[i].p_name+'<br><span class="colorB">型号：'+sbtp_data[i].p_size+'</span></div><div class="FR C18M F2 ALP LH15 colorA ellips3">'+sbtp_data[i].p_char+'</div></div>';
	}    	
	document.getElementById('cata2').innerHTML=cont;
}
function rendqx(r,isbn){//租赁订单
	var wmoney=Math.min(_u.money,r*100),money=(r-wmoney*0.01).toFixed(2);
	console.log(wmoney,money);
	document.getElementById("form").innerHTML='<div class="W11 H bgc8" ><div class="FL BTN " onclick="hide(&quot;form&quot;)">&lt;</div>租赁订单</div><div id="dianpu0" class="W11"></div><ul id="dianpu" class="none W11"></ul><p class="W11 F3 " onclick=""><span class="FL ML">收货人:'+_u.per_full_name+'<span class="FR MR">'+_u.per_phone0+'</span><br>收获地址:'+_u.per_address+'</p><div class="FL MLT A11 H AC bgc9">质押慧脑币：'+wmoney+'</div><div class="FL MLT A11 H AC bgc9">支付押金：'+money+'元</div>'+paystyle+'<div class="FL MLT A11 H AC bgc35" onclick="pay_suit9(&quot;+money+&quot;)">确认支付</div>';
	show("form");_init("form");
	//查询最近的网点
	if(_u&&_u.user_phone!=""){var map=new Map();
		map.put("token",_u.token);map.put("userguid",_u.user_guid);
		map.put("isbn",isbn);
		map.put("x1",localgps.lng-1);map.put("x2",localgps.lng+1);
		map.put("y1",localgps.lat-1);map.put("y2",localgps.lat+1);console.log(map);
		WITAJAX.ajaxmap(map,"http://121.43.233.185/mavenmedicalsharing/qxfp/retrievebygps.do",
		function(d){console.log(d);
		if(d.result==1){var cont='',da=d.message,ln=da.length,j=0,dist0=2;
			for(var i=0;i<ln;i++){
				cont+='<li class="ML W11 H ALP bordB">'+da[i].addr+'<span class="FR B6M">数量：'+da[i].inventory+'</span></li>';
				dist=Math.abs(localgps.lng-da[i].lng)+Math.abs(localgps.lng-da[i].lng);
				if(dist<dist0){j=i;dist0=dist}
			}
			document.getElementById("dianpu").innerHTML=cont;
			document.getElementById("dianpu0").innerHTML='<li class="ML W11 H ALP bordB">'+da[j].addr+'<span class="FR B6M">数量：'+da[j].inventory+'</span></li>';
		}},error);}
}