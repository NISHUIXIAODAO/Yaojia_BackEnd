package com.ccl.userboot.medicinestore.interceptors;

import com.ccl.userboot.medicinestore.common.convention.enums.UserErrorCode;
import com.ccl.userboot.medicinestore.common.convention.exception.ClientException;
import com.ccl.userboot.medicinestore.utils.JwtUtils;
import com.ccl.userboot.medicinestore.utils.UserUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserInterceptor implements HandlerInterceptor {
    private final UserUtils userUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取用户登录凭证
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("TOKEN".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    Claims claims;
                    String userEmail;// 获取用户email
                    String uri = request.getRequestURI();
                    log.info("访问uri => " + uri);
                    if (token != null && (claims = JwtUtils.parseJWT(token)) != null && (userEmail = JwtUtils.getUserName(claims)) != null) {
                        //获取用户id
                        val userId = userUtils.getUserId(token);
                        boolean exitUser = userUtils.existUser(userId);
                        if (!exitUser) {
                            log.error("不存在此用户");
                            throw new ClientException(UserErrorCode.USER_NULL);
                        }
                        log.info("放行用户{},访问接口{}", userId, uri);
                        return true;


                    }
                }

            }
        }
        return false;
    }
}
