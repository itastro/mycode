package com.bl.station.serviceimpl.file;

import com.bl.station.entity.Source;
import com.bl.station.exception.CustomException;
import com.bl.station.param.SourceParam;
import com.bl.station.service.file.FileService;
import com.bl.station.utils.FastDFSClientWrapper;
import com.bl.station.utils.StationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileServiceImpl
 * @Description TODO
 * @Date 2018/8/20 14:06
 * @Author itastro
 * @Version 1.0
 **/

@Transactional
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Autowired
    private FileService fileService;


    @Override
    public StationResult upload(SourceParam sourceParam) throws Exception{
        MultipartFile file = sourceParam.getFile();
        Source source = new Source();
        String url = "";


            if (file == null) {
                throw new CustomException("文件不能为空");
            }

            long i = file.getSize();
            if (i > 1024 * 1024*10) {
                throw new CustomException("文件不能大于10M");
            }
            url = fastDFSClientWrapper.uploadFile(file);


        return StationResult.success("上传成功");


    }
}
