package com.example.administrator.demo.util;

import android.util.Base64;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author TangLongHui
 * @data created on 2019/3/13.
 * @describe TODO 扫一扫工具类
 */

public class ScanUtils {
    private static final String DEFAULT_KEY = "";



    /**
     * @Description: TODO
     * @param: tag 标识
     * @param: scanStr 扫码解析出来的字符串
     * @param: decrypt 是否解密
     * @param: decryptKey 秘钥
     * @param: listener 回调
     */
    public static void analysis(String tag, String scanStr, boolean decrypt, String decryptKey, onCallbackListener listener){
        String str="";
        if (decrypt){
            if (null!=decryptKey){
                str=decryptDES(scanStr,decryptKey);
            }else {
                str=decryptDES(scanStr);
            }
            if (null ==str){
                listener.onFailed("解密失败");
                return;
            }
        }else {
            str=scanStr;
        }
        String[] strings=str.split("\\.|:|-");
        if (!strings[0].equals("")){
            listener.onFailed("非本应用支持的学校标识");
            return;
        }
        if (tag.equals("")|| null==tag){
            listener.onSuccess(strings);
            return;
        }
        if (tag.equals("")){
            if (strings[1].equals("")){
                listener.onFailed("不支持该二维码");
            }else {
                listener.onSuccess(strings);
            }
            return;
        }
        if (strings[1].equals(tag)){
            listener.onSuccess(strings);
        }
    }
    /**
     * @author TangLongHui
     * @data created on 2019/7/2
     * @describe TODO 需要解密使用自定义秘钥
     */
    public static void analysis(String tag, String scanStr, String decryptKey, onCallbackListener listener){
       analysis(tag,scanStr,true,decryptKey,listener);
    }
    /**
     * @author TangLongHui
     * @data created on 2019/7/2
     * @describe TODO true 默认解密 false 不解密
     */
    public static void analysis(String tag, String scanStr, boolean isdefaultDecrypt, onCallbackListener listener){
        if (isdefaultDecrypt){
            analysis(tag,scanStr,true,DEFAULT_KEY,listener);

        }else {
            analysis(tag,scanStr,false,null,listener);
        }
    }
    /**
     * @author TangLongHui
     * @data created on 2019/7/2
     * @describe TODO 不解密
     */
    public static void analysis(String tag, String scanStr, onCallbackListener listener){
        analysis(tag,scanStr,false,null,listener);
    }
    /**
     * 解密的过程与加密的过程大致相同
     *
     * @param decryptString 密文
     * @param decryptKey    密钥
     * @return 返回明文
     */
    public static String decryptDES(String decryptString, String decryptKey){
        try {
            //先使用Base64解密
            byte[]byteMi= Base64.decode(decryptString,0);
            //实例化SecretKeySpec，根据传入的密钥获得字节数组来构造SecretKeySpec,
            Key key= null;
            try {
                key = getRawKey(decryptKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //创建密码器
            Cipher cipher= Cipher.getInstance("DES");
            //用密钥初始化Cipher对象,上面是加密，这是解密模式
            cipher.init(Cipher.DECRYPT_MODE,key);
            //获取解密后的数据
            byte [] decryptedData=cipher.doFinal(byteMi);
            return new String(decryptedData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String decryptDES(String decryptString){
        return decryptDES(decryptString,DEFAULT_KEY);
    }
    /**
     * @author TangLongHui
     * @data created on 2019/7/2
     * @describe TODO 获得 key
     */
    private static Key getRawKey(String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(Base64.decode(key.getBytes(),0));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(dks);
    }
    public interface onCallbackListener{
        void onSuccess(String[] results);
        void onFailed(String msg);
    }

}
