package cn.shengrui.common.beans;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName PageQuery
 * @Description TODO
 * @Date 2018/10/7 16:52
 * @Author itastro
 * @Version 1.0
 **/
public class PageQuery {

    @Setter
    private Integer pageNo = 1;

    @Getter
    @Setter
    private Integer size = 300000;

    @Setter
    private int offset;

    public int getOffset() {
        return (pageNo - 1) * size;
    }


    public Integer getPageNo() {
        if (pageNo == 0) {
            return 1;
        }
        if (pageNo < 0) {
            return 1;
        }
        return pageNo;
    }
}