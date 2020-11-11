package jp.co.sakura.auth.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class AccessAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService authUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token;
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails authUser=authUserService.loadUserByUsername(username);
        if (username.equals(authUser.getUsername()) && password.equals(authUser.getPassword())) {
            token = new UsernamePasswordAuthenticationToken(username, password, authUser.getAuthorities());
        } else {
            throw new BadCredentialsException("ユーザ名やパスワードが正しくない。");
        }

        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
