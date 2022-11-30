package com.example.redis.utils;

import com.example.redis.bean.AddDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
@Data
@Component
public class JwtUtils {
    private static final String TOKEN_SECRET = "cuAihCz53DZRjSwabsGcZJ2Ai6At+T142updateJMsk7iQ=";
    private static final long EXPIRE_TIME = 15 * 60 * 1000; //過期時間，15分鐘
    /**
     * 生成jws
     * @param subject 使用者資訊，EX:可以放使用者物件
     */
    public static String creatJWT(AddDto subject,Long mills){
        SignatureAlgorithm  signatureAlgorithm= SignatureAlgorithm.HS256;//演算法
        long nowMillis = System.currentTimeMillis(); //.currentTimeMillis() 方法返回當前時間(毫秒)
        Date now=new Date(nowMillis); //如果傳進的預設時間為null，預設過期時間設為15分鐘
        //過期時間點＝目前時間＋過期時間
        Date expDate = new Date(nowMillis); //將時間轉換成Date物件
        Key secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(subject.getAccount()) //JWT的身分標示
                .setSubject(subject.getPassword())//主題可以是json數據
                .setIssuer("howard") //簽發者
                .setIssuedAt(now) //簽發時間
                .signWith(signatureAlgorithm,secretKey)
                .setExpiration(expDate);//設置過期時間
        if (mills >= 0) {
            long expMillis = nowMillis + mills;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //設定過期時間
        }
        return builder.compact();
    }

    /**
     * 生成金鑰
     */
    private static Key generalKey() {
        byte[] encodeKey =  Base64.decodeBase64(JwtUtils.TOKEN_SECRET);
        // 根據給定的位元組陣列使用AES加密演算法構造一個金鑰，使用 encodedKey中的始於且包含 0 到前 leng 個位元組這是當然是所有。
        return new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");

    }

    public static Claims parseJWT(String jwt) {
        Key secretKey = generalKey(); //簽名祕鑰，和生成的簽名的祕鑰一模一樣
        return Jwts
                .parser()
                .setSigningKey(secretKey) //設定簽名的祕鑰
                .parseClaimsJws(jwt).getBody(); //設定需要解析的jwt
    }


}
