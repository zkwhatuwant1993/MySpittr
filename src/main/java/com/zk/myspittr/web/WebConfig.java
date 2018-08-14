package com.zk.myspittr.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.zk.myspittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

//    /**
//     * 配置视图解析器
//     *
//     * @return 视图解析器组件
//     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//        return resolver;
//    }

    /**
     * 配置未处理的请求(当DispatcherServlet映射到"/"时)静态资源的请求转发到默认的servlet来处理
     *
     * @param configurer 用于配置默认servlet的类
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /**
     * 该bean用于加载资源文件，并且bean的id必须为messageSource，然后可以使用spring jsp taglib中的message标签获取对应的属性值。
     * @return messageSource
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * 配置使用Apache Tiles需要的bean
     * @return TilesConfigurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layout/tiles.xml","/WEB-INF/views/**/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * 配置使用Apach tiles需要的视图解析器
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

}
