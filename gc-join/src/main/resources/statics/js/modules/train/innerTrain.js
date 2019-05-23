// "======================== 公用 ==============================="
//左侧
function countLeft() {
    var oheight1 = 10;
    for (var i = 0; i < $(".jcha1").length; i++) {
        oheight1 += $(".jcha1").eq(i).outerHeight(true);
    }
    rxued.init.countH($(".scroll-content"), oheight1, function () {
        $(".scroll-content").slimScroll({
            height: $(".scroll-content1").eq(0).height(),
            borderRadius: "0px"
        });
    });
    $(".scroll-content").parent(".slimScrollDiv").height($(".scroll-content").height());
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
//二段状态处理固定
function countstatus(){
    $(".statusScroll").each(function(){
        var statusH=12;
        for(var i=0;i<$(this).closest(".uiTab9Con").find(".statusCha").length;i++)
        {
            statusH+=$(this).closest(".uiTab9Con").find(".statusCha").eq(i).outerHeight(true);
        }
        var statusendH=$(window).height() - $("#main_header").outerHeight(true) - $(".j_uiTab9").outerHeight(true)-statusH;
        $(this).height(statusendH).slimScroll({
            height: statusendH,
            borderRadius: "0px"
        });
        $(this).parent(".slimScrollDiv").height(statusendH);
    })
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
$(function(){
    countLeft();
    countMiddle();
    countRight();
})
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
    $(".anItemBor-active").removeClass("anItemBor-active");
    $(this).closest(".layerRtb").animate({
        left: '-100%'
    }, function () {
        $(this).hide();
    });
});


// "======================== 一段 ==============================="
//选项卡
$(document).on("click",".uiTab1 .uiTab1-li",function(){
    var oindex=$(this).attr("data-index");
    $(this).addClass("uiTab1-active").siblings().removeClass("uiTab1-active");
    $(".daily_title").eq(oindex).find("li:eq(0)").click();
    countLeft();
});

//左侧列表行点击
$(document).on("click","#tabData tr",function(){
    clickTr($(this))
});

//一段表格点击事件
function clickTr(obj){
    $(obj).addClass("tractive").siblings().removeClass("tractive");
    id=$(".tractive").attr("id");
    //二段 信息栏  的展示
    $(".j_uiTab9 li").eq(0).click();

}

//一段搜索
$(document).on("click",".serial_number",function(){
    $(this).closest(".contentbox").find(".dailyftSearch").show();
});
$(document).on("click",".uiText-searchIcon",function(){
    $(this).closest(".contentbox").find(".dailyftSearch").hide();
});


$(document).on("click","#rxprojectMain .j_uiTab9 li",function(){
    var _othisIndex=$(this).index();
    id=$(".tractive").attr("id");
    var areaId = $(".tractive").attr("data-type");
    $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");
    $("#j-tc-center-content").empty();
    if(_othisIndex == 0){
        //url = "https://gnr.rxjy.com/hrms/externalInterface/getUserDetail?userNo="+id+"&areaId="+areaId;
        //$("#j-tc-center-courseInfo").load(url);
        var  type = $(".uiTab9-active").attr("data-page");
        $("#j-tc-center-courseInfo").load("../train/two/"+type,{cardNo:id},function (data){});
    }else if(_othisIndex == 1){
        //url = "https://gnr.rxjy.com/hrms/internalPersonal/getUserMsg?curUserCard=00000079&Userno="+id+"&AreaId="+areaId;
        //$("#j-tc-center-courseInfo").load(url);
        var  type =  $(".uiTab9-active").attr("data-page");
        $("#j-tc-center-courseInfo").load("../train/two/"+type,{cardNo:id},function (data){});
    }else{
        var type = $(".uiTab9-active").attr("data-page");
        $("#j-tc-center-courseInfo").load("../train/turnTwoEducation",{type:type},function(data){});
    }


    countMiddle();
    countRight();
    $(".layerRtb").animate({
        left: '-100%',
    },function(){
        $(this).hide();
    });
});


//三段页面
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
    // 人士 培训三段
    if ($(this).attr("biaoshi")=="letterTraining"){
        var cardNo = $(".tractive").attr("id");
        thirdCommonAlert.load("../train/three/"+thisPage,{cardNo:cardNo},function(){
            countMiddle();
            countRight();
        });
    }else{
        thirdCommonAlert.load("../train/threeEducationPageShow",{type:thisPage},function(){
            countMiddle();
            countRight();
        });
    }

});


//四段 页面
$(document).on("click",".anItemBorFour[data-page]",function () {
    var thisPage=$(this).attr("data-page");

    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");

    //三段页面加载位置
    var fourCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    fourCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    var parameter;
    fourCommonAlert.load("../train/fourEducationPageShow",{type:thisPage},function(){
        countMiddle();
        countRight();
    });
});