package com.bl.station.service.menu;

import com.bl.station.dto.MenuLeveDto;
import com.bl.station.param.MenuParam;
import com.bl.station.utils.StationResult;

import java.util.List;

public interface MenuService {

    StationResult add(MenuParam menuParam);

    List<MenuLeveDto> menuTree();

    //更新部门
    StationResult update(MenuParam menuParam);

    //删除部门
    StationResult delete(Integer id);

}
