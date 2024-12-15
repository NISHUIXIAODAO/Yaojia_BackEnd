package com.ccl.userboot.medicinestore.Strategy.user;

import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;

public class PasswordCorrectStrategy implements AuthenticationStrategy{
    @Override
    public boolean authenticate(User user, UserLoginReqDTO userLoginReqDTO) {
        //判断密码是否正确
        return user.getUserPassword().equals(userLoginReqDTO.getUserPassword()); // 密码是否匹配
    }

    @Override
    public String getFailureMessage() {
        return "密码错误！";
    }
}
