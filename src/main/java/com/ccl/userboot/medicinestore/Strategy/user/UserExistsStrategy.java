package com.ccl.userboot.medicinestore.Strategy.user;

import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;

public class UserExistsStrategy implements AuthenticationStrategy{
    @Override
    public boolean authenticate(User user, UserLoginReqDTO userLoginReqDTO) {
        return user != null; // 用户不为空表示存在
    }

    @Override
    public String getFailureMessage() {
        return "用户不存在！";
    }
}
