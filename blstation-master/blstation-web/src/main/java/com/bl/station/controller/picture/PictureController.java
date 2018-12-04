package com.bl.station.controller.picture;

import com.bl.station.service.picture.PictrueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/pic")
public class PictureController {


    @Autowired
    private PictrueService pictrueService;

    @RequestMapping(value = "/uploadpic", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return pictrueService.upload(file);

    }
}
