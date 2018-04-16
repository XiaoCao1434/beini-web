/**
 * 工程通用JS文件
 * @author lb_chen
 * @date 2018-04-14
 */
/**
 * 通过handlebars将template和数据渲染到页面标签
 * @param templateSelector 模板选择器(模板从哪来,示例：<code>#templateId</code>)
 * @param data 渲染的数据 需要嵌套到模板的数据
 * @param htmlSelector html选择器(写到哪里去,示例：<code>#htmlId</code>)
 * @returns 无返回值
 */
function handlebarsRender(templateSelector,data,htmlSelector){
	var page = $(templateSelector).html();
	var template = Handlebars.compile(page);
	var html = template(data);
	$(htmlSelector).html(html);
}

