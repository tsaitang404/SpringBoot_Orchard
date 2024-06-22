package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.GradeMapper;
import com.xdz.orchard.entity.Grade;
import com.xdz.orchard.service.GradeService;
import org.springframework.stereotype.Service;

/**
 * 品级(Grade)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:54
 */
@Service("gradeService")
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

}
