package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class DoctorListRespDTO {
    private Integer doctorId;
    private String doctorName;
    private String doctorWorkload;
}
