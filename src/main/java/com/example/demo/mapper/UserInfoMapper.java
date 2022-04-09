package com.example.demo.mapper;

import com.example.demo.model.UserInfoModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author 冯邵兵
 * @since 2022-03-25
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoModel> {

    Set<String> findPermissionsByUserId(Long userId);
}

