package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.PruningRecordMapper;
import com.xdz.orchard.entity.PruningRecord;
import com.xdz.orchard.service.PruningRecordService;
import org.springframework.stereotype.Service;

/**
 * 修剪记录(PruningRecord)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:35:17
 */
@Service("pruningRecordService")
public class PruningRecordServiceImpl extends ServiceImpl<PruningRecordMapper, PruningRecord> implements PruningRecordService {

}
