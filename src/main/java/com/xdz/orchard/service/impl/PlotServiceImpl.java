package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.PlotMapper;
import com.xdz.orchard.entity.Plot;
import com.xdz.orchard.service.PlotService;
import org.springframework.stereotype.Service;

/**
 * 地块(Plot)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 15:37:57
 */
@Service("plotService")
public class PlotServiceImpl extends ServiceImpl<PlotMapper, Plot> implements PlotService {

}
