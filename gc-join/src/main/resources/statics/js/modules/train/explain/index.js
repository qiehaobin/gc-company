$(document).on("click","#tab1 tbody tr",function () {
    setTimeout(function(){
        $("#conterUlId li:eq(0)").click();
    },200);

});

//选中 一段 出二段
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
        left: '100%',
    },function(){
        $(this).hide();
    });
});


//主选项卡
$(document).on("click","#conterUlId li",function(){
    var classUuid  = $(".tractive").attr("id");
    var thisAttr=$(this).attr("id");
    switch(thisAttr){
        case "train_state":
            $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");
            //加载第二段数据
            $(".state-content").load("../explain/stateMiddleShow",{classUuid:classUuid},function(){});
            break;
        case "train_set"://二段 设  数据切换展示
            $(".state-content").load("../explain/stateMiddleSetShow",{classUuid:classUuid},function(){});
            break;
        case "train_person":////二段 人  数据切换展示
            $(".state-content").load("${ctx}/train/explain/stateMiddlePersonShow",{classUuid:classUuid},function(){});
            break;
        case "train_class"://二段 课  数据切换展示
            $(".state-content").load("${ctx}/train/explain/stateMiddleCourseShow",{classUuid:classUuid},function(){});
            break;
        case "train_teach" : //二段 教  数据展示
            $(".state-content").load("${ctx}/train/explain/stateMiddleTeachShow",{classUuid:classUuid},function(){});
            break;
    }
    $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");
    $(".anItemBor-active").removeClass("anItemBor-active");
    $(".layerRtb").animate({
        left: '-100%',
    },function(){
        $(this).hide();
    });
    $("#hidClickNav").val($(".uiTab9-active").attr("data-index"));//获取主导航当前选中项

    countMiddle();
    countstatus()
});
//中间
function countMiddle() {
    var theight = $("body").height() - $("#topnav").height() - $(".j_uiTab9").outerHeight() - 11;
    $("#j-tc-center-content").height(theight).slimScroll({
        height: theight,
        borderRadius: "0px"
    });
    $("#j-tc-center-content").parents(".slimScrollDiv").eq(0).height(theight);
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

$(window).resize(function(){
    countLeft();
    countMiddle();
})
//左侧
function countLeft() {
    var oheight1 = 10;
    for (var i = 0; i < $(".jcha1").length; i++) {
        oheight1 += $(".jcha1").eq(i).outerHeight(true);
    }
    rxued.init.countH($(".scroll-content"), oheight1, function () {
        $(".scroll-content").slimScroll({
            height: $(".scroll-content").eq(0).height(),
            borderRadius: "0px"
        });
    });
    $(".scroll-content").parent(".slimScrollDiv").height($(".scroll-content").height());
}

//右侧
function countRight() {
    var rightHeight = $("body").height() - $("#topnav").outerHeight() - $(".j-tc-righttop-tab").outerHeight() - $(".tc-right-bottom").outerHeight() - 10;
    $(".tc-right-top,#j-visit").height(rightHeight);
    $(".tc-right-top,#j-visit").parent(".slimScrollDiv").height(rightHeight);
}