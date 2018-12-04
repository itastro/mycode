package cn.shengrui.common.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * @ClassName MD5Util
 * @Description TODO
 * @Date 2018/10/6 22:06
 * @Author itastro
 * @Version 1.0
 **/
public class MD5Util {

    private final static Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

    public final static String encrypt(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOGGER.error("generate md5 error, {}", s, e);
            return null;
        }
    }

    public static void main(String[] args) {
        String password = MD5Util.encrypt("123456");
        System.out.print(password);
    }
}
