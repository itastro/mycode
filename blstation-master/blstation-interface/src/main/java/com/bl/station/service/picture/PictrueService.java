package com.bl.station.service.picture;

import org.springframework.web.multipart.MultipartFile;


public interface PictrueService {

    String upload(MultipartFile file) throws  Exception;
}
