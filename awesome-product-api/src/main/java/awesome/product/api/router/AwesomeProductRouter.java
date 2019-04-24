package awesome.product.api.router;

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
public class AwesomeProductRouter {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // 匹配的请求转发到 awesome-elasticsearch-server 服务
                .route(p -> p
                        .path("/api/product/computers")
                        .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
                        .uri("lb://awesome-elasticsearch-server"))
                .build();

    }
}
