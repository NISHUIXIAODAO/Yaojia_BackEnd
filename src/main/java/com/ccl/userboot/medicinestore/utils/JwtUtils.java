package com.ccl.userboot.medicinestore.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class JwtUtils {

    private static final String KEY = "XGNBqTVwAvrmGEAGACOa1Lhkb8gXu3kTBcSUYkXupXRPt5MG5MB3RA06RoxxNAjy";
    public static final String USER_NAME_KEY = "username";

    /**
     * 创建JWT令牌
     *
     * @param username 用户名
     * @return 生成的JWT令牌
     */
    public static String createToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(USER_NAME_KEY, username);

        // 使用 Base64 编码密钥
        byte[] signingKey = Base64.getEncoder().encode(KEY.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000 * 7)) // 7天过期
                .signWith(SignatureAlgorithm.HS256, signingKey) // 使用字节数组作为密钥
                .compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param token JWT令牌
     * @return 解析后的Claims对象
     */
    public static Claims parseJWT(String token) {
        byte[] signingKey = Base64.getEncoder().encode(KEY.getBytes());

        return Jwts.parserBuilder() // 使用新版方法
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从Claims中获取用户名
     *
     * @param claims Claims对象
     * @return 用户名
     */
    public static String getUserName(Claims claims) {
        if (claims != null) {
            return (String) claims.get(USER_NAME_KEY);
        }
        return null;
    }

    /**
     * 验证JWT令牌
     *
     * @param token JWT令牌
     * @return 验证结果
     */
    public static boolean verifyToken(String token) {
        try {
            byte[] signingKey = Base64.getEncoder().encode(KEY.getBytes());

            Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            log.error("Token verification failed", e);
            return false;
        }
    }
}
