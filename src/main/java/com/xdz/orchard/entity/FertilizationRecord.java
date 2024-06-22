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
 * 施肥记录(FertilizationRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@SuppressWarnings("serial")
@TableName("fertilization_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FertilizationRecord extends Model<FertilizationRecord> {
    //施肥记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //施肥日期
    private String fertilizationDate;
    //肥料类型
    private String fertilizerType;
    //施肥量（公斤）
    private Float amount;
}
