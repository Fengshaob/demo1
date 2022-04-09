package com.example.demo.controller.user;


import com.example.demo.aspect.ExceptionHandler;
import com.example.demo.common.Response;
import com.example.demo.common.ResponseUtil;
import com.example.demo.model.UserInfoModel;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-25
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ExceptionHandler("查询用户")
    @GetMapping("/getById")
    @ResponseBody
    public Response<UserInfoModel> getById(@RequestParam Long userId) {
        UserInfoModel user = userInfoService.getById(userId);
        return ResponseUtil.success(user);
    }

}

