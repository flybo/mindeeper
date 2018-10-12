//百度地图JS
function loadbaidujs(){
	if(document.getElementById("baidu1js").src==""){
		window.BMap_loadScriptTime = (new Date).getTime();
		document.getElementById("baidu1js").src=	"http://api.map.baidu.com/getscript?v=2.0&ak=44467bc81d4cda32b4d33ba93b49dfd4&services=&t=20180521160403";
		document.getElementById("baidu2js").src="http://api.map.baidu.com/getscript?v=1.1&ak=&services=true&t=20130716024058";
		document.getElementById("baidu1cs").href="http://api.map.baidu.com/res/11/bmap.css";
	}else{baidustart();}
}
function baidustart(){//闭包,借鉴了jQuery的script跨域方法
	function load_script(xyUrl, callback){
		var head = document.getElementsByTagName('head')[0];
		var script = document.createElement('script');
		script.type = 'text/javascript';
		script.src = xyUrl;
		script.onload = script.onreadystatechange = function(){
			if((!this.readyState || this.readyState === "loaded" || this.readyState === "complete")){callback && callback();
				script.onload = script.onreadystatechange = null;
				if ( head && script.parentNode ) {
					head.removeChild( script );
				}
			}
		};
		head.insertBefore( script, head.firstChild );
	}
	function translate(point,type,callback){
		var callbackName = 'cbk_' + Math.round(Math.random() * 10000);
		var xyUrl = "http://api.map.baidu.com/ag/coord/convert?from="+ type + "&to=4&x=" + point.lng + "&y=" + point.lat + "&callback=BMap.Convertor." + callbackName;
		load_script(xyUrl);		//动态创建script标签
		BMap.Convertor[callbackName] = function(xyResult){
			delete BMap.Convertor[callbackName];    //调用完需要删除改函数
			var point = new BMap.Point(xyResult.x, xyResult.y);
			callback && callback(point);
		}
	}
	window.BMap = window.BMap || {};
	BMap.Convertor = {};
	BMap.Convertor.translate = translate;
}
//百度API JS
function setMapEvent(){
	map.enableScrollWheelZoom();//启用地图滚轮放大缩小
	map.enableKeyboard();//启用键盘上下左右键移动地图
	map.enableDragging();//启用地图拖拽事件
	map.enableDoubleClickZoom();//启用鼠标双击放大
}
function addMapControl(){
	var ctrl_n=new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});map.addControl(ctrl_n);//添加缩放控件
	var ctrl_o=new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:3});map.addControl(ctrl_o);//添加缩略图控件
	var ctrl_s=new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});map.addControl(ctrl_s);//添加比例尺控件
}

function getgpsfrombaidu(){//生成网页地图
	document.getElementById("map").innerHTML='<div id="allmap" class="W11 H11"></div><img id="flag" src="../img/a/flag.png" class="index99 fixc B2M H4M"/><div class="absolute top0 right0 M05 F3 LH25 ALP colorY bgca rad1">点击地图上正确的位置，可重新定位<div class="FR ACP bgc14 rad1" onclick="backlocation()">确认定位</div></div>';
    map=new BMap.Map("allmap");
	addr2GPS();
}
function addr2GPS(d){//地址查GPS
	var pbtn=document.getElementById("adcode"),ad=pbtn.value+pbtn.nextSibling.value;
	if(ad){show("map");
		var geo = new BMap.Geocoder();
		geo.getPoint(ad,function (point){var p=point||new BMap.Point(120.15,30.32);	
		map.centerAndZoom(p,document.getElementById("map").title||11);getcenter();});
    	map.addEventListener("dragend",getcenter,false);//移动地图监听
		setMapEvent();	addMapControl();
    } else {alert("请先选择地域")}
}
var localgps;
function getcenter() {//百度坐标
	localgps={lng:map.getCenter().lng,lat:map.getCenter().lat}
}
function backlocation(){
	if(localgps){console.log(localgps);
		var obg=document.getElementById("gps");
		if(obg.tagName=="INPUT"){obg.value=localgps.lng+","+localgps.lat;
		}else{obg.innerHTML="经纬度("+localgps.lng+","+localgps.lat+")";}
		hide("map");
	}else{alert("请移动地图使红旗对准要标注的位置")}
}
function createMap(x,y,s){//创建地图
	var map = new BMap.Map("dituContent");
	var point = new BMap.Point(x,y);
	map.centerAndZoom(point,s);
	window.map = map;
	setMapEvent();
	addMapControl();
}
function markmap(s){console.log(markerArr);
	var gt=postmessage({functionname: "setmappot",witparams:{markerArr:markerArr},callback: ""})
	if(gt==-1){
		document.getElementById("map").innerHTML='<div id="allmap" class="W11 H11"></div><div class="absolute top1 right1 rad1 B5M AC F3 LH2 colorR borderO bgca8Y" id="dri_btn" onclick="drive()">导航</div><div class="absolute bottom0 M rad1 B5M AC F3 LH2 colorR borderO bgca8Y" onclick="hide(&quot;map&quot;)">&lt;</div>';
	show("map");
	map=new BMap.Map("allmap");
	point=new BMap.Point(localgps.lng,localgps.lat);console.log(point);
	map.centerAndZoom(point,s||12);
   	map.addEventListener("dragend",getcenter,false);//移动地图监听
	setMapEvent();	addMapControl();
	addMarker();
}}

function mapmark(r,t){//标注
	var marker=new BMap.Marker(r.point,{icon:""}),
	iw=new BMap.InfoWindow("<b class='iw_poi_title'>"+tl+"</b><div class='iw_poi_content'>"+ct.street+ct.streetNumber+"</div>");
	map.addOverlay(marker);	marker.openInfoWindow(iw);
}
function addMarker1(point, index, strtitle, strhtml){
var myIcon=new BMap.Icon("jiantou.png", new BMap.Size(25,30),{anchor:new BMap.Size(10,25),imageOffset: new BMap.Size(0,0-index*25)});
var marker = new BMap.Marker(point, { icon: myIcon });
map.addOverlay(marker);
} 
/*
function addMarker(){
	for(var i=0;i<markerArr.length;i++){console.log(i);
		var json=markerArr[i];
		var marker=new BMap.Marker(new BMap.Point(json.x,json.y),{icon:""});iw=new BMap.InfoWindow("<b class='iw_poi_title' title='"+json.title+"'>"+json.title+"</b><div class='iw_poi_content'>"+json.content+"</div>");
		map.addOverlay(marker);	marker.openInfoWindow(iw);
	}
}

var localgps={lng:120.15,lat:30.32};
function drive(){console.log(135);getLocation();
var driving = new BMap.DrivingRoute(map,{renderOptions:{map:map,autoViewport:true}});    
driving.search("昆明","普洱");
}
function getLocation() {	if(navigator.geolocation&&navigator.geolocation.getCurrentPosition){navigator.geolocation.getCurrentPosition(translatePoint); }
  else{alert("请开启导航权限")}
}

function showPosition(position){var gp=document.getElementById("dri_btn");
    if(flag<5){gp.innerHTML="<a href='baidumap://map/direction?origin="+position.lat+","+position.lng+
"&destination=30.285092,120.15225&mode=driving&src=yourCompanyName|yourAppName'>导航</a>";}
	else{gp.innerHTML="<a href='bdapp://map/direction?origin=latlng:"+position.lat+","+position.lng+"|name:当前位置"+ "&destination="+destin_txt+"&mode=driving&src=yourCompanyName|yourAppName'>导航</a>";}
}
function translatePoint(position){//转换坐标 
	BMap.Convertor.translate( new BMap.Point(position.coords.longitude,position.coords.latitude),0,showPosition); 
}
*/