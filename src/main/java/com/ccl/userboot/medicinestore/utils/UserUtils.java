package com.ccl.userboot.medicinestore.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dao.mapper.UserMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {
    @Autowired
    private UserMapper userMapper;

    public Integer getUserId(String token){
        //解密token获取userEmail
        val claims = JwtUtils.parseJWT(token);
        val userEmail = JwtUtils.getUserName(claims);
        //根据userEmail查询userId
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        val userQueryWrapper = queryWrapper.select("user_id").eq("user_email", userEmail);
        return userMapper.selectOne(userQueryWrapper).getUserId();

    }

    public boolean existUser(Integer userId){
        //根据用户ID查用户是否存在
        return userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getUserId, userId)
        )!=null;
    }
}
