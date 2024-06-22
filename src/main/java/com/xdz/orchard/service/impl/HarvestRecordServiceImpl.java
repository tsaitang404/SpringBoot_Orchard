package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.HarvestRecordMapper;
import com.xdz.orchard.entity.HarvestRecord;
import com.xdz.orchard.service.HarvestRecordService;
import org.springframework.stereotype.Service;

/**
 * 采摘记录(HarvestRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:55
 */
@Service("harvestRecordService")
public class HarvestRecordServiceImpl extends ServiceImpl<HarvestRecordMapper, HarvestRecord> implements HarvestRecordService {

}
