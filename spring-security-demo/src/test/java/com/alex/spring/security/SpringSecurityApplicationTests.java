package com.alex.spring.security;

import com.alex.spring.security.model.InvestUser;
import com.alex.spring.security.service.InvestUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private InvestUserService investUserService;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    void contextLoads() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("invest");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("211314");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }

}
