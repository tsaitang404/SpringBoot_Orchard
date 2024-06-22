package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.PestRecordMapper;
import com.xdz.orchard.entity.PestRecord;
import com.xdz.orchard.service.PestRecordService;
import org.springframework.stereotype.Service;

/**
 * 虫害记录(PestRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:57
 */
@Service("pestRecordService")
public class PestRecordServiceImpl extends ServiceImpl<PestRecordMapper, PestRecord> implements PestRecordService {

}
