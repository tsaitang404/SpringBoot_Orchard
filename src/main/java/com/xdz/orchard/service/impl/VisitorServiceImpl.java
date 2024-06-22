package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.VisitorMapper;
import com.xdz.orchard.entity.Visitor;
import com.xdz.orchard.service.VisitorService;
import org.springframework.stereotype.Service;

/**
 * 游客(Visitor)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:35:19
 */
@Service("visitorService")
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {

}
