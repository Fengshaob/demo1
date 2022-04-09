package com.example.demo.service;

import com.example.demo.model.UserInfoModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-25
 */
public interface UserInfoService extends IService<UserInfoModel> {

    Set<String> findPermissionsByUserId(Long userId);
}
