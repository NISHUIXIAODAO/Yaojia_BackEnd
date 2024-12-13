package com.ccl.userboot.medicinestore.config;

import com.ccl.userboot.medicinestore.interceptors.UserInterceptor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("添加拦截器");


        // 配置用户拦截器
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login",
                        "/user/outLogin",
                        "/user/register"
                ); // 这里可以排除不需要进行Token验证的路径
    }
}
