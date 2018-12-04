package com.bl.station.controller.file;

/**
 * @ClassName FileController
 * @Description TODO
 * @Date 2018/8/20 14:05
 * @Author itastro
 * @Version 1.0
 **/

import com.bl.station.param.SourceParam;
import com.bl.station.service.file.FileService;
import com.bl.station.utils.StationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public StationResult upload(SourceParam sourceParam) throws  Exception {

        return fileService.upload(sourceParam);

    }


}
