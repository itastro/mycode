package com.bailian.car.dao.cars.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bailian.car.domain.cars.car.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> ,JpaSpecificationExecutor<Project>{

	Project findByProjectName(String projecName);

	@Query(value = "select * from t_project where project_sn=?1", nativeQuery = true)
	Project findByProject_sn(String project_sn);

	@Query(value = "select * from t_project where project_sn=?1", nativeQuery = true)
	Project findByProject_snAndProjectName(String project_sn);

	@Modifying
	@Query(value = "UPDATE t_project SET project_status=?2 WHERE project_sn=?1", nativeQuery = true)
	void updateStatus(String projectSn, String status);

	@Query(value = "SELECT project_sn FROM t_project", nativeQuery = true)
	List<String> loadprojectSn();

	@Query(value = "SELECT projectName FROM t_project WHERE project_sn=?1", nativeQuery = true)
	String loadNameBySn(String sn);

	@Query(value = "SELECT project_status FROM t_project WhERE project_sn=?1", nativeQuery = true)
	String loadstatusBySn(String sn);

	@Query(value = "SELECT project_sn FROM t_project WHERE project_sn like CONCAT('%',:project_sn,'%')", nativeQuery = true)
	List<String> likeProjectSn(@Param("project_sn") String projectsn);

}
