package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.FertilizationRecordMapper;
import com.xdz.orchard.entity.FertilizationRecord;
import com.xdz.orchard.service.FertilizationRecordService;
import org.springframework.stereotype.Service;

/**
 * 施肥记录(FertilizationRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@Service("fertilizationRecordService")
public class FertilizationRecordServiceImpl extends ServiceImpl<FertilizationRecordMapper, FertilizationRecord> implements FertilizationRecordService {

}
