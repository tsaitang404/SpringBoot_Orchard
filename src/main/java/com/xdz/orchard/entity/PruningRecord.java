package com.xdz.orchard.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 修剪记录(PruningRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:35:18
 */
@SuppressWarnings("serial")
@TableName("pruning_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PruningRecord extends Model<PruningRecord> {
    //修剪记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //修剪日期
    private String pruningDate;
    //修剪方法（如剪枝、修整等）
    private String method;
}
