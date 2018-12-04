package com.bailian.car.service.cars.license.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.JsonData;
import com.bailian.car.dao.cars.car.CarInsuranceRepository;
import com.bailian.car.dao.cars.car.CarLicenseRepository;
import com.bailian.car.dao.cars.car.CarRepository;
import com.bailian.car.dao.cars.car.HistoryLicenseRepository;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.cars.car.CarInsurance;
import com.bailian.car.domain.cars.car.CarLicense;
import com.bailian.car.domain.cars.car.HistoryLicense;
import com.bailian.car.domain.cars.car.QCar;
import com.bailian.car.domain.cars.car.QCarInsurance;
import com.bailian.car.domain.cars.car.QCarLicense;
import com.bailian.car.dto.LicenseDto;
import com.bailian.car.param.LicSearchParam;
import com.bailian.car.param.LicenseParam;
import com.bailian.car.service.cars.license.LicenseService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.JsonMapper;
import com.bailian.car.utils.TokenManagerUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	private CarLicenseRepository carLicenseRepository;
	@Autowired
	private CarInsuranceRepository carInsuranceRepository;

	@Autowired
	private HistoryLicenseRepository historyLicenseRepository;
	// 实体管理
	@Autowired
	private EntityManager entityManager;

	// 查询工厂
	private JPAQueryFactory queryFactory;

	// 初始化查询工厂
	@PostConstruct
	public void init() {
		queryFactory = new JPAQueryFactory(entityManager);
	}

	@Autowired
	private CarRepository carRepository;

	@Override
	public PageBean<LicenseDto> pageQuery(PageQuery pageQuery, LicSearchParam licSearchParam) {

		log.info("licSearchParam:{}", JsonMapper.obj2String(licSearchParam));
		// TODO Auto-generated method stub
		PageBean<LicenseDto> pageBean = new PageBean<>();
		Pageable pageable = new PageRequest(pageQuery.getPage(), pageQuery.getSize());
		QCar qCar = QCar.car;
		QCarLicense qCarLicense = QCarLicense.carLicense;
		QCarInsurance qCarInsurance = QCarInsurance.carInsurance;
		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;
		Predicate predicate4 = null;
		Predicate predicate5 = null;
		Predicate predicate6 = null;
		Predicate predicate7 = null;
		
		Predicate predicate8 = null;
		Predicate predicate9 = null;
		Predicate predicate10 = null;
		if (licSearchParam != null) {

			if (StringUtils.isNotBlank(licSearchParam.getvSn())) {
				predicate1 = qCarLicense.vSn.like("%" + licSearchParam.getvSn() + "%");
			}

			if (StringUtils.isNotBlank(licSearchParam.getlNo())) {
				predicate4 = qCarLicense.licenseNo.like("%" + licSearchParam.getlNo() + "%");
			}

			if (StringUtils.isNotBlank(licSearchParam.getEngineNumber())) {
				predicate5 = qCar.engineNumber.like("%" + licSearchParam.getEngineNumber() + "%");

			}

			if (StringUtils.isNotBlank(licSearchParam.getVin())) {
				predicate6 = qCar.vin.like("%" + licSearchParam.getVin() + "%");

			}
			if (StringUtils.isNotBlank(licSearchParam.getInsRemark())) {
				predicate8 = qCarInsurance.remark.like("%" + licSearchParam.getInsRemark() + "%");

			}
			
			if (StringUtils.isNotBlank(licSearchParam.getVehicleInspection())) {
				predicate9 = qCarInsurance.vehicleInspection.like("%" + licSearchParam.getVehicleInspection() + "%");

			}
		
			if (StringUtils.isNotBlank(licSearchParam.getApplyTime())) {
				log.info("licSearchParam:{}",
						JsonMapper.obj2String(DateUtils.String2date(licSearchParam.getApplyTime())));
				log.info("licSearchParam:{}", JsonMapper
						.obj2String(DateUtils.addOneDay(DateUtils.String2date(licSearchParam.getApplyTime()))));
				predicate2 = qCarLicense.applytime.between(DateUtils.String2date(licSearchParam.getApplyTime()),
						DateUtils.addOneDay(DateUtils.String2date(licSearchParam.getApplyTime())));

			}

			if (StringUtils.isNotBlank(licSearchParam.getlEndTime())) {
				predicate3 = qCarLicense.licenseEndTime.between(DateUtils.String2date(licSearchParam.getlEndTime()),
						DateUtils.addOneDay(DateUtils.String2date(licSearchParam.getlEndTime())));
			}

			if (StringUtils.isNotBlank(licSearchParam.getMaketime())) {
				predicate7 = qCarLicense.maketime.between(DateUtils.String2date(licSearchParam.getMaketime()),
						DateUtils.addOneDay(DateUtils.String2date(licSearchParam.getMaketime())));
			}
			
			predicate10 = qCar.car_status.equalsIgnoreCase("进行");

		}

		// 查询
		JPAQuery<LicenseDto> query = queryFactory.select(Projections.bean(LicenseDto.class, qCar.project,
				qCar.projectEngineer, qCar.car_status, qCar.upcheckTime, qCar.backchecktime, qCar.brandModelone,
				qCar.brandModeltwo, qCar.vehicleQuality, qCar.engineNumber, qCar.vin, qCar.adminName, qCar.vSn,
				qCar.customer, qCar.picurl,qCarLicense.licenseEndTime, qCarLicense.licenseStartTime, qCarLicense.llave,
				qCarInsurance.endTime, qCarInsurance.vehicleInspection, qCar.checkStaionType, qCarLicense.applytime,
				qCarLicense.applyperson, qCarLicense.remark, qCarLicense.maketime, qCarLicense.licenseNo))
				.from(qCar, qCarInsurance, qCarLicense)
				.where(qCar.vSn.eq(qCarLicense.vSn), qCarLicense.vSn.eq(qCarInsurance.vSn), predicate1, predicate2,
						predicate3, predicate5, predicate6, predicate4, predicate7,predicate8,predicate9,predicate10)
				.orderBy(qCarLicense.applytime.desc());

		pageBean.setTotal((long) query.createQuery().getResultList().size());
		pageBean.setRows(query.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetchResults().getResults());
		log.info("pageBean:{}", JsonMapper.obj2String(pageBean));
		return pageBean;
	}
	@RequiresRoles(value = { "admin", "plateManage","insuranceManage" }, logical = Logical.OR)
	@Override
	public JsonData vehicleInspectionCheck(String vSn) {
		long time = new Date().getTime();
		if (StringUtils.isBlank(vSn)) {
			return JsonData.fail("请你选择一辆车");
		}
		StringBuilder builder = new StringBuilder();
		long ltime = 0;
		CarInsurance insurance = carInsuranceRepository.findByvSn(vSn);
		if (insurance == null) {
			return JsonData.fail("此车未进行保险申请,无法验车");
		} else {
			if (StringUtils.isBlank(insurance.getInsNo())) {
				return JsonData.fail("此车无保险,无法验车");
			}

			if (insurance.getLave() <= 0) {
				return JsonData.fail("此车保险已经过期,请你先进行续保");
			}
		}

		CarLicense license = carLicenseRepository.findByvSn(vSn);

		if (license != null) {
			if (license.getLicenseEndTime() != null) {
				ltime = license.getLicenseEndTime().getTime();
			}
			long i = (ltime - time) / 1000 / 60 / 60 / 24;
			if (i >= 30) {
				builder.append("车辆编号为" + "<font color=\"#FF0000\">" + vSn + "<font/>" + "距离临牌到期日还有"
						+ "<font color='#FF0000'>" + i + "<font/>" + "天" + "<br/>");
			}

			if (StringUtils.isBlank(license.getLicenseNo())) {
				builder.append("车辆编号为" + "<font color=\"#FF0000\">" + vSn + "<font/>" + "无临牌,是否进行强制验车" + "<br/>");
			}
		}

		if (("已申请").equals(insurance.getVehicleInspection())) {
			builder.append("车辆编号为" + "<font color=\"#FF0000\">" + vSn + "<font/>" + "已经申请过验车,请你确认是否重复验车" + "<br/>");
		}

		if (("已申请").equals(insurance.getVehicleInspection())) {
			builder.append("车辆编号为" + "<font color=\"#FF0000\">" + vSn + "<font/>" + "已经申请验车" + "<br/>");
		}

		if (builder.toString().isEmpty()) {
			return JsonData.success("无问题，请你进行确认操作");
		}
		return JsonData.error(builder.toString());
	}

	// 验车
	@RequiresRoles(value = { "admin", "plateManage","insuranceManage" }, logical = Logical.OR)
	@Override
	public JsonData generateVehicleInspection(String vSn) {
		// 查询这两车的保险
		Car car = carRepository.findByVSn(vSn);
		CarInsurance carInsurance = carInsuranceRepository.findByvSn(vSn);
		CarLicense carLicense = carLicenseRepository.findByvSn(vSn);
		if (carInsurance != null) {
			if (("已申请").equals(carInsurance.getVehicleInspection())) {
				return JsonData.fail("此车已经进行过验车,请进行临牌信息录入");
			}
			if (carLicense == null) {
				carLicense = CarLicense.builder().vSn(vSn).applytime(new Date())
						.applyperson(TokenManagerUtils.getNickname()).vehicleInspection("已申请").build();
				carInsurance.setVehicleInspection("已申请");
				car.setVehicleInspection("已申请");
				carLicenseRepository.save(carLicense);

			} else {
				carInsurance.setVehicleInspection("已申请");
				carLicense.setApplyperson(TokenManagerUtils.getNickname());
				carLicense.setVehicleInspection("已申请");
				carLicense.setApplytime(new Date());
				car.setVehicleInspection("已申请");
			}
			return JsonData.success("验车申请成功");
		}

		return JsonData.fail("请申请保险");
	}

	// 保存时更新车辆总表信息
	@Override
	public JsonData saveLicenese(LicenseParam license) {
		//
		String vSn = license.getvSn();
		
		Car car = carRepository.findByVSn(vSn);
		CarLicense carLicense = carLicenseRepository.findByvSn(vSn);
		if (("未申请").equals(carLicense.getVehicleInspection())) {
			return JsonData.fail("请你先进行验车");
		}

		if (carLicense != null) {
			if (license.getWhether().equals("是")) {
				BeanUtils.copyProperties(license, carLicense);
				carLicense.setMaketime(new Date());
				carLicense.setAddPerson(TokenManagerUtils.getNickname());

				carInsuranceRepository.updateVehicleInspection(vSn);
				carLicense.setVehicleInspection("未申请");
				car.setVehicleInspection("未申请");
				carLicense.setLicenseStartTime(new Date());
				carLicenseRepository.save(carLicense);

				HistoryLicense historyLicense = createLicHistory(carLicense);

				historyLicenseRepository.save(historyLicense);
				carRepository.updateLicense(vSn, license.getLicenseEndTime(), license.getLicenseNo(),
						license.getRemark());
				return JsonData.success("录入信息成功");
			} else {
				carLicense.setRemark(license.getRemark());
			}

		}
		return JsonData.fail("请进行验车申请");
	}

	// 创建车牌历史纪录
	private HistoryLicense createLicHistory(CarLicense carLicense) {
		HistoryLicense historyLicense = HistoryLicense.builder().vSn(carLicense.getvSn())
				.addPerson(carLicense.getAddPerson()).applyperson(carLicense.getApplyperson())
				.applytime(carLicense.getApplytime()).maketime(carLicense.getMaketime())
				.licenseEndTime(carLicense.getLicenseEndTime()).licenseStartTime(carLicense.getLicenseStartTime())
				.licenseNo(carLicense.getLicenseNo()).remark(carLicense.getRemark()).build();
		return historyLicense;
	}

	@Override
	public List<HistoryLicense> historyLicenseByvSn(String vSn) {
		// TODO Auto-generated method stub
		List<HistoryLicense> list = historyLicenseRepository.findByvSn(vSn);
		return list;
	}

	@Override
	public JsonData updateLicense(LicenseParam license) {

		String vSn = license.getvSn();
		CarLicense carLicense = carLicenseRepository.findByvSn(vSn);
		// Car car = carRepository.findByvSn(vSn);
		if (carLicense == null) {
			return JsonData.fail("请先进行验车/车牌录入 ");
		}
		String licenseNo = license.getLicenseNo();
		Date licenseEndTime = license.getLicenseEndTime();
		String remark = license.getRemark();
		carLicenseRepository.updateLicense(vSn, licenseNo, licenseEndTime, remark);
		historyLicenseRepository.updateLicense(vSn, licenseNo, licenseEndTime, remark, carLicense.getMaketime());
		// car.setLicenseStartTime(new Date());
		// car.setLicenseEndTime(license.getLicenseEndTime()); //设置牌照的终止日
		carRepository.updateLicense(vSn, license.getLicenseEndTime(), license.getLicenseNo(), license.getRemark());
		HistoryLicense historyLicense = createLicHistory(carLicense);
		historyLicenseRepository.save(historyLicense);
		return JsonData.success("修改成功");
	}
	
	@RequiresRoles(value = { "admin", "plateManage","insuranceManage" }, logical = Logical.OR)
	@Override
	public JsonData cancle(String vSn) {
		Car car = carRepository.findByvSn(vSn);
		carInsuranceRepository.updateVehicleInspection(vSn);
	    car.setVehicleInspection("未申请");
		carLicenseRepository.deleteByvSn(vSn);
		return JsonData.success("取消验车成功");
	}

}
