package com.bailian.car.controller.checktable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bailian.car.annotation.JSON;
import com.bailian.car.domain.cars.checktable.CheckParentItem;
import com.bailian.car.service.checktable.CheckTableService;

@Controller
@RequestMapping("/check/table")
public class CheckTableController {
	@Autowired
	private CheckTableService checkTableService;

	// 查询安全检查表
	@RequestMapping("/safe.action")
	@JSON(type = CheckParentItem.class, include = "id,pname,carCheckRequest")

	public List<CheckParentItem> findSafeTable() {
		return checkTableService.findSafeTable();
	}

	// 查询线束检查表
	@RequestMapping("/hi.action")
	@JSON(type = CheckParentItem.class, filter = "carCheckRequest")
	public List<CheckParentItem> findHiTable() {
		return checkTableService.findHiTable();
	}

	// bom 检查表
	@RequestMapping("/bom.action")
	@JSON(type = CheckParentItem.class, include = "id,pname")
	public List<CheckParentItem> findBomTable() {
		return checkTableService.findBomTable();
	}
}
