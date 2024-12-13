package com.ccl.userboot.medicinestore.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ccl.userboot.medicinestore.dao.entity.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("Users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;

    private String userName;

    private String userEmail;

    private String userPassage;

    private UserStatus userStatus;

    private Date createdAt;

    private Integer roleId;
}
