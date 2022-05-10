package com.disilab.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {
    public static String SECRET_KEY = "&E)H@McQfTjWnZq4";
    public static SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

    public static String enCode(String s) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(s.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        return encrypted;
    }

    public static String deCode(String s) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteDecrypted = cipher.doFinal(Base64.getDecoder().decode(s));
        String decrypted = new String(byteDecrypted);
        return decrypted;
    }

}
