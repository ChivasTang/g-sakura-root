package jp.co.sakura.core.service;

import jp.co.sakura.core.dao.AuthUserDAO;
import jp.co.sakura.core.domain.dto.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AuthUserService implements UserDetailsService {

    @Resource
    private AuthUserDAO authUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserDAO.selectUserByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException(username + " not be found...");
        }
        return getUser(authUser);
    }

    public User getUser(AuthUser authUser) {
        log.debug("User is: {}", authUser.toString());
        return new User(authUser.getUsername(),
                authUser.getPassword(),
                authUser.isEnabled(),
                authUser.isAccountNonExpired(),
                authUser.isCredentialsNonExpired(),
                authUser.isAccountNonLocked(),
                authUser.getAuthorities()
        );
    }
}
