package com.bailian.car.service.project;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.domain.cars.car.Project;

public interface ProjectService {

	JsonData batchImport(MultipartFile file);

	JsonData update(String[] projectSn, String status);

	List<String> loadprojectSn();

	String loadNameBySn(String sn);

	String loadStatusBySn(String sn);

	JsonData save(Project project);

	JsonData update(Project project);

	PageBean<Project> query(PageQuery query,String sn);

	JsonData delProject(String[] ids);

	List<String> likeProjectSn(String projectsn);

}
