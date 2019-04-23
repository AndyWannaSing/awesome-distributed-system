package awesome.user.server.service.impl;

import awesome.user.server.bean.User;
import awesome.user.server.dao.UserDao;
import awesome.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 用户服务实现类
 *
 * @author: Andy
 * @time: 2019/4/18 11:07
 * @since
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

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
    @Override
    public ResponseEntity<?> getUser(Integer id) {
        User user = userDao.getUserById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
