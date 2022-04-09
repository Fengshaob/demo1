package com.example.demo.service;

import com.example.demo.model.RoleModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-04-02
 */
public interface RoleService extends IService<RoleModel> {

    Set<String> findRoleNameByUserId(Long userId);
}
