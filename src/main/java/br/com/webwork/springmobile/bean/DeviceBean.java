package br.com.webwork.springmobile.bean;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@SuppressWarnings("deprecation")
public class DeviceBean extends WebMvcConfigurerAdapter{
	
	@Bean
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
		return new DeviceResolverHandlerInterceptor();
	}
	
	@Bean
	public DeviceHandlerMethodArgumentResolver  deviceHandlerMethodArgumentResolver() {
		return new DeviceHandlerMethodArgumentResolver();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(deviceResolverHandlerInterceptor());
	    registry.addInterceptor(sitePreferenceHandlerInterceptor());
	}
	
	@Bean
	public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
	    return new SitePreferenceHandlerInterceptor();
	}
	
	@Bean
	public SitePreferenceHandlerMethodArgumentResolver sitePreferenceHandlerMethodArgumentResolver() {
	    return new SitePreferenceHandlerMethodArgumentResolver();
	}
	
	public void addArgumentResolvers(
	        List<HandlerMethodArgumentResolver> argumentResolvers) {
	    argumentResolvers.add(deviceHandlerMethodArgumentResolver());
	}
}
