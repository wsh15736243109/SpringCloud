package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.DepartmentModel;
import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.model.SecurityCodeModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    //用户注册
    @Insert("INSERT INTO user_info(nickname,phone,pwd,register_time,enable) values(#{nickname},#{phone},#{pwd},#{register_time},0)")
    int register_user(PersonModel personModel);

    //根据手机号查询是否存在
    @Select("SELECT COUNT(*) FROM user_info WHERE phone = #{phone}")
    int getCountByPhone(@Param("phone") String phone);

    //通过手机号查询该用户所有信息
    @Select("SELECT * FROM user_info WHERE phone = #{phone}")
    PersonModel findByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM department_table")
    List<DepartmentModel> getAllDepartment();

    @Insert("INSERT INTO security_code(code_value,accepter,send_time,code_status,type) VALUES(#{code_value},#{accepter},#{send_time},#{code_status},#{type})")
    int securityCodeAdd(SecurityCodeModel model);

    @Select("SELECT * FROM security_code WHERE accepter = #{accepter} and code_value=#{code}  and type=#{type} ORDER BY send_time DESC LIMIT 1")
    SecurityCodeModel isValidCode(@Param("code") String code, @Param("accepter") String phone, @Param("type") int type);

    @Update("UPDATE user_info SET pwd= #{pwd} where phone = #{phone}")
    int updateUserPassword(@Param("phone") String phone, @Param("pwd") String pwd);

    @Update("UPDATE security_code SET code_status= #{code_status} where id = #{id}")
    int updateSecurityCode(SecurityCodeModel securityCodeModel);
}
