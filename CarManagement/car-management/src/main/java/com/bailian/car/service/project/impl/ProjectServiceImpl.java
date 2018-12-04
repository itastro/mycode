package com.bailian.car.service.project.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.CarRepository;
import com.bailian.car.dao.cars.project.ProjectRepository;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.cars.car.Project;
import com.bailian.car.exception.ParamException;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.service.project.ProjectService;
import com.bailian.car.utils.ExcelUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ProjectRepository projectRepository;

	// 导入项目
	@Override
	public JsonData batchImport(MultipartFile file) {
		try {
			List<String[]> readExcel = ExcelUtils.readExcel(file);
			if (readExcel != null && readExcel.size() > 0) {
				for (int i = 1; i < readExcel.size(); i++) {
					String[] strings = readExcel.get(i);
					String projectName = strings[2];

					String customer = strings[1];
					Project excelProject = new Project();
					excelProject.setProjectName(projectName);
					excelProject.setCustomer(customer);
					String project_sn = strings[0];
					Project project = projectRepository.findByProject_sn(project_sn);
					if (project != null) {
						continue;
					}
					excelProject.setProject_sn(project_sn);
					String project_status = strings[3];
					excelProject.setProject_status(project_status);
					projectRepository.save(excelProject);

				}
				return JsonData.success("项目导入成功");
			}
			return JsonData.fail("内容不能为空");

		} catch (

		Exception e) {
			throw new PermissionException("excel格式错误,请按指定模板导入");
		}

	}

	@Override
	public JsonData update(String[] projectSns, String status) {
		if (projectSns != null) {
			for (String projectSn : projectSns) {
				projectRepository.updateStatus(projectSn, status);
				//carRepository.updateProject(projectSn, status);
			}
		}
		return JsonData.success("更新成功");
	}

	@Override
	public List<String> loadprojectSn() {

		return projectRepository.loadprojectSn();
	}

	@Override
	public String loadNameBySn(String sn) {
		// TODO Auto-generated method stub
		return projectRepository.loadNameBySn(sn);
	}

	@Override
	public String loadStatusBySn(String sn) {

		return projectRepository.loadstatusBySn(sn);
	}

	@Override
	public JsonData save(Project project) {
		Project project2 = projectRepository.findByProject_sn(project.getProject_sn());
		if (project2 != null) {
			return JsonData.fail("项目编号已占用");
		}
		Project project3 = projectRepository.findByProjectName(project.getProjectName());
		if (project3 != null) {
			return JsonData.fail("项目名称已占用");
		}

		projectRepository.save(project);
		return JsonData.success("项目添加成功");
	}

	@Override
	public JsonData update(Project project) {
		Integer id = project.getId();
		if (id == null) {
			log.error("id不能为null");
			throw new ParamException("请传入车辆id");
		}
		projectRepository.save(project);
		return JsonData.success("修改成功");
	}

	@Cacheable("car")
	@Override
	public PageBean<Project> query(PageQuery query,String sn) {
		Sort sort = new Sort(Direction.DESC, "id");
		PageBean<Project> result = new PageBean<>();

		Pageable pageable = new PageRequest(query.getPage(), query.getSize(),sort);

		final List<Predicate> list = new ArrayList<>();

		Specification<Project> specification = new Specification<Project>() {

			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				if(StringUtils.isNotBlank(sn)) {
					Predicate p6 = cb.like(root.get("project_sn").as(String.class),
							"%" + sn + "%");
					list.add(p6);
				}
				
				return cb.and(list.toArray(new Predicate[list.size()]));

			}
		};
		
		Page<Project> pageData = projectRepository.findAll(specification, pageable);
		result.setTotal(pageData.getTotalElements());
		result.setRows(pageData.getContent());
		return result;
	}

	@Override
	public JsonData delProject(String[] ids) {
		if (ids == null) {
			return JsonData.fail("请选择需要删除的项目");
		}
		if (ids.length < 1) {
			return JsonData.fail("请选择需要删除的项目");
		}
		for (String id : ids) {

			List<Car> list = carRepository.findByProject(Integer.parseInt(id));

			for (Car car : list) {
				car.setProject(null);
			}
			projectRepository.delete(Integer.parseInt(id));
		}
		return JsonData.success("删除成功");
	}

	@Override
	public List<String> likeProjectSn(String projectsn) {

		return projectRepository.likeProjectSn(projectsn);
	}

}
