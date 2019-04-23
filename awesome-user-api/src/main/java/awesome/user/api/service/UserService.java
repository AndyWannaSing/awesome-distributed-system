package awesome.user.api.service;

import awesome.user.api.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "awesome-user-server", fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 获取用户信息
     *
     *
     * @param id 用户ID
     * @return: {@link <User> }
     * @author: Andy
     * @time: 2019/4/16 22:02
     */
    @GetMapping("/api/user/{id}")
    ResponseEntity<?> getUser(@PathVariable("id") Integer id);
}
