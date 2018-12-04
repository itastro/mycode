package cn.shengrui.system.controller;

import cn.shengrui.common.annotation.OperationLog;
import cn.shengrui.common.base.BaseController;
import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.constant.SysUserConstant;
import cn.shengrui.common.enums.OperationType;
import cn.shengrui.common.enums.ResultEnum;
import cn.shengrui.common.exception.PermissionException;
import cn.shengrui.dto.SysUserDto;
import cn.shengrui.param.SysUserParam;
import cn.shengrui.system.entity.SysUser;
import cn.shengrui.system.service.SysTreeService;
import cn.shengrui.system.shiro.ShiroUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @ClassName UserController
 * @Description TODO
 * @Date 2018/10/8 10:11
 * @Author itastro
 * @Version 1.0
 **/

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private HttpSession session;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private SysTreeService sysTreeService;

    @PostMapping("/login")
    public JsonResult login() {


        //获取当前的主体
        Subject subject = SecurityUtils.getSubject();
        //获取from 表单的用户名
        String username = request.getParameter("username");
        //获取from表单的密码
        String password = request.getParameter("password");
        //获取from表单的验证码
        String vrifyCode = request.getParameter("vrifyCode");
        //从session中获取验证码
        String code = (String) session.getAttribute("vrifyCode");
        //获取验证码后删除验证码
        session.removeAttribute("vrifyCode");

        password = ShiroUtils.sha256(password, SysUserConstant.SALT);
        boolean rememberMe = true;
        //如果有点击  记住我
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password, rememberMe);

        try {
            //登录成功 保存session
            subject.login(usernamePasswordToken);
            //获取当前登录的用户
            SysUser user = (SysUser) subject.getPrincipal();
            //设置到session
            session.setAttribute("user", user);


            SysUserDto sysUserDto = SysUserDto.adapt(user);
            sysUserDto.setToken(subject.getSession().getId().toString());
            return JsonResult.success("登录成功", sysUserDto);
        } catch (UnknownAccountException e) {
            return JsonResult.fail("用户名或者密码错误", null);
        } catch (IncorrectCredentialsException e) {
            return JsonResult.fail("用户名或者密码错误", null);
        } catch (LockedAccountException e) {
            return JsonResult.fail("账号被冻结", null);
        }
    }


    @GetMapping("/defaultKaptcha")
    public void defaultKaptcha() throws Exception {

        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();

            request.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();

    }


    @PostMapping("/userupdate ")
    @OperationLog(action = "用户自己更新用户信息", type = OperationType.UPDATE)
    public JsonResult userupdate(@Valid SysUserParam sysUserParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.fail(bindingResult.getFieldError().getDefaultMessage(), null);
        }
        return JsonResult.success("更新成功", null);
    }

    @PostMapping("/logout")
    public JsonResult loginOut() {
        // 基于Shiro的退出
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //session.removeAttribute("user");
        return JsonResult.success("用户退出成功", null);
    }

    @RequestMapping(value = "/unauth")
    public JsonResult unauth() {
        return JsonResult.build(300, "请进行登录", "请进行登录");
    }

    @RequestMapping(value = "/unauthorizedUrl")
    public JsonResult unauthorizedUrl() {
        throw new PermissionException(ResultEnum.ACL_ERROR);
    }

    @GetMapping("/getUserMenuTree")
    public JsonResult getUserMenuTree() {

        return sysTreeService.userMenuTree();
    }

}
