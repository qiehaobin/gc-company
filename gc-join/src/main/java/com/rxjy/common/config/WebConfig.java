package com.rxjy.common.config;

import com.rxjy.modules.sys.interceptor.LoginUserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * WebMvc配置
 *
 * @author kami
 * @email zhangqm@rxjy.com
 * @date 2018-05-17 15:53:56
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("/app/**").addResourceLocations("classpath:/app/");
    }

//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
//
//        //生成json时，将所有Long转换成String
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        objectMapper.registerModule(simpleModule);
//
//        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        converters.add(0, jackson2HttpMessageConverter);
//    }

	/**
	 * 自定义拦截器
	 *
	 *
	 * @remake By kami
	 *
	 * 需要放行地址备注：
	 * swagger、wps(登陆和退出)
	 * shiro已经过滤的防止多次重定向
	 * 对外暴露的api地址
	 *
	 * @author kami
	 * @email zhangqm@rxjy.com
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePatterns = new ArrayList<>();
        //swagger接口
        excludePatterns.add("/swagger/**");
        excludePatterns.add("/v2/api-docs");
        excludePatterns.add("/swagger-ui.html");
        excludePatterns.add("/swagger-resources/**");
        excludePatterns.add("/webjars/**");
        //登陸
        excludePatterns.add("/wps/**");
        excludePatterns.add("/train/**");
        excludePatterns.add("/error/**");
        excludePatterns.add("/air/**");


        //去除shiro拦截
        excludePatterns.add("/manager/**");
        excludePatterns.add("/statics/**");
        //api拦截
        excludePatterns.add("/api1/**");
        excludePatterns.add("/api2/**");
        excludePatterns.add("/library/**"); // 库板块
        excludePatterns.add("/recruit/postStandard/**");
        excludePatterns.add("/innerUser/**");
        excludePatterns.add("/review/**");
        excludePatterns.add("/person/**"); // 函用户 （一）
        excludePatterns.add("/letter/**"); // 函用户 （二）
        excludePatterns.add("/kshop/**"); // 函用户 （二）

        //班 模板
        excludePatterns.add("/classtemplate/**");
        //新闻推送
        excludePatterns.add("/app/**");

        registry.addInterceptor(new LoginUserInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePatterns);
    }

    /**
     *  跨域 配置
     * @return
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");

        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}
