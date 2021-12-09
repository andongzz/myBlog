package com.JIA.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author J.I.A.
 * @create 2021-12-07
 */
@Configuration
public class MySpringMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/login").setViewName("admin-login");
        registry.addViewController("/admin/index").setViewName("private/admin-index");
        registry.addViewController("/cloud/start").setViewName("user-cloud");
        registry.addViewController("/cloud/help").setViewName("user-cloud-help");
        registry.addViewController("/admin/cloud/check/code").setViewName("private/admin-check-code");
    }
}
