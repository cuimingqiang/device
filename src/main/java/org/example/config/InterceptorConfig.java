package org.example.config;

import org.example.interceptor.CorsInterceptor;
import org.example.interceptor.DeviceLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * <p>
 * 不用权限可以访问url    /api/v1/pub/
 * 要登录可以访问url    /api/v1/pri/
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new DeviceLoginInterceptor()).addPathPatterns("/api/v1/device/**",
                        "/api/v1/user/**")
                //不拦截哪些路径   斜杠一定要加
                .excludePathPatterns("/api/v1/device/upload");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
