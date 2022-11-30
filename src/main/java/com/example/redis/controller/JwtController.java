//package com.example.redis.controller;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.web.bind.annotation.RestController;
//import org.yaml.snakeyaml.scanner.Constant;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
// @RestController                                        //製造jwt參數有id subject ttlmills
//public class JwtController {
//    public String createJWT(String id, String subject, long ttlMillis) throws Exception {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定簽名的時候使用的簽名演算法，也就是header那部分，jjwt已經將這部分內容封裝好了。
//        long nowMillis = System.currentTimeMillis();//生成JWT的時間
//        Date now = new Date(nowMillis);
//        Map<String,Object> claims = new HashMap<String,Object>();//建立payload的私有宣告（根據特定的業務需要新增，如果要拿這個做驗證，一般是需要和jwt的接收方提前溝通好驗證方式的）
//        claims.put("uid", "DSSFAWDWADAS...");
//        claims.put("user_name", "admin");
//        claims.put("nick_name","DASDA121");
//        SecretKey key = generalKey();//生成簽名的時候使用的祕鑰secret,這個方法本地封裝了的，一般可以從本地配置檔案中讀取，切記這個祕鑰不能外露哦。它就是你服務端的私鑰，在任何場景都不應該流露出去。一旦客戶端得知這個secret, 那就意味著客戶端是可以自我簽發jwt了。
//        //下面就是在為payload新增各種標準宣告和私有聲明瞭
//        JwtBuilder builder = Jwts.builder() //這裡其實就是new一個JwtBuilder，設定jwt的body
//                .setClaims(claims)          //如果有私有宣告，一定要先設定這個自己建立的私有的宣告，這個是給builder的claim賦值，一旦寫在標準的宣告賦值之後，就是覆蓋了那些標準的宣告的
//                .setId(id)                  //設定jti(JWT ID)：是JWT的唯一標識，根據業務需要，這個可以設定為一個不重複的值，主要用來作為一次性token,從而回避重放攻擊。
//                .setIssuedAt(now)           //iat: jwt的簽發時間
//                .setSubject(subject)        //sub(Subject)：代表這個JWT的主體，即它的所有人，這個是一個json格式的字串，可以存放什麼userid，roldid之類的，作為什麼使用者的唯一標誌。
//                .signWith(signatureAlgorithm, key);//設定簽名使用的簽名演算法和簽名使用的祕鑰
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);     //設定過期時間
//        }
//        return builder.compact();           //就開始壓縮為xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx這樣的jwt
//        //列印了一哈哈確實是下面的這個樣子
//        //eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiIiLCJ1c2VyX25hbWUiOiJhZG1pbiIsIm5pY2tfbmFtZSI6IkRBU0RBMTIxIiwiZXhwIjoxNTE3ODI4MDE4LCJpYXQiOjE1MTc4Mjc5NTgsImp0aSI6Imp3dCJ9.xjIvBbdPbEMBMurmwW6IzBkS3MPwicbqQa2Y5hjHSyo
//    }
//     public Claims parseJWT(String jwt) throws Exception{
//         SecretKey key = generalKey();  //簽名祕鑰，和生成的簽名的祕鑰一模一樣
//         Claims claims = Jwts.parser()  //得到DefaultJwtParser
//                 .setSigningKey(key)         //設定簽名的祕鑰
//                 .parseClaimsJws(jwt).getBody();//設定需要解析的jwt
//         return claims;
//     }
//     private SecretKey generalKey() {
//         String stringKey = Constant.JWT_SECRET;//本地配置檔案中加密的密文7786df7fc3a34e26a61c034d5ec8245d
//         byte[] encodedKey = Base64.decodeBase64(stringKey);//本地的密碼解碼[B@152f6e2
//         System.out.println(encodedKey);//[B@152f6e2
//         System.out.println(Base64.encodeBase64URLSafeString(encodedKey));//7786df7fc3a34e26a61c034d5ec8245d
//         SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// 根據給定的位元組陣列使用AES加密演算法構造一個金鑰，使用 encodedKey中的始於且包含 0 到前 leng 個位元組這是當然是所有。（後面的文章中馬上回推出講解Java加密和解密的一些演算法）
//         return key;
//     }
//
//     //主程式
//
//                                             // .
//                                         }
