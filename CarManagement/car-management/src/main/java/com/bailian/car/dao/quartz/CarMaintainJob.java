package com.bailian.car.dao.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bailian.car.service.CarMaintain.CarMaintainService;
public class CarMaintainJob implements Job {
	@Autowired
	private CarMaintainService carMaintainService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("检测维修状态");

		carMaintainService.updtaStatus();

	}

}
