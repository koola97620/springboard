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
    // '/' 요청은 모든 요청을 말합니다. 이 요청은 원래 WAS 의 Default Servlet 가 처리해줍니다.
    // '/' url을 처리하는 새 서블릿을 만들었는데, 만약 새 서블릿이 요청을 처리하지 못하면,
    // 디폴트 서블릿이 처리하게끔 넘겨줍니다.
    // 누가? DispatcherServlet이.
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
