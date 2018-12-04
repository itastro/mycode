package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.CompanyParam;
import cn.shengrui.param.CompanySearch;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyServiceTest {


    @Autowired
    private CompanyService companyService;

    @Test
    public void save() throws Exception {

        CompanyParam companyParam = new CompanyParam();

        for (int i = 0; i < 100; i++) {
            companyParam.setName("王" + i);
            companyParam.setRemark("测试" + i);

            companyService.save(companyParam);
        }
    }

    @Test
    public void delete() throws Exception {

        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        companyService.delete(list);

    }

    @Test
    public void update() throws Exception {

        CompanyParam companyParam = new CompanyParam();
        companyParam.setId(88);
        companyParam.setName("王大锤");
        companyParam.setRemark("你好");
        companyService.update(companyParam);
    }

    @Test
    public void pageQuery() throws Exception {

        CompanySearch companySearch = new CompanySearch();
        companySearch.setName("王");

        PageQuery pageQuery = new PageQuery();

        pageQuery.setPageNo(2);
        pageQuery.setSize(2);

        JsonResult jsonResult = companyService.pageQuery(pageQuery, companySearch);

        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));


    }

}