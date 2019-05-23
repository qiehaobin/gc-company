$(function() {
	var urls = decodeURI(decodeURI(location.search));; //获取url中"?"符后的字串  
	var theRequest = {};
	var arrs = [];
	if(urls.indexOf("?") != -1) {
		var str = urls.substr(1);
		strs = str.split("&");
		for(var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	$('.ansNum').text(theRequest.nopassArr);
	$('.returnBtn').click(function() {
		window.location.href = './index.html';
	})
})