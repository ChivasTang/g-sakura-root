package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.entity.UserInfo;

public interface UserInfoDAO extends BaseMapper<UserInfo> {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}