
 


var prov = document.getElementById("prov");
var city = document.getElementById('city');
var country =document.getElementById('country');
 
 
/*用于保存当前所选的省市区*/
var current = {
    prov: '',
    city: '',
    country: ''
};
 
/*自动加载省份列表*/
(function showProv() {
	console.log("自动加载省份列表");
//  btn.disabled = true;
    var len = provice.length;
    for (var i = 0; i < len; i++) {
        var provOpt = document.createElement('option');
        provOpt.innerText = provice[i]['name'];
        provOpt.value = i;
        prov.appendChild(provOpt);
    }
})();
 
/*根据所选的省份来显示城市列表*/
function showCity(obj) {
	console.log("根据所选的省份来显示城市列表");
	
    var val = obj.options[obj.selectedIndex].value;
    

    
    if (val != current.prov) {
        current.prov = val;
        
        
    }
      
    if (val != null&&val!="请选择省份") {
        city.length = 1;
     
        var cityLen = provice[val]['city'].length;        
        for (var j = 0; j < cityLen; j++) {
        	
            var cityOpt = document.createElement('option');
            cityOpt.innerText = provice[val]["city"][j].name;
            cityOpt.value = j;
            city.appendChild(cityOpt);
        }
    }else{

city.length=1;
    }
 
country.length=1;
}
 
/*根据所选的城市来显示县区列表*/
function showCountry(obj) {
	
	console.log("根据所选的城市来显示县区列表");
     
    var val = obj.options[obj.selectedIndex].value;
  
    current.city = val;
    if (val != null&&val!="请选择城市") {
        country.length = 1; //清空之前的内容只留第一个默认选项
        var countryLen = provice[current.prov]["city"][val].districtAndCounty.length;
        if (countryLen == 0) {
//          addrShow.value = provice[current.prov].name + '-' + provice[current.prov]["city"][current.city].name;
            return;
        }
        for (var n = 0; n < countryLen; n++) {
            var countryOpt = document.createElement('option');
            countryOpt.innerText = provice[current.prov]["city"][val].districtAndCounty[n];
            countryOpt.value = n;
            country.appendChild(countryOpt);
        }
    }else{

country.length=1;
    }
}
 
///*选择县区之后的处理函数*/
function selecCountry(obj) {
    current.country = obj.options[obj.selectedIndex].value;
    
}


// 
///*点击确定按钮显示用户所选的地址*/
//function showAddr() {
//  addrShow.value = provice[current.prov].name + '-' + provice[current.prov]["city"][current.city].name + '-' + provice[current.prov]["city"][current.city].districtAndCounty[current.country];
//}