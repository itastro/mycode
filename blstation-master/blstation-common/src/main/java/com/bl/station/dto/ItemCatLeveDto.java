package com.bl.station.dto;

import com.bl.station.entity.Itemcat;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName ItemCatLeveDto
 * @Description TODO
 * @Date 2018/9/3 16:35
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
public class ItemCatLeveDto extends Itemcat{


    /**
     * 自己下面包含自己，组成一个树形结构
     */
    private List<ItemCatLeveDto> children = Lists.newArrayList();

    /**
     * copy
     */

    public static ItemCatLeveDto adapt(Itemcat itemcat) {
        ItemCatLeveDto itemCatLeveDto = new ItemCatLeveDto();
        BeanUtils.copyProperties(itemcat, itemCatLeveDto);
        return itemCatLeveDto;
    }
}
