package com.zbx.rilsy.system.service.impl;

import com.zbx.rilsy.system.entity.po.UserPo;
import com.zbx.rilsy.system.dao.UserDao;
import com.zbx.rilsy.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserPo> implements IUserService {

}
