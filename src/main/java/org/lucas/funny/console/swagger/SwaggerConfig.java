package org.lucas.funny.console.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())// controller路径。
                .paths(PathSelectors.any())
                .build();
    }

    // 配置 API 文档标题、描述、作者等等相关信息。
    private ApiInfo createApiInfo(){
        return new ApiInfoBuilder()
                .title("前后端分离系统API接口文档")
                .termsOfServiceUrl("")
                .description("Spring MVC中使用Swagger2构建Restful API")
                .contact(new Contact("lucas","","zhangliuhui8952@126.com"))
                .version("1.0")
                .build();
    }
}
