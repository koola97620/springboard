package com.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 이게 DispatchServlet 뷰(여기선 jsp)에 대한 설정 및 리소스에 대한 설정,
// 그리고 파일 업로드에 필요한 멀티파트에 대한 설정도 할 수 있어요.

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.board.controller", "com.board.config"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {


    // default tomcat의 servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
