package jp.co.sakura.core.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.co.sakura.app.AppBoot;
import jp.co.sakura.core.domain.dto.AuthUser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {AppBoot.class})
public class AuthUserDAOTest {

    private static final String USERNAME_BOSS = "boss";
    private static final Long USER_ID_BOSS = 2L;

    @Resource
    private AuthUserDAO authUserDAO;

    @Test
    public void selectUserByUsername() throws JsonProcessingException {
        AuthUser authUser = authUserDAO.selectUserByUsername(USERNAME_BOSS);
        Assert.assertEquals(authUser.getUsername(), USERNAME_BOSS);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(authUser.getPassword());
        System.out.println(objectMapper.writeValueAsString(authUser));
    }

    @Test
    public void selectUserByUserId() throws JsonProcessingException {
        AuthUser authUser = authUserDAO.selectUserByUserId(USER_ID_BOSS);
        Assert.assertEquals(authUser.getUserId(), USER_ID_BOSS);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(authUser.getPassword());
        System.out.println(objectMapper.writeValueAsString(authUser));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}