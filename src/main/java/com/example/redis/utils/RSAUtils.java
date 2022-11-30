package com.example.redis.utils;

import ch.qos.logback.core.encoder.EncoderBase;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class RSAUtils {

    //生成密鑰
    public void generateKey() throws NoSuchAlgorithmException {
        //指定演算法
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        //長度
        keyPairGenerator.initialize(2048);
        //製造
        KeyPair key =keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) key.getPrivate();// 私鑰
        RSAPublicKey publicKey=(RSAPublicKey) key.getPublic();//公鑰

    }

    //加密解密

}
