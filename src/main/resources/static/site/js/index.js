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
		 loadPage(url, title);
	})
	// 点击标签上的删除按钮
	$("#tab-list").on("click", "i.fa-times", function(e){
		removeTab(this);
		e.stopPropagation(); // 阻止js事件冒泡机制
	})
});

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

function removeTab(obj)
{
	$(obj).parents("li").remove();
}