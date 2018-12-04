package com.bl.station.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 部门的工具类
 *
 * @author itastro
 */


public class LeveUtils {

    // 分隔符
    public final static String SEPARATOR = ".";
    // 部门的根节点
    public final static String ROOT = "0";


    /**
     * @param  parentLevel
     *
     * @param  parenId
     *
     * @return
     *
     */

    // 0
    // 0.1
    // 0.1.2
    // 0.1.3
    // 0.4

    @SuppressWarnings("unchecked")
    public static String calculateLevel(String parentLevel, int parenId) {
        // 父部门层级是否为空
        if (StringUtils.isBlank(parentLevel)) {
// 返回根节点
            return ROOT;
        } else {
            // 连上parentid
            return StringUtils.join(parentLevel, SEPARATOR, parenId);
        }
    }
}
