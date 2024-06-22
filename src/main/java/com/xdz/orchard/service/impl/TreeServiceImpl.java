package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.TreeMapper;
import com.xdz.orchard.entity.Tree;
import com.xdz.orchard.service.TreeService;
import org.springframework.stereotype.Service;

/**
 * 果树(Tree)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 15:45:33
 */
@Service("treeService")
public class TreeServiceImpl extends ServiceImpl<TreeMapper, Tree> implements TreeService {

}
