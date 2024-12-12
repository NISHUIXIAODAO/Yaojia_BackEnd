package com.ccl.userboot.medicinestore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccl.userboot.medicinestore.dao.entity.Dockers;
import com.ccl.userboot.medicinestore.dao.mapper.DockersMapper;
import com.ccl.userboot.medicinestore.dto.resp.DockerListRespDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccl.userboot.medicinestore.service.IDockersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccl
 * @since 2024-12-12
 */
@Service
public class DockerServiceImpl extends ServiceImpl<DockersMapper, Dockers> implements IDockersService {
    @Override
    public List<DockerListRespDTO> getDockerList(Integer size, Integer offset) {
        Page<Dockers> page = new Page<>(offset, size);
        IPage<Dockers> dockersPage = baseMapper.selectPage(
                page, new QueryWrapper<>()
        );
        List<Dockers> dockers = dockersPage.getRecords();
        return convertDockerListToDtoList(dockers);
    }

    public List<DockerListRespDTO> convertDockerListToDtoList(List<Dockers> dockers) {
        List<DockerListRespDTO> dtoList = new ArrayList<>();
        for (Dockers docker : dockers) {
            DockerListRespDTO dto = new DockerListRespDTO();
            BeanUtil.copyProperties(docker, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
