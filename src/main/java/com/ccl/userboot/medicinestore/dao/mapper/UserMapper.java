package com.ccl.userboot.medicinestore.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccl.userboot.medicinestore.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM Users WHERE user_email = #{userEmail}")
    User findByEmail(String userEmail);
}
