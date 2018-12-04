package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonMapper;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.management.entity.TFile;
import cn.shengrui.management.mapper.TFileMapper;
import cn.shengrui.param.SelectFileType;
import cn.shengrui.param.TcuParam;
import cn.shengrui.param.TcuSearch;
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
public class TcuServiceTest {


    @Autowired
    private TcuService tcuService;

    @Autowired
    private FileService tFileMapper;

    @Test
    public void save() throws Exception {
        List<Integer> list = Lists.newArrayList();
        for (int i = 1080; i < 1100; i++) {
            TcuParam tcuParam = new TcuParam();
            tcuParam.setTcuType("CTC");
            tcuParam.setTcuCode("1001" + i);
            tcuParam.setBootVersion("1001");
            tcuParam.setSupplier("中兴");
            tcuParam.setSupCode("cccccc" + i);
            list.add(1);
            list.add(2);
            list.add(3);
            JsonResult jsonResult = tcuService.save(tcuParam);
            log.info(JsonMapper.obj2String(jsonResult));

        }
    }

    @Test
    public void update() throws Exception {


        TcuParam tcuParam = new TcuParam();
        tcuParam.setId(1);
        tcuParam.setTcuType("CTCCCCCC");
        tcuParam.setTcuCode("10012");
        tcuParam.setBootVersion("1001");
        tcuParam.setSupplier("中兴");
        tcuParam.setSupCode("cccccc");

        JsonResult jsonResult = tcuService.update(tcuParam);
        log.info(JsonMapper.obj2String(jsonResult));
    }

    @Test
    public void delete() throws Exception {


    }

    @Test
    public void pageQuery() throws Exception {

        TcuSearch companySearch = new TcuSearch();
        //scompanySearch.setTucCode("100");

        PageQuery pageQuery = new PageQuery();

        pageQuery.setPageNo(2);
        pageQuery.setSize(2);

        JsonResult jsonResult = tcuService.pageQuery(pageQuery, companySearch);

        log.info("jsonResult:{}", JsonMapper.obj2String(jsonResult));
    }

    @Test
    public void checkExist() throws Exception {
    }

    @Test
    public void get() throws Exception {

        SelectFileType selectFileType = new SelectFileType();
        selectFileType.setType(1);
        JsonResult jsonResult = tFileMapper.findAll(1);

    }
}