package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.DiseasePreventionRecordMapper;
import com.xdz.orchard.entity.DiseasePreventionRecord;
import com.xdz.orchard.service.DiseasePreventionRecordService;
import org.springframework.stereotype.Service;

/**
 * 防病记录(DiseasePreventionRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 15:58:44
 */
@Service("diseasePreventionRecordService")
public class DiseasePreventionRecordServiceImpl extends ServiceImpl<DiseasePreventionRecordMapper, DiseasePreventionRecord> implements DiseasePreventionRecordService {

}
