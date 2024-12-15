package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.Strategy.user.AuthenticationStrategy;
import com.ccl.userboot.medicinestore.Strategy.user.PasswordCorrectStrategy;
import com.ccl.userboot.medicinestore.Strategy.user.UserExistsStrategy;
import com.ccl.userboot.medicinestore.common.convention.enums.UserErrorCode;
import com.ccl.userboot.medicinestore.common.convention.exception.ClientException;
import com.ccl.userboot.medicinestore.dao.entity.User;
import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import com.ccl.userboot.medicinestore.dao.mapper.UserMapper;
import com.ccl.userboot.medicinestore.dto.req.UserLoginReqDTO;
import com.ccl.userboot.medicinestore.dto.req.UserRegisterReqDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserListRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserLoginRespDTO;
import com.ccl.userboot.medicinestore.dto.resp.UserRegisterRespDTO;
import com.ccl.userboot.medicinestore.service.UserService;

import com.ccl.userboot.medicinestore.utils.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static com.ccl.userboot.medicinestore.utils.ConstantUtils.USER_SESSION_NAME;

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
    public UserLoginRespDTO login(HttpServletResponse response, UserLoginReqDTO userLoginReqDTO) {
        // 返回对象
        UserLoginRespDTO responseDTO = new UserLoginRespDTO();

        // 根据邮箱查找用户
        User user = userMapper.findByEmail(userLoginReqDTO.getUserEmail());
        // 创建策略列表，将所有策略添加到列表中
        List<AuthenticationStrategy> strategies = new ArrayList<>();
        strategies.add(new UserExistsStrategy());
        strategies.add(new PasswordCorrectStrategy());
        //jwt加密逻辑
        String token = JwtUtils.createToken(userLoginReqDTO.getUserEmail());
        // 遍历策略列表，逐个执行策略的认证方法
        for (AuthenticationStrategy strategy : strategies) {
            if (!strategy.authenticate(user, userLoginReqDTO)) {
                UserLoginRespDTO userLoginRespDTO = new UserLoginRespDTO();
                userLoginRespDTO.setLoginStatus(strategy.getFailureMessage());
                userLoginRespDTO.setUserEmail(user.getUserEmail());
                userLoginRespDTO.setUserName(user.getUserName());
                userLoginRespDTO.setToken(null);
                return userLoginRespDTO;
            }
        }



        // 设置token到Cookie
        Cookie cookie = new Cookie(USER_SESSION_NAME, token);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        responseDTO.setToken(token);
        responseDTO.setUserName(user.getUserName());
        responseDTO.setUserEmail(user.getUserEmail());
        responseDTO.setLoginStatus("成功登录");
        return responseDTO;
    }

    @Override
    public UserRegisterRespDTO register(UserRegisterReqDTO userRegisterReqDTO) {
        val user = User.builder()
                .userName(userRegisterReqDTO.getUserName())
                .userPassword(userRegisterReqDTO.getUserPassword())
                .userEmail(userRegisterReqDTO.getUserEmail())
                .build();
        val insert = baseMapper.insert(user);
        if (insert>0){
            UserRegisterRespDTO userRegisterRespDTO = new UserRegisterRespDTO();
            userRegisterRespDTO.setUserEmail(user.getUserEmail());
            userRegisterRespDTO.setUserName(user.getUserName());
            //生成token
            val token = JwtUtils.createToken(user.getUserEmail());
            userRegisterRespDTO.setToken(token);
            return userRegisterRespDTO;
        }
        throw new ClientException(UserErrorCode.USER_SAVE_ERROR);
    }


}
