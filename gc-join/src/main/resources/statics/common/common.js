function changeCol() {
    $(".diffColor").removeClass("cGeen").removeClass("cRed");
    $(".circlemark").each(function () {
        if($(this).hasClass("circlemark-rs")){
            $(this).removeClass().addClass("circlemark").addClass("circlemark-rs");
        }else {
            $(this).removeClass().addClass("circlemark");
        }
    });
    $(".colorPerson,.rankColor").removeClass("cGreen").removeClass("cOrange").removeClass("cRed");
    $(".chaColor").removeClass("cGreen").removeClass("cRed");
    $(".stateColor").removeClass("cGreen").removeClass("cRed").removeClass("cPurple");
    $(".managerColor").removeClass("cY00cc33").removeClass("cL99cc00").removeClass("cZff9900").removeClass("cCff6633");
    //差值标红
    $(".diffColor").each(function () {
        var num = parseInt($(this).html());
        if(num > 999){
            $(this).html("999")
        }
        if(num < -999){
            $(this).html("-999")
        }
        if($(this).html() != "-"){
            var diff = parseInt($(this).html());
            if(diff > 0){
                $(this).removeClass("cGreen").removeClass("cRed").addClass("cGreen")
            }
            if(diff < 0){
                $(this).removeClass("cGreen").removeClass("cRed").addClass("cRed")
            }
        }
    });
    //记录中的优良中差加颜色
    $(".circlemark").each(function () {
        var zi = $(this).html();
        var cls = "";
        switch (zi){
            case "优": cls = "circlemark-green";break;
            case "拆": cls = "circlemark-green";break;
            case "良": cls = "circlemark-lightGreen";break;
            case "中": cls = "circlemark-yellow";break;
            case "差": cls = "circlemark-lightRed";break;
            case "未": cls = "circlemark-lightRed";break;
            case "待": cls = "circlemark-purple";break;
            case "盯": cls = "circlemark-red";break;
            case "完": cls = "circlemark-green";break;
            case "等": cls = "circlemark-gray";break;
            case "问题": cls = "circlemark-lightRed";break;
            case "正常": cls = "circlemark-green";break;
            default : cls = "";break;
        }
        $(this).addClass(cls);
        if(zi=="-") $(this).html("")
    });
    $(".colorPerson").each(function () {
        var zi = $(this).html();
        var cls = "";
        switch (zi){
            case "优": cls = "cGreen";break;
            case "正常": cls = "cGreen";break;
            case "异常": cls = "cOrange";break;
            case "问题": cls = "cRed";break;
            case "空岗": cls = "cRed";break;
        }
        $(this).addClass(cls);
    });
    $(".stateColor").each(function () {
        var zi = $(this).html();
        var cls = "";
        switch (zi){
            case "正": cls = "cGreen";break;
            case "完": cls = "cGreen";break;
            case "待一": cls = "cPurple";break;
            case "待二": cls = "cPurple";break;
            case "待": cls = "cPurple";break;
            case "盯": cls = "cRed";break;
        }
        $(this).addClass(cls);
    });
    $(".chaColor").each(function (i) {
        var num = parseFloat($(this).html());
        if(num < 0 ){
            $(this).addClass("cRed");
        }else {
            $(this).addClass("cGreen")
        }
    });
    $(".rankColor").each(function () {
        var rank = $(this).html();
        var cls = "";
        switch (rank){
            case "正常": cls = "cGreen";break;
            case "异常": cls = "cOrange";break;
            case "问题": cls = "cRed";break;
        }
        $(this).addClass(cls);
    });
    $(".managerColor").each(function () {
        var rank = $(this).html();
        var cls = "";
        switch (rank){
            case "优": cls = "cY00cc33";break;
            case "良": cls = "cL99cc00";break;
            case "中": cls = "cZff9900";break;
            case "差": cls = "cCff6633";break;
        }
        $(this).addClass(cls);
    });
    $(".plus_minus").each(function () {
        $(this).removeClass("cRed").removeClass("cBlue").removeClass("cGrey");
        var num = parseFloat($(this).html());
        if (num<0){
            $(this).addClass("cRed");
        }else if (num>0){
            $(this).addClass("cBlue");
        }else {
            $(this).addClass("cGrey");
        }
    })
};
//筛选
function selectRegion() {
    var regionSel = $(".RegionSelect option:selected").html();
    $("#tab1 tr").show().addClass("totalNum");
    if (regionSel == "地区") {
        totalNum();
        return;
    }
    $("#tab1 tr").each(function(){
        var region = $(this).find('td:eq(0)').html().trim();
        if (regionSel != "地区" && region != regionSel){
            $(this).hide().removeClass("totalNum");
        }
    });
    var arr = [];
    $("#tab1 tr").each(function () {
        if($(this).css("display") != "none"){
            arr.push($(this));
        }
    });
    totalNum();
    if(arr.length!=0) arr[0].click();
}
function totalNum() {
    $("#totalNum").html($("#tab1 .totalNum").length);
    $("#zNum").html($("#tab1 .totalNum .state正常").length);
    $("#eNum").html($("#tab1 .totalNum .state异常").length);
    $("#wNum").html($("#tab1 .totalNum .state问题").length);
}
$(".tj_bottom .col-md-3").click(function () {
    $(".emptyTr").remove();
    var tx = $(this).attr("title");
    if(tx==""){
        $("#tab1 tr").show().addClass("totalNum");
    }else {
        $("#tab1 tr").hide().removeClass("totalNum");
        $("#tab1 .state"+tx).parent().addClass('totalNum').show();
    }

    var arr = [];
    var flag = 0;
    $("#tab1 tr").each(function () {
        if($(this).css("display") != "none"){
            arr.push($(this));
            flag = 1;
        }
    });
    if(arr.length!=0) arr[0].click();
    totalNum();
    if(flag == 0){
        $("#tab1 tbody").append('<tr class="emptyTr"><td>暂无数据</td></tr>')
    }
});
function clickLi() {
    $(".daily_title .title_cur").click();
    $(".dailyftSearch").hide();
}
function changeLable(text) {
    text =text.toString();
    switch (text){
        case '11':text = 'R6';break;
        case '12':text = '北京';break;
        case '15':text = '南京';break;
        case '16':text = '合肥';break;
        case '18':text = '武汉';break;
        case '19':text = '天津';break;
        case '20':text = '郑州';break;
        case '21':text = '重庆';break;
        case '22':text = '成都';break;
        case '25':text = '西安';break;
        case '26':text = '杭州';break;
        case '30':text = '济南';break;
        case '31':text = '石家庄';break;
        case '36':text = '宁波';break;
        case '38':text = '上海';break;
        case '49':text = '望京';break;
        case '50':text = '亦庄';break;
        case '55':text = 'CBD';break;
        case '39':text = '集团';break;
        case '60':text = '汉口';break;
        case '61':text = '湖北';break;
        case '62':text = '江苏';break;
        case '65':text = '雁塔';break;
        case '66':text = '重案';break;
    }
    return text;
}
function changecolor(){
    $(".uiTable tbody tr:visible").each(function(i){
        if(i%2!=0)
        {
            $(this).addClass("trodd")
        }
    })
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes();
    return currentdate;
}

/*截取*/
function textSub(text,length){
    if(typeof (text)=='undefined') text='';
    var subStr = text;
    if(text.length>(length+1)){
        subStr = text.substr(0,length)+'...'
    }
    return subStr;
}
function deChange(text) {
    if(text==null||text==''||typeof (text)=='undefined') {
        text = "-";
    }
    return text;
}

/*重新计算中间宽度*/
function modifyCenterWidth() {
    $(".wrapper").on("click",".tc-center .uiTab9.j_uiTab9>li",function () {
        $(".tc-center").css("width","470px");
    })
}

function otherJSEffect() {

    $("#tab1 *[title]").hover(function () {
        if($(this).attr("title")!=""){
            var title=$(this).attr("title");
            $(this).attr("data-tips",title );
            $(this).attr("title","");
            layer.tips(title,$(this),{tips:[2,'#3595CC'],time:0,maxWidth:500});
        }
    });
    $("#tab1 *[title]").mouseleave(function () {
        $(this).attr("title",$(this).attr("data-tips"));
        layer.closeAll();
    });


    $(".fixedtips").click(function () {
        if ($(this).attr("data-fixedflag") == 0) {
            $(this).next(".fixedtipscon").show();
            $(this).attr("data-fixedflag", "1")
        }
        else {
            $(this).next(".fixedtipscon").hide();
            $(this).attr("data-fixedflag", "0")
        }
    });

    //左侧JS
    rxued.table.LChangeapart($("#tab1 tr"), "#f9f9f9", "#fff");
    rxued.table.hoverChage($("#tab1 tr"), "#eaf4fe");
    rxued.init.countH($(".scroll-content"), "15", function () {
        $(".scroll-content").slimScroll({height: $(".scroll-content").eq(0).height()-40, borderRadius: "0px"});
    });
    $(window).resize(function () {
        rxued.init.countH($(".scroll-content"), "15", function () {
            $(".scroll-content").slimScroll({height: $(".scroll-content").eq(0).height(), borderRadius: "0px"});
            $(".scroll-content").parents(".slimScrollDiv").height($(".scroll-content").eq(0).height())
        });
    });

    //中间JS
    rxued.areaSwitch.Tab($('.j_uiTab9'), 'uiTab9-active', $('.uiTab9Con'), 'click');
    var theight = $("body").height()- $("#topnav").height() - $(".j_uiTab9").outerHeight() - 11;
    $("#j-tc-center-content,.j-tc-center-content").height(theight).slimScroll({height: theight, borderRadius: "0px"});
    $(window).resize(function () {
        var theight = $("body").height() - $("#topnav").height() - $(".j_uiTab9").outerHeight() - 11;
        $("#j-tc-center-content,.j-tc-center-content").height(theight).slimScroll({height: theight, borderRadius: "0px"});
        $("#j-tc-center-content,.j-tc-center-content").parents(".slimScrollDiv").eq(0).height(theight)
    });

    //右侧JS
    var rightHeight = $("body").height() - $("#topnav").outerHeight() - $(".j-tc-righttop-tab").outerHeight() - $(".tc-right-bottom").outerHeight() - 10;
    $(".tc-right-top").height(rightHeight);
    $("#j-visit,#j-visit2").height(rightHeight);
    $(".tc-taskDiv").height(rightHeight - 22);
    $(".tc-taskDiv").width($(".tc-right-top").width() - 102);
    $(window).resize(function () {
        var rightHeight = $("body").height() - $("#topnav").outerHeight() - $(".j-tc-righttop-tab").outerHeight() - $(".tc-right-bottom").outerHeight() - 10;
        $(".tc-right-top").height(rightHeight);
        $("#j-visit,#j-visit2").height(rightHeight)
    });


    $(".topdaily .topdailybtn").click(function () {
        $(this).parents(".topdaily").find(".topdailybtn").removeClass("active");
        $(this).addClass("active");
        $(".dailyrgt-divZi").hide();
        $(".visitCon").show();
    });

    $(".dailyrgt-botradio .uiRadio12").click(function () {
        $(".dailyrgt-divZi").hide();
        $(".dailyrgt-botradio").hide();
        $(".visi-text-content").show();
    });
    /*右侧滑出详细关闭*/
    $(".rig_close").click(function () {
        $(this).parents(".layerRtb").animate({
            left: '-100%',
            opacity: 0
        }, function () {
            $(this).hide();
            $(".anItemBor").removeClass("anItemBor-active");
        });
    });

    $(".anItemBor").click(function () {
        $(".layerRtb-threecolumn").show();
        var layerRtbHei=$(".tc-right").height()-$(".layerRtb-head").height()-$(".layerRtb-footer").height()-40;
        $(".layerRtb-scroll").slimScroll({
            height: layerRtbHei,
            borderRadius: "0px"
        });
        $(this).addClass("anItemBor-active").siblings().removeClass("anItemBor-active");
        $(".layerRtb-threecolumn").stop().animate({
            left:"0px",
            opacity: 1
        });
    });

    //新增
    $(".AddIcon").click(function(){
        $(".defaultblock").hide();
        $(".newblock").show();
    })

}