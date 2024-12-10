package com.ccl.userboot.medicinestore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;

import java.util.List;

public interface UserService extends IService<User> {
    List<UserListRespDTO> getUserList(Integer size, Integer offset);
}
