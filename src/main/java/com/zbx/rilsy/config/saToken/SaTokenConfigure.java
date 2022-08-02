package com.zbx.rilsy.config.saToken;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zbx
 * @date 2022/8/2
 * @describe
 **/
@Configuration
@EnableWebMvc
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册Sa-Token的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义认证规则
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {

            // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
            SaRouter.match("/**", r -> StpUtil.checkLogin());
            // 仅仅需要登录认证的接口
            SaRouter.match("/logout", "/index").stop();
            // 根据路径匹配权限
            String path = req.getUrl();
            SaRouter.match("/**", r -> StpUtil.checkPermission(path));

        })).addPathPatterns("/**").excludePathPatterns("/login","/captcha");
    }

}
