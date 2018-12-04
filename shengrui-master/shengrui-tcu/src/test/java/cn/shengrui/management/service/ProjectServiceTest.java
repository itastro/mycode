package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.ProjectParam;
import cn.shengrui.param.ProjectSearch;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

@Slf4j
public class ProjectServiceTest {


    @Autowired
    private ProjectService projectService;

    @Test
    public void save() throws Exception {

        ProjectParam projectParam = new ProjectParam();

        projectParam.setCompany_id(5);
        projectParam.setName("天上人间");
        List list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        JsonResult jsonResult = projectService.save(projectParam);
        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));

    }

    @Test
    public void update() throws Exception {
        ProjectParam projectParam = new ProjectParam();
        projectParam.setId(13);
        projectParam.setCompany_id(5);
        projectParam.setName("天上人间情");
        List list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        JsonResult jsonResult = projectService.save(projectParam);
        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));
    }

    @Test
    public void delete() throws Exception {

        List<Integer> ids = Lists.newArrayList();
        ids.add(13);

        JsonResult result = projectService.delete(ids);
        log.info("result:{}", JsonMapper.obj2String(result));
    }

    @Test
    public void pageQuery() throws Exception {

        PageQuery pageQuery = new PageQuery();
        ProjectSearch projectSearch = new ProjectSearch();
        JsonResult jsonResult = projectService.pageQuery(pageQuery, projectSearch);

        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));
    }

    @Test
    public void checkExist() throws Exception {
    }

}