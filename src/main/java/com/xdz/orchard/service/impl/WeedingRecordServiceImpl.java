package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.WeedingRecordMapper;
import com.xdz.orchard.entity.WeedingRecord;
import com.xdz.orchard.service.WeedingRecordService;
import org.springframework.stereotype.Service;

/**
 * 除草记录(WeedingRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:35:20
 */
@Service("weedingRecordService")
public class WeedingRecordServiceImpl extends ServiceImpl<WeedingRecordMapper, WeedingRecord> implements WeedingRecordService {

}
