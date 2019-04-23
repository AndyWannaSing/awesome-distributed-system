package awesome.user.api.fallback;

import awesome.user.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * user 服务降级类
 *
 * @author: Andy
 * @time: 2019/4/16 21:47
 * @since
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public ResponseEntity<?> getUser(Integer id) {
        return new ResponseEntity<>("Server 请求失败！" ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
