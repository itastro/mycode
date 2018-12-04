package cn.shengrui.common.util;

/**
 * @ClassName Test
 * @Description TODO
 * @Date 2018/10/17 10:55
 * @Author itastro
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String ha="ftp://192.168.153.128/shengrui/tcufile/idea使用教程2017-06-01.pdf";
        String re = "";
        re = "((http|ftp|https)://)(([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}))(:[0-9]{1,4})*";

        String c = ha.replaceAll(re, "");
        System.out.print(c);
    }
}
