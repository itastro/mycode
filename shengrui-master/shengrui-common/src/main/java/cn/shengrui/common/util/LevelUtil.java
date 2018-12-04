package cn.shengrui.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName LevelUtil
 * @Description 层级工具类
 * @Date 2018/10/6 22:06
 * @Author itastro
 * @Version 1.0
 **/
public class LevelUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(LevelUtil.class);

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    // 0
    // 0.1
    // 0.1.2
    // 0.1.3
    // 0.4
    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
