$(function() {
	//进行选择
	$(document).on('click','.radio',function(){
		$(this).closest("dl").find(".selected").removeClass("selected");
		$(this).addClass("selected");
	})
	var ansArr=['A','B','C','D'];//标准答案
	var grades=50;//每道题的分数
	var n=0;//错误的题号
	var m;//错误的选项
	var gradesSum;//总分数
	var passGrade=100;//通过分数标准
	$('.submitBtn').click(function(){
		var datas=[];//  选中的答案
		var errorArr=[]; //
		var sums=[];
		$('.answer dd .option .selected').each(function(i){
			var anses=$(this).siblings('p').find('.request').text();//当前选项
			datas.push(anses);
		})
//			console.log(datas);
			for(var i=0;i<ansArr.length;i++){
				if(ansArr[i]!=datas[i]){
					n=i+1;
					sums.push(n);//错误的题号数组
					m=datas[i];
					errorArr.push(datas[i]);//错误的选项数组	
				}
			}
			if(datas.length!=ansArr.length){
				alert('请答完题');
				return false;
			}
//			console.log(sums);
//			console.log(errorArr);
			gradesSum=(ansArr.length - errorArr.length)*grades;//总分
//			alert(gradesSum);
			if(gradesSum>=passGrade){
//				alert('答题通过');
				window.location.href = './pass.html';
			}else if(gradesSum<passGrade){
//				alert('答题未通过');
				window.location.href = './nopass.html?nopassArr='+sums+'';
			}
	})
})