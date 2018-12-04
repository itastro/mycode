package com.bailian.car.dao.log;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bailian.car.domain.Log.SysLog;

public interface SysLogRepository extends JpaRepository<SysLog, Integer>, JpaSpecificationExecutor<SysLog> {

	@Query(value = "select l from  SysLog l where l.module=?1")
	Page<SysLog> findcarLog(@Param(value = "module") String module, Pageable pageable);

	@Query(value = "select l from  SysLog l where l.module=?1")
	Page<SysLog> findDriverLog(@Param(value = "module") String module, Pageable pageable);

	@Query(value = "select l from  SysLog l where l.module=?1")
	Page<SysLog> findMaintainLog(@Param(value = "module") String module, Pageable pageable);

	@Query(value = "select l from  SysLog l where l.module=?1")
	Page<SysLog> findSystemLog(@Param(value = "module") String module, Pageable pageable);

}
