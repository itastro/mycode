package cn.shengrui.common.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName PageBean
 * @Description TODO
 * @Date 2018/10/17 17:24
 * @Author itastro
 * @Version 1.0
 **/
public class PageBean<T> {

    private List<T> data = Lists.newArrayList();

    private int total = 0;
}
