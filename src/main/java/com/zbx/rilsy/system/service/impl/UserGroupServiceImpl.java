package com.zbx.rilsy.system.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbx.rilsy.system.entity.po.UserGroupPo;
import com.zbx.rilsy.system.dao.UserGroupDao;
import com.zbx.rilsy.system.service.IUserGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户分组映射表 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupDao, UserGroupPo> implements IUserGroupService {

    @Override
    public Set<Long> getGroupIdsByUserId(Long userId) {
        List<UserGroupPo> list = this.list(new QueryWrapper<UserGroupPo>().eq("user_id", userId));
        return list.stream().map(UserGroupPo::getGroupId).collect(Collectors.toSet());
    }

}
