package com.example.demo.service.impl;

import com.example.demo.model.RoleModel;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-04-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleModel> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> findRoleNameByUserId(Long userId) {
        return roleMapper.findRoleNameByUserId(userId);
    }
}
