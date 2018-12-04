package com.bl.station.mapper;

import com.bl.station.entity.User;
import com.bl.station.entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("username") String username ,@Param("password") String  password);

    List<User>  pageQuery();
}