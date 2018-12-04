package com.bailian.car.service.driver.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.GroupReposity;
import com.bailian.car.dao.driver.DriverGroupRepository;
import com.bailian.car.dao.driver.DriverRepository;
import com.bailian.car.domain.cardriver.Driver;
import com.bailian.car.domain.cardriver.DriverGroup;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.cars.car.Project;
import com.bailian.car.exception.ParamException;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.param.DriverSearchParam;
import com.bailian.car.param.SortOrder;
import com.bailian.car.service.driver.DriverService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.ExcelUtils;
import com.bailian.car.utils.JsonMapper;
import com.bailian.car.utils.StringU;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private DriverGroupRepository driverGroupRepository;

	@Override
	public JsonData add(Driver carDriver) {
		if (carDriver == null) {
			return JsonData.fail("驾驶员不能为空");
		}
		Driver driver = driverRepository.findByName(carDriver.getName());

		if (driver != null) {
			return JsonData.fail("此驾驶员存在");
		}
		Driver employeeCard = driverRepository.findByEmployeeCard(carDriver.getEmployeeCard());
		if (employeeCard != null) {
			return JsonData.fail("此员工卡号已经存在");
		}
		/*Driver findByIccard = driverRepository.findByIccard(carDriver.getIccard());
		if (findByIccard != null) {
			return JsonData.fail("此IC卡号被占用");
		}*/
		log.info("carDriver:{}", JsonMapper.obj2String(carDriver));

		carDriver.setIsallow("禁止");

		driverRepository.save(carDriver);

		return JsonData.success("添加成功");
	}

	@Override
	public PageBean<Driver> pageQuery(PageQuery pageQuery, DriverSearchParam searchParam) {
		log.info("pageQuery:{}", JsonMapper.obj2String(pageQuery));
		log.info("searchParam:{}", JsonMapper.obj2String(searchParam));
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize());
		// 按照命令进行排序
		if (pageQuery.getSortOder() != null) {
			if (pageQuery.getSortOder().equals(SortOrder.DESC)) {
				pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), Direction.ASC,
						pageQuery.getSort());
			}
		}
		if (pageQuery.getSort() != null) {
			if (pageQuery.getSort().equals(SortOrder.ASC)) {
				pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize(), Direction.ASC,
						pageQuery.getSort());
			}
		}

		List<Predicate> ps = new ArrayList<Predicate>();
		PageBean<Driver> pageBean = new PageBean<>();
		Specification<Driver> spec = new Specification<Driver>() {
			@Override
			public Predicate toPredicate(Root<Driver> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (searchParam != null) {

					// 名字
					if (StringUtils.isNotBlank(searchParam.getDriverName())) {
						Predicate p1 = cb.like(root.get("name").as(String.class),
								"%" + searchParam.getDriverName() + "%");

						ps.add(p1);
					}

					if (StringUtils.isNotBlank(searchParam.getGroupName())) {
						Join<Driver, DriverGroup> carjoin = root.join("groups", JoinType.INNER);

						Predicate p3 = cb.like(carjoin.get("name").as(String.class),
								"%" + searchParam.getGroupName() + "%");

						ps.add(p3);
					}

				}
				return cb.and(ps.toArray(new Predicate[ps.size()]));
			}
		};
		Page<Driver> pagedata = driverRepository.findAll(spec, pageable);
		pageBean.setTotal(pagedata.getTotalElements());
		pageBean.setRows(pagedata.getContent());
		return pageBean;
	}

	@Override
	public JsonData delete(String[] ids) {
		log.info("ids:{}", JsonMapper.obj2String(ids));
		try {
			if (ids.length != 0) {
				for (String id : ids) {
					Driver driver = driverRepository.findOne(Integer.parseInt(id));
					driver.setGroups(null);
					driverRepository.delete(Integer.parseInt(id));
				}
				return JsonData.success("删除成功");
			}
		} catch (Exception e) {
			throw new ParamException("此驾驶员不在");
		}
		return JsonData.fail("删除失败");
	}

	@Override
	public Driver findById(Integer id) {
		Driver carDriver = driverRepository.findOne(id);
		return carDriver;
	}

	@Override
	public JsonData updatedriver(Driver carDriver) {
		log.info("carDriver:{}", JsonMapper.obj2String(carDriver));
		Driver save = driverRepository.save(carDriver);
		if (save != null) {
			return JsonData.success("修改成功");
		}
		return JsonData.fail("修改失败");
	}

	@Override
	public JsonData authorized(String[] ids, Date startTime, Date endTime, String[] gids) {
		log.info("ids:{}", JsonMapper.obj2String(ids));
		if (ids == null) {
			return JsonData.fail("请至少选择一个驾驶员");
		}

		if (ids.length == 0) {
			return JsonData.fail("请至少选择一个驾驶员");
		}
		for (String id : ids) {
			startTime = new Date();
			endTime = DateUtils.getLastDayThisYear();
			driverRepository.updateAuthorized(Integer.parseInt(id), startTime, endTime);
			if (gids.length > 0) {
				for (String gid : gids) {
					if (gid.equals("[]")) {
						continue;
					}
					int gi = Integer.parseInt(gid);
					List<String> lists = driverGroupRepository.findByGidAndgi(id, gi);
					if (lists.isEmpty()) {
						driverGroupRepository.inSert(id, gi);
					}
					
				}
			}
		}
		return JsonData.success("授权成功");
	}

	@Override
	public JsonData cancelAuthorized(String[] ids, String[] gids) {
		log.info("ids:{}", JsonMapper.obj2String(ids));
		if (ids == null) {
			return JsonData.fail("请至少选择一个驾驶员");
		}

		if (ids.length == 0) {
			return JsonData.fail("请至少选择一个驾驶员");
		}

		for (String id : ids) {
			driverRepository.cancelAuthorized(Integer.parseInt(id));

			//driverCancelGroup(gids, id);
		}
		return JsonData.success("取消成功");
	}

	// 驾驶员取消分组
	private void driverCancelGroup(String[] gids, String id) {
		for (String gid : gids) {
			driverGroupRepository.cancelGroup(Integer.parseInt(gid), id);
		}
	}

	@Override
	public int insertDBByExcel(InputStream excelFile, String fileName) throws IOException {
		int count = 0;

		try {
			boolean b = ExcelUtils.isExcel(fileName);
			if (b == false) {
				throw new ParamException("此文件不是excel,请正确选择文件");
			}

			List<Driver> list = new ArrayList<Driver>();
			// 使用poi解析excel
			@SuppressWarnings("resource")
			// XSSFWorkbook book = new XSSFWorkbook(excelFile);
			// work book factory
			Workbook book = WorkbookFactory.create(excelFile);
			// 获得sheet
			Sheet sheet = book.getSheetAt(0);
			// 获得sheet 中的每一行
			for (Row row : sheet) {
				// 一行数据队形一个驾驶员对象
				// 跳过第一行
				if (row.getRowNum() == 0) {
					continue;
				}
				// 跳过空行
				if (row.getCell(0) == null || StringUtils.isBlank(row.getCell(0).getStringCellValue())) {

				}
				// 把数据封装进 驾驶员对象
				Driver driver = new Driver();
				Set<DriverGroup> set = new HashSet<>();
				driver.setName(row.getCell(0).getStringCellValue());
				driver.setEmployeeCard((StringU.getString(row.getCell(1).getNumericCellValue())));
				driver.setIccard((StringU.getString(row.getCell(2).getNumericCellValue())));
				driver.setTelephone(StringU.getString(row.getCell(3).getNumericCellValue()));

				String groups = row.getCell(4).getStringCellValue();
				String[] groupss = groups.split(",");
				if (groupss.length != 0) {
					for (String name : groupss) {
						DriverGroup group = driverGroupRepository.findByName(name);
						if (group != null) {
							set.add(group);
							driver.setGroups(set);
						}
					}
				}
				driver.setIsallow(row.getCell(5).getStringCellValue());
				driver.setAllowStartTime(row.getCell(6).getDateCellValue());
				driver.setAllowEndTime(row.getCell(7).getDateCellValue());
				count++;
				list.add(driver);
			}
			driverRepository.save(list);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			throw new PermissionException("excel异常,请你上传正确的excel");
		}

	}

	@Override
	public JsonData insertDBByExcel(MultipartFile file, String filename) {
		int count = 0;
		try {
			List<String[]> readExcel = ExcelUtils.readExcel(file);
			if (readExcel != null && readExcel.size() > 0) {
				for (int i = 1; i < readExcel.size(); i++) {
					log.info("readExcel.get(i):{}", JsonMapper.obj2String(readExcel.get(i)));
					String[] strings = readExcel.get(i);
					String employeeCard = strings[1];
					Driver driver1 = driverRepository.findByEmployeeCard(employeeCard);
					if (driver1 != null) {
						continue;
					}
					Driver driver = new Driver();
					driver.setEmployeeCard(employeeCard);

					String name = strings[0];
					driver.setName(name);
					String iccard = strings[2];
					Driver driver2 = driverRepository.findByIccard(iccard);
					if (driver2 != null) {
						continue;
					}
					driver.setIccard(iccard);
					String tel = strings[3];
					driver.setTelephone(tel);
					String type = strings[4];
					driver.setAllowType(type);
					String remark = strings[5];
					driver.setRemark(remark);
					driver.setIsallow("禁止");
					driver.setAllowStartTime(null);
					driver.setAllowEndTime(null);
					driverRepository.save(driver);
					count++;
				}
			}
		} catch (Exception e) {
			throw new PermissionException("excel异常,请你上传正确的excel");
		}
		return JsonData.success("你导入了" + count + "名驾驶员,已自动去掉员工卡号相同的数据");

	}
}
