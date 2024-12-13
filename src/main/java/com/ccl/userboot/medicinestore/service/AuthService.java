package com.ccl.userboot.medicinestore.service;

import com.ccl.userboot.medicinestore.dao.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    // 密钥，可以通过配置文件或者环境变量获取，确保其安全
    private static final String SECRET_KEY = "your_secret_key";

    public String generateToken(User user) {
        // 获取当前时间
        long now = System.currentTimeMillis();

        // 设置 token 有效期为 1 小时（可以根据需要调整）
        long expirationTime = 3600000; // 1小时 = 3600000毫秒

        // 生成 JWT Token
        return Jwts.builder()
                .setSubject(user.getUserEmail()) // 用户标识，例如使用用户名或用户 ID
                .setIssuedAt(new Date(now)) // 设置签发时间
                .setExpiration(new Date(now + expirationTime)) // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用 HMAC SHA-256 算法签名
                .compact();
    }
}
