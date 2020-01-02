package com.xy.door.configuration;

import com.xy.door.listener.UserListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiayun
 * @version V1.0.0
 * @description WebConfiguration
 * @date   2019/12/24 15:05
 */
// @Configuration
public class WebConfiguration {

    //    @Bean
//    public ServletRegistrationBean indexServletRegistration() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new IndexServlet());
//        registration.addUrlMappings("/hello");
//        return registration;
//    }

    @Bean
    public FilterRegistrationBean indexFilterRegistration() {

        //配置无需过滤的路径或者静态资源，如：css，imgage等
        StringBuffer excludedUriStr = new StringBuffer();
        excludedUriStr.append("/door/login");
        excludedUriStr.append(",");
        excludedUriStr.append("/door/index");
        excludedUriStr.append(",");
        excludedUriStr.append("/static/*");
        excludedUriStr.append(",");
        excludedUriStr.append("/favicon.ico");
        excludedUriStr.append(",");
        excludedUriStr.append("/js/*");

        FilterRegistrationBean registration = new FilterRegistrationBean(new UserListener());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("excludedUri", excludedUriStr.toString());
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

//    @Bean
//    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
//        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
//        servletListenerRegistrationBean.setListener(new IndexListener());
//        return servletListenerRegistrationBean;
//    }
}
