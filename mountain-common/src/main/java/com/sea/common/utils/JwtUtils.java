package com.sea.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@Data
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    // 签名私钥
    private String key;
    // 签名的失效时间
    private Long ttl;

    /**
     * 设置认证token
     */
    public String createJwt(String id, String name, Map<String, Object> map) {
        long now = System.currentTimeMillis();
        long exp = now + ttl;
        JwtBuilder jwtBuilder = Jwts.builder().setId("1").setSubject("张三")
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder.setClaims(map);
        jwtBuilder.setExpiration(new Date(exp));
        return jwtBuilder.compact();
    }

    /**
     * 解析token字符串获取clams
     */
    public Claims parseJwt(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}

