package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.entity.AuthUser;

public interface AuthUserDAO extends BaseMapper<AuthUser> {

    AuthUser selectByUsername(String username);

    AuthUser selectByUserId(Long userId);
}