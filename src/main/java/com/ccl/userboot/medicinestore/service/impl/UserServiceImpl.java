package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import com.ccl.userboot.medicinestore.dao.mapper.UserMapper;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
