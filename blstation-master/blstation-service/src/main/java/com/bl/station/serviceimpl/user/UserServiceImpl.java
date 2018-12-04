package com.bl.station.serviceimpl.user;

import com.bl.station.exception.PermissionException;
import com.bl.station.page.PageInfo;
import com.bl.station.mapper.UserMapper;
import com.bl.station.entity.User;
import com.bl.station.param.LoginParam;
import com.bl.station.page.PageParam;
import com.bl.station.service.user.UserService;
import com.bl.station.utils.MD5Utils;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Slf4j
@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserMapper userMapper;


    @Override
    public StationResult login(LoginParam loginParam, HttpServletRequest httpServletRequest) {
       //vrifyCode

        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        log.info("vrifyCode:{}", vrifyCode);
        String code = loginParam.getVrifyCode();
        log.info("code:{}", code);
        if (StringUtils.isBlank(code)) {
            return StationResult.fail("验证码错误");
        }

        if (!code.equals(vrifyCode)) {
            return StationResult.fail("验证码错误");
        }
        String passWord = MD5Utils.toMD5(loginParam.getPassWord(), loginParam.getUserName());

        log.info("passWord:{}", passWord);
        User user = userMapper.login(loginParam.getUserName(), passWord);

        if (user == null) {
            return StationResult.fail("用户名或密码错误");
        }
        httpServletRequest.getSession().setAttribute("user", user);
        return StationResult.success("登录成功");
    }

    @Override
    public StationResult addUser(User user) {

        User token = (User) request.getSession().getAttribute("user");
        if (token == null) {
            throw new PermissionException("请进行登录");
        }
        user.setCreatetime(new Date());

        user.setOperator(token.getUsername());

        if (StringUtils.isBlank(user.getUsername())) {
            StationResult.fail("账户不能为空");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            StationResult.fail("密码不能为空");
        }
        String password = MD5Utils.toMD5(user.getPassword(), user.getUsername());
        user.setPassword(password);

        int i = userMapper.insert(user);

        return StationResult.success("添加账户成功");
    }

    @Override
    public StationResult delete(Integer id) {

        int i = userMapper.deleteByPrimaryKey(id);

        log.info("i:{}", i);
        return StationResult.success("删除成功");
    }


    @Override
    public PageInfo<User> pageQuery(PageParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getSize());
        List<User> users = userMapper.pageQuery();

        PageInfo result = new PageInfo<User>(users);
        return result;
    }
}
