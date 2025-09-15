// 代码生成时间: 2025-09-15 20:59:59
package com.example.theme;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import javax.annotation.Nullable;

@Controller("/theme")
public class ThemeController {
    // 从配置文件读取主题
# 增强安全性
    @Value('${theme.default:light}')
    private String defaultTheme;

    // 获取当前主题
# 添加错误处理
    @Get("/current")
    public HttpResponse<String> getCurrentTheme() {
        return HttpResponse.ok(defaultTheme);
# 改进用户体验
    }

    // 切换主题
    @Get("/switch/{theme}")
    public HttpResponse<String> switchTheme(@PathVariable @Nullable String theme) {
        try {
            // 检查主题是否有效
            if (theme == null || !(theme.equals("light") || theme.equals("dark"))) {
                return HttpResponse.badRequest("Invalid theme");
            }
# 增强安全性
            // 更新主题
            defaultTheme = theme;
            return HttpResponse.ok("Theme switched to 