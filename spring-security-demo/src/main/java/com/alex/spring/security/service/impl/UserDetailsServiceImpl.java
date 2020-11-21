package com.alex.spring.security.service.impl;

import com.alex.spring.security.model.InvestUser;
import com.alex.spring.security.service.InvestUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 登录时校验用户名和密码
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private InvestUserService investUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Wrapper<InvestUser> wrapper = new EntityWrapper<>();
        wrapper.eq("name", s);
        InvestUser investUser = investUserService.selectOne(wrapper);
        if (Objects.isNull(investUser))
            throw new UsernameNotFoundException("用户不存在");
        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_sale,ROLE_manager");
        return new User(investUser.getName(),new BCryptPasswordEncoder().encode(investUser.getPassword()), grantedAuthorityList);
    }
}
