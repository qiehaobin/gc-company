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
        if(typeof($(this).attr("data-need-cha"))!="undefined")
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
    $(this).closest(".layerRtb").animate({
        left: '-100%'
    }, function () {
        $(this).hide();
    });
});
//隔行换色
function changecolor(){
    $(".trodd").removeClass("trodd");
    $(".changecolor").each(function(){
        $(this).find("tr:visible").each(function(i){
            if(i%2!=0)
            {
                $(this).addClass("trodd")
            }
        })
    })
}

// "======================== 一段 ==============================="

var classUuid ;
function getAllTrainClassList(data){
    var ids = data;
    $("#hidTrVal").val(ids);
    $.post("../train/queryAllTrainClass",data,function(res){
        if(res.msg == "success"){
            $(".total").html(res.list.length);
            var list = res.list;
            $(".scroll-content table tbody").empty()
            if(list.length>0){
                $.each(list,function(key,value){//遍历键值对
                    var num;
                    if(value.ext1 != null){
                        num = value.ext1;
                    }else{
                        num = "<span class='cRed'>-999+</span>";
                    }
                    var className = value.className.substring(0,2)+"..";
                    $(".scroll-content table tbody").append('<tr percent="'+value.percent+'" id="'+value.classUuid+'"><td width="20%">'+value.departmentId+'</td><td width="20%" title="'+value.className+'">'+className+'</td><td width="20%">'+value.level+'</td><td width="20%">'+value.percent+'</td><td>'+num+'</td></tr>' )
                })
                setTimeout(function(){
                    changecolor();
                    clickTr();
                    if($("#hidTrVal").val()!="")
                    {
                        $("#tab1 tr[id='"+$("#hidTrVal").val()+"']").click();
                    }else{
                        $("#tab1 tr:eq(0)").click();
                    }
                })

            }
        }
    });
}
//一段表格点击事件
function clickTr(){
    $("#tab1 tbody tr").click(function(){
        $(this).addClass("tractive").siblings().removeClass("tractive");
        classUuid=$(".tractive").attr("id");
        $("#trian_visit").load("../train/threeReturnContentList",{classUuid:classUuid},function(){});
        //加载第二段数据
        if($("#hidClickNav").val()!="")
        {
            var dataIndex=$("#hidClickNav").val();
            $("#conterUlId li[data-index='"+dataIndex+"']").click();

        }else{
            $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
        }

    })
}
// "======================== 二段 ==============================="
//主选项卡
$(document).on("click","#conterUlId li",function(){
    var thisAttr=$(this).attr("id");
    switch(thisAttr){
        case "train_state":
            $(this).addClass("uiTab9-active").siblings().removeClass("uiTab9-active");

            classUuid=$(".tractive").attr("id");
            //加载第二段数据
            $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
            break;
        case "train_set"://二段 设  数据切换展示
            $(".state-content").load("../train/stateMiddleSetShow",{classUuid:classUuid},function(){});
            break;
        case "train_person"://二段 人  数据切换展示
            $(".state-content").load("../train/stateMiddlePersonShow",{classUuid:classUuid},function(){});
            break;
        case "train_class"://二段 课  数据切换展示
            $(".state-content").load("../train/stateMiddleCourseShow",{classUuid:classUuid},function(){});
            break;
        case "train_teach" : //二段 教  数据展示
            $(".state-content").load("../train/stateMiddleTeachShow",{classUuid:classUuid},function(){});
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
});


//点击二段出三段  修改班级信息的三段
$(document).on("click",".anItemBorThree[data-type]",function () {
    var ext3 = $("#choose_roel_id").val();
    var thisPage=$(this).attr("data-type");
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    var ext1 = thisPage;
    var ext2 = $("#train_people_dayNum").val();
    thirdCommonAlert.load("../train/threeTrainClassUpdate",{classUuid:classUuid,ext1:ext1,ext2:ext2,ext3:ext3},function(){
        setTimeout(function(){
        countThree();
        },500)
    });
});

// "======================== 三段 ==============================="
//二段 设  目的的修改
$(document).on("click","#purposeUpdate",function(){
    var purpose = $("#purpose").val();
    $.post("../train/updateTrainClass",{classUuid:classUuid,purpose:purpose},function (data) {
        if(data == 1){//修改成功
            alert("保存成功！");
        }else{
            alert("网络连接错误！");
        }
    });
})

//三段 班级名称修改
$(document).on("click","#classNameUpdate",function(){
    $("#hidClickNav").val($(".uiTab9-active").attr("data-index"));//获取主导航当前选中项
    $("#hidTrVal").val($(".tractive").attr("id"));//获取左侧列表当前选中项
    var className = $(".newClassName").val();
    $.post("../train/updateTrainClass",{classUuid:classUuid,className:className},function(data){
        if(data == 1){//修改成功 刷新二段
            $(".close_allPopup").click();
            getAllTrainClassList({});
        }else{
            alert("网络错误，请稍后重试！");
        }
    });
})

//三段 天数的修改以及设置
$(document).on("click","#dayNumUpdate",function(){
    $("#hidClickNav").val($(".uiTab9-active").attr("data-index"));//获取主导航当前选中项
    $("#hidTrVal").val($(".tractive").attr("id"));//获取左侧列表当前选中项
    var createTime = $("#beginTime").val();
    var endTime = $("#endTime").val();
    var dayNum = $("#dayNum_num").val();
    if(createTime == null || createTime == ""){
        alert("请输入有效的开始时间！");
        return;
    }else if(endTime == null || endTime == ""){
        alert("请输入有效的结束时间！");
        return;
    }else{
        $.post("../train/updateTrainClassAndAddTrainClassNum",{classUuid:classUuid,createTime:createTime,endTime:endTime,dayNum:dayNum},function(data){
            if(data == 1){//修改成功 刷新二段
                $(".rig_close").click();
                getAllTrainClassList();
            }else{
                alert("网络错误，请稍后重试！");
            }
        });
    }
})


//三段 部门 角色修改
$(document).on("click","#departmentUpdate",function(){
    $("#hidClickNav").val($(".uiTab9-active").attr("data-index"));//获取主导航当前选中项
    $("#hidTrVal").val($(".tractive").attr("id"));//获取左侧列表当前选中项

    obj = document.getElementsByName("checkRole");
    check_val = "";
    for(k in obj){
        if(obj[k].checked)
            check_val += obj[k].value+",";
    }
    var role = check_val;
    if(role != "" && role != null){
        $.post("../train/updateTrainClass",{classUuid:classUuid,role:role},function(data){
            if(data == 1){//修改成功 刷新
                $(".rig_close").click();
                getAllTrainClassList();
                //加载第二段数据
                $(".state-content").load("../train/stateMiddleShow",{classUuid:classUuid},function(){});
            }else{
                alert("网络错误，请稍后重试！");
            }
        });
    }else{
        alert("请选择要修改的角色！");
    }

})

// 三段 类型 核心内容等修改
$(document).on("click","#content_update",function(){
    $("#hidClickNav").val($(".uiTab9-active").attr("data-index"));//获取主导航当前选中项
    $("#hidTrVal").val($(".tractive").attr("id"));//获取左侧列表当前选中项
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

//五段  教  已评人员 分数展示
$(document).on("click",".trian_class_arrive_people_check",function(){
    var personId = $(this).attr("data-value");
    var trainCurriculumId = $(".anItemBor-active .train_curriculum_id").val();

    //五段页面加载位置
    var fiveCommonAlert = $(".layerRtb[data-type='fiveCommonAlert']");
    fiveCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='fiveCommonAlert']").load("../train/queryTrianPeopleEvaluateInfo",{personId:personId,trainCurriculumId:trainCurriculumId,classUuid:classUuid },function(){
        setTimeout(function(){
            countThree();
        },500)
    });
})

//四段人员信息 评分页面展示
$(document).on("click",".trian_class_arrive_people",function(){
    //personId为卡号信息
    var personId = $(this).attr("data-value")
    var ext1 = $(this).attr("data-type");
    var biaoshi = $("input[name='biaoshi']").val();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");

    //三段页面加载位置
    var fiveCommonAlert = $(".layerRtb[data-type='fiveCommonAlert']");
    fiveCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='fiveCommonAlert']").load("../train/trainClassPeopleEvaluateShow",{classUuid:classUuid,personId:personId,ext1:ext1,ext2:biaoshi},function(){
        setTimeout(function(){
            countThree();
        },500)
    });
})



//未 录分数人员列表展示
$(document).on("click",".evaluate_flag",function(){
    var courseId = $("input[name='courseId']").val();
    //ext1里面存储了 待录或者已录标示
    var ext1 = $(this).attr("data-type");

    var courseId = $("input[name='courseId']").val();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");

    //三段页面加载位置
    var fourCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    fourCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='fourCommonAlert']").load("../train/queryRosterTrainPeopleevaluateFlag",{classUuid:classUuid,ext1:ext1,ext2:courseId},function(){
        setTimeout(function(){
            countThree();
        },500)
    });

})

//教 结束按钮点击时间
$(document).on("click",".startClassBtnActive",function(){
    alert("结束按钮操作");

})
//四段  教  三段课程添加时间与地点页面
$(document).on("click",".updateTrainCourseBeginTime",function(){
    /*var course = $(".anItemBor-active .update_train_course").val();
    var trainCurriculumId = $(".anItemBor-active .train_curriculum_id").val();*/
    var id = $(this).find(".update_trian_course_id").val();
    var curriculumName = $(this).find(".four_trian_curriculum_name").val();

    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");

    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='fourCommonAlert']").load("../train/updateTrainCurriculumPageShow",{id:id,curriculumName:curriculumName,classUuid:classUuid },function(){
        setTimeout(function(){
            countThree();
        },500)
    });
})





//五段  教 保存评分信息
/**
 * 卡号
 * @param personId 卡号
 */
function addTrainPeopleEvaluate(personId,biaoshi) {
    //课程标识
    var uniqueCourseId = $(".anItemBor-active .train_curriculum_id").val();
    var trainCurriculumId = $(".anItemBor-active .train_curriculum_id").val();
    var profession = $("#profession").val();
    var attitude = $("#attitude").val();
    var though = $("#though").val();
    var personComment = $("#person_comment").val(); //评语

if(!profession){
    alert("请完善信息")
    return;
}
    if(!attitude){
        alert("请完善信息")
        return;
    }
    if(!though){
        alert("请完善信息")
        return;
    }
    if(!personComment){
        alert("请完善信息")
        return;
    }

    $.post("../train/addTrainPeopleEvaluate",{trainCurriculumId:uniqueCourseId,profession:profession,attitude:attitude,though:though,
        personComment:personComment,classUuid:classUuid,personId:personId,ext1:biaoshi,ext2:uniqueCourseId},function(data){
        if(data.code == 0){
            var biaoshi = data.biaoshi;
            //加载 第四段未评价列表
            loadNoPingList(biaoshi);
        }
    });
}

/**
 * 带录 标识
 * @param biaoshi
 */
function loadNoPingList(biaoshi) {
    //ext1里面存储了 待录或者已录标示
    var ext1 = biaoshi;
    var courseId = $("input[name='courseId']").val();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");

    //三段页面加载位置
    var fourCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    fourCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    //先清除掉 之前的内容
    $(".layerRtb[data-type='fourCommonAlert']").load("../train/queryRosterTrainPeopleevaluateFlag",{classUuid:classUuid,ext1:biaoshi,ext2:courseId},function(){
        setTimeout(function(){
            countThree();
        },500)
    }).css("display","block");
    $(".layerRtb[data-type='fiveCommonAlert']").css({"display":"none"});
    //刷新3段
    $(".anItemBor-active").click();
}

//三段  教  三段页面的展示
function threeCourseAndPeople(obj,ext1,ext2,ext3,remarks,classUuid,curriculum_id) {
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(obj).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeCourseAndPeople",{remarks:remarks,ext1:ext1,ext2:ext2,ext3:ext3,classUuid:classUuid,ext4:curriculum_id},function(){
        setTimeout(function(){
            countThree();
        },500)
    });
}


//三段  课程信息 详情页面
$(document).on("click",".courseInfo",function(){
    var id = $(this).find(".train_course_id").val();
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeCurriculumInfo",{id:id},function(){
        setTimeout(function(){
            countThree();
        },500)
    });

})

//三段  课  选课页面加载
$(document).on("click",".loadCurriculm",function(){
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeChooseCurriculumShow",{classUuid:classUuid},function(){
        setTimeout(function(){
            countThree();
        },500)
    });

})
//三段 人  选人页面加载
$(document).on("click",".loadUserSelect",function(){
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeChoosePeopleShow",{classUuid:classUuid},function(){
        setTimeout(function(){
            countThree();
        },500)
    });

})

// 为班级中 各天 添加课程 需要class_uuid，class_num_uuid，课程的id
$(document).on("click","#addTrainCurriculum",function(){
    var classNumUuid = $(".title-choice.current").attr("data-day");
    if(classNumUuid == undefined){
        alert("请先为为当前班级添加人员以及开始和结束时间！");
        return;
    }else {
        obj = $(".cur_edit");
        check_val = "";
        for(k in obj){
            if(obj[k].checked)
                check_val += obj[k].value+",";
        }
        var ext1 = check_val;
        if(ext1 != null && ext1 != ""){
            $.post("../train/addTrainCurriculum",{ext1:ext1,classNumUuid:classNumUuid,classUuid:classUuid},function(data){
                //刷新课 二段信息
                $("#train_class").click();
            });
        }
    }

})

//陪 人 三段 人员添加确定按钮
$(document).on("click","#addTrainPeople",function(){
    var roleId = $("#choose_role").val();
    ext2 = roleId;
    obj = document.getElementsByName("check_people");
    check_val = "";
    for(k in obj){
        if(obj[k].checked)
            check_val += "{"+obj[k].value+"}"+",";
    }
    var ext1 = check_val.substring(0,check_val.length-1);
    ext1 = "["+ext1+"]";
    if(ext1 != null && ext1 != ""){
        $.post("../train/addTrainPeople",{ext1:ext1,classUuid:classUuid,ext2:ext2},function(data){
            //刷新人 二段信息
            $("#train_person").click();
        });
    }
})

//培 三段  回访的添加
$("#return_content").click(function(){
    var content = $("#content_info").val();
    var stateFlag = $(".topdaily .active").attr("data-type");
    if(content == null || content == ""){
        alert("请添加回访内容！")
    }else{
        $.post("../train/addTrainReturnContent",{classUuid:classUuid,content:content,stateFlag:stateFlag},function(data){
            if(data == 1){
                $(this).parents(".topdaily").find(".topdailybtn").removeClass("active");
                $(".dailyrgt-divZi").show();
                $(".visi-text-content").hide();
                classUuid=$(".tractive").attr("id");
                $("#trian_visit").load("../train/threeReturnContentList",{classUuid:classUuid},function(){});
            }
        });
    }

})



//培 人 三段  人员信息详情
function queryPersonInfo(obj,u_kahao,postFlag){
    //关闭当前的三段页面
    $(".close_allPopup").click();
    //设置选中样式
    $(obj).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
    //隐藏所有弹窗
    $(".layerRtb").hide().stop(true, true).animate({
        left: "-100%"
    }, 200);
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='thirdCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);
    $(".layerRtb[data-type='thirdCommonAlert']").load("../train/threeQueryPeopleInfo",{u_kahao:u_kahao,ext1:postFlag},function(){
        setTimeout(function(){
            countThree();
        },500)
    });
}


//教 四段花名册列表
$(document).on("click","#four_roster",function(){
    var classUuid = $("input[name='classUuid']").val();

    var uniqueCourseId = $(".anItemBor-active .train_curriculum_id").val();

    //var courseId = $("input[name='courseId']").val();
    //三段页面加载位置
    var thirdCommonAlert = $(".layerRtb[data-type='fourCommonAlert']");
    thirdCommonAlert.show().stop(true, true).animate({
        left: "0"
    }, 200);

    $(".layerRtb[data-type='fourCommonAlert']").load("../train/fourRosterPeople1",{classUuid:classUuid,ext1:uniqueCourseId},function(){
        setTimeout(function(){
            countThree();
        },500)
    });
})

/**
 * 签到
 */
function saveRelation() {
    //课程uuid
    var classuuid=$("#saveRelation").attr("classuuid");
    //课程id
    var courseid = $("#saveRelation").attr("courseid");


    var uniqueCourseId = $(".anItemBor-active .train_curriculum_id").val();

    var param = {};

    var userCardEs = new Array();

    if (classuuid != undefined && classuuid != null){
        param.classuuid = classuuid;
    }

    if (courseid != undefined && courseid != null){
        param.courseid = courseid;
    }
    if (uniqueCourseId != undefined && uniqueCourseId != null){
        param.uniqueCourseId =uniqueCourseId;
    }
    $("input[name='ischeck']").each(function() {

        if (this.checked) {
            userCardEs.push(this.value)
        }
    });
    param.userCardEs = userCardEs;
    param.courseid = courseid;
    param.classuuid = classuuid;
    $.ajax({
        type: "POST",
        url: '../train/saveRoster',
        contentType: "application/json",
        data: JSON.stringify(param),
        success: function (r) {
            if (r.code === 0) {
                alert('操作成功');
                $(".layerRtb[data-type='fourCommonAlert']").animate({"left":"100%"},function () {
                    $(this).hide()
                })
                cancelDisplay();

            } else {
                alert(r.msg);
            }
        }
    })
}



// 结束课的 状态
$(document).on("click",".startClassBtn",function(){

    var curriculumId = $("input[name='curriculumId']").val();
    var param = {curriculumId:curriculumId,classUuid:classUuid};
    $.ajax({
        type: "POST",
        url: '../train/endCourse',
        data: param,
        success: function (r) {
            if (r.code === 0) {
                alert('操作成功', function (index) {
                });
            } else {
                alert(r.msg);
            }
        }
    });
})

// 结束课的 状态
$(document).on("click",".printUserBtn",function(){
    var courseId = $("input[name='courseId']").val();
    $.get("../train/exportUser",{classUuid:classUuid,courseId:courseId});
})

//回显示 带评数
$(document).on("click","#cancelDisplay",function(){
    var courseId = $("input[name='courseId']").val();
    $.ajax({
        type: "POST",
        url: '../train/cancelDisplay',
        data: {courseId:courseId,classUuid:classUuid},
        success: function (r) {
            if (r.msg =='success') {
                $("#daiPing").html(r.noPingJiaCount);
                $("#yiPing").html(r.pingJiaCount);
                $(".layerRtb[data-type='fourCommonAlert']").css("display","none");
            } else {
                alert(r.msg);
            }
        }
    })
})

/**
 * 回显 待评 和 未评人数
 */
function cancelDisplay() {
    var courseId = $("input[name='courseId']").val();
    $.ajax({
        type: "POST",
        url: '../train/cancelDisplay',
        data: {courseId:courseId,classUuid:classUuid},
        success: function (r) {
            if (r.msg =='success') {
                $("#daiPing").html(r.noPingJiaCount);
                $("#yiPing").html(r.pingJiaCount);
                $("input[data-type='people_no']").removeAttr("disabled");
                $(".layerRtb[data-type='fourCommonAlert']").css("display","none");
            } else {
                alert(r.msg);
            }
        }
    })
}

/**
 * 导出签到 的人
 */
function exportArriveFlag() {
    var uniqueCourseId = $(".anItemBor-active .train_curriculum_id").val();
    //发送请求
    window.location.href="/train/exportArriveFlag?classUuid="+classUuid+"&ext1="+uniqueCourseId;
}


/**
 * 结束课程
 */
function endCourseState(classUuid) {
    var percent = $(".tractive").attr("percent");
    var percentArray = percent.split("/");
    if (percentArray[0] < percentArray[1]) {
        alert("请先结束课程信息...");
        return;
    }
    console.info(percentArray);
    $.get('../train/endCourseState',{classUuid:classUuid,classState:2},function (res) {
        if (res.msg== "success"){
            getAllTrainClassList();
            alert("结课成功...");
        } else {
            alert("节课失败...");
        }
    });
}
