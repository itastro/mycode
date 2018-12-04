package cn.shengrui.common.propertites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName propertites
 * @Description TODO
 * @Date 2018/11/12 10:40
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "ftp")
@Component
public class FtpPertites {

    /**
     * FTP地址
     **/
    private String address;

    /**
     * FTP端口
     **/
    private int port;

    /**
     * FTP用户名
     **/
    private String ftpUsername;

    /**
     * FTP密码
     **/
    private String ftpPassword;

    /**
     * FTP基础目录
     **/
    private String basePath;

    /**
     * tcu目录
     */
    private String tcuPath;

    /**
     * bfc
     */
    private String bfcPath;

    /**
     * 脚本目录
     */
    private String shengruiScriptPath;

    private String providerScriptPath;

    /**
     * 本地字符编码
     **/
    private String localCharset;

    /**
     * FTP协议里面，规定文件名编码为iso-8859-1
     **/
    private String serverCharset;

    /**
     * UTF-8字符编码
     **/
    private String charsetUtf8;

    /**
     * OPTS UTF8字符串常量
     **/

    private String optsUtf8;

    /**
     * 设置缓冲区大小4M
     **/
    private int bufferSize;

}
