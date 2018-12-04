package com.bl.station.service.ItemCat;

import com.bl.station.dto.ItemCatLeveDto;
import com.bl.station.entity.Itemcat;
import com.bl.station.param.ItemCatParam;
import com.bl.station.utils.StationResult;

import java.util.List;

/**
 * @ClassName ItemCarService
 * @Description TODO
 * @Date 2018/8/14 11:15
 * @Author itastro
 * @Version 1.0
 **/
public interface ItemCatService {

    StationResult save(ItemCatParam itemCatParam);

    StationResult delete(Integer id);

    List<ItemCatLeveDto> tree();

    StationResult update(ItemCatParam itemCatParam);


    Itemcat findItemCatById(Integer id);






}
