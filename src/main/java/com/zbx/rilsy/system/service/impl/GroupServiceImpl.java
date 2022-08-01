package com.zbx.rilsy.system.service.impl;

import com.zbx.rilsy.system.entity.po.GroupPo;
import com.zbx.rilsy.system.dao.GroupDao;
import com.zbx.rilsy.system.service.IGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户分组表 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupPo> implements IGroupService {

}
