package com.ccl.userboot.medicinestore.dto.req;

import lombok.Data;

@Data
public class UserListReqDTO {
    private Integer size;
    private Integer offset;
    // TODO token 放在请求头里
}
