package cn.shengrui.management.service;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.param.FileSearch;
import cn.shengrui.param.SelectFileType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName FileService
 * @Description TODO
 * @Date 2018/10/17 9:53
 * @Author itastro
 * @Version 1.0
 **/
public interface FileService {

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    JsonResult upload(MultipartFile file, Integer type);

    /**
     * 上传多个文件
     *
     * @param files
     * @return
     */
    JsonResult batchUpload(List<MultipartFile> files);


    /**
     * 文件删除
     *
     * @param ids
     * @return
     */
    JsonResult delete(List<Integer> ids);


    /**
     * 文件查询
     */
    JsonResult pageQuery(PageQuery pageQuery, FileSearch fileSearch);

    /**
     * 查询所有TCU文件
     */

    JsonResult findAll(Integer type);


    Object download(String name, String savePath);


    JsonResult findShengruiScript();

    JsonResult findProviderScript();
}