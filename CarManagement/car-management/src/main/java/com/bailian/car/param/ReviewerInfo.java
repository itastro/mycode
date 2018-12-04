package com.bailian.car.param;

import java.io.Serializable;
import java.util.List;

import com.bailian.car.domain.carcheck.BomCheck;
import com.bailian.car.domain.carcheck.Reviewer;
import com.bailian.car.domain.carcheck.SafeCheck;
import com.bailian.car.domain.carcheck.SystemCheck;
import com.bailian.car.domain.cars.develop.DevelopToolsRecord;

/**
 * 
    * @ClassName: ReviewerInfo
    * @Description: 审核视图
    * @author itastro
    * @date 2018年6月21日
    *
 */
public class ReviewerInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public SafeCheck getSafeCheck() {
		return safeCheck;
	}

	public void setSafeCheck(SafeCheck safeCheck) {
		this.safeCheck = safeCheck;
	}

	public SystemCheck getHiCheck() {
		return hiCheck;
	}

	public void setHiCheck(SystemCheck hiCheck) {
		this.hiCheck = hiCheck;
	}

	public BomCheck getbCheck() {
		return bCheck;
	}

	public void setbCheck(BomCheck bCheck) {
		this.bCheck = bCheck;
	}

	public List<DevelopToolsRecord> getDevelopToolsRecords() {
		return developToolsRecords;
	}

	public void setDevelopToolsRecords(List<DevelopToolsRecord> developToolsRecords) {
		this.developToolsRecords = developToolsRecords;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	private Reviewer reviewer;

	private SafeCheck safeCheck;

	private SystemCheck hiCheck;

	private BomCheck bCheck;

	private List<DevelopToolsRecord> developToolsRecords;

}
