
//获取地址栏参数
function getUrlParam(name)
{
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r!=null) return unescape(r[2]); return null; //返回参数值
};
var indexTopic=0;
var olens=0;
var osingleW;
//计算宽高
function countWidthHeight(){
    //计算高度和宽度
    $(".answerTopicUl dl").width($(".answerTopic").width()+1);
    osingleW=$(".answerTopicUl dl").eq(0).width();
    indexTopic=0;
    olens=$(".answer dl").length;
    $(".answerTopicUl").css("width",osingleW*olens);
    $(".answerTopic").css({width:osingleW,height:$(".answerTopicUl dl").eq(indexTopic).height(),overflow:"hidden"});
}
//进行选择
function  optionClick(obj){
    $(obj).closest("dl").find(".selected").removeClass("selected");
    $(obj).find(".radio").addClass("selected");
}
$(function() {

//进入下一题
    $(document).on('click','.nextBtn',function(){
        if(indexTopic<olens)
        {
            indexTopic++;
            $(".answerTopic").css({height:$(".answerTopicUl dl").eq(indexTopic).height(),overflow:"hidden"});
            if (!$(".answerTopicUl").is(":animated")) {
                $(".answerTopicUl").animate({marginLeft:-osingleW*indexTopic+"px"},200);
            }

            if(indexTopic==olens-1)
            {
                $(this).next(".submitBtn").show();
                $(this).hide();
            }
        }
    })


// 	var ansArr=['A','B','C','D'];//标准答案
// 	var grades=50;//每道题的分数
// 	var n=0;//错误的题号
// 	var m;//错误的选项
// 	var gradesSum;//总分数
// 	var passGrade=100;//通过分数标准
// 	$('.submitBtn').click(function(){
// 		var datas=[];
// 		var errorArr=[];
// 		var sums=[];
// 		$('.answer dd .option .selected').each(function(i){
// 			var anses=$(this).siblings('p').find('.request').text();//当前选项
// 			datas.push(anses);
// 		})
// //			console.log(datas);
// 			for(var i=0;i<ansArr.length;i++){
// 				if(ansArr[i]!=datas[i]){
// 					n=i+1;
// 					sums.push(n);//错误的题号数组
// 					m=datas[i];
// 					errorArr.push(datas[i]);//错误的选项数组	
// 				}
// 			}
// 			if(datas.length!=ansArr.length){
// 				alert('请答完题');
// 				return false;
// 			}
// //			console.log(sums);
// //			console.log(errorArr);
// 			gradesSum=(ansArr.length - errorArr.length)*grades;//总分
// //			alert(gradesSum);
// 			if(gradesSum>=passGrade){
// //				alert('答题通过');
// 				window.location.href = './pass.html';
// 			}else if(gradesSum<passGrade){
// //				alert('答题未通过');
// 				window.location.href = './nopass.html?nopassArr='+sums+'';
// 			}
// 	})
})