package org.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.model.user.User;
import org.example.model.user.UserManager;

import java.util.Date;

/**
 * Jwt工具类
 * 注意点:
 * 1、生成的token, 是可以通过base64进行解密出明文信息
 * 2、base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3、无法作废已颁布的token，除非改秘钥
 */
public class JWTUtils {


    /**
     * 过期时间，一周
     */
    private  static final long EXPIRE = 60000 * 60 * 24 * 7;
    //private  static final long EXPIRE = 1;


    /**
     * 加密秘钥
     */
    private  static final String SECRET = "jd.jd";


    /**
     * 令牌前缀
     */
    private  static final String TOKEN_PREFIX = "jd";


    /**
     * subject
     */
    private  static final String SUBJECT = "gaiji";


    /**
     * 根据用户信息，生成令牌
     * @param user
     * @return
     */
    public static String geneUserToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("account",user.account)
                .claim("id",user.id)
                .claim("deviceFingerprint",user.deviceFingerprint)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;


        return token;
    }
    public static String geneUserManagerToken(UserManager user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("account",user.account)
                .claim("id",user.id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }


    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            return Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
        }catch (Exception e){
            return null;
        }
    }



}
