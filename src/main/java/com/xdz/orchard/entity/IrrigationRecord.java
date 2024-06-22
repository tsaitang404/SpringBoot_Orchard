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
 * 灌溉记录(IrrigationRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:56
 */
@SuppressWarnings("serial")
@TableName("irrigation_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IrrigationRecord extends Model<IrrigationRecord> {
    //灌溉记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //灌溉日期
    private String irrigationDate;
    //灌溉量（升）
    private Float amount;
}
