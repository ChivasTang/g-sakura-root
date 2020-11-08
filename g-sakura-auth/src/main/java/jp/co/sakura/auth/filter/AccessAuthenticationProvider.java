package jp.co.sakura.auth.filter;

import jp.co.sakura.core.service.AuthUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("accessAuthenticationProvider")
public class AccessAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = authUserService.loadUserByUsername(username);

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
