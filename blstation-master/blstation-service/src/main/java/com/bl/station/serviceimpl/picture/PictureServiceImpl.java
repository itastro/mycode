package com.bl.station.serviceimpl.picture;

import com.bl.station.exception.CustomException;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Transactional
@Component
public class PictureServiceImpl implements PictrueService {

    @Autowired
    private FastDFSClientWrapper clientConfig;


    @Override
    public String upload(MultipartFile file) throws  Exception{
        String url = "";

        if (file==null){
            throw new CustomException("文件不能为空");
        }

            long i = file.getSize();
            if (i > 1024*1024*10) {
                throw new CustomException("文件不能大于10M");
            }
            url = clientConfig.uploadFile(file);


        return url;
    }
}
