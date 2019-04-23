package awesome.user.server.dao;

import awesome.user.server.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Andy
 * @time: 2019/4/18 14:22
 * @since
 */
@Mapper
public interface UserDao {
    User getUserById(Integer id);
}
