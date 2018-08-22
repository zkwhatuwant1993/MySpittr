package com.zk.myspittr.config;

import com.zk.myspittr.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        //将一个或者多个url路径mapping到DispatcherServlet
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        String location = System.getProperty("user.dir") + ""
        registration.setMultipartConfig(new MultipartConfigElement("F:\\tmp\\spitter\\uploads",2097152, 4194304,0));
    }
}
