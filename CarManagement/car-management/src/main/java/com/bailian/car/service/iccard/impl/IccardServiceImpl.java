package com.bailian.car.service.iccard.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.bailian.car.beans.PageBean;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.common.IccardResult;
import com.bailian.car.common.JsonData;
import com.bailian.car.common.LedResult;
import com.bailian.car.dao.cars.car.CarRepository;
import com.bailian.car.dao.driver.DriverRepository;
import com.bailian.car.dao.iccard.IccardRepository;
import com.bailian.car.dao.iccard.IccardUseHistoryRepository;
import com.bailian.car.domain.cardriver.Driver;
import com.bailian.car.domain.cars.car.Car;
import com.bailian.car.domain.iccard.Iccard;
import com.bailian.car.domain.iccard.IccardUseHistory;
import com.bailian.car.exception.PermissionException;
import com.bailian.car.param.IccardSearch;
import com.bailian.car.param.WriteCarCard;
import com.bailian.car.service.iccard.IccardService;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class IccardServiceImpl implements IccardService {

	@Autowired
	private IccardUseHistoryRepository iccardUseHistoryRepository;

	@Autowired
	private IccardRepository iccardRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired

	private DriverRepository driverRepository;

	@Override
	public JsonData insert(IccardUseHistory iccardUseHistory) {
		try {
			iccardUseHistoryRepository.save(iccardUseHistory);
			return JsonData.success("插入成功");
		} catch (Exception e) {
			return JsonData.fail("插入失败");
		}

	}

	@Override
	public JsonData save(Iccard iccard) {
		iccardRepository.save(iccard);
		return JsonData.success("添加成功");
	}

	@Override
	public List<Iccard> findSuppercarid() {
		return iccardRepository.findSuppercarid();
	}

	@Override
	public List<Iccard> findBackcarid() {
		// TODO Auto-generated method stub
		return iccardRepository.findbackcarid();
	}

	@Override
	public List<Iccard> findDrivercarid() {
		// TODO Auto-generated method stub
		return iccardRepository.findDrivercarid();
	}

	@Override
	public List<Iccard> findcarid() {
		// TODO Auto-generated method stub
		return iccardRepository.findcarid();
	}

	@Override
	public PageBean<Iccard> findAll(PageQuery pQuery, IccardSearch iSearch) {
		log.info("pQuery:{}", JsonMapper.obj2String(pQuery));
		log.info("iSearch:{}", JsonMapper.obj2String(iSearch));
		Pageable pageable = new PageRequest(pQuery.getPage(), pQuery.getSize());
		List<Predicate> ps = new ArrayList<Predicate>();
		PageBean<Iccard> pageBean = new PageBean<>();
		Specification<Iccard> spec = new Specification<Iccard>() {
			@Override
			public Predicate toPredicate(Root<Iccard> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;

			}
		};
		Page<Iccard> pagedata = iccardRepository.findAll(spec, pageable);
		pageBean.setTotal(pagedata.getTotalElements());
		pageBean.setRows(pagedata.getContent());
		return pageBean;

	}

	@Override
	public JsonData delete(Integer id) {
		iccardRepository.delete(id);
		return JsonData.success("删除成功");
	}

	@Override
	public JsonData update(Iccard iccard) {
		iccardRepository.save(iccard);
		return JsonData.success("更新成功");
	}

	@Override
	public IccardResult vehicleBindingcard(WriteCarCard writeCarCard) {
		if (writeCarCard.getCardType() == 0) {

			Car car = carRepository.findByIccard(writeCarCard.getCardNumber());
			
			if (car != null) {
				car.setIccard(null);
			}
			//return IccardResult.fail("此卡已经绑定过车辆", "1");
			Car car2 = carRepository.findByvSn(writeCarCard.getOtherNumber());
			if (car2==null) {
				return IccardResult.fail("此车辆不存在", "1");
			}
			saveIccard(writeCarCard);
			
		
			carRepository.updateCard(writeCarCard.getOtherNumber(), writeCarCard.getCardNumber());
			return IccardResult.success("绑定车辆成功", "0");
		} else if (writeCarCard.getCardType() == 1) {

			Driver driver = driverRepository.findByIccard(writeCarCard.getCardNumber());

			Driver card = driverRepository.findByEmployeeCard(writeCarCard.getOtherNumber());
			
			if (card==null) {
				return IccardResult.fail("此驾驶员不存在", "1");
			}
			
			if (driver != null) {
				driver.setIccard(null);
			}
			//return IccardResult.fail("此卡已经绑定过驾驶员", "1");
			saveIccard(writeCarCard);
			driverRepository.updateCard(writeCarCard.getOtherNumber(), writeCarCard.getCardNumber());
			return IccardResult.success("绑定驾驶员成功", "0");
		}
		return IccardResult.fail("绑定失败", "1");
	}

	private void saveIccard(WriteCarCard writeCarCard) {
		Iccard iccard = null;
		iccard = new Iccard();
		iccard.setCardType(writeCarCard.getCardType());
		iccard.setIccard(writeCarCard.getCardNumber());
		iccardRepository.save(iccard);
	}

	@Override
	public LedResult searchAuth(String codeOne, String codeTwo,String io) {
		//创建历史记录
		IccardUseHistory iccardUseHistory=new IccardUseHistory();
		log.info("codeOne:{}",JsonMapper.obj2String(codeOne));
		log.info("codeTwo:{}",JsonMapper.obj2String(codeTwo));
		log.info("io:{}",JsonMapper.obj2String(io));	
		
		LedResult ledResult= new LedResult();
		Iccard iccarone = iccardRepository.findByIccard(codeOne);
		Iccard iccartwo = iccardRepository.findByIccard(codeTwo);
		log.info("iccarone:{}",JsonMapper.obj2String(iccarone));
		log.info("iccartwo:{}",JsonMapper.obj2String(iccartwo));
		
		if (io.equals("i")) {
			if(iccarone!=null) {
				Driver codeOneDriver = driverRepository.findByIccard(codeOne);
				Car codeOneCar = carRepository.findByIccard(codeOne);
				//判断卡1是否是驾驶员卡
				if (codeOneDriver!=null) {
					//查询卡的类型
					Integer type=iccardRepository.findByCarType(codeOne);
					//如果是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriverAuth(0);
						ledResult.setDriver(codeOneDriver.getName());
						ledResult.setReason("超级卡");
                        saveInHistory(iccardUseHistory, ledResult.getDriver(), "超级卡", ledResult.getReason(), codeOne, "超级卡","",null);
						return ledResult;
					}
				}
				//判断卡1是否是车卡
				if (codeOneCar!=null) {
					//查询卡的类型
					Integer type=iccardRepository.findByCarType(codeOne);
					//如果是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setDriverAuth(0);
						ledResult.setCarAuth(0);
						ledResult.setDriver("超级卡");
						ledResult.setCarCode(codeOneCar.getvSn());
						ledResult.setReason("超级卡");
						saveInHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), "超级卡", codeOne,codeOneCar.getLicenseNo(),codeOneCar.getLicenseEndTime());
						return ledResult;
					}else {
						//如果不是超级卡
						ledResult.setIn(0);
						ledResult.setCardType(1);
						ledResult.setDriverAuth(0);
						ledResult.setCarAuth(0);
						ledResult.setCarCode(codeOneCar.getvSn());
						ledResult.setDriver("未知");
						ledResult.setReason("允许进入");
						saveInHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), "", codeOne,codeOneCar.getLicenseNo(),codeOneCar.getLicenseEndTime());
						return ledResult;
					}
					
				}
			}
			
			//判断卡2是否存在
			if(iccartwo!=null) {
				Driver codeTwoDriver = driverRepository.findByIccard(codeTwo);
				Car codeTwoCar = carRepository.findByIccard(codeTwo);
				//判断卡2是否绑定驾驶员
				if (codeTwoDriver!=null) {
					Integer type=iccardRepository.findByCarType(codeTwo);
					//判断卡2是否是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriverAuth(0);
						ledResult.setCarCode("超级卡");
						ledResult.setDriver(codeTwoDriver.getName());
						ledResult.setReason("超级卡");
						saveInHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), codeTwo, "超级卡","",null);
						return ledResult;
					}
				}
				//判断卡2是否绑定绑定车辆
				if (codeTwoCar!=null) {
					
					Integer type=iccardRepository.findByCarType(codeTwo);
					//判断卡的类型
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriverAuth(0);
						ledResult.setCarCode(codeTwoCar.getvSn());
						ledResult.setDriver("超级卡");
						ledResult.setReason("超级卡");
						saveInHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), "超级卡", codeTwo,codeTwoCar.getLicenseNo(),codeTwoCar.getLicenseEndTime());
						return ledResult;
					}else {
						ledResult.setIn(0);
						ledResult.setCarCode(codeTwoCar.getvSn());
						ledResult.setDriverAuth(0);
						ledResult.setCardType(1);
						ledResult.setDriver("未知");
						ledResult.setReason("正常");
						saveInHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), "", codeTwo,codeTwoCar.getLicenseNo(),codeTwoCar.getLicenseEndTime());
						return ledResult;
					}
					
				}
			}
			ledResult.setIn(1);
			ledResult.setCardType(1);
			ledResult.setCarAuth(1);
			ledResult.setCarCode("未知");
			ledResult.setDriver("未知");
			ledResult.setReason("未识别到IC卡");
			return  ledResult;
			
		}
		
		if (io.equals("o")) {
			
			if(iccarone!=null) {
				Driver codeOneDriver = driverRepository.findByIccard(codeOne);
				Car codeOneCar = carRepository.findByIccard(codeOne);
				//判断卡1是否是驾驶员卡
				if (codeOneDriver!=null) {
					//查询卡的类型
					Integer type=iccardRepository.findByCarType(codeOne);
					//如果是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriverAuth(0);
						ledResult.setDriver(codeOneDriver.getName());
						ledResult.setCarCode("超级卡");
						ledResult.setReason("超级卡");
						saveOutHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), codeOne, "超级卡","",null);
						carRepository.updateDriverByIccard(ledResult.getDriver(),codeTwo);
						return ledResult;
					}
				}
				//判断卡1是否是车卡
				if (codeOneCar!=null) {
					//查询卡的类型
					Integer type=iccardRepository.findByCarType(codeOne);
					//如果是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setCarCode(codeOneCar.getvSn());
						ledResult.setDriverAuth(0);
						ledResult.setDriver("超级卡");
						ledResult.setReason("超级卡");
						saveOutHistory(iccardUseHistory, "超级卡", ledResult.getCarCode(), ledResult.getReason(), "超级卡", codeOne,codeOneCar.getLicenseNo(),codeOneCar.getLicenseEndTime());
						carRepository.updateDriverByIccard(ledResult.getDriver(),codeTwo);
						return ledResult;
					}
				}
			}
			
			//判断卡2是否存在
			if(iccartwo!=null) {
				Driver codeTwoDriver = driverRepository.findByIccard(codeTwo);
				Car codeTwoCar = carRepository.findByIccard(codeTwo);
				//判断卡2是否绑定驾驶员
				if (codeTwoDriver!=null) {
					Integer type=iccardRepository.findByCarType(codeTwo);
					//判断卡2是否是超级卡
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriver(codeTwoDriver.getName());
						ledResult.setCarCode("超级卡");
						ledResult.setDriverAuth(0);
						ledResult.setReason("超级卡");
						saveOutHistory(iccardUseHistory, ledResult.getDriver(), "超级卡", ledResult.getReason(), codeTwo, "超级卡","",null);
						carRepository.updateDriverByIccard(ledResult.getDriver(),codeTwo);
						return ledResult;
					}
				}
				//判断卡2是否绑定绑定车辆
				if (codeTwoCar!=null) {	
					Integer type=iccardRepository.findByCarType(codeTwo);
					//判断卡的类型
					if (type==255) {
						ledResult.setIn(0);
						ledResult.setCardType(0);
						ledResult.setCarAuth(0);
						ledResult.setDriverAuth(0);
						ledResult.setDriver("超级卡");
						ledResult.setCarCode(codeTwoCar.getvSn());
						ledResult.setReason("超级卡");
						saveOutHistory(iccardUseHistory, ledResult.getDriver(), ledResult.getCarCode(), ledResult.getReason(), "超级卡", codeTwo,codeTwoCar.getLicenseNo(),codeTwoCar.getLicenseEndTime());
						carRepository.updateDriverByIccard(ledResult.getDriver(),codeTwo);
						return ledResult;
					}
				}
			}

		    //如果没有超级,就必须两张卡都扫到 
			//必须是一张车卡  一张人卡
			if (StringUtils.isNotBlank(codeOne)&&StringUtils.isNotBlank(codeTwo)) {
				String driverCode="";
				String carCode="";
				Driver outDriver=null;
				Car outCar=null;
				//给车卡赋值
				outDriver = driverRepository.findByIccard(codeOne);
				if (outDriver!=null) {
					driverCode=codeOne;
				}
				
				if (StringUtils.isBlank(driverCode)) {
					outDriver= 	driverRepository.findByIccard(codeTwo);
					if (outDriver!=null) {
						driverCode=codeTwo;
					}
				}
				//给驾驶员卡赋值
			    outCar = carRepository.findByIccard(codeOne);
			    if (outCar!=null) {
					carCode =codeOne;
				}
			    
				if (StringUtils.isBlank(carCode)) {
					outCar = carRepository.findByIccard(codeTwo);
					if (outCar!=null) {
						carCode=codeTwo;
					}	
				}
				
				if (outDriver!=null&&outCar!=null) {
					
					if ("禁止".equals(outDriver.getIsallow())) {
						ledResult.setCardType(1);
						ledResult.setCarAuth(1);
						ledResult.setDriver(outDriver.getName());
						ledResult.setDriverAuth(1);
						ledResult.setCarCode(outCar.getvSn());
						ledResult.setReason("驾驶员禁止驾驶");
						return ledResult;
					}
					
					if (StringUtils.isBlank(outCar.getInsNo())) {
						ledResult.setCardType(1);
						ledResult.setCarAuth(1);
						ledResult.setDriverAuth(1);
						ledResult.setDriver(outDriver.getName());
						ledResult.setCarCode(outCar.getvSn());
						ledResult.setReason("车辆无保险");
						return ledResult;
					}
					if (StringUtils.isBlank(outCar.getLicenseNo())) {
						ledResult.setCardType(1);
						ledResult.setCarAuth(1);
						ledResult.setDriverAuth(1);
						ledResult.setDriver(outDriver.getName());
						ledResult.setCarCode(outCar.getvSn());
						ledResult.setReason("车辆无牌照");
						return ledResult;
					}
					
					if (outCar.getEndTime().getTime()-System.currentTimeMillis()<=0) {
						
						ledResult.setCardType(1);
						ledResult.setCarAuth(1);
						ledResult.setDriverAuth(1);
						ledResult.setDriver(outDriver.getName());
						ledResult.setCarCode(outCar.getvSn());
						ledResult.setReason("保险过期");
						return ledResult;
					}
					if (outCar.getLicenseEndTime().getTime()-System.currentTimeMillis()<=0) {
						ledResult.setCardType(1);
						ledResult.setCarAuth(1);
						ledResult.setDriverAuth(1);
						ledResult.setDriver(outDriver.getName());
						ledResult.setCarCode(outCar.getvSn());
						ledResult.setReason("牌照过期");
						return ledResult;
					}
					ledResult.setCardType(0);
					ledResult.setCarAuth(0);
					ledResult.setCardType(1);
					ledResult.setDriverAuth(0);
					ledResult.setDriver(outDriver.getName());
					ledResult.setCarCode(outCar.getvSn());
					ledResult.setReason("允许通过");
					
					//保存历史记录
					saveOutHistory(iccardUseHistory, ledResult.getDriver(), outCar.getvSn(), ledResult.getReason(), driverCode, carCode,outCar.getLicenseNo(),outCar.getLicenseEndTime());
					carRepository.updateDriverByIccard(outDriver.getName(),carCode);
				}else {
					ledResult.setCardType(1);
					ledResult.setCarAuth(1);
					ledResult.setDriverAuth(1);
					ledResult.setReason("车卡或者人卡无效");
					return ledResult;	
				}

			}else {
				ledResult.setIn(1);
				ledResult.setCardType(1);
				ledResult.setCarAuth(1);
				ledResult.setDriverAuth(1);
				ledResult.setReason("必须扫到车卡和人卡");
				return ledResult;
			}
			
		 return ledResult;
		}
		
		throw new PermissionException("异常");
	}

	private void saveOutHistory(IccardUseHistory iccardUseHistory,String driverName,String vSn ,String reason, String driverCode,
			String carCode,String lno,Date lendtime) {
		iccardUseHistory.setLicenseEndTime(lendtime);
		iccardUseHistory.setDriverName(driverName);
		iccardUseHistory.setLicenseNo(lno);
	      iccardUseHistory.setCariccard(carCode);
	      iccardUseHistory.setDrivercard(driverCode);
	      iccardUseHistory.setError(reason);
	      iccardUseHistory.setCarSn(vSn);
	      iccardUseHistory.setUpdateTime(new Date());
	      iccardUseHistory.setIo("o");
	      this.insert(iccardUseHistory);
	}

	private void saveInHistory(IccardUseHistory iccardUseHistory,String driverName,String vSn ,String reason, String driverCode,
			String carCode,String lno,Date lendtime) {
		iccardUseHistory.setLicenseEndTime(lendtime);
		iccardUseHistory.setLicenseNo(lno);
		  iccardUseHistory.setDriverName(driverName);
		  iccardUseHistory.setDrivercard(driverCode);
		  iccardUseHistory.setCariccard(carCode);
		  iccardUseHistory.setError(reason);
		  iccardUseHistory.setCarSn(vSn);
		  iccardUseHistory.setUpdateTime(new Date());
		  iccardUseHistory.setIo("i");
		  this.insert(iccardUseHistory);
	}

	@Override
	public IccardResult carIn(String codeOne, String codeTwo) {
		Iccard iccardOne = iccardRepository.findByIccard(codeOne);
		Iccard iccardTwo = iccardRepository.findByIccard(codeTwo);
		
		if (iccardOne!=null&iccardTwo!=null) {
			return IccardResult.success("允许进", "0");
		}
		return IccardResult.fail("禁止入内", "1");
	}
}
