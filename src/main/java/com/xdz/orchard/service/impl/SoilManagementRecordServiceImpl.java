package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.SoilManagementRecordMapper;
import com.xdz.orchard.entity.SoilManagementRecord;
import com.xdz.orchard.service.SoilManagementRecordService;
import org.springframework.stereotype.Service;

/**
 * 土壤管理记录(SoilManagementRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:35:18
 */
@Service("soilManagementRecordService")
public class SoilManagementRecordServiceImpl extends ServiceImpl<SoilManagementRecordMapper, SoilManagementRecord> implements SoilManagementRecordService {

}
