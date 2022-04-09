package com.example.demo.mapper;

import com.example.demo.model.RoleModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-04-02
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleModel> {

    Set<String> findRoleNameByUserId(Long userId);
}

