package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import com.ccl.userboot.medicinestore.dao.mapper.UserMapper;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserLoginRespDTO;
import com.ccl.userboot.medicinestore.service.AuthService;
import com.ccl.userboot.medicinestore.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {

    @Override
    public List<UserListRespDTO> getUserList(Integer size, Integer offset) {
        Page<User> page = new Page<>(offset, size);
        IPage<User> userPage = baseMapper.selectPage(page,
                new LambdaQueryWrapper<User>()
                        .eq(User::getUserStatus,UserStatus.active)
        );
        List<User> users = userPage.getRecords();
        return convertUserListToDtoList(users);
    }

    public List<UserListRespDTO> convertUserListToDtoList(List<User> users) {
        List<UserListRespDTO> dtoList = new ArrayList<>();
        for (User user : users) {
            UserListRespDTO dto = new UserListRespDTO();
            BeanUtil.copyProperties(user, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserLoginRespDTO login(String userEmail, String userPassage) {
        // 返回对象
        UserLoginRespDTO response = new UserLoginRespDTO();

        // 根据邮箱查找用户
        User user = userMapper.findByEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!user.getUserPassage().equals(userPassage)) {
            response.setLoginStatus("fail");
            return response;
        }
        response.setToken("true");
        response.setUserName(user.getUserName());
        response.setUserEmail(user.getUserEmail());
        response.setLoginStatus("success");
        return response;
    }
}
