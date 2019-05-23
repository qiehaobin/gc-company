// "======================== 公用 ==============================="
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
        if(typeof($(this).attr("data-need-cha"))!=undefined)
        {
            oheight+=parseInt($(this).attr("data-need-cha"));
        }
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
countLeft();
countMiddle();
countRight();
countstatus();
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
//隔行换色
function changecolor(){
    $(".uiTable tbody tr:visible").each(function(i){
        if(i%2!=0)
        {
            $(this).addClass("trodd")
        }
    })
}
// "======================== 一段 ==============================="















var classUuid ;

//一段表格点击事件
function clickTr(){
    $("#tab1 tbody tr").click(function(){
        $(this).addClass("tractive").siblings().removeClass("tractive");
        classUuid=$(".tractive").attr("id");
        //加载第二段数据
        $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
    })
}
// "======================== 二段 ==============================="
//主选项卡
$("#conterUlId").on("click","li",function(){
    var thisAttr=$(this).attr("id");
    switch(thisAttr){
        case "train_set"://二段 设  数据切换展示
            $(".state-content").load("../train/stateMiddleSetShow",{classUuid:classUuid},function(){});
        break;
        case "train_person":////二段 人  数据切换展示
            $(".state-content").load("../train/stateMiddlePersonShow",{classUuid:classUuid},function(){});
            break;
        case "train_class"://二段 课  数据切换展示
           // $(".state-content").load("../train/stateMiddlePersonShow",{classUuid:classUuid},function(){});
            break;

    }
    $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");
    $(".layerRtb").animate({
        left: '-100%',
    },function(){
        $(this).hide();
    });
});




$(document).unbind("click").on("click",".anItemBorThree[data-type]",function () {
    var thisPage=$(this).attr("data-type");
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
    var ext1 = thisPage;
    thirdCommonAlert.load("../train/threeTrainClassUpdate",{classUuid:classUuid,ext1:ext1},function(){});


    /*var parameter;
    thirdCommonAlert.load(thisPage, function () {
        setTimeout(function(){
            countThree();
        })
    });*/
});


//二段 设  目的的修改
$("#purposeUpdate").click(function(){
    var purpose = $("#purpose").val();
    $.post("../train/updateTrainClass",{classUuid:classUuid,purpose:purpose},function (data) {
        if(data == 1){//修改成功
            alert("保存成功！");
        }else{
            alert("网络连接错误！");
        }
    });
});











//三段 人  选人页面加载
$(document).on("click",".loadUserSelect",function(){
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeChoosePeopleShow",{classUuid:classUuid},function(){});
})

//三段修改页面的相关关闭
$(".layerRtb").on("click",".rig_close",function(){
    $(".layerRtb ").hide();
})


//三段 班级名称修改
$("#classNameUpdate").click(function () {
    var className = $(".newClassName").val();
    $.post("../train/updateTrainClass",{classUuid:classUuid,className:className},function(data){
        if(data == 1){//修改成功 刷新二段
            $(".rig_close").click();
            getAllTrainClassList();
            /*$(".layerRtb ").hide();
            $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});*/
        }else{
            alert("网络错误，请稍后重试！");
        }
    });
});

//三段 部门 角色修改
$(document).on("click","#departmentUpdate",function(){
    var role = $("#role_update").val();
    $.post("../train/updateTrainClass",{classUuid:classUuid,role:role},function(data){
        if(data == 1){//修改成功 刷新
            $(".rig_close").click();
            getAllTrainClassList();
        }else{
            alert("网络错误，请稍后重试！");
        }
    });
})

// 三段 类型 核心内容等修改
$(document).on("click","#content_update",function(){
    var type = $("#type_update").val();
    var development = $("#development_update").val();
    var content = $("#train_content_update").val();
    if(content == null || content == ""){
        alert("请输入核心内容！");
    }else{
        $.post("../train/updateTrainClass",{classUuid:classUuid,type:type,development:development,content:content},function(data){
            if(data == 1){//修改成功 刷新二段
                $(".rig_close").click();
                getAllTrainClassList();
            }else{
                alert("网络错误，请稍后重试！");
            }
        });
    }
})

//陪 人 三段 人员添加确定按钮
$("#addTrainPeople").click(function () {
    obj = document.getElementsByName("check");
    check_val = "";
    for(k in obj){
        if(obj[k].checked)
            check_val += obj[k].value+",";
    }
    var ext1 = check_val;
    alert(ext1);
    if(ext1 != null && ext1 != ""){
        $.post("../train/addTrainPeople",{ext1:ext1,classUuid:classUuid},function(data){
            //刷新人 二段信息
            $("#train_person").click();
        });
    }
})

//三段 天数的修改以及设置
$("#dayNumUpdate").click(function(){
    var createTime = $("#beginTime").val();
    var endTime = $("#endTime").val();
    var dayNum = $("#dayNum_num").val();
    if(dayNum == null || dayNum == ""){
        alert("请输入有效天数！");
        return;
    }else if(createTime == null || createTime == ""){
        alert("请输入有效的开始时间！");
        return;
    }else if(endTime == null || endTime == ""){
        alert("请输入有效的结束时间！");
        return;
    }else{
        $.post("../train/updateTrainClassAndAddTrainClassNum",{classUuid:classUuid,createTime:createTime,endTime:endTime,dayNum:dayNum},function(data){
            if(data == 1){//修改成功 刷新二段
                $(".layerRtb ").hide();
                $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
            }else{
                alert("网络错误，请稍后重试！");
            }
        });
    }

});

function getAllTrainClassList(data){
    $.post("../train/queryAllTrainClass",data,function(res){
        if(res.msg == "success"){
            $(".total").html(res.list.length);
            var list = res.list;
            $(".scroll-content table tbody").empty()
            if(list.length>0){
                $.each(list,function(key,value){//遍历键值对
                    $(".scroll-content table tbody").append('<tr id="'+value.classUuid+'"><td width="20%">'+value.departmentId+'</td><td width="20%">'+value.className+'</td><td width="20%">'+value.level+'</td><td width="20%">'+value.percent+'</td><td></td></tr>' )
                })
                setTimeout(function(){
                    changecolor();
                    clickTr();
                    $("#tab1 tr:eq(0)").click();
                    classUuid=$(".tractive").attr("id");
                    //加载第二段数据
                    $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
            })

            }
        }
    });
}