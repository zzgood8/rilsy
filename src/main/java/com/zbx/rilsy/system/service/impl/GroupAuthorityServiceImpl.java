package com.zbx.rilsy.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbx.rilsy.system.entity.po.GroupAuthorityPo;
import com.zbx.rilsy.system.dao.GroupAuthorityDao;
import com.zbx.rilsy.system.entity.po.UserGroupPo;
import com.zbx.rilsy.system.service.IGroupAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 分组权限映射表 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class GroupAuthorityServiceImpl extends ServiceImpl<GroupAuthorityDao, GroupAuthorityPo> implements IGroupAuthorityService {

    @Override
    public Set<Long> getAuthorityIdsByGroupIds(Set<Long> groupIds) {
        if (CollectionUtil.isEmpty(groupIds)) return groupIds;
        List<GroupAuthorityPo> list = this.list(new QueryWrapper<GroupAuthorityPo>().in("group_id", groupIds));
        if (CollectionUtil.isEmpty(list)) return new HashSet<>();
        return list.stream().map(GroupAuthorityPo::getAuthorityId).collect(Collectors.toSet());
    }
}
