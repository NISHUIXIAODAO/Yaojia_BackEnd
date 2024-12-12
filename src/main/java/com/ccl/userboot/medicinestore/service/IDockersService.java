package com.ccl.userboot.medicinestore.service;

import com.ccl.userboot.medicinestore.dao.entity.Dockers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ccl.userboot.medicinestore.dto.resp.DockerListRespDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
public interface IDockersService extends IService<Dockers> {
    List<DockerListRespDTO> getDockerList(Integer size, Integer offset);

}
