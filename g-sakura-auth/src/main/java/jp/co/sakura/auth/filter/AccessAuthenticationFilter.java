package jp.co.sakura.auth.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AccessAuthenticationManager accessAuthenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        super.setAuthenticationManager(accessAuthenticationManager);
        return super.attemptAuthentication(request, response);
    }

}
