//记录顶部导航条和主导航固定状态下文档的高度，以便于和二级三级导航菜单展开时nav的高度做对比
//j_outer位主导航菜单中除了nav-ul外的其他标签加上j_outer,用于计算nav高度并和文档高度做对比
function countnavH(){
	var navOtherH=0;
	var onavconH=0;
	for(var oj=0;oj<$(".j_outer").length;oj++)
	{
		navOtherH+=$(".j_outer").eq(oj).outerHeight(true);
	}
	//判断是导航是否是选项卡形式的，如果是选向卡则计算当前nav-ul的高度
	$("#nav .nav-ul").each(function(){
		if($(this).css("display")=="block")
		{
			onavconH=$(this).outerHeight()+navOtherH;
		}
	})
	if(onavconH<$(document).height()-$("#main_header").height())
	{
		$("#nav").height($(document).height()-$("#main_header").height());
	}else{
		$("#nav").height(onavconH);
	}
}
//左侧导航js 一级菜单点击
$(".nav-ul>li>a").click(function(){
	$(this).parent("li").siblings().removeClass("open");
	$(this).parent("li").siblings().find(".open").removeClass("open");
	$(this).parent("li").siblings().find("ul").slideUp(200);
	if($(this).next("ul").length>0)
	{
	
		if($(this).next("ul").css("display")!="block")
		{
			$(this).parent("li").addClass("open");
			$(this).next("ul:first").slideDown(200,function(){
				countnavH();
			});
		}
		else
		{
			$(this).parent("li").removeClass("open");
			$(this).parent("li").find(".open").removeClass("open");
			$(this).parent("li").find("ul").slideUp(200,function(){
				countnavH();
			});
		}
	}
	else
	{
		$(this).parent("li").addClass("active").siblings().removeClass("active");
		$(this).parent("li").siblings().find(".active").removeClass("active");
	}
});

//左侧导航js 二级菜单点击
$(".nav-ul ul>li>a").click(function(){
	$(this).parent("li").siblings().removeClass("open");
	$(this).parent("li").siblings().find(".open").removeClass("open");
	$(this).parent("li").siblings().find("ul").slideUp(200);
	if($(this).next("ul").length>0)
	{
		//水平方向展示的导航菜单，如果二级菜单中有三级菜单，则取消二级菜单点击事件
	
		//竖直方向折叠导航，如果二级菜单中有三级菜单，则取消二级菜单点击事件
		if($("body").hasClass("nav-collapsed-min")&&$(this).next("ul").length>0)
		{
			return false;
		}
		if($(this).next("ul").css("display")!="block")
		{
			$(this).parent("li").addClass("open");
			$(this).next("ul:first").slideDown(200,function(){
				countnavH();
			});
		}
		else
		{
			$(this).parent("li").removeClass("open");
			$(this).parent("li").find("ul").slideUp(200,function(){
				countnavH();
			});
		}
	}
	else
	{
		$(this).parent("li").addClass("active").siblings().removeClass("active");
		$(this).parent("li").siblings().find(".active").removeClass("active");
		$(this).parents("li").addClass("active");
		$(this).parents("li").siblings().removeClass("active");
		$(this).parents("li").siblings().find(".active").removeClass("active");
		$(this).parents("li").siblings().find(".open").removeClass("open");
		$(this).parents("li").siblings().find("ul").slideUp(200);
	}
});
//左侧导航js 三级菜单点击
$(".nav-ul ul ul>li>a").click(function(){
	$(this).parent("li").addClass("active").siblings().removeClass("active");
	$(this).parents("li").addClass("active");
	$(this).parents("li").siblings().removeClass("active");
	$(this).parents("li").siblings().find(".active").removeClass("active");
	$(this).parents("li").siblings().find(".open").removeClass("open");
	$(this).parents("li").siblings().find("ul").slideUp(200);
});
//折叠导航js
$(".setup_nav").click(function(){
	$(".nav-horizontal .more-nav-li").removeClass("open_link");
	$(".nav-ul .open").removeClass("open");
	$(".nav-ul li ul").hide();
	$("body").toggleClass("nav-collapsed-min");

		$(".AccordingDiv").css("margin-top","0px");
		if($("body").hasClass("nav-collapsed-min"))
		{
			$(".rolechange").hide();
			//判断nav-features位置(导航内容数据比较少时，.nav-features div以顶部对齐，内容比较多少，.nav-features div以底部对齐)
			if($(".nav-features").length>0)
			{
				if($(".nav-ul").outerHeight()>300&&$(".nav-vertical").hasClass("nav-collapsed-min"))
				{
					$(".nav-vertical.nav-collapsed-min .nav-features div").css({"top":"auto","bottom":"0"});
				}else{
					$(".nav-vertical.nav-collapsed-min .nav-features div").css({"top":"0","bottom":"auto"});
				}
			}
			$("#main_content").css("marginLeft","50px");
		}else{
			$(".rolechange").show();
			$("#main_content").css("marginLeft","180px");
		}
		//由水平方向导航切换到垂直方向
		///$(".nav-vertical .nav-ul>li").css("display","block");

	countnavH();
});

function init(){
	//给nav赋自定义属性值，以便于导航不固定时调用
	var navH=$("#nav").outerHeight();
	var main_contentH=$("#main_box").height();
	if(navH<main_contentH)
	{
		$("#nav").attr("data-height",main_contentH);
	}
}
$(function(){
	init();
})




//点击头部导航圆圈效果
!function(t, i, e, o) {
    function n(i, e) {
        this.$element = t(i),
        this.options = t.extend({}, n.Defaults, this._getOptionsFromElementAttributes(), e),
        this._prepare(),
        this._bind()
    }
    n.prototype._bind = function() {
        var n, r, a, s, p, c = this.$element, l = this.options;
        s = "ontouchend" in i || i.DocumentTouch && e instanceof DocumentTouch,
        p = 1 == s ? "touchend.rippleria" : "click.rippleria",
        this.$element.bind(p, function(i) {
           // i.stopPropagation();
            var e = t("<span class='rippleria-ink'></span>");
            if (c.prepend(e),
            l.color != o && e.css("background-color", l.color),
            e.css("animation", "rippleria " + l.duration / 1e3 + "s " + l.easing),
            setTimeout(function() {
                e.remove()
            }
            , parseFloat(l.duration)),
            e.height() || e.width() || (n = Math.max(c.outerWidth(), c.outerHeight()),
            e.css({
                height: n,
                width: n
            })),
            1 == s) {
                var p = i.originalEvent.touches[0] || i.originalEvent.changedTouches[0];
                r = p.pageX - c.offset().left - e.width() / 2,
                a = p.pageY - c.offset().top - e.height() / 2
            } else
                r = i.pageX - c.offset().left - e.width() / 2,
                a = i.pageY - c.offset().top - e.height() / 2;
            e.css({
                top: a + "px",
                left: r + "px"
            })
        }
        )
    }
    ,
    n.prototype._prepare = function() {
        var t = this.$element;
        "static" == t.css("position") && t.css("position", "relative"),
        t.css("overflow", "hidden");
        var i = "block" == t.css("display") ? "block" : "inline-block";
        t.css("display", i),
        t.wrapInner("<div class='rippleria-wrap'></div>")
    }
    ,
    n.prototype._getOptionsFromElementAttributes = function() {
        var i = this;
        return attrs = {},
        t.each(n.Defaults, function(t, e) {
            var o = i.$element.attr("data-rippleria-" + t);
            null  != o && (attrs[t] = o)
        }
        ),
        attrs
    }
    ,
    n.prototype.changeColor = function(t) {
        this.options.color = t
    }
    ,
    n.prototype.changeEasing = function(t) {
        this.options.easing = t
    }
    ,
    n.prototype.changeDuration = function(t) {
        this.options.duration = t
    }
    ,
    n.Defaults = {
        duration: 750,
        easing: "linear",
        color: o
    },
    t.fn.rippleria = function(i) {
        var e = Array.prototype.slice.call(arguments, 1);
        return this.each(function() {
            var o = t(this)
              , r = o.data("rippleria");
            r || (r = new n(this,"object" == typeof i && i),
            o.data("rippleria", r)),
            "string" == typeof i && "_" !== i.charAt(0) && r[i].apply(r, e)
        }
        )
    }
    ,
    t(function() {
        t("[data-rippleria]").rippleria()
    }
    )
}
(window.jQuery, window, document);






//左侧菜单滚动条调用
$(function () {
    $(".nav-wrapper-content").slimScroll({ height: "100%", borderRadius: "6px" });
})