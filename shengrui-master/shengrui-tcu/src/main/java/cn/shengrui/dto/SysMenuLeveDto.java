package cn.shengrui.dto;

import cn.shengrui.system.entity.SysMenu;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName SysMenuLeveDto
 * @Description TODO
 * @Date 2018/10/22 14:21
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@ToString
public class SysMenuLeveDto extends SysMenu {


    /**
     * 菜单集合
     */
    private List<SysMenuLeveDto> menuList = Lists.newArrayList();


    /**
     * 进行适配
     *
     * @param menu
     * @return
     */
    public static SysMenuLeveDto adapt(SysMenu menu) {
        SysMenuLeveDto menuLeveDto = new SysMenuLeveDto();
        BeanUtils.copyProperties(menu, menuLeveDto);
        return menuLeveDto;
    }


}
