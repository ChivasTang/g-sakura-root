package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.entity.User;

public interface UserDAO extends BaseMapper<User> {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}