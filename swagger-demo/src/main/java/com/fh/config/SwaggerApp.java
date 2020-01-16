package com.fh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApp {

   @Bean
   public Docket api() {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               // 自行修改为自己的包路径
               .apis(RequestHandlerSelectors.basePackage("com.fh.controller"))
               .paths(PathSelectors.any())
               .build();
   }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot使用swagger在线文档")
                .description("swagger UI接入教程")
                //服务条款网
                //.termsOfServiceUrl("我的博客地址，https://www.cnblogs.com/saoyou/")
                //版本号
                .version("1.0")
                    .contact(new Contact("翟浩浩", "https://www..baidu.com", "13269879116@163.com"))
                .build();
    }

}
