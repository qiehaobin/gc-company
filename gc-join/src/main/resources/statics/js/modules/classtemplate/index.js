// 角色列表
function roleList(){
    $.get("queryTrainRole",function (value) {
        if (value.msg=="success"){
            var roleList = value.result;
            $.each(roleList,function (i,data) {
                $("#role").append( '<p class="col-md-4">\n' +
                    '        <label class="uiRadio12">\n' +
                    '        <input name="role" class="uiRadio12-input" value="'+data.role_id+'" type="checkbox">'+data.role_name+'\n' +
                    '        </label>' +
                    '    </p>');
            });
        }
    });
};

/**
 * 添加班级 模板
 */
function addTemplate() {
    //模板名称
    var templateName = $("#templateName").val();
    //等级
    var level = $("#level").val();
    //天
    var dayNum = $("input[name='dayNum']").val();
    //目的
    var purpose = $("#purpose").val();
    //类型
    var type= $("#type").val();
    //拓展
    var development = $("#development").val();
    // 选中的角色
    var roleList = new Array();
    $("input[name='role']:checkbox:checked").each(function (i) {
        roleList.push($(this).val());
    });
    $.ajax({
        url:'saveTemplate',
        dataType:"json",
        type:'post',
        contentType: 'application/json',
        data:JSON.stringify({templateName:templateName,level:level,dayNum:dayNum,purpose:purpose,type:type,departmentId:'工程部',development:development,role:JSON.stringify(roleList)}),
        success: function (data) {
            if (data.msg=="success"){
                layer.msg("添加成功",{icon:1,time:2000});
                $(".AddIcon").click();
                //页面加载1段
                $("#rxprojectLeft").load("one/list",function(){
                    countLeft();
                });
                //加载二段主内容区
                $("#rxprojectMain").load("main",function(){
                    countRight();
                });

            }
        }

    });

}

/**
 *  通过 班模板id  更新模板信息
 * @param id
 */
function updateTemplateById(id) {
    $.ajax({
        url:'../../train/classtemplate/trainclasstemplate/update',
        dataType:"json",
        type:'post',
        contentType: 'application/json',
        data:JSON.stringify({id:id,templateName:$("input[name='templateName']").val()}),
        success: function (value) {
            if(value.msg == "success"){
                layer.msg("修改成功",{icon:1,time:2000});
                $(".tc-center-tabW ul li:eq(1)").click();
            }
        }
    });
}

/**
 *  刪除 班模板
 * @param id
 */
function deleteClassTemplate(id) {
    layer.confirm("确认要删除吗?", {btn: ['确定', '取消'], title: "提示"}, function (e) {
        $.get('../../train/classtemplate/trainclasstemplate/deleteById',{id:id},function (value) {
            if (value.msg =="success"){
                layer.msg("刪除模板班成功",{icon:1,time:2000});
                //页面加载1段
                $("#rxprojectLeft").load("one/list",function(){
                    countLeft();
                });
                //加载二段主内容区
                $("#rxprojectMain").load("main",function(){
                    countRight();
                });
            }
        });
    });

}

/**
 *  删除 选中的 课
 * @param id
 */
$(document).on('click','.MissionEdit',function (e) {
    e.stopPropagation();
    var id=$(this).attr('data-id');
    layer.confirm("确认要删除吗?", {btn: ['确定', '取消'], title: "提示"}, function (e) {
        $.get("../../train/classtemplate/traintemplatecurriculum/deleteById",{id:id},function (value) {
            if (value.msg=="success"){
                layer.close(layer.index);
                layer.msg("删除成功",{icon:1,time:2000});
                $(".tc-center-tabW ul li:eq(2)").click();
            }
        });
    });
})
