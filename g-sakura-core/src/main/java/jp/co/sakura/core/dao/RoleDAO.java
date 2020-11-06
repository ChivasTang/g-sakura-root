package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.entity.Role;

public interface RoleDAO extends BaseMapper<Role> {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}