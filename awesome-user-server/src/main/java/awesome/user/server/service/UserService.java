package awesome.user.server.service;

import awesome.user.server.bean.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    /**
     * 根据用户 ID 获取用户信息
     *
     *
     * @param id
     * @return: {@link ResponseEntity<User> }
     * @author: Andy
     * @time: 2019/4/18 11:08
     * @since
     */
    ResponseEntity<?> getUser(Integer id);
}
