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
 * 采摘记录(HarvestRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:55
 */
@SuppressWarnings("serial")
@TableName("harvest_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HarvestRecord extends Model<HarvestRecord> {
    //采摘记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //采摘日期
    private String harvestDate;
    //产量（公斤）
    private Float yield;
    //水果品质（如A级、B级等）
    private String quality;
    //销售去向
    private String salesDestination;
    //每公斤价格（元）
    private Float pricePerKg;
}
