package cn.shengrui.common.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {


    /**
     * 把string  字符串转化成List<Integer>
     *
     * @param str
     * @return
     */


    public static List<Integer> splitToListInt(String str) {
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        //JDK1.8的流遍历方式
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }

    /**
     * 获取文件的绝对路径
     *
     * @param url
     * @return
     */
    public static String getFilePath(String url) {
        String target = "";
        //匹配协议 主机名 端口的正则
        String reg = "((http|ftp|https)://)(([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(:[0-9]{1,4})*";
        target = url.replaceAll(reg, "");
        return target;
    }
}
