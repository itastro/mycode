package com.bailian.car.dao.iccard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bailian.car.domain.iccard.IccardUseHistory;

public interface IccardUseHistoryRepository extends JpaRepository<IccardUseHistory, Integer>, JpaSpecificationExecutor<IccardUseHistory> {
	
    @Query(value="SELECT * FROM iccard_use_history  WHERE ID = ( SELECT MAX(ID) FROM iccard_use_history)",nativeQuery=true)
	IccardUseHistory getnewinfo();


}
