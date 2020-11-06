package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.entity.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDAO extends BaseMapper<UserRole> {
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);
}