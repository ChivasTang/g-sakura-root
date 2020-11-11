package jp.co.sakura.core.dao;

import jp.co.sakura.app.AppBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AppBoot.class})
public class AuthUserServiceTest {

    private static final String USERNAME_BOSS = "boss";
    private static final Long USER_ID_BOSS = 2L;

    @Resource
    private UserDetailsService authUserService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

//    @Test
//    public void selectByUsername() throws JsonProcessingException {
//        AuthUser authUser = authUserDAO.selectByUsername(USERNAME_BOSS);
//        Assert.assertEquals(authUser.getUsername(), USERNAME_BOSS);
//        Assert.assertEquals(passwordEncoder.encode("123"), authUser.getPassword());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(authUser));
//    }
//
//    @Test
//    public void selectByUserId() throws JsonProcessingException {
//        AuthUser authUser = authUserDAO.selectByUserId(USER_ID_BOSS);
//        Assert.assertEquals(authUser.getUserId(), USER_ID_BOSS);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(authUser.getPassword());
//        System.out.println(objectMapper.writeValueAsString(authUser));
//    }


//    @Test
//    public void loadUserByUsername(){
//        User user= (User)authUserService.loadUserByUsername(USERNAME_BOSS);
//        System.out.println(user.toString());
//    }
}