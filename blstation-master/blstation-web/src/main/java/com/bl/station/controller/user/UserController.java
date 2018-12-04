package com.bl.station.controller.user;


import com.bl.station.page.PageInfo;
import com.bl.station.entity.User;
import com.bl.station.exception.CustomException;
import com.bl.station.exception.ParamException;
import com.bl.station.param.LoginParam;
import com.bl.station.page.PageParam;
import com.bl.station.service.user.UserService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author itastro
 */
@Api(description = "用户API")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(notes = "添加用户", value = "添加用户")
    @PostMapping("/add")
    public StationResult addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @GetMapping("/{id}")

    public String test(@PathVariable(name = "id") Integer id) throws CustomException {

        if (id == 1) {
            throw new CustomException("id不能为1");

        } else if (id == 2) {
            throw new ParamException("id不能为2");
        }

        return "SUCCESS";
    }

    @ApiOperation(notes = "获取验证码", value = "获取验证码")
    @GetMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();

            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @ApiOperation(notes = "登录", value = "登录")
    @RequestMapping("/login")
    public StationResult login(@RequestBody LoginParam loginParam) {

        log.info("进入登录的方法");
        log.info("loginParam：{}", JsonMapper.obj2String(loginParam));
        StationResult stationResult = userService.login(loginParam, request);

        return stationResult;
    }

    @ApiOperation(notes = "删除用户", value = "删除用户")
    @PostMapping("/delete/{id}")
    public StationResult delete(@PathVariable(name = "id") Integer id) {
        log.info("id:{}", id);
        return userService.delete(id);
    }

    @ApiOperation(notes = "查询所有用户", value = "查询所有用户")
    @GetMapping("/findAll")
    public PageInfo<User> findAllUser(PageParam pageParam) {
        PageInfo result = userService.pageQuery(pageParam);
        return result;
    }


}
