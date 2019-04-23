package awesome.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 *
 * @author: Andy
 * @time: 2019/4/15 15:39
 * @since
 */
@SpringBootApplication
@EnableFeignClients
public class AwesomeUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwesomeUserApiApplication.class, args);
    }

}
