// "======================== 公用 ==============================="
//左侧
function countLeft() {
    //左侧JS
    rxued.table.LChangeapart($("#tab1 tr"),"#f9f9f9","#fff");
    rxued.table.hoverChage($("#tab1 tr"),"#eaf4fe")
    rxued.init .countH($(".scroll-content"),"15",function(){
        $(".scroll-content").slimScroll({ height: $(".scroll-content").eq(0).height(), borderRadius: "0px" });
    });
}
//中间
function countMiddle() {
    var theight = $("body").height() - $("#topnav").height() - $(".j_uiTab9").outerHeight() - 11;
    $("#j-tc-center-content").height(theight).slimScroll({
        height: theight,
        borderRadius: "0px"
    });
    $("#j-tc-center-content").parents(".slimScrollDiv").eq(0).height(theight);
}
//右侧
function countRight() {
    var rightHeight = $("body").height() - $("#topnav").outerHeight() - $(".j-tc-righttop-tab").outerHeight() - $(".tc-right-bottom").outerHeight() - 10;
    $(".tc-right-top,#j-visit").height(rightHeight);
    $(".tc-right-top,#j-visit").parent(".slimScrollDiv").height(rightHeight);
}

//三段滚动条
function countThree(){
	$(".threeScroll").each(function(){
		var oheight=10;
		for(var i=0;i<$(this).closest(".layerRtb").find(".threeCha").length;i++)
		{
			oheight+=$(this).closest(".layerRtb").find(".threeCha").eq(i).outerHeight(true);
		}
		var oendH=$(this).closest(".layerRtb").height()-oheight;
		$(this).height(oendH).slimScroll({
            height: oendH,
            borderRadius: "0px"
        });
        $(this).parent(".slimScrollDiv").height(oendH);
	})
	
}
//隔行换色
function changecolor(){
	$(".uiTable tbody tr:visible").each(function(i){
		if(i%2!=0)
		{
			$(this).addClass("trodd")
		}
	})
}
$(window).resize(function(){
	countLeft();
	countMiddle();
	countRight();
	countstatus();
	countThree();
})
//三段弹出层关闭
$(document).on("click",".close_allPopup",function(){
    $(".anItemBor-active").removeClass("anItemBor-active");
    $(this).closest(".layerRtb").animate({
        left: '-100%'
    }, function () {
        $(this).hide();
    });
});
//四段弹出层关闭
$(document).on("click",".closeFour",function () {
	$(this).closest(".layerRtb").animate({
        left: '-100%'
    }, function () {
        $(this).hide();
    });
});


// "======================== 一段 ==============================="
//选项卡
$(document).on("click",".uiTab1 li",function(){
    var oindex=$(this).attr("data-index");
    $(this).addClass("uiTab1-active").siblings().removeClass("uiTab1-active");
    $(".daily_title").eq(oindex).find("li:eq(0)").click();
    $(".contentbox").hide().eq(oindex).show();
    $(".uiTab9").hide().eq(oindex).show();
    $(".uiTab9").eq(oindex).find("li:eq(0)").click();
    countLeft();
    changecolor();
});
//左侧列表行点击
$(document).on("click","#tabData tr",function(){
    $(this).addClass("tractive").siblings().removeClass("tractive");
    $("#rxprojectMain").find(".uiTab9:eq(0) li:eq(0)").click(); // 二段默认点击状态
});
$(document).on("click","#tabData2 tr",function(){
    $(this).addClass("tractive").siblings().removeClass("tractive");
    $("#rxprojectMain").find(".uiTab9:eq(1) li:eq(0)").click(); // 二段默认点击状态
});
$(document).on("click","#tabData3 tr",function(){
    $(this).addClass("tractive").siblings().removeClass("tractive");
    $("#rxprojectMain").find(".uiTab9:eq(2) li:eq(0)").click(); // 二段默认点击状态
});
//一段搜索
$(document).on("click",".serial_number",function(){
    $(this).closest(".contentbox").find(".dailyftSearch").show();
});
$(document).on("click",".uiText-searchIcon",function(){
    $(this).closest(".contentbox").find(".dailyftSearch").hide();
});


// "======================== 二段 ==============================="
//主选项卡
$(document).on("click","#rxprojectMain .j_uiTab9 li",function(){
    var _othisIndex=$(this).index();
    var thispage=$(this).attr("data-page");
    $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");
    $("#j-tc-center-content").empty();
    $("#j-tc-center-content").load("two/"+thispage,function(){
        countMiddle();
        countRight();
    });
    $(".layerRtb").animate({
        left: '-100%',
    },function(){
        $(this).hide();
    });
});
$(document).on("click",".anItemBorThree[data-page]",function () {
    var thisPage=$(this).attr("data-page");
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    var parameter;
    thirdCommonAlert.load("three/"+thisPage, function () {
    	setTimeout(function(){
    		countThree();
    	})
    });
});

// "======================== 三段 ==============================="
$(document).on("click",".anItemBorFour[data-page]",function () {
    var thisPage=$(this).attr("data-page");
    //四段页面加载位置
    var fourCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    fourCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    fourCommonAlert.load("four/"+thisPage, function () {
    	setTimeout(function(){
    		countThree();
    	})
    });
});
//对勾、差号
$(document).on("click",".dataExamBtn",function(event){
	stopEventBubble(event);
	$(this).addClass("dataExamSelected").siblings().removeClass("dataExamSelected");
	if($(this).hasClass("dataExamYes"))
	{
		$(".score span").text("1");
	}else{
		$(".score span").text("0");
	}
});
// "======================== 四段 ==============================="

