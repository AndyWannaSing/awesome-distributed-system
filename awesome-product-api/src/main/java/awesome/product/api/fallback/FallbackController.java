package awesome.product.api.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务熔断类
 *
 *
 * @author: Andy
 * @time: 2019/4/15 15:46
 * @since
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public ResponseEntity<?> fallback() {
        return new ResponseEntity<>("Server 请求失败！", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
