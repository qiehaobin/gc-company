function selectCondition() {
    var post = $("#postSelect").val();
    var type = $("#typeSelect").val();
    getList({"postId":post,"typeId":type})
}

function getInfoById(id) {
    $.get("../../recruit/postStandard/info/" + id, function (res) {
        if(res.msg=="success"){
            var obj = res.postStandard;
            $("#sex").html(obj.sex == '0' ? '女' : '男')
            $("#ageMin").html(obj.ageMin)
            $("#ageMax").html(obj.ageMax)
            $("#workingLife").html(obj.workingLife)
            $("#education").html(obj.education)
            $("#specialty").html(obj.specialty)
            $("#salaryMin").html(obj.salaryMin)
            $("#salaryMax").html(obj.salaryMax)
            $("#requirement").html(obj.requirement)
            var _obj = $(".defaultblock");
            if(obj.sex==0){
                _obj.find('input[name="sex1"]:eq(1)').click()
            }else {
                _obj.find('input[name="sex1"]:eq(0)').click()
            }
            _obj.find('.agestart').val(obj.ageMin)
            _obj.find('.ageend').val(obj.ageMax)
            _obj.find('.workspan').val(obj.workingLife)
            _obj.find('.educationspan').val(obj.education)
            _obj.find('.majorspan').val(obj.education)
            _obj.find('.salarystart').val(obj.salaryMin)
            _obj.find('.salaryend').val(obj.salaryMax)
            _obj.find('.analyEditArea').val(obj.requirement)
        }
    });
}

function clickTr() {
    $("#tab1 tr").click(function () {
        var index = $('.j_uiTab9 li').index($('.defaultblock .j_uiTab9 .uiTab9-active'));
        if (index == -1) index = 0;
        $(".CloseMouseRight").click();
        $(".rigImg_icon").click();
        $(this).addClass("tractive").siblings().removeClass("tractive");
        $(".j_uiTab9 li:eq(" + index + ")").click();
        $("#deletePostStandard").attr("data-id",$(this).attr("data-id"));
        getInfoById($(this).attr("data-id"))
        $(".defaultblock").show();
        $(".newblock").hide();
    });
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

function JSEffect() {
    //状态、处理固定
    countstatus();
    //编辑按钮
    $(document).on("click",".img_edit",function(){
        $(this).hide();
        $(this).closest(".analyItemCon").find(".analyLook").hide();
        $(this).closest(".analyItemCon").find(".analyEdit").show();
        $(this).closest(".analyItemCon").find(".save_img,.goback_img").show();
    });
    //保存
    $(document).on("click",".save_img",function(){
        var obj = $(this);
        var _obj = $(".defaultblock");
        var sex = _obj.find('input[name="sex1"]:checked').val();
        var ageMin = _obj.find('.agestart').val();
        var ageMax = _obj.find('.ageend').val();
        var workingLife = _obj.find('.workspan').val();
        var education = _obj.find('.educationspan').val();
        var specialty = _obj.find('.majorspan').val();
        var salaryMin = _obj.find('.salarystart').val();
        var salaryMax = _obj.find('.salaryend').val();
        var requirement = _obj.find('.analyEditArea').val()
        if(sex == '' ||ageMin == '' ||ageMax == '' ||workingLife == '' ||education == '' ||specialty == '' ||salaryMin == '' ||salaryMax == '' ||requirement == ''){
            layer.msg('请完善资料提交！', {icon: 5, time: 2000});
            return;
        }
        if(parseInt(ageMin)>parseInt(ageMax)){
            layer.msg('最小年龄应该小于最大年龄！', {icon: 5, time: 2000});
            return;
        }
        if(parseInt(salaryMin)>parseInt(salaryMax)){
            layer.msg('最小薪资应该小于最大薪资！', {icon: 5, time: 2000});
            return;
        }
        var data = {
            "id": $("#deletePostStandard").attr("data-id"),
            "sex":sex,
            "ageMin":ageMin,
            "ageMax":ageMax,
            "workingLife":workingLife,
            "education":education,
            "specialty":specialty,
            "salaryMin":salaryMin,
            "salaryMax":salaryMax,
            "requirement":requirement
        };
        $.ajax({
            url:"../../recruit/postStandard/update",
            type:"post",
            data:data,
            success:function(text){
                if(text.msg=="success"){
                    layer.msg('修改成功！', {icon: 1, time: 2000});
                    obj.closest(".analyItemCon").find(".img_edit").show();
                    obj.closest(".analyItemCon").find(".analyLook").show();
                    obj.closest(".analyItemCon").find(".analyEdit").hide();
                    obj.closest(".analyItemCon").find(".save_img,.goback_img").hide();
                    $("#tab1 .tractive").click();
                }
            },
            error:function(){
                layer.msg('提交失败！', {icon: 5, time: 2000});
            }
        });
    });
    //撤销
    $(document).on("click",".goback_img",function(){
        $(this).closest(".analyItemCon").find(".img_edit").show();
        $(this).closest(".analyItemCon").find(".analyLook").show();
        $(this).closest(".analyItemCon").find(".analyEdit").hide();
        $(this).closest(".analyItemCon").find(".save_img,.goback_img").hide();
    });
    $("#savePostStandard").click(function () {
        var postId = $("#post").val();
        var postName = $("#post").find("option:selected").text();
        var typeId = $("#type").val();
        var typeName = $("#type").find("option:selected").text();
        var obj = $("#newPostStandard");
        var sex = obj.find('input[name="sex1"]:checked').val();
        var ageMin = obj.find('.agestart').val().trim();
        var ageMax = obj.find('.ageend').val().trim();
        var workingLife = obj.find('.workspan').val().trim();
        var education = obj.find('.educationspan').val().trim();
        var specialty = obj.find('.majorspan').val().trim();
        var salaryMin = obj.find('.salarystart').val().trim();
        var salaryMax = obj.find('.salaryend').val().trim();
        var requirement = obj.find('.analyEditArea').val().trim();
        if(sex == '' ||ageMin == '' ||ageMax == '' ||workingLife == '' ||education == '' ||specialty == '' ||salaryMin == '' ||salaryMax == '' ||requirement == ''){
            layer.msg('请完善资料提交！', {icon: 5, time: 2000});
            return;
        }
        if(parseInt(ageMin)>parseInt(ageMax)){
            layer.msg('最小年龄应该小于最大年龄！', {icon: 5, time: 2000});
            return;
        }
        if(parseInt(salaryMin)>parseInt(salaryMax)){
            layer.msg('最小薪资应该小于最大薪资！', {icon: 5, time: 2000});
            return;
        }
        var data = {
            "postId": postId,
            "postName":postName,
            "typeId":typeId,
            "typeName":typeName,
            "sex":sex,
            "ageMin":ageMin,
            "ageMax":ageMax,
            "workingLife":workingLife,
            "education":education,
            "specialty":specialty,
            "salaryMin":salaryMin,
            "salaryMax":salaryMax,
            "requirement":requirement
        };
        $.ajax({
            url:"../../recruit/postStandard/save",
            type:"post",
            data:data,
            success:function(text){
                if(text.msg=="success"){
                    layer.msg('保存成功！', {icon: 1, time: 2000});
                    $(".defaultblock").show();
                    $(".newblock").hide();
                    $("#newPostStandard .analyItem").find('input,textarea').val("")
                    getList(null);
                }else {
                    layer.msg(text.msg, {icon: 5, time: 2000});
                }
            },
            error:function(){
                layer.msg('提交失败！', {icon: 5, time: 2000});
            }
        });


    })
    $("#deletePostStandard").click(function () {
        $.get("../../recruit/postStandard/update",{ id:$(this).attr("data-id"), delFlag:"1"}, function (res) {
            if(res.msg=="success"){
                layer.msg('删除成功！', {icon: 1, time: 2000});
                getList()
            }
        });
    })

}

function getList(data) {
    $.get("../../recruit/postStandard/list/",data, function (res) {
        if(res.msg=="success"){
            var list = res.list;
            $("#tab1 tbody").empty()
            if(list.length>0){
                $.each(list,function(key,value){  //遍历键值对
                    $("#tab1 tbody").append(' <tr data-id="'+value.id+'" data-postId="'+value.postId+'" data-typeId="'+value.typeId+'">\n' +
                        '                        <td width="50%">'+value.postName+'</td>\n' +
                        '                        <td width="30%">'+value.typeName+'</td>\n' +
                        '                        <td>'+value.time+'</td>\n' +
                        '                    </tr>')
                })
                changecolor();
                clickTr();
                $("#tab1 tr:eq(0)").click();
            }
        }
    });
}