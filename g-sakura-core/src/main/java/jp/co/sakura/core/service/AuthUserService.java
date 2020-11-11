package jp.co.sakura.core.service;

import jp.co.sakura.core.dao.AuthUserDAO;
import jp.co.sakura.core.domain.entity.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private AuthUserDAO authUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = findByUsername(username);
        if (authUser == null || !username.equals(authUser.getUsername())) {
            throw new UsernameNotFoundException("not found user :" + username);
        }
        return getUser(authUser);
    }

    private AuthUser findByUsername(String username) {
        return authUserDAO.selectByUsername(username);
    }

    public User getUser(AuthUser authUser) {
        return new User(authUser.getUsername(), authUser.getPassword(), authUser.getAuthorities());
    }

}
