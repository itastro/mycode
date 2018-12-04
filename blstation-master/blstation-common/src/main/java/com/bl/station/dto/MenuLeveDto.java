package com.bl.station.dto;

import com.bl.station.entity.Menu;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


import java.util.List;

/**
 * 树形结构
 *
 * @author itastro
 */
@Getter
@Setter
public class MenuLeveDto extends Menu {
    /**
     * 自己下面包含自己，组成一个树形结构
     */
    private List<MenuLeveDto> children = Lists.newArrayList();

    /**
     * copy
     */

    public static MenuLeveDto adapt(Menu menu) {
        MenuLeveDto menuLeveDto = new MenuLeveDto();
        BeanUtils.copyProperties(menu, menuLeveDto);
        return menuLeveDto;
    }
}
