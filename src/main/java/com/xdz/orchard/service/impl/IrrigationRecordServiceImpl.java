package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.IrrigationRecordMapper;
import com.xdz.orchard.entity.IrrigationRecord;
import com.xdz.orchard.service.IrrigationRecordService;
import org.springframework.stereotype.Service;

/**
 * 灌溉记录(IrrigationRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:56
 */
@Service("irrigationRecordService")
public class IrrigationRecordServiceImpl extends ServiceImpl<IrrigationRecordMapper, IrrigationRecord> implements IrrigationRecordService {

}
