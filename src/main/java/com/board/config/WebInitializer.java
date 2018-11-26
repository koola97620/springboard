package com.board.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// 초기화 클래스.
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 여기서 리턴된 @Configuration 클래스들은 ContextLoaderListener가 생성한
    // 애플리케이션 컨텍스트를 설정하는데 사용된다.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationConfig.class};
    }

    // 설정 클래스를 명시
    // 여기서 리턴된 @Configuration 클래스들은 DispatcherServlet의 애플리케이션 컨텍스트에
    // 대한 핀들을 정의한다.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcContextConfiguration.class};
    }

    // DispatcherServlet 을 /에 매핑.
    // 애플리케이션으로 들어오는 모든 요청을 처리한다.
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }


}
