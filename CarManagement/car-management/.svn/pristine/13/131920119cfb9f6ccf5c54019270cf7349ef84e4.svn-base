package com.bailian.car.dao.cars.check;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bailian.car.domain.carcheckresult.HIResult;

public interface HIResultReposity extends JpaRepository<HIResult, String> {

	List<HIResult> findByvSn(String vSn);

	HIResult findByvSnAndItem(String vSn, String item);

	HIResult findByvSnAndPitemAndItem(String vSn, String pitem, String item);

}
