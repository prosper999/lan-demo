package etg.lan.demo.config;

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
public class Swagger2Configuration {

    @Bean
    public Docket createBackendRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("前端服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("etg.lan.demo.frontendcontroller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createFrontendRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后端管理服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("etg.lan.demo.backendcontroller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Restful Api")
                .description("Restful api")
                .contact(new Contact("Wang Daojun","","wangdaojun@rfchina.com"))
                .version("1.0")
                .build();
    }
}
