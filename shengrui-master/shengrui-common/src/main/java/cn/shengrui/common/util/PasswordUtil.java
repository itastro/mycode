package cn.shengrui.common.util;


import java.util.Date;
import java.util.Random;

/**
 * 
    * @ClassName: PasswordUtil
    * @Description: 密码工具类
    * @author itastro
    * @date 2018年10月3日
    *
 */
public class PasswordUtil {

	//字母
    public final static String[] word = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "j", "k", "m", "n",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "J", "K", "M", "N",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };
  //数字
    public final static String[] num = {
            "2", "3", "4", "5", "6", "7", "8", "9"
    };
  //随机生成密码
    public static String randomPassword() {
    	//定义buffer
        StringBuffer stringBuffer = new StringBuffer();
        //定义random
        Random random = new Random(new Date().getTime());
        boolean flag = false;
        int length = random.nextInt(3) + 8;
        for (int i = 0; i < length; i++) {
        	
           //为true时随机出来一个字符
        	//为false 时随机出来一个数字
            if (flag) {
                stringBuffer.append(num[random.nextInt(num.length)]);
            } else {
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag = !flag;
        }
        //返回密码的字符串
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
    }
}
