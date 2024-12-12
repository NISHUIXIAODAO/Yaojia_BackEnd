package com.ccl.userboot.medicinestore.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
@Getter
@Setter
public class Dockers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "docker_id", type = IdType.AUTO)
    private Integer dockerId;

    private String dockerName;

    private String dockerWorkload;


}
