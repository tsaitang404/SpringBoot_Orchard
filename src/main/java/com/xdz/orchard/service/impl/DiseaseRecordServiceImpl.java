package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.DiseaseRecordMapper;
import com.xdz.orchard.entity.DiseaseRecord;
import com.xdz.orchard.service.DiseaseRecordService;
import org.springframework.stereotype.Service;

/**
 * 病害记录(DiseaseRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:21
 */
@Service("diseaseRecordService")
public class DiseaseRecordServiceImpl extends ServiceImpl<DiseaseRecordMapper, DiseaseRecord> implements DiseaseRecordService {

}
