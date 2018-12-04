package com.bl.station.service.user;

import com.bl.station.page.PageInfo;
import com.bl.station.entity.User;
import com.bl.station.param.LoginParam;
import com.bl.station.page.PageParam;
import com.bl.station.utils.StationResult;

import javax.servlet.http.HttpServletRequest;


public interface UserService {


    StationResult addUser(User user);


    StationResult login(LoginParam LoginParam, HttpServletRequest httpServletRequest);

    StationResult delete(Integer id);

    PageInfo<User> pageQuery(PageParam queryParam);

}
