package com.sea.ums.controller;

import com.sea.common.entity.Result;
import com.sea.common.entity.ResultCode;
import com.sea.common.exception.CommonException;
import com.sea.common.utils.JwtUtils;
import com.sea.ums.domain.User;
import com.sea.ums.service.UserService;
import com.sea.ums.vo.ProfileResult;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/queryUserById")
    public Result queryUserById(@RequestParam String id) {
        User user = userService.queryUserById(id);
        Result result = Result.SUCCESS();
        result.setData(user);
        return result;
    }

    /**
     * 登录，并返回token
     * @param paramMap Map
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> paramMap) {
        String mobile = paramMap.get("mobile");
        String password = paramMap.get("password");

        User user = userService.queryUserByMobile(mobile);
        // 用户名或密码错误
        if(user == null || !user.getPassword().equals(password)) {
            return new Result(ResultCode.MOBILEORPASSWORD_ERROR);
        }
        // 返回token
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        String token = jwtUtils.createJwt(user.getId(), user.getUsername(), map);
        return new Result(ResultCode.SUCCESS, token);
    }

    /**
     * 用户登录成功之后，获取用户信息
     * @return Result
     */
    @PostMapping("/profile")
    public Result profile(HttpServletRequest request) {
        String accessToken = request.getHeader("access_token");
        if(StringUtils.isEmpty(accessToken)) {
            throw new CommonException(ResultCode.UNAUTHENTICATED);
        }
        Claims claims = jwtUtils.parseJwt(accessToken);
        String userId = claims.getId();
        // 查询权限
        User user = userService.queryUserById(userId);
        ProfileResult profileResult = new ProfileResult(user);
        return new Result(ResultCode.SUCCESS, profileResult);
    }
}
