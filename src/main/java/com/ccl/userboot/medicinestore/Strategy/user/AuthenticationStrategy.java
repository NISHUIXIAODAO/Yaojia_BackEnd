package com.ccl.userboot.medicinestore.Strategy.user;


import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;

/**
 * 认证策略接口
 * 定义认证方法和获取失败消息的方法
 */
public interface AuthenticationStrategy {
    /**
     * 认证方法
     * @param user 用户对象
     * @param userLoginReqDTO 登录请求对象
     * @return 认证是否通过
     */
    boolean authenticate(User user,  UserLoginReqDTO userLoginReqDTO);

    /**
     * 获取认证失败消息
     * @return 失败消息字符串
     */
    String getFailureMessage();
}