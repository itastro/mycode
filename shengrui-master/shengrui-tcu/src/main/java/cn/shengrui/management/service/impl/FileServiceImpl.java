package cn.shengrui.management.service.impl;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageInfo;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.constant.SysStatus;
import cn.shengrui.common.util.FTPUtil;
import cn.shengrui.common.util.IpUtil;
import cn.shengrui.management.entity.TFile;
import cn.shengrui.management.mapper.TFileMapper;
import cn.shengrui.param.FileSearch;
import cn.shengrui.management.service.FileService;
import cn.shengrui.param.SelectFileType;
import cn.shengrui.system.shiro.ShiroUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FileServiceImpl
 * @Description 上传文件的实现类
 * @Date 2018/10/17 9:53
 * @Author itastro
 * @Version 1.0
 **/

@Service
@Transactional
public class FileServiceImpl implements FileService {

  @Autowired
  private FTPUtil ftpUtil;
  @Autowired
  private HttpServletRequest request;

  @Autowired
  private TFileMapper tFileMapper;

  @Override
  public JsonResult upload(MultipartFile file, Integer type) {
    String url = "";
    TFile tFile = TFile.builder().name(file.getOriginalFilename()).build();

    JsonResult jsonResult = ftpUtil.webUploadLocalFile(file, type);
    url = jsonResult.getData().toString();

    if (jsonResult.getCode() == 1) {
      tFile.setOperateIp(IpUtil.getUserIP(request));
      //TODO
      tFile.setOperator(ShiroUtils.getUserName());
      tFile.setUploadtime(new Date());
      tFile.setUrl(url);
      tFile.setStatus(SysStatus.USE);
      tFile.setType(type);
      tFileMapper.insert(tFile);
      return JsonResult.success("文件上传成功", null);
    }

    return jsonResult;
  }

  @Override
  public JsonResult batchUpload(List<MultipartFile> files) {
    return null;
  }


  @Override
  public JsonResult delete(List<Integer> ids) {
    //boolean flag = false;
    String name = "";
    for (Integer id : ids) {
      TFile tFile = tFileMapper.selectByPrimaryKey(id);
      tFile.setStatus(SysStatus.DELETE);
      tFileMapper.updateByPrimaryKeySelective(tFile);
      //切底删除
      tFileMapper.deleteByPrimaryKey(id);
    }
    return JsonResult.success("文件删除成功", ids);
  }

  @Override
  public JsonResult pageQuery(PageQuery pageQuery, FileSearch fileSearch) {
    PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getSize());

    List<TFile> page = tFileMapper.pageQuery(fileSearch);

    PageInfo<TFile> result = new PageInfo<TFile>(page);
    return JsonResult.success("查询成功", result);
  }

  @Override
  public JsonResult findAll(Integer type) {
    List<TFile> list = tFileMapper.findFileByType(type);
    return JsonResult.success("成功", list);
  }


  @Override
  public Object download(String name, String savePath) {
//(String ftpPath, String fileName, String savePath) {
    boolean flag = FTPUtil.downloadFile(FTPUtil.BASE_PATH + FTPUtil.TCU_PATH, name, savePath);

    if (flag) {
      JsonResult.build(1, "文件下载成功");
    }
    return JsonResult.build(0, "文件下载失败");
  }

  @Override
  public JsonResult findShengruiScript() {

    List<TFile> tFiles = tFileMapper.findByShengruiScript();
    return null;
  }

  @Override
  public JsonResult findProviderScript() {
    List<TFile> tFiles = tFileMapper.providerByShengruiScript();
    return null;
  }
}
