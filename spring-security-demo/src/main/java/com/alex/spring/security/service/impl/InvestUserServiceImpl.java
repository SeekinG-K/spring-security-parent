
package com.alex.spring.security.service.impl;

import com.alex.spring.security.dao.InvestUserDao;
import com.alex.spring.security.model.InvestUser;
import com.alex.spring.security.service.InvestUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
  * <pre>
  * @description: 业务类
  * @copyright: Copyright (c) 2020 迅策科技
  * @author: bo.yan    
  * @version: 1.0 
  * @date: 2020-11-21 
  * @time: 7:39:33
  * </pre>
  */  
@Service
@Transactional
public class InvestUserServiceImpl extends ServiceImpl<InvestUserDao, InvestUser> implements InvestUserService {
}