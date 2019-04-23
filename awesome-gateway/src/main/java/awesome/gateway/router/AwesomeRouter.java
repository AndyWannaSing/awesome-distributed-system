package awesome.gateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由类
 *
 *
 * @author: Andy
 * @time: 2019/4/15 15:43
 * @since
 */
@Configuration
public class AwesomeRouter {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // 匹配的请求转发到 awesome-user-api 服务
                .route(p -> p
                        .path("/api/user/*")
                        .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
                        .uri("lb://awesome-user-api"))
                // 匹配的请求转发到 awesome-product-api 服务
                .route(p -> p
                        .path("/api/product/*")
                        .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
                        .uri("lb://awesome-product-api"))
                .build();

    }
}
