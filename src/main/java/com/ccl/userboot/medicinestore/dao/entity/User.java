package com.ccl.userboot.medicinestore.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)

    private Integer userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private UserStatus userStatus;

    private Date createdAt;

    private Integer roleId;
}
