package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.PersonModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM wsh_person WHERE name = #{name}")
    PersonModel findByName(@Param("name") String name);

    @Select("SELECT * FROM wsh_person")
    List<PersonModel> getAllPerson();
}
