package com.ccl.userboot.medicinestore.dto.resp;

import lombok.Data;

@Data
public class DockerListRespDTO {
    private Integer dockerId;
    private String dockerName;
    private String dockerWorkload;
}
