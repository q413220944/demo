package com.djfy.demo.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author QuinPluto
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * Swagger2创建Docket的Bean
     *
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(Swagger2.basePackage("com.djfy.demo.api")).paths(PathSelectors.any()).build();
    }

    /**
     * Predicate that matches RequestHandler with given base package name for the class of the handler method.
     * This predicate includes all request handlers matching the provided basePackage
     *
     * @param basePackage - base package of the classes
     * @return this
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return new Predicate<RequestHandler>() {

            @Override
            public boolean apply(RequestHandler input) {
                return declaringClass(input).transform(handlerPackage(basePackage)).or(true);
            }
        };
    }

    /**
     * 处理包路径配置规则,支持多路径扫描匹配以逗号隔开
     *
     * @param basePackage 扫描包路径
     * @return Function
     */
    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return new Function<Class<?>, Boolean>() {

            @Override
            public Boolean apply(Class<?> input) {
                for (String strPackage : basePackage.split(",")) {
                    boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                    if (isMatch) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * @param input RequestHandler
     * @return Optional
     */
    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

    /**
     * Swagger2创建该Api的基本信息
     *
     * @return ApiInfo
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("demo项目API")
                .description("demo项目接口提供")
                .termsOfServiceUrl("http://localhost:21100/demo").version("1.0").build();
    }

}
