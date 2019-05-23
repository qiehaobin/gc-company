/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.rxjy.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Swagger配置
 *
 * @author kami
 * @email zhangqm@rxjy.com
 * @date 2018-05-17 15:53:56
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})//在生产环境不开启
public class SwaggerConfig{

    @Bean
    public Docket createApiApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API接口文档")
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.rxjy.modules"))
                .paths(PathSelectors.any())
                .build();
    }


    /*@Bean
    public Docket createSysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("first-Api接口文档")
            .apiInfo(apiInfo1())
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .apis(RequestHandlerSelectors.basePackage("com.rxjy.modules.api1"))
            .paths(PathSelectors.any())
            .build();
    }*/

    /*@Bean
    public Docket createIvtApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("second-Api2接口文档")
                .apiInfo(apiInfo2())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.rxjy.modules.api2"))
                .paths(PathSelectors.any())
                .build();
    }*/

    /*@Bean
    public Docket createTrainApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("内部人事 培")
                .apiInfo(apiInfo2())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.rxjy.modules.train"))
                .paths(PathSelectors.any())
                .build();
    }*/


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("工程-人事平台")
            .description("工程-人事平台-api文档")
            .termsOfServiceUrl("http://www.rxjy.com")
            .version("1.0.1")
            .build();
    }

    /*private ApiInfo apiInfo1() {
        return new ApiInfoBuilder()
                .title("api-first")
                .description("first-api1文档")
                .termsOfServiceUrl("http://a.rx")
                .version("1.0.1")
                .build();
    }*/

    /*private ApiInfo apiInfo2() {
        return new ApiInfoBuilder()
                .title("api-second")
                .description("second-api2文档")
                .termsOfServiceUrl("http://a.rx")
                .version("1.0.1")
                .build();
    }*/

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("token", "token", "header")
        );
    }

}