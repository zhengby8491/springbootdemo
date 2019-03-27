$(document).ready(function()
{
	// 点击左侧菜单加载页面
	$(".load-link").on("click", function()
	{
		var url = $(this).data("url");
		var title = $(this).data("title");
		loadPage(url, title);
	})
	// 点击标签加载页面
	$("#tab-list").on("click","li", function(){
		var url = $(this).data("url");
		var title = $(this).data("title");
		if(Helper.validator.isNotEmpty(url) && Helper.validator.isNotEmpty(title))
		{
			loadPage(url, title);
		}
	})
	// 点击标签上的删除按钮
	$("#tab-list").on("click", "i.fa-times", function(e){
		removeTab(this);
	})
	
	$("#tab-list").on("mouseenter", "li", function(){
		createMouseDownMenuData($(this));
	});
});

/* 加载页面 */
function loadPage(url, title)
{
	var tabList = $("#tab-list").find("li");
	var hasTab = false;
	// 判断是否已有此tab标签页
	tabList.each(function()
	{
		// 已打开过的页签再显示出来
		if ($(this).data("url") == url)
		{
			hasTab = true;
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		}
	});
	// 不含有此标签页则执行下列函数
	if (!hasTab)
	{
		$("#tab-list").find("li").removeClass("active");
		$("#tab-list").append("<li class='active' data-title='"+ title +"' data-url='"+ url +"'><span class='tab'>"+ title +"</span><i class='fa fa-times'></i></li>");
	}
	$.get(url, function(data)
	{
		$(".layoutContent").html(data);
	});
}
/* 删除页签 */
function removeTab(obj)
{
	var that = $(obj).parents("li");
	// 如果删除了当前页签则自动加载左边最近的页签
	if (that.hasClass("active"))
	{
	  that.prev().trigger("click");
	}
	that.remove();
	e.stopPropagation(); // 阻止js事件冒泡机制
}

/**
 * 页签右建事件
 */
function createMouseDownMenuData(obj)
{
	obj.unbind("mousedown");
	obj.one("mousedown", (function(e)
	{
		if (e.which == 3)
		{// 右键事件
			var _THIS = $(this);
			var SELF = "self";
			var OTHER = "other";
			var LEFT = "left";
			var RIGHT = "right";
			var ALL = "all";
			var opertionn = {
				name : "",
				offsetX : 2,
				offsetY : 2,
				textLimit : 10,
				beforeShow : $.noop,
				afterShow : $.noop
			};
			var refreshSelf = function()
			{
				_THIS.trigger("click");
			}
			var closeByType = function(type)
			{
				var liCurrIndex = $("#tab-list li").index(_THIS);// 当前页签的索引（从0开始）
				var liLength = $("#tab-list li").length;
				switch (type)
				{
				case SELF:
					removeTab(_THIS);
					_THIS.remove();
					num == 0 ? num = 0 : num--;
					break;
				case OTHER:
					for (var i = 0; i < liLength; i++)
					{
						if (i != 0)
						{
							if (i < liCurrIndex)
							{
								$("#tab-list li").eq(1).remove();
							} else if (i > liCurrIndex)
							{
								$("#tab-list li").eq(2).remove();
							}
						}
					}
					num = 1;
					break;
				case LEFT:
					for (var k = 0; k < liCurrIndex; k++)
					{
						if (k != 0)
						{
							$("#tab-list li").eq(1).remove();
							num == 0 ? num = 0 : num--;
						}
					}
					break;
				case RIGHT:
					for (var x = liCurrIndex; x < liLength; x++)
					{
						$("#tab-list li").eq(liCurrIndex + 1).remove();
						num == 0 ? num = 0 : num--;
					}
					break;
				case ALL:
					for (var y = 0; y < liLength; y++)
					{
						if (y != 0)
						{
							$("#tab-list li").eq(1).remove();
						}
					}
					num = 0;
					break;
				}

				if (!$("#tab-list li").hasClass("active"))
				{
					$("#tab-list li").removeClass("active").eq(-1).addClass("active");
				}
				//tabNavallwidth();
			}

			var liCurrIndex = $("#tab-list li").index($(this));// 当前页签的索引（从0开始）
			var liLength = $("#tab-list li").length;
			function createMenuData()
			{

				var refreshSelf_tab = {
					text : "刷新",
					func : function()
					{
						refreshSelf();
					}
				};
				var closeSelf_tab = {
					text : "关闭",
					func : function()
					{
						closeByType(SELF);
					}
				};
				var closeOther_tab = {
					text : "关闭其它",
					func : function()
					{
						closeByType(OTHER);
					}
				};
				var closeLeft_tab = {
					text : "关闭左侧",
					func : function()
					{
						closeByType(LEFT);
					}
				};
				var closeRight_tab = {
					text : "关闭右侧",
					func : function()
					{
						closeByType(RIGHT);
					}
				};
				var closeAll_tab = {
					text : "关闭全部",
					func : function()
					{
						closeByType(ALL);
					}
				};
				if (liCurrIndex == 0)
				{
					return [ [ refreshSelf_tab ] ];
				} else
				{
					if (liLength == 2)
					{// 只有自己
						return [ [ refreshSelf_tab ], [ closeSelf_tab ] ];
					} else if (liCurrIndex == 1)
					{// 自己是第一个节点
						return [ [ refreshSelf_tab ], [ closeSelf_tab, closeRight_tab ], [ closeAll_tab ] ];
					} else if (liCurrIndex > 1 && (liCurrIndex < liLength - 1))
					{// 自己是中间节点
						return [ [ refreshSelf_tab ], [ closeSelf_tab, closeOther_tab, closeLeft_tab, closeRight_tab ], [ closeAll_tab ] ];
					} else
					{// 自己是末节点
						return [ [ refreshSelf_tab ], [ closeSelf_tab, closeLeft_tab ], [ closeAll_tab ] ];
					}
					return null;
				}

			}
			;
			_THIS.smartMenu(createMenuData(), opertionn);

		}
	}));
}