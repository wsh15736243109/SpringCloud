package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.PersonModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    //用户注册
    @Insert("INSERT INTO user_info(nickname,phone,pwd,register_time,enable) values(#{nickname},#{phone},#{pwd},#{register_time},0)")
    int register_user(PersonModel personModel);

    //根据手机号查询是否存在
    @Select("SELECT COUNT(*) FROM user_info WHERE phone = #{phone}")
    int getCountByPhone(@Param("phone")String phone);

    //通过手机号查询该用户所有信息
    @Select("SELECT * FROM user_info WHERE phone = #{phone}")
    PersonModel findByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM wsh_person")
    List<PersonModel> getAllPerson();
}
