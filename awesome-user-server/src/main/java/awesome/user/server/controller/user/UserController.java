package awesome.user.server.controller.user;

import awesome.user.server.bean.User;
import awesome.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author: Andy
 * @time: 2019/4/16 21:36
 * @since
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     *
     *
     * @param id 用户ID
     * @return: {@link ResponseEntity<User> }
     * @author: Andy
     * @time: 2019/4/16 22:02
     */
    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
        try {
            ResponseEntity<?> responseEntity = userService.getUser(id);
            if(responseEntity.getStatusCode() == HttpStatus.OK){
                return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
            }
            return new ResponseEntity<>("请求失败！", responseEntity.getStatusCode());
        }catch (Exception e){
            //todo: do something
            return new ResponseEntity<>("请求失败！", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
