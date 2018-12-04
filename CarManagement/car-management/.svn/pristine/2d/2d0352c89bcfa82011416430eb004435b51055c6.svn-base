package com.bailian.car.carm;

import java.io.IOException;
import java.util.List;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.bailian.car.beans.PageQuery;
import com.bailian.car.dao.CarMaintain.ScreenRepository;
import com.bailian.car.dao.cars.car.CarPositionRepository;
import com.bailian.car.dao.cars.check.HIResultReposity;
import com.bailian.car.dao.cars.project.ProjectRepository;
import com.bailian.car.dao.oil.OilCardRepository;
import com.bailian.car.dao.system.MenuRepository;
import com.bailian.car.domain.carmaintain.Screen;
import com.bailian.car.domain.system.Menu;
import com.bailian.car.utils.DateUtils;
import com.bailian.car.utils.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Transactional
@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class CarmTest {
	@Autowired
	private ScreenRepository screenRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void test1() {
		// 创建排序规则
		Sort sort = new Sort(Direction.DESC, "applyTime");
		// 分页查询
		PageQuery query = new PageQuery();
		Pageable pageable = new PageRequest(query.getPage(), query.getSize(), sort);
		String status = "已注销";
		Page<Screen> pageData = screenRepository.findAll(status, pageable);
	}

	@Autowired
	private MenuRepository menuRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void xi() {
		List<String> list = projectRepository.likeProjectSn("123");
		log.info("list:{}", JsonMapper.obj2String(list));
	}

	@Test
	public void testfildUpload() throws Exception, IOException, MyException {
		// 加载配置文件
		ClientGlobal.init("E:/bailian/CarManagement/car-management/src/test/resources/resource/client.conf");
		// 创建一个trackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 使用TranckerClient对象.获得一个tranckServer
		TrackerServer trackerServer = trackerClient.getConnection();
		// 创建一个StorageServer的引用.值为null
		StorageServer storageServer = null;
		// 创建一个StorageCliet对象,需要两个参数TrakerServer对象 storageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 使用Storageclient对象上传图片
		String[] strings = storageClient.upload_file("C:/t01e9be3b3e7e12e866.jpg", "jpg", null);
		// 返回数组 包含组名和路径
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
