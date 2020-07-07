package com.hzm.springcloud;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/7 16:00
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)      // 选择swagger2版本
                .apiInfo(apiInfo())         //定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.hzm.springcloud.controller"))  // 指定生成api文档的包
                .paths(PathSelectors.any())     // 指定所有路径
                .build();
    }

    /**
     * 构建文档api信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("支付模块api文档")     // 文档标题
                .contact(new Contact("api文档", "url", "13242849755@163.com"))   //联系人信息
                .description("描述")      //描述
                .version("1.0")     //文档版本号
               //.termsOfServiceUrl("http://localhost:8080")     //网站地址
                .build();
    }

}
