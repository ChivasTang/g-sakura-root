package jp.co.sakura.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jp.co.sakura.core.domain.dto.AuthUser;

public interface AuthUserDAO extends BaseMapper<AuthUser> {
    AuthUser selectUserByUsername(String username);
    AuthUser selectUserByUserId(Long userId);
}
