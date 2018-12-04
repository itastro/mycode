package cn.shengrui.management.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.beans.PageQuery;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.util.StringUtil;
import cn.shengrui.param.FileSearch;
import cn.shengrui.management.service.FileService;
import cn.shengrui.param.SelectFileType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @ClassName FileController
 * @Description TODO
 * @Date 2018/10/17 9:38
 * @Author itastro
 * @Version 1.0
 **/
@Slf4j

@RestController
@RequestMapping("/tcufile")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 多文件删除
     *
     * @param
     * @return
     */
    @OperationLog(action = "文件上传", type = OperationType.OTHERT)
    @PostMapping(value = "/upload")
    @RequiresPermissions(value = "file:up", logical = Logical.OR)
    public JsonResult upload(HttpServletRequest request, @RequestParam(value = "type", defaultValue = "1") Integer type) {
        log.info("type:{}", type);
        MultipartFile file = null;
        if (request instanceof MultipartHttpServletRequest) {
            file = ((MultipartHttpServletRequest) request).getFile("file");
        }
        return fileService.upload(file, type);
    }

    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/upload/batch")
    public JsonResult batchUpload(HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return JsonResult.fail("You failed to upload " + i, e.getMessage());

                }
            } else {
                return JsonResult.fail("You failed to upload " + i, "文件为空");

            }
        }
        return JsonResult.fail("文件上传成功");
    }

    @OperationLog(action = "文件删除", type = OperationType.DELETE)
    @RequiresPermissions(value = "file:delete", logical = Logical.OR)
    @PostMapping("/delete")
    public JsonResult delete(String ids) {

        if (StringUtils.isBlank(ids)) {
            return JsonResult.fail("请选择需要删除的文件");
        }
        List<Integer> list = StringUtil.splitToListInt(ids);
        return fileService.delete(list);
    }

    @OperationLog(action = "文件查询", type = OperationType.QUERY)
    @RequiresPermissions(value = "file:list", logical = Logical.OR)
    @GetMapping("/pageQuery")

    public JsonResult pageQuery(PageQuery pageQuery, FileSearch fileSearch) {

        return fileService.pageQuery(pageQuery, fileSearch);
    }

    @GetMapping("/findAll")
    @RequiresUser
    public JsonResult findAll(Integer type) {
        return fileService.findAll(type);
    }

    @GetMapping("/download")
    public Object download(String fileName, String savePath) {
        String name = fileName.replaceAll(" ", "");
        return fileService.download(name, savePath);
    }
}
