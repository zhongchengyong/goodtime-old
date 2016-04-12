package com.mySSM.util;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by zhongcy on 2016/3/24.
 */
public class DESUtils {
    private static Logger logger= LoggerFactory.getLogger(DESUtils.class);
    private static Key key;
    private static String KEY_STR="mysql";
    static{
        try {
            KeyGenerator generator=KeyGenerator.getInstance("DES");
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key=generator.generateKey();
            generator=null;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    /**
     * º”√‹∑Ω∑®
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        logger.info("key------------------"+key.toString());

        try {
            byte[] strBytes=str.getBytes("UTF-8");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encryptStrBytes=cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  String getDecryptString(String str){
        BASE64Decoder base64Decoder=new BASE64Decoder();
        try {
            byte[] strByte=base64Decoder.decodeBuffer(str);
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] encryptStrBytes=cipher.doFinal(strByte);
            return new String(encryptStrBytes,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Test
    public void test(){
        System.out.println(getEncryptString("root"));
        System.out.println(getEncryptString(""));
    }
}
