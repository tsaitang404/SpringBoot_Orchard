package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.PestPreventionRecordMapper;
import com.xdz.orchard.entity.PestPreventionRecord;
import com.xdz.orchard.service.PestPreventionRecordService;
import org.springframework.stereotype.Service;

/**
 * 防虫记录(PestPreventionRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:57
 */
@Service("pestPreventionRecordService")
public class PestPreventionRecordServiceImpl extends ServiceImpl<PestPreventionRecordMapper, PestPreventionRecord> implements PestPreventionRecordService {

}
