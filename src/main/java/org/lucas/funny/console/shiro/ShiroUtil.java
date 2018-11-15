package org.lucas.funny.console.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;


/**
 * 加密工具
 */
public class ShiroUtil {


    /**
     * 获取加密盐
     *
     * @return 自动生成的盐
     */
    public static String getSalt(String args) {
        return DigestUtils.md5Hex(args);
    }

    /**
     * 通过加密盐加密后的字符串
     *
     * @param salt      盐
     * @param keyBytes 未加密的字符串
     * @return 加密后的字符串
     */
    public static String getMd5String(String salt, String keyBytes) {
        return Md5Crypt.apr1Crypt(keyBytes, salt);
    }
}
