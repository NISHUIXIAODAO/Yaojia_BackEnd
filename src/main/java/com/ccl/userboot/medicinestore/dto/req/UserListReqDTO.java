package com.ccl.userboot.medicinestore.dto.req;

import lombok.Data;

@Data
public class UserListReqDTO {
    private Integer size;
    private Integer offest;
    // TODO token 放在请求头里
}
